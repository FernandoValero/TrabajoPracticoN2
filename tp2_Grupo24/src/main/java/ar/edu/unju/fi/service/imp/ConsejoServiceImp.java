package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.lista.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejoService{
	
	@Autowired
	private ListaConsejo listaConsejo;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getListaConsejo() {
		return listaConsejo.getConsejos();
	}
	
	@Override
	public void guardar(@Valid Consejo consejo) {
		listaConsejo.getConsejos().add(consejo);
		
	}
	
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
	

	@Override
	public void eliminar(Consejo consejoEncontrada) {
		listaConsejo.getConsejos().remove(consejoEncontrada);
		
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}
}
