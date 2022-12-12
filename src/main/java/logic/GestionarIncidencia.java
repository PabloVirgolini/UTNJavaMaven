package logic;

import java.util.ArrayList;
import java.util.LinkedList;

import data.DataPersona;
import data.IncidenciaDAO;
import data.MaquinaDAO;
import entities.Incidencia;
import entities.Maquina;
import entities.Persona;

public class GestionarIncidencia {
	private MaquinaDAO mDAO;
	private DataPersona pDAO;
	private IncidenciaDAO iDAO;
	
	public GestionarIncidencia() {
		 mDAO = new MaquinaDAO();
		 pDAO = new DataPersona();
		 iDAO = new IncidenciaDAO();
	}
	
	public Maquina validarMaquina(Maquina m) {
		return mDAO.getById(m);
	}
	
	public LinkedList<Persona> getEncargadosReparaciones(){
		int codigoEncargadoReparacion = 1;
		
		LinkedList<Persona> encargados = new LinkedList<>(); 
		LinkedList<Persona> lista = pDAO.getAll();
    	for(Persona per: lista) { 
    		if (per.getCargo().getIdCargo()==codigoEncargadoReparacion){
    			encargados.add(per);
    		}
    	}
    	return encargados;
	}
	
	public Boolean add(Incidencia inc) {
		iDAO = new IncidenciaDAO();
		int cantidad = iDAO.getAll().size();
		iDAO.add(inc);
		if (cantidad<iDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean update(Incidencia inc) {
		iDAO.update(inc);
		
		return true;
	}
	
	public Boolean remove(Incidencia inc) {
		int cantidad = iDAO.getAll().size();
		iDAO.remove(inc);
		if (cantidad>iDAO.getAll().size()) {
			return true;	
		} else return false;
	}
	
	public Boolean validarAsignacionDeEncargado(Persona per) {
		
		if (per.getCargo().getIdCargo()==2) {
				return true;
		} else return false;
		
	}
	
	public void asignarIncidencia(Incidencia inc, Persona per) {
		
	}
	
	public void cerrarIncidencia(Incidencia inc) {
		
	}
	
	public void abrirIncidencia() {
		
	}
	
	public LinkedList<Incidencia> getPorMaquina(Maquina m){
		LinkedList<Incidencia> incidencias = new LinkedList<>();
		incidencias = iDAO.getPorMaquina(m);
		return incidencias;
	}
}