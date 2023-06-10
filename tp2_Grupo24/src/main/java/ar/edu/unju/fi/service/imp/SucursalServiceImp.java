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
	 *Método para obtener la lista de Sucursales.
	 *Devuelve las sucursales.
	 */
	@Override
	public List<Sucursal> getListaSucursal() {
		return listaSucursal.getSucursales();
	}

	
	/*
	 * Método para guardar una nueva sucursal.
	 * Agrega la nueva sucursal a la lista de sucursales.
	 */
	@Override
	public void guardar(@Valid Sucursal sucursal) {
		listaSucursal.getSucursales().add(sucursal);
		
	}
 
	
	/*
	 * Método para buscar una sucursal.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales.
	 * Devuelve la sucursal encontrada.
	 */
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

	
	/*
	 * Método para editar una sucursal existente.
	 * Actualiza los atributos de la sucursal encontrada con los valores proporcionados.
	 */	
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

	
	/*
	 * Método para eliminar una sucursal.
	 * Remueve la sucursal de la lista de sucursales.
	 */
	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		listaSucursal.getSucursales().remove(sucursalEncontrada);
		
	}
	
	/*
	 * Método para devolver un sucursal.
	 * Devuelve una sucursal.
	 */
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
}
