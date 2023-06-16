package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
/**
 * Respresenta un Producto de la tienda
 * @author Grupo_24
 */
@Component
public class Producto {
	/**
	 * Es el nombre del Producto.
	 */
	@NotEmpty(message="*Agregue Nombre")
	@Size(min=4,message="*Debe tener almenos 4 caracteres")
	private String nombre;
	@NotNull(message="Agregue un código")
	@Positive(message="*Debe ser mayor a 0")
	/**
	 * Es el cóodigo del Producto.
	 */
	private int codigo;
	@Positive(message="*Debe ser mayor a 0")
	/**
	 * Es el precio del Producto.
	 */
	private double precio;
	@NotEmpty(message="*Debe agregar categoría")
	@Size(min=4, max=30,message="*Debe tener entre 4-30 caracteres")
	/**
	 * Es la categoría a la pertenece el Producto.
	 */
	private String categoria;
	@Positive(message="*Debe ser mayor positivo")
	@Min(value=0,message="Debe ser mayor a 0")
	@Max(value=50,message="Debe ser menor o igual 50")
	/**
	 * Es el descuento en caso de que tuviera el Producto.
	 */
	private int descuento;
	@NotBlank(message="Debe seleccionar una imagen")
	/**
	 * Es el ruta de la imagen del Producto.
	 */
	private String imagen;
	/**
	 * Constructor vacío de la clase Producto.
	 */
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase Producto que acepta valores de todos los atributos.
	 * @param nombre, El nombre del producto.
	 * @param codigo, El código del producto.
	 * @param precio, El precio del producto.
	 * @param categoria, La categoría del producto.
	 * @param descuento, El descuento aplicado al producto.
	 * @param imagen, La imagen del producto.
	 */
	public Producto(String nombre, int codigo, double precio, String categoria, int descuento, String imagen) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.imagen = imagen;
	}
	/**
	 * Retorna el nombre del producto.
	 * @return El nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre del producto.
	 * @param nombre El nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Retorna el código del producto.
	 * @return El código del producto.
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Establece el código del producto.
	 * @param codigo El código del producto.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * Retorna el precio del producto.
	 * @return El precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Establece el precio del producto.
	 * @param precio El precio del producto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Retorna el categoría del producto.
	 * @return El categoría del producto.
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * Establece el categoría del producto.
	 * @param categoria La categoría del producto.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * Retorna el descuento del producto.
	 * @return El descuento del producto.
	 */
	public int getDescuento() {
		return descuento;
	}
	/**
	 * Establece el descuento del producto.
	 * @param descuento El descuento del producto.
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	/**
	 * Retorna la ruta de la imagen del producto.
	 * @return La ruta de la imagen del producto.
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Establece el ruta imagen del producto.
	 * @param imagen La ruta de la imagen del producto.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * Calcula el precio final con descuento aplicado.
	 * El descuento se calcula mediante la resta del precio original con el descuento del producto.
	 * @return El precio después de aplicar el descuento.
	 */
	public double calcularDescuento() {
		return precio-(precio*descuento/100);
	}
}