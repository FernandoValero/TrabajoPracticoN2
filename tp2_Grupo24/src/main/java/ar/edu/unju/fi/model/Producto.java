package ar.edu.unju.fi.model;

public class Producto {
	String nombre;
	int codigo;
	double precio;
	String categoria;
	byte descuento;
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public Producto(String nombre, int codigo, double precio, String categoria, byte descuento) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
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
	public byte getDescuento() {
		return descuento;
	}
	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
	double calcularDescuento(double precio, byte descuento) {
		return precio-(precio*descuento/100);
	}
}
