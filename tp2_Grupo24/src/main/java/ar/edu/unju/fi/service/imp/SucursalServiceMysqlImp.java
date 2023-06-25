package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	
	/**
	 *Método para obtener la lista de Sucursales.
	 *Devuelve las sucursales.
	 */
	@Override
	public List<Sucursal> getListaSucursal() {
		
		return sucursalRepository.findByEstado(true);
	}

	
	/*
	 * Método para guardar una nueva sucursal.
	 * Agrega la nueva sucursal a la lista de sucursales.
	 */
	@Override
	public void guardar(@Valid Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	
	/*
	 * Método para buscar una sucursal.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales.
	 * Devuelve la sucursal encontrada.
	 */
	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	
	/*
	 * Método para editar una sucursal existente.
	 * Actualiza los atributos de la sucursal encontrada con los valores proporcionados.
	 */	
	@Override
	public void editar(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	
	/*
	 * Método para eliminar una sucursal.
	 * Remueve la sucursal de la lista de sucursales.
	 */
	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		sucursalEncontrada.setEstado(false);
		sucursalRepository.save(sucursalEncontrada);
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
