package logic;

import data.CargoDAO;
import entities.Cargo;

public class GestionarCargo{

	private CargoDAO sDAO;
	
	
	public GestionarCargo() {
		sDAO=new CargoDAO();
	}
	
	public Cargo validate(Cargo cargoPersona) {
		
		return sDAO.getById(cargoPersona);
	}
	
	public Boolean add(Cargo sec) {
		sDAO = new CargoDAO();
		int cantidad = sDAO.getAll().size();
		sDAO.add(sec);
		if (cantidad==sDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean update(Cargo sec) {
		sDAO = new CargoDAO();
		sDAO.update(sec);
		
		return true;
	}
	
	public Boolean remove(Cargo sec) {
		sDAO = new CargoDAO();
		int cantidad = sDAO.getAll().size();
		sDAO.remove(sec);
		if (cantidad>sDAO.getAll().size()) {
			return true;	
		} else return false;
	}
}