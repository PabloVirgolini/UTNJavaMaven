package data;
//orig
import entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataPersona {
	
	public LinkedList<Persona> getAll(){
		DataRol dr=new DataRol();
		CargoDAO cDAO = new CargoDAO();
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					
					p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.getDocumento().setTipo(rs.getString("tipo_doc"));
					p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					
					Cargo c = new Cargo();
					c.setIdCargo(rs.getInt("idCargo"));
					p.setCargo(new Cargo());
					p.setCargo(cDAO.getById(c));
					
					p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					pers.add(p);
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
		
		
		return pers;
	}
	
	
	public Persona getByEmailPassword(Persona per) {
		DataRol dr=null;
		CargoDAO cDAO = new CargoDAO();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona WHERE email=? AND password=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				
				
				Cargo c = new Cargo();
				c.setIdCargo(rs.getInt("idCargo"));
				p.setCargo(new Cargo());
				p.setCargo(cDAO.getById(c));
				
				dr = new DataRol();
				dr.setRoles(p);
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
		
		return p;
	}
	
	public Persona getByEmail(Persona per) {
		DataRol dr=null;
		CargoDAO cDAO = new CargoDAO();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona WHERE email=?"
					);
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				
				Cargo c = new Cargo();
				c.setIdCargo(rs.getInt("idCargo"));
				p.setCargo(new Cargo());
				p.setCargo(cDAO.getById(c));
				
				dr = new DataRol();
				dr.setRoles(p);
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
		
		return p;
	}

	
	
	public LinkedList<Persona> getByCargo(Cargo c) {
		DataRol dr=new DataRol();
		CargoDAO cDAO = new CargoDAO();
		Persona p=null;
		LinkedList<Persona> lista= new LinkedList<>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona WHERE idCargo=?"
					);
			stmt.setInt(1, c.getIdCargo());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				
				p.setDocumento(new Documento());
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				
				p.setCargo(new Cargo());
				p.setCargo(cDAO.getById(c));
				
				dr.setRoles(p);
				
				lista.add(p);
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
		
		return lista;
	}
	
	
	public Persona getByDocumento(Persona per) {
		DataRol dr=new DataRol();
		CargoDAO cDAO = new CargoDAO();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona WHERE tipo_doc=? and nro_doc=?"
					);
			stmt.setString(1, per.getDocumento().getTipo());
			stmt.setString(2, per.getDocumento().getNro());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				
				
				Cargo c = new Cargo();
				c.setIdCargo(rs.getInt("idCargo"));
				p.setCargo(new Cargo());
				p.setCargo(cDAO.getById(c));
				
				
				dr.setRoles(p);
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
		
		return p;
	}
	
	public Persona getById(Persona per) {
		DataRol dr=new DataRol();
		CargoDAO cDAO = new CargoDAO();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado,idCargo FROM persona WHERE id=?"
					);
			stmt.setInt(1, per.getId());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(per.getId());
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				
				
				Cargo c = new Cargo();
				c.setIdCargo(rs.getInt("idCargo"));
				p.setCargo(new Cargo());
				p.setCargo(cDAO.getById(c));
				
				
				dr.setRoles(p);
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
		
		return p;
	}
	
	public void add(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into persona(nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDocumento().getTipo());
			stmt.setString(4, p.getDocumento().getNro());
			stmt.setString(5, p.getEmail());
			stmt.setString(6, p.getPassword());
			stmt.setString(7, p.getTel());
			stmt.setBoolean(8, p.isHabilitado());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
            
            if (p.getAllRoles().size()>0) {
            	this.saveRoles(p);
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
	
	public void update(Persona per) {
		PreparedStatement stmt= null;
		try {
			System.out.println(per);
			
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE persona SET tipo_doc=?, nro_doc=?, nombre=?, apellido=?, email=?, tel=?, habilitado=? WHERE id=?");
			stmt.setString(1, per.getDocumento().getTipo());
			stmt.setString(2, per.getDocumento().getNro());
			stmt.setString(3, per.getNombre());
			stmt.setString(4, per.getApellido());
			stmt.setString(5, per.getEmail());
			stmt.setString(6, per.getTel());
			stmt.setBoolean(7, per.isHabilitado());
			
			stmt.setInt(8, per.getId());
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
	
	public void remove(Persona per) {
		PreparedStatement stmt= null;
		try {
			this.removeAllRoles(per);
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM persona WHERE id=?");
			stmt.setInt(1, per.getId());
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

	public void cambiarPassword(Persona per) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE persona SET password=?, WHERE id=?");
			stmt.setString(1, per.getPassword());		
			stmt.setInt(2, per.getId());
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
	
	
	public void saveRoles(Persona per) {
		ArrayList<Rol> roles = per.getAllRoles();
		System.out.println("Clase PERSONA. Metodo saveRoles");
		System.out.println("Cant. ROLES: " + roles.size());
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"insert into rol_persona(id_persona, id_rol) values(?,?)",
								PreparedStatement.RETURN_GENERATED_KEYS
								);
				for (Rol r: roles) {
					stmt.setInt(1, per.getId());
					stmt.setInt(2, r.getId());
					stmt.executeUpdate();
				}
				
			} catch (SQLException e) {
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
	

	
	public void removeRol(Persona per, Rol r) {
		PreparedStatement stmt= null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"DELETE FROM rol_persona WHERE id_persona=? and id_rol=?"
								);
				stmt.setInt(1, per.getId());
				stmt.setInt(2, r.getId());
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
	
	public void removeAllRoles(Persona per) {
		PreparedStatement stmt= null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"DELETE FROM rol_persona WHERE id_persona=?"
								);
				stmt.setInt(1, per.getId());
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
	
	public Persona getIDxEmail(Persona per) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id FROM persona WHERE email=?"
					);
			stmt.setString(1, per.getEmail());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				per.setId(rs.getInt("id"));
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
		
		return per;
	}
	
}
