package logic;

import data.SeccionDAO;
import entities.Seccion;

public class GestionarSeccion{

	private SeccionDAO sDAO;
	
	
	public GestionarSeccion() {
		sDAO=new SeccionDAO();
	}
	
	public Seccion validate(Seccion seccionMaquina) {
		
		return sDAO.getById(seccionMaquina);
	}
	
	public Boolean add(Seccion sec) {
		sDAO = new SeccionDAO();
		int cantidad = sDAO.getAll().size();
		sDAO.add(sec);
		if (cantidad==sDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean update(Seccion sec) {
		sDAO = new SeccionDAO();
		sDAO.update(sec);
		
		return true;
	}
	
	public Boolean remove(Seccion sec) {
		sDAO = new SeccionDAO();
		int cantidad = sDAO.getAll().size();
		sDAO.remove(sec);
		if (cantidad>sDAO.getAll().size()) {
			return true;	
		} else return false;
	}
}