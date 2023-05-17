package ar.edu.unju.fi.lista;

import java.util.List;
import java.util.ArrayList;
import ar.edu.unju.fi.model.Producto;


public class ListaProducto {
	private List<Producto> productos;
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Bebedero Comedor Celeste",34,4500.5,"Comedero",5));
		productos.add(new Producto("Cepillo Autolimpiante",35,1825,"Peluquería",2));
		productos.add(new Producto("Rascador 2 casitas",36,15800,"Rascador",10));
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}

