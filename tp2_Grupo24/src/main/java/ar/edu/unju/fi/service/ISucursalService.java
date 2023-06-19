package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {

	/**
	 *Devuelve la lista de Sucursales
	 */
	List<Sucursal> getListaSucursal();
	
	/**
	 *Metodo que permite guardar una sucursal
	 *@param sucursal, valor a guardar
	 */
	void guardar (@Valid Sucursal sucursal);
	
	/**
	 *Metodo para buscar una sucursal que coincida con el id por paramtero
	 *@param id, sucursal a buscar
	 */
	Sucursal getBy(Long id);
	
	/**
	 *Metodo que permite modificar los datos de una sucursal
	 *@param sucursal, sucursal a modificar
	 */
	void editar (Sucursal sucursal);
	
	/**
	 *Metodo que permite eliminar una sucursal
	 * *@param sucursalEncontrada, sucursal a eliminar
	 */
	void eliminar (Sucursal sucursalEncontrada);
	
	/**
	 *Devuelve la instancia de una sucursal
	 */
	Sucursal getSucursal();

	/**
	 *Método para obtener la lista de Sucursales.
	 *Devuelve las sucursales.
	 */
}
