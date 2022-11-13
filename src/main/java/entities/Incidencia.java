package entities;

import java.time.LocalDate;
import java.util.Date;

public class Incidencia {
	int id;
	LocalDate fechaApertura;
	LocalDate fechaCierre;
	String descripcionProblema;
	Persona personaApertura;
	Persona personaAsignada;
	Maquina maquina;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public LocalDate getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getDescripcionProblema() {
		return descripcionProblema;
	}
	public void setDescripcionProblema(String descripcionProblema) {
		this.descripcionProblema = descripcionProblema;
	}
	public Persona getPersonaApertura() {
		return personaApertura;
	}
	public void setPersonaApertura(Persona personaApertura) {
		this.personaApertura = personaApertura;
	}
	public Persona getPersonaAsignada() {
		return personaAsignada;
	}
	public void setPersonaAsignada(Persona personaAsignada) {
		this.personaAsignada = personaAsignada;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	
	
	
}
