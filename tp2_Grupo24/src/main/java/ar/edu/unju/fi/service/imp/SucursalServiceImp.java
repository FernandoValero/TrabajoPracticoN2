package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ar.edu.unju.fi.lista.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Service
public class SucursalServiceImp implements ISucursalService{

	@Autowired
	private ListaSucursal listaSucursal;
	
	@Autowired
	private Sucursal sucursal;
	
	/**
	 * Método para obtener la lista de Sucursales 
	 *Devuelve las sucursales
	 */
	@Override
	public List<Sucursal> getListaSucursal() {
		return listaSucursal.getSucursales();
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		listaSucursal.getSucursales().add(sucursal);
		
	}

	@Override
	public Sucursal getBy(String nombre) {
		Sucursal sucursalEncontrada=null;
		for(Sucursal sucu : listaSucursal.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrada=sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}

	@Override
	public void editar(Sucursal sucursal) {
		for (Sucursal sucu:listaSucursal.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setHorario(sucursal.getHorario());
				sucu.setImagen(sucursal.getImagen());
				sucu.setNombre(sucursal.getNombre());
				sucu.setTelefono(sucursal.getTelefono());
				break;
			}	
		}
	}

	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		listaSucursal.getSucursales().remove(sucursalEncontrada);
		
	}
	
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
}
