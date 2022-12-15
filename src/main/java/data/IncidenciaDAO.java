package data;

import entities.*;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class IncidenciaDAO extends Conexion{
	
	public void add(Incidencia i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO incidencia(fechaApertura,descripcionProblema,idPersonaApertura,idMaquina) VALUES (?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setObject(1, i.getFechaApertura());
			stmt.setString(2, i.getDescripcionProblema());
			stmt.setInt(3, i.getPersonaApertura().getId());
			stmt.setInt(4, i.getMaquina().getId());
			
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			
            if(keyResultSet!=null && keyResultSet.next()){
                i.setId(keyResultSet.getInt(1));
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
		
	public Incidencia getById(Incidencia incToSearch) {
		Incidencia i=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM incidencia WHERE idIncidencia=?"
					);
			stmt.setInt(1, incToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				i=new Incidencia();
				i.setId(rs.getInt("idIncidencia"));
				i.setFechaApertura(rs.getObject("fechaApertura",LocalDate.class));
				i.setDescripcionProblema(rs.getString("descripcionProblema"));
				
				DataPersona pDAO = new DataPersona();
				Persona pApertura=new Persona();
				pApertura.setId(rs.getInt("idPersonaApertura"));
				i.setPersonaApertura(pDAO.getById(pApertura));
				
				Persona pAsignada=new Persona();
				pAsignada.setId(rs.getInt("idPersonaAsignada"));
				i.setPersonaAsignada(pDAO.getById(pAsignada));
				
				i.setFechaCierre(rs.getObject("fechaCierre",LocalDate.class));
				
				MaquinaDAO mDAO = new MaquinaDAO();
				Maquina m = new Maquina();
				m.setId(rs.getInt("idMaquina"));
				i.setMaquina(mDAO.getById(m));
				
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
		return i;
	}
	
	public LinkedList<Incidencia> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Incidencia> incidencias= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT * FROM incidencia");
			if(rs!=null) {
				while(rs.next()) {
					Incidencia i=new Incidencia();
					i.setId(rs.getInt("idIncidencia"));
					i.setDescripcionProblema(rs.getString("descripcionProblema"));
					i.setFechaApertura(rs.getObject("fechaApertura",LocalDate.class));
					i.setFechaCierre(rs.getObject("fechaCierre",LocalDate.class));
					
					MaquinaDAO mDAO=new MaquinaDAO();
					Maquina m = new Maquina();
					m.setId(rs.getInt("idMaquina"));
					i.setMaquina(mDAO.getById(m));
					
					DataPersona pDAO = new DataPersona();
					Persona pApertura=new Persona();
					pApertura.setId(rs.getInt("idPersonaApertura"));
					i.setPersonaApertura(pDAO.getById(pApertura));
					
					Persona pAsignada=new Persona();
					pAsignada.setId(rs.getInt("idPersonaAsignada"));
					i.setPersonaAsignada(pDAO.getById(pAsignada));
					
					incidencias.add(i);
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
	
		return incidencias;
	}
	
	
	public LinkedList<Incidencia> getPorMaquina(Maquina m){
		LinkedList<Incidencia> incidencias= new LinkedList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM incidencia WHERE idMaquina=?"
					);
			stmt.setInt(1, m.getId());
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Incidencia i=new Incidencia();
					i.setId(rs.getInt("idIncidencia"));
					i.setDescripcionProblema(rs.getString("descripcionProblema"));
					i.setFechaApertura(rs.getObject("fechaApertura",LocalDate.class));
					i.setFechaCierre(rs.getObject("fechaCierre",LocalDate.class));
					
					i.setMaquina(m);
					
					DataPersona pDAO = new DataPersona();
					Persona pApertura=new Persona();
					pApertura.setId(rs.getInt("idPersonaApertura"));
					i.setPersonaApertura(pDAO.getById(pApertura));
					
					Persona pAsignada=new Persona();
					pAsignada.setId(rs.getInt("idPersonaAsignada"));
					i.setPersonaAsignada(pDAO.getById(pAsignada));
					
					incidencias.add(i);
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
	
		return incidencias;
	}	
	
	public void remove(Incidencia inc) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM incidencia where idIncidencia=?");
			stmt.setInt(1, inc.getId());
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
	
	public void update(Incidencia inc) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE incidencia SET fechaApertura=?, descripcionProblema=?, idPersonaApertura=?, idPersonaAsignada=?, fechaCierre=?, idMaquina=?");
			stmt.setObject(1, inc.getFechaApertura());
			stmt.setString(2, inc.getDescripcionProblema());
			stmt.setInt(3, inc.getPersonaApertura().getId());
			stmt.setInt(4, inc.getPersonaAsignada().getId() );
			stmt.setObject(5, inc.getFechaCierre());
			stmt.setInt(6, inc.getMaquina().getId());
			
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
	
	public void indicarCierre(Incidencia inc) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE incidencia SET fechaCierre=? WHERE idIncidencia=?");
			stmt.setObject(1, inc.getFechaCierre());
			stmt.setInt(2, inc.getId());
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
