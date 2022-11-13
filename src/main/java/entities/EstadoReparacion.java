package entities;

public class EstadoReparacion {
	int id;
	String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public EstadoReparacion() {
		
	}
	
	public EstadoReparacion(int nroId, String strDescrip) {
		this.id=nroId;
		this.descripcion=strDescrip;
	}
}
