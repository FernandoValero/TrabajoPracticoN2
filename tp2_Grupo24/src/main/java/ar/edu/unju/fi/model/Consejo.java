package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Consejo {
	private String titulo;
	private String descripcion;
	private String imagen;
	public Consejo() {
		// TODO Auto-generated constructor stub
	}
	
	public Consejo(String titulo, String descripcion, String imagen) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}