package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService {
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private Producto producto;
	
	@Override
	public List<Producto> getLista() {
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void modificar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void eliminar(Producto productoEncontrado){
		productoEncontrado.setEstado(false);
		productoRepository.save(productoEncontrado);
	}

	@Override
	public Producto getBy(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public Producto getProducto() {
		return producto;
	}

}
