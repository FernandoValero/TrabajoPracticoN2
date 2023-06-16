package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.lista.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejoService{
	
	@Autowired
	private ListaConsejo listaConsejo;
	
	@Autowired
	private Consejo consejo;
	
	
	/**
	 *Método para obtener la lista de Consejos.
	 *Devuelve los consejos.
	 */
	@Override
	public List<Consejo> getListaConsejo() {
		return listaConsejo.getConsejos();
	}
	
	/*
	 * Método para guardar un nuevo consejo.
	 * Agrega el nuevo consejo a la lista de consejos.
	 */
	@Override
	public void guardar(@Valid Consejo consejo) {
		listaConsejo.getConsejos().add(consejo);
		
	}
	
	/*
	 * Método para buscar un consejo.
	 * Busca el consejo con el nombre proporcionado en la lista de consejos.
	 * Devuelve el consejo encontrado.
	 */
	@Override
	public Consejo getBy(String nombre) {
		Consejo consejoEncontrada=null;
		for(Consejo consejo : listaConsejo.getConsejos()) {
			if(consejo.getTitulo().equals(nombre)) {
				consejoEncontrada=consejo;
				break;
			}
		}
		return consejoEncontrada;
	}

	/*
	 * Método para editar un consejo existente.
	 * Actualiza los atributos del consejo encontrado con los valores proporcionados.
	 */
	@Override
	public void editar(Consejo consejo) {
		for (Consejo conse:listaConsejo.getConsejos()) {
			if(conse.getTitulo().equals(consejo.getTitulo())) {
				conse.setTitulo(consejo.getTitulo());
				conse.setDescripcion(consejo.getDescripcion());
				conse.setImagen(consejo.getImagen());
				break;
			}	
		}
		
	}
	
	/*
	 * Método para eliminar un consejo.
	 * Remueve el consejo de la lista de consejos.
	 */
	@Override
	public void eliminar(Consejo consejoEncontrada) {
		listaConsejo.getConsejos().remove(consejoEncontrada);
		
	}

	/*
	 * Método para devolver un consejo.
	 * Devuelve un consejo.
	 */
	@Override
	public Consejo getConsejo() {
		return consejo;
	}
}
