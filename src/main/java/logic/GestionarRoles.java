package logic;

import data.DataPersona;
import data.DataRol;
import entities.Persona;
import entities.Rol;

public class GestionarRoles {

	private DataRol rDAO;
	
	
	public GestionarRoles () {
		rDAO=new DataRol();
	}
	
	public Boolean asignarRol(Persona per, Rol rol) {
		if (!per.hasRol(rol)) {
			per.addRol(rol);
			return true;
		}else return false;
	}
	
	public Boolean add(Rol rol) {
		int cantidad = rDAO.getAll().size();
		rDAO.add(rol);
		if (cantidad==rDAO.getAll().size()) {
			return true;	
		} else return false;
	}
}