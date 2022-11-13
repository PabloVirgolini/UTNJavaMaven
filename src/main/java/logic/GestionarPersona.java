package logic;

import java.util.LinkedList;

import data.DataPersona;
import data.DataRol;
import entities.Persona;
import entities.Rol;

public class GestionarPersona {
	private DataPersona pDAO;
	private DataRol rDAO;
	
	public GestionarPersona() {
		pDAO=new DataPersona();
	}
	
	public LinkedList<Persona> getAll(){
		return pDAO.getAll();
	}
	
	public Rol validate(Rol rolPersona) {
		return rDAO.getById(rolPersona);
	}
	
	public Boolean add(Persona per) {
		int cantidad = pDAO.getAll().size();
		pDAO.add(per);
		if (cantidad==pDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean update(Persona per) {
		pDAO = new DataPersona();
		pDAO.update(per);
		
		return true;
	}
	
	public Boolean remove(Persona per) {
		pDAO = new DataPersona();
		int cantidad = pDAO.getAll().size();
		pDAO.remove(per);
		if (cantidad>pDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
}