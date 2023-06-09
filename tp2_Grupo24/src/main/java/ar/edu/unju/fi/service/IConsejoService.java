package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;
import jakarta.validation.Valid;


public interface IConsejoService {
	
	/**
	 *Devuelve la lista de Consejos
	 */
	List<Consejo> getListaConsejo();
	
	/**
	 *Metodo que permite guardar un consejo
	 *@param consejo, valor a guardar.
	 */
	void guardar (@Valid Consejo consejo);
	
	/**
	 *Metodo para buscar un consejo que coincida con el id por parametro
	 *@param id, consejo a buscar.
	 */
	Consejo getBy(Long id);
	
	/**
	 *Metodo que permite modificar los datos de un consejo
	 *@param consejo, consejo a modificar.
	 */
	void editar (Consejo consejo);
	
	/**
	 *Metodo que permite eliminar un consejo
	 * *@param consejoEncontrada, consejo a eliminar
	 */
	void eliminar (Consejo consejoEncontrada);
	
	/**
	 *Devuelve la instancia de un consejo.
	 */
	Consejo getConsejo();
	
}
