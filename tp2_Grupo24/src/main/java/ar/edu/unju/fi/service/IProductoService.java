package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.model.Producto;


public interface IProductoService {
	List<Producto> getLista();
	void guardar(Producto producto);
	void modificar(Producto producto);
	void eliminar(Producto productoEncontrado);
	Producto getBy(String codigo);
	Producto getSucursal();
}
