package ar.edu.unju.fi.model;

import javax.swing.ImageIcon;

public class Sucursal {
	private String nombre;
	private String direccion;
	private String telefono;
	private String horario;
	private ImageIcon imagen;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	
	public Sucursal(String nombre, String direccion, String telefono, String horario,ImageIcon imagen) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	
	
}