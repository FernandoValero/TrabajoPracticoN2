package ar.edu.unju.fi.lista;

import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

import java.util.ArrayList;
/**
 * La clase ListaProducto representa una lista de productos.
 * @author Grupo_24
 */
@Component
public class ListaProducto {
	/**
	 * Lista de productos.
	 */
	private List<Producto> productos;
	/**
	 * Constructor de la clase ListaProducto.
	 */
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Bebedero Comedor Celeste",34,4500.5,"Comedero",5,"comedorbebedor.png"));
		productos.add(new Producto("Cepillo Autolimpiante",35,1825,"Peluquería",2,"peine.png"));
		productos.add(new Producto("Rascador 2 casitas",36,15800,"Rascador",10,"rascador.jpg"));
		productos.add(new Producto("Caja Transportadora Perro - Gato",36,15800,"Transporte",10,"transportador.jpg"));
		productos.add(new Producto("Mochila Trasportadora de Gatos",36,15800,"Transporte",10,"mochila_transportadora.jpg"));
		productos.add(new Producto("Kit Sanitario",36,15800,"Limpieza",10,"kitsanitario.png"));
	}
	/**
	 * Retorna la lista de productos.
	 * @return La lista de productos.
	 */
	public List<Producto> getProductos() {
		return productos;
	}
	/**
	 * Establece la lista de productos.
	 * @param productos, Lista de productos.
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}

