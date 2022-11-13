package entities;

public class Seccion {
	private int id;
	private String descripcion;
	
	
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

	public Seccion() {		
	}
	
	public Seccion(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	
}
