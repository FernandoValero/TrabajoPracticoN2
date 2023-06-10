package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.lista.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService{
	@Autowired
	private ListaProducto listaProducto;
	
	@Autowired
	private Producto producto;
	
	@Override
	public List<Producto> getLista() {
		return listaProducto.getProductos();
	}
	@Override
	public void guardar(Producto producto) {
		listaProducto.getProductos().add(producto);
	}
	@Override
	public void modificar(Producto producto) {
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()==producto.getCodigo()) {
				prod.setNombre(producto.getNombre());
				prod.setPrecio(producto.getPrecio());
				prod.setCategoria(producto.getCategoria());
				prod.setDescuento(producto.getDescuento());
				break;
			}
		}
	}
	@Override
	public void eliminar(Producto productoEncontrado) {
		listaProducto.getProductos().remove(productoEncontrado);		
	}
	@Override
	public Producto getBy(int codigo) {
		Producto productoEncontrado = new Producto();
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()==codigo) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}
	@Override
	public Producto getProducto() {
		return producto;
	}
}
