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

	@Override
	public void guardar(@Valid Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	@Override
	public Servicio getBy(Long id) {
		return servicioRepository.findById(id).get();
	}

	@Override
	public void editar(Servicio servicio) {
		/*servicio.setid(servicio.getId());
		servicio.setDia(servicio.getDia());
		servicio.setPaseador(servicio.getPaseador());
		servicio.setHorario(servicio.getHorario());
		sucursal.setEstado(true);*/
		servicioRepository.save(servicio);

	}

	@Override
	public void eliminar(Servicio servicioEncontrada) {
		//eliminacion logica
		servicioEncontrada.setEstado(false);
		servicioRepository.save(servicioEncontrada);
		

	}

	@Override
	public Servicio getServicio() {
		
		return servicio;
	}

}
