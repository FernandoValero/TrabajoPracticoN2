package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Component
public class Producto {
	
	@NotEmpty(message="*Agregue Nombre")
	@Size(min=4,message="*Debe tener almenos 4 caracteres")
	private String nombre;
	@NotNull(message="Agregue un código")
	@Positive(message="*Debe ser mayor a 0")
	private int codigo;
	@Positive(message="*Debe ser mayor a 0")
	private double precio;
	@NotEmpty(message="*Debe agregar categoría")
	@Size(min=4, max=30,message="*Debe tener entre 4-30 caracteres")
	private String categoria;
	@Positive(message="*Debe ser mayor positivo")
	@Min(value=0,message="Debe ser mayor a 0")
	@Max(value=50,message="Debe ser menor o igual 50")
	private int descuento;
	@NotBlank(message="Debe seleccionar una imagen")
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
