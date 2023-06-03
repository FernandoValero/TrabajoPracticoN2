package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	private String nombre;
	private int codigo;
	private double precio;
	private String categoria;
	private int descuento;
	private String imagen;
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Producto(String nombre, int codigo, double precio, String categoria, int descuento, String imagen) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public double calcularDescuento() {
		return precio-(precio*descuento/100);
	}
}
