package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService{
	
	@Override
	public List<Producto> getLista() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Producto productoEncontrado) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Producto getBy(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Producto getSucursal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public ProductoServiceImp() {
		// TODO Auto-generated constructor stub
	}
}
