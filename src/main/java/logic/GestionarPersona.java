package logic;

import java.util.ArrayList;
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
		rDAO = new DataRol();
	}
	
	public LinkedList<Persona> getAll(){
		return pDAO.getAll();
	}
	
	public Rol validate(Rol rolPersona) {
		return rDAO.getById(rolPersona);
	}
	
	public Boolean add(Persona per) {
		if pDAO.getByEmail(per)=null {
			int cantidad = pDAO.getAll().size();
			pDAO.add(per);
			if (cantidad==pDAO.getAll().size()) {
				return true;	
			} else { 
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Boolean update(Persona per) {
		if pDAO.getByEmail(per).getId()==per.getId(){
			pDAO.update(per);
			return true;
		else {  
			// entiendo que se editó el mail y el mail nuevo que indico ya existe para otro usuario
			return false;
		}
	}
	
	public Boolean remove(Persona per) {
		//pDAO = new DataPersona();
		int cantidad = pDAO.getAll().size();
		pDAO.remove(per);
		if (cantidad>pDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public ArrayList<Rol> getAllRoles(Persona per){
		ArrayList<Rol> lista = new ArrayList<>();
		lista = per.getAllRoles();
		
		return lista;
	}
	
	public ArrayList<Rol> getAllRolesRestantes(Persona per){
		//rDAO = new DataRol();
		
		ArrayList<Rol> listaRolesPersona = new ArrayList<>();
		LinkedList<Rol> listaRolesGenerales = new LinkedList<>();
		ArrayList<Rol> listaRolesRestantes = new ArrayList<>();
		
		listaRolesPersona = per.getAllRoles();
		listaRolesGenerales = rDAO.getAll();
		
		for (Rol r: listaRolesGenerales) {
			if (!listaRolesPersona.contains(r)) {
				listaRolesRestantes.add(r);
			}
		}
		return listaRolesRestantes;
	}
	
	public Boolean addRol(Persona per, Rol rol) {
		int cantidad = per.getAllRoles().size();
		System.out.println("ROLES antes: " + cantidad);
		if (!per.hasRol(rol)) {
			per.addRol(rol);
			pDAO.saveRoles(per);
		};
		if (cantidad>per.getAllRoles().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean removeRol(Persona per, Rol rol) {
		int cantidad = per.getAllRoles().size();
		
		if (per.hasRol(rol)) {
			per.removeRol(rol);
			pDAO.removeRol(per, rol);
		};
		
		if (cantidad<per.getAllRoles().size()) {
			return true;	
		} else return false;
	}
	
	public Rol getRol(Rol rol) {
		Rol r=new Rol();
		r=rDAO.getByDesc(rol);
		return r;
	}
	
}