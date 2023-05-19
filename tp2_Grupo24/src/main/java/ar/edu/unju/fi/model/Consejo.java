package ar.edu.unju.fi.model;

public class Consejo {
	private String titulo;
	private String descripcion;

	
	public Consejo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Consejo(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
