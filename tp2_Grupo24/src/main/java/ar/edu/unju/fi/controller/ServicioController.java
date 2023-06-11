package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.lista.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	ListaServicio listaServicios;
	/**Inytección de una intancia de la intefaz IServicioService*/ 
	@Autowired
	private IServicioService servicio;
	
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
	public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		ModelAndView modelView = new ModelAndView("servicios");
		if(result.hasErrors()){
			
			modelView.setViewName("nuevo_servicio");
			return modelView;
		}
		
		listaServicios.getServicios().add(servicio);
		modelView.addObject("servicios", listaServicios.getServicios());
		return modelView;
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
	/**
	 * Método para modificar un servicio existente.
	 * @return vista "servicios" mediante la redirección.
	 */
	@PostMapping("/editar")
	public String editarServicio(@Valid @ModelAttribute("servicio")Servicio servicio,BindingResult result) {
		if(result.hasErrors()){
		
			return "nuevo_servicio";
		}
		for(Servicio serv: listaServicios.getServicios()) {
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setDia(servicio.getDia());
				serv.setPaseador(servicio.getPaseador());
				serv.setHorario(servicio.getHorario());
			}
		}
		return "redirect:/servicio/servicios";
	}
	
	/**
	 * Método para eliminar un servicio.
	 * @return vista "servicios" mediante la redirección.
	 */
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