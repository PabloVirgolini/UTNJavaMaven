package logic;

import data.MaquinaDAO;
import data.SeccionDAO;
import entities.Maquina;
import entities.Seccion;

public class GestionarMaquina {
	private SeccionDAO sDAO;
	private MaquinaDAO mDAO;
	
	public GestionarMaquina() {
		sDAO=new SeccionDAO();
	}
	
	public Seccion validate(Seccion seccionMaquina) {
		
		return sDAO.getById(seccionMaquina);
	}
	
	public Boolean add(Maquina maq) {
		mDAO = new MaquinaDAO();
		int cantidad = mDAO.getAll().size();
		mDAO.add(maq);
		if (cantidad==mDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean update(Maquina maq) {
		mDAO = new MaquinaDAO();
		mDAO.update(maq);
		
		return true;
	}
	
	public Boolean remove(Maquina maq) {
		mDAO = new MaquinaDAO();
		int cantidad = mDAO.getAll().size();
		mDAO.remove(maq);
		if (cantidad>mDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	
}
