package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class ControlMenu {
	
	private DataPersona dp;
	private DataRol rDAO;
	
	public ControlMenu() {
		dp=new DataPersona();
		rDAO = new DataRol();
	}
	
	public Boolean validatePermisos(Persona p, int nroRol) {
		Boolean b=null;
		p=dp.getIDxEmail(p);		
		p=rDAO.setRoles(p);
		
		System.out.println(p);
		
		Rol r = new Rol();
		r.setId(nroRol);
		r=rDAO.getById(r);
		
		if (p.hasRol(r)) {
			b = true;
		}else {
			b=false;
		}
		
		System.out.println(b);
		return b;		
	}
}
