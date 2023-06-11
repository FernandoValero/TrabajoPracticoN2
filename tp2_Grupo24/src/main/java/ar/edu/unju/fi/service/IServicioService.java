package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

/**
* Esta interfaz define los métodos para administrar los servicios.
*/
public interface IServicioService {
	/**
	 *Devuelve la lista de Servicio
	 */
	List<Servicio> getLista();
	
	/**
	 *Metodo que permite guardar un servicio
	 *@param servicio, valor a guardar
	 */
	void guardar (@Valid Servicio servicio);
	
	/**
	 *Metodo que permite editar los datos de un servicio
	 *@param servicio, servicio a editar
	 */
	void editar (Servicio servicio);
	
	/**
	 *Metodo que permite eliminar un servicio
	 * *@param servicioEncontrada, servicio a eliminar
	 */
	
	void eliminar(Servicio servicio);

	/**
	 *Metodo para buscar un servicio que coincida con el paseador por paramtero
	 *@param paseador, servicio a buscar
	 */
	Servicio getBy(String paseador);
	/**
	 *Devuelve la instancia de un servicio
	 */
	
	Servicio getServicio();
}
