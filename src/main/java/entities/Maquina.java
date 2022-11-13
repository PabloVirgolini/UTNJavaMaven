package entities;

import java.time.*;

public class Maquina{
	private int id;
	private String nombre;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Seccion seccionAsignada;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta2) {
		this.fechaAlta = fechaAlta2;
	}
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public Seccion getSeccionAsignada() {
		return seccionAsignada;
	}
	public void setSeccionAsignada(Seccion seccionAsignada) {
		this.seccionAsignada = seccionAsignada;
	}
	
	public Maquina() {
		
	}
	
	public Maquina(int id, String nombre, LocalDate fechaAlta, Seccion seccionAsignada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.seccionAsignada = seccionAsignada;
	}

	public Maquina(int id, String nombre, LocalDate fechaAlta, LocalDate fechaBaja, Seccion seccionAsignada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.seccionAsignada = seccionAsignada;
	}
	@Override
	public String toString() {
		return "Maquina [id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja
				+ ", seccionAsignada=" + seccionAsignada + "]";
	}
	

	

}
