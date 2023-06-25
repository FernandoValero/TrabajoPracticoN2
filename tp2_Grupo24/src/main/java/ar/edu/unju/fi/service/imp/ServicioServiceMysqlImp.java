package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service("servicioServiceMysql")
public class ServicioServiceMysqlImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	@Override
	public List<Servicio> getListaServicio() {

		return servicioRepository.findByEstado(true);
	}
	/*
	 * Método para guardar un nuevo servicio.
	 * Agrega el nuevo servicio a la lista de servicio.
	 */
	@Override
	public void guardar(@Valid Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}
	/*
	 * Método para buscar un servicio.
	 * Busca del servicio con el nombre proporcionado en la lista de servicios.
	 * Devuelve el servicio encontrado.
	 */
	@Override
	public Servicio getBy(Long id) {
		return servicioRepository.findById(id).get();
	}
	/*
	 * Método para editar un servicio existente.
	 * Actualiza los atributos del servicio encontrado con los valores proporcionados.
	 */
	@Override
	public void editar(Servicio servicio) {
		servicioRepository.save(servicio);

	}
	/*
	 * Método para eliminar un servicio..
	 * Remueve el servicio de la lista de servicios.
	 */
	@Override
	public void eliminar(Servicio servicioEncontrada) {
		//eliminacion logica
		servicioEncontrada.setEstado(false);
		servicioRepository.save(servicioEncontrada);
		

	}
	/*
	 * Método para devolver un servicio.
	 * Devuelve un servicio.
	 */
	@Override
	public Servicio getServicio() {
		
		return servicio;
	}

}
