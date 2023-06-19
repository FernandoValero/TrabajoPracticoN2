package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.lista.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;

/**
 * Implementación de la interfaz IProductoService que proporciona métodos para administrar los productos.
 */

@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService{
	@Autowired
	private ListaProducto listaProducto;
	
	@Autowired
	private Producto producto;
	/**
	* Obtiene la lista de todos los productos.
	* @return una lista de productos
	*/
	@Override
	public List<Producto> getLista() {
		return listaProducto.getProductos();
	}
	/**
	*  Guardo un nuevo producto.
	*  @param producto, producto a guardar.
	*/
	@Override
	public void guardar(Producto producto) {
		listaProducto.getProductos().add(producto);
	}
	/**
	*  Modifica un producto existente.
	*  @param producto, producto a modificar.
	*/
	@Override
	public void modificar(Producto producto) {
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getId()==producto.getId()) {
				prod.setNombre(producto.getNombre());
				prod.setPrecio(producto.getPrecio());
				prod.setCategoria(producto.getCategoria());
				prod.setDescuento(producto.getDescuento());
				break;
			}
		}
	}
	/**
	*  Elimina un producto existente.
	*  @param productoEncontrado, el producto a eliminar.
	*/
	@Override
	public void eliminar(Producto productoEncontrado) {
		listaProducto.getProductos().remove(productoEncontrado);		
	}
	/**
    * Encuentra un producto de acuerdo a su código.
    * @param codigo, el código del producto a buscar.
    * @return el producto que tenga coincidencia.
    */
	@Override
	public Producto getBy(Long id) {
		Producto productoEncontrado = new Producto();
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getId()==id){
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}
	/**
    * Genera un nuevo producto.
    * @return un objeto producto.
    */
	@Override
	public Producto getProducto() {
		return producto;
	}
}
