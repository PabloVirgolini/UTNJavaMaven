package entities;

import java.io.InputStream;

public class Foto {

	int idFoto;
	Incidencia incidencia;
	String descripcion;
	String inputStream;
	
	public String getInputStream() {
		return inputStream;
	}
	public void setInputStream(String inputStream) {
		this.inputStream = inputStream;
	}
	public int getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
	public Incidencia getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
