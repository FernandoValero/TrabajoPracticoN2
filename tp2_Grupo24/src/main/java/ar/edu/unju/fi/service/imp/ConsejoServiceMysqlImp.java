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
	
	@Override
	public List<Consejo> getListaConsejo() {
		return consejoRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Consejo consejo) {
		consejo.setEstado(true);
		consejoRepository.save(consejo);

	}

	@Override
	public Consejo getBy(Long id) {
		
		return consejoRepository.findById(id).get();
	}

	@Override
	public void editar(Consejo consejo) {
		
		consejoRepository.save(consejo);

	}

	@Override
	public void eliminar(Consejo consejoEncontrada) {
		consejoEncontrada.setEstado(false);
		consejoRepository.save(consejoEncontrada);
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

}
