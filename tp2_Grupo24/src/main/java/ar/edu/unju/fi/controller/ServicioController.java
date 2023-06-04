package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.lista.ListaServicio;
import ar.edu.unju.fi.model.Servicio;


@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	ListaServicio listaServicios;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 * Método que maneja la solicitud GET "/servicio/servicios" y muestra la página de lista de servicios.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "servicios" que se mostrará al usuario.
	 */

	@GetMapping("/servicios")
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "servicios";
	}
	
	/**
	 * Método que maneja la solicitud GET "/servicio/nuevo" y muestra la página para crear un nuevo servicio.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "nuevo_servicio" que se mostrará al usuario.
	 */
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicio", servicio);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	
	/**
	 * Método que maneja la solicitud POST "/servicio/guardar" y guarda un nuevo servicio en la lista de servicios.
	 * 
	 * @param servicio el objeto Servicio que se va a guardar.
	 * @return un objeto ModelAndView que redirecciona a la página de lista de servicios.
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarServicioPage(@ModelAttribute("servicios")Servicio servicio) {
		ModelAndView ModelView = new ModelAndView("servicios");
		listaServicios.getServicios().add(servicio);
		ModelView.addObject("servicios", listaServicios.getServicios());
		return ModelView;
	}
	/**
	 * Método que maneja la solicitud GET "/servicio/editar/{paseador}" y muestra la página para editar un servicio existente.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @param paseador de servicio que se va a editar.
	 * @return el nombre de la vista "nuevo_servicio" que se mostrará al usuario.
	 */
	@GetMapping("/editar/{paseador}")
	public String getEditarServicioPage1(Model model, @PathVariable(value="paseador")String paseador) {
		Servicio servicioEncontrada = new Servicio();
		boolean edicion = true;
		for(Servicio serv : listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				servicioEncontrada = serv;
				break;
			}	
		}
		model.addAttribute("servicio", servicioEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	@PostMapping("/editar")
	public String editarServicio(@ModelAttribute("servicio")Servicio servicio) {
		for(Servicio serv: listaServicios.getServicios()) {
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setDia(servicio.getDia());
				serv.setPaseador(servicio.getPaseador());
				serv.setHorario(servicio.getHorario());
			}
		}
		return "redirect:/servicio/servicios";
	}
	
	@GetMapping("/eliminar/{paseador}")
	public String EliminarServicio(@PathVariable(value="paseador")String paseador) {
		for(Servicio serv:listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}
		return "redirect:/servicio/servicios";
	}

}