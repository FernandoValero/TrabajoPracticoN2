package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service("consejoServiceMysql")
public class ConsejoServiceMysqlImp implements IConsejoService {

	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	/**
	 *Método para obtener la lista de Consejos.
	 *Devuelve los consejos.
	 */
	@Override
	public List<Consejo> getListaConsejo() {
		return consejoRepository.findByEstado(true);
	}
	
	/*
	 * Método para guardar un nuevo consejo.
	 * Agrega el nuevo consejo a la lista de consejos.
	 */
	@Override
	public void guardar(@Valid Consejo consejo) {
		consejo.setEstado(true);
		consejoRepository.save(consejo);

	}

	/*
	 * Método para buscar un consejo.
	 * Busca el consejo con el nombre proporcionado en la lista de consejos.
	 * Devuelve el consejo encontrado.
	 */
	@Override
	public Consejo getBy(Long id) {
		
		return consejoRepository.findById(id).get();
	}

	/*
	 * Método para editar un consejo existente.
	 * Actualiza los atributos del consejo encontrado con los valores proporcionados.
	 */	
	@Override
	public void editar(Consejo consejo) {
		
		consejoRepository.save(consejo);

	}

	/*
	 * Método para eliminar un consejo.
	 * Elimina el consejo de la lista de consejos.
	 */
	@Override
	public void eliminar(Consejo consejoEncontrada) {
		consejoEncontrada.setEstado(false);
		consejoRepository.save(consejoEncontrada);
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
