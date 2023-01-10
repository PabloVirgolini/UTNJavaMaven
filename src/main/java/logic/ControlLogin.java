package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class ControlLogin {
	private DataPersona dp;
	
	public ControlLogin() {
		dp=new DataPersona();
	}
	
	public Persona validateUser(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByEmailPassword(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public Boolean validatePermisos(Persona p, int nroRol) {
		Boolean b=null;
		DataRol rDAO = new DataRol();
		Rol rol = null;
		Rol r = new Rol();
		
		r.setId(nroRol);
		
		rol=rDAO.getById(r);
		
		System.out.println(r);
		
		if (p.hasRol(rol)) {
			b = true;
		} else {
			b=false;
		}
			
		return b;		
	}
}
