package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.lista.ListaServicio;
import ar.edu.unju.fi.service.IServicioService;

/**
 * Implementación de la interfaz IServicioService que proporciona métodos para administrar los servicios.
 */

@Service
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	private ListaServicio listaServicio;
	
	@Autowired
	private Servicio servicio;

	/**
	* Obtiene la lista de todos los servicios.
	* @return una lista de servicios
	*/
	@Override
	public List<Servicio> getListaServicio(){
		return listaServicio.getServicios();
	}
	/**
	*  Guarda un nuevo servicio.
	*  @param servicio, servicio a guardar.
	*/
	@Override
	public void guardar(Servicio servicio) {
		listaServicio.getServicios().add(servicio);
	}
	/**
	    * Encuentra un servicio de acuerdo a su paseador.
	    * @param paseador, el paseador de servicio a buscar.
	    * @return el servicio que tenga coincidencia.
	    */
	@Override
	public Servicio getBy(Long id) {
		Servicio servicioEncontrada=new Servicio();
		for(Servicio serv : listaServicio.getServicios()) {
			if(serv.getId().equals(id)) {
				servicioEncontrada=serv;
				break;
			}
		}
		return servicioEncontrada;
	}
	/**
	*  edita un servicio existente.
	*  @param servicio, servicio a editar.
	*/
	@Override
	public void editar(Servicio servicio) {
		for(Servicio serv:listaServicio.getServicios()) {
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setDia(servicio.getDia());
				serv.setPaseador(servicio.getPaseador());
				serv.setHorario(servicio.getHorario());
				break;
			}
		}
	}
	/**
	*  Elimina un servicio existente.
	*  @param servicioEncontrada, el servicio a eliminar.
	*/
	@Override
	public void eliminar(Servicio servicioEncontrada) {
		listaServicio.getServicios().remove(servicioEncontrada);
	}
	/**
	    * Genera un nuevo servicio.
	    * @return un objeto servicio.
	    */
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
}