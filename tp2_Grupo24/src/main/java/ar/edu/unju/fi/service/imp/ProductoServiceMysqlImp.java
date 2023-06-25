package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
/**
 * Implementación de la interfaz IProductoService que define los métodos de servicio para la entidad Producto.
 * Utiliza el repositorio IProductoRepository para acceder y manipular los datos.
 */
@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService {
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private Producto producto;
	  /**
     * Obtiene una lista de productos, pero solo los que contiene el estado true
     * @return una lista de productos activos
     */
	@Override
	public List<Producto> getLista() {
		return productoRepository.findByEstado(true);
	}
	/**
     * Guarda un producto en la base de datos.
     * @param producto el producto a guardar
     */
	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}
	/**
     * Modifica un producto existente en la base de datos.
     * @param producto el producto a modificar
     */
	@Override
	public void modificar(Producto producto) {
		productoRepository.save(producto);
	}
	/**
     * Elimina un producto mediante una eliminación lógica esta establece el estado de un producto en "false".
     * @param productoEncontrado el producto a eliminar
     */
	@Override
	public void eliminar(Producto productoEncontrado){
		productoEncontrado.setEstado(false);
		productoRepository.save(productoEncontrado);
	}
	 /**
     * Obtiene un producto por su identificador.
     * @param id el identificador del producto
     * @return el producto encontrado
     */
	@Override
	public Producto getBy(Long id) {
		return productoRepository.findById(id).get();
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
