package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

/**
* Esta interfaz define los métodos para administrar los productos.
*/
public interface IProductoService {
	/**
	* Obtiene la lista de todos los productos.
	* @return una lista de productos
	*/
	List<Producto> getLista();
	/**
	*  Guardo un nuevo producto.
	*  @param producto, producto a guardar.
	*/
	void guardar(Producto producto);
	/**
	*  Modifica un producto existente.
	*  @param producto, producto a modificar.
	*/
	void modificar(Producto producto);
	/**
	*  Elimina un producto existente.
	*  @param productoEncontrado, el producto a eliminar.
	*/
	void eliminar(Producto productoEncontrado);
	/**
    * Encuentra un producto de acuerdo a su código.
    * @param codigo, el código del producto a buscar.
    * @return el producto que tenga coincidencia.
    */
	Producto getBy(int codigo);
	/**
    * Obtiene un nuevo producto.
    * @return un objeto producto.
    */
	Producto getProducto();
}
