package data;

import entities.*;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class MaquinaDAO extends Conexion{
	
	public void add(Maquina p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into maquina(name,fechaAlta,fechaBaja,sectorAsignado) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setObject(2, p.getFechaAlta());
			stmt.setObject(3, p.getFechaBaja());
			stmt.setInt(4, p.getSeccionAsignada().getId());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
		
	public Maquina getById(Maquina maqToSearch) {
		Maquina m=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from maquina where idmaquina=?"
					);
			stmt.setInt(1, maqToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				m=new Maquina();
				m.setId(rs.getInt("idmaquina"));
				m.setNombre(rs.getString("name"));
				m.setFechaAlta(rs.getObject("fechaAlta",LocalDate.class));
				m.setFechaBaja(rs.getObject("fechaBaja",LocalDate.class));
				
				Seccion s = new Seccion();
				s.setId(rs.getInt("sectorAsignado"));
				SeccionDAO sDAO=new SeccionDAO();
				s=sDAO.getById(s);
				m.setSeccionAsignada(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public Maquina getByNombre(Maquina maqToSearch) {
		Maquina m=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from maquina where name=?"
					);
			stmt.setString(1, maqToSearch.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				m=new Maquina();
				m.setId(rs.getInt("idmaquina"));
				m.setNombre(rs.getString("name"));
				m.setFechaAlta(rs.getObject("fechaAlta",LocalDate.class));
				m.setFechaBaja(rs.getObject("fechaBaja",LocalDate.class));
				
				Seccion s = new Seccion();
				s.setId(rs.getInt("idSeccion"));
				SeccionDAO sDAO=new SeccionDAO();
				s=sDAO.getById(s);
				m.setSeccionAsignada(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
	
	public LinkedList<Maquina> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Maquina> maquinas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT * FROM maquina");
			if(rs!=null) {
				while(rs.next()) {
					Maquina m=new Maquina();
					m.setId(rs.getInt("idmaquina"));
					m.setNombre(rs.getString("name"));
					m.setFechaAlta(rs.getObject("fechaAlta",LocalDate.class));
					m.setFechaBaja(rs.getObject("fechaBaja",LocalDate.class));
					
					Seccion s = new Seccion();
					s.setId(rs.getInt("sectorAsignado"));
					SeccionDAO sDAO=new SeccionDAO();
					s=sDAO.getById(s);
					m.setSeccionAsignada(s);
					
					maquinas.add(m);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return maquinas;
	}
	
	public LinkedList<Maquina> getPorSector(Seccion secToSearch){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Maquina> maquinas = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from maquina where sectorAsignado=?"
					);
			stmt.setInt(1, secToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					Maquina m=new Maquina();
					m.setId(rs.getInt("idmaquina"));
					m.setNombre(rs.getString("name"));
					m.setFechaAlta(rs.getObject("fechaAlta",LocalDate.class));
					m.setFechaBaja(rs.getObject("fechaBaja",LocalDate.class));
					
					Seccion s = new Seccion();
					s.setId(rs.getInt("sectorAsignado"));
					SeccionDAO sDAO=new SeccionDAO();
					s=sDAO.getById(s);
					m.setSeccionAsignada(s);
					
					maquinas.add(m);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return maquinas;
	}
	
	
	public void remove(Maquina maq) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from maquina where idmaquina=?");
			stmt.setInt(1, maq.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public void update(Maquina maq) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE maquina SET name=?, fechaAlta=?, fechaBaja=?, sectorAsignado=? WHERE idmaquina=?");
			
			stmt.setString(1, maq.getNombre());
			stmt.setObject(2, maq.getFechaAlta());
			stmt.setObject(3, maq.getFechaBaja());
			stmt.setInt(4, maq.getSeccionAsignada().getId());
			
			stmt.setInt(5, maq.getId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public void indicarBaja(Maquina maq) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE maquina SET fechaBaja=? WHERE idmaquina=?");
			stmt.setObject(1, maq.getFechaBaja());
			stmt.setInt(2, maq.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
}
