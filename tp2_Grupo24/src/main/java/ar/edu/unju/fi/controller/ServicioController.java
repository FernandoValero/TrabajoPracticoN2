package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	/**Inytección de una intancia de la intefaz IServicioService*/ 
	@Autowired
	@Qualifier("servicioServiceMysql")
	private IServicioService servicioService;
	/**
	 * Método que maneja la solicitud GET "/servicio/servicios" y muestra la página de lista de servicios.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "servicios" que se mostrará al usuario.
	 */

	@GetMapping("/servicios")
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios", servicioService.getListaServicio());
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
		model.addAttribute("servicio", servicioService.getServicio());
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
			modelView.addObject("servicio", servicio);
			return modelView;
		}
		
		servicioService.guardar(servicio);
		modelView.addObject("servicios", servicioService.getListaServicio());
		return modelView;
	}
	/**
	 * Método que maneja la solicitud GET "/servicio/editar/{paseador}" y muestra la página para editar un servicio existente.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @param paseador de servicio que se va a editar.
	 * @return el nombre de la vista "nuevo_servicio" que se mostrará al usuario.
	 */
	@GetMapping("/editar/{id}")
	public String getEditarServicioPage(Model model, @PathVariable(value="id")Long id) {
		boolean edicion = true;
		Servicio servicioEncontrada = servicioService.getBy(id);
		model.addAttribute("servicio", servicioEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	/**
	 * Método para modificar un servicio existente.
	 * @return vista "servicios" mediante la redirección.
	 */
	@PostMapping("/editar")
	public String editarServicio(@Valid @ModelAttribute("servicio")Servicio servicio,BindingResult result, Model model) {
		if(result.hasErrors()){
		return "nuevo_servicio";
		}
		servicioService.editar(servicio);
		return "redirect:/servicio/servicios";
	}
	
	/**
	 * Método para eliminar un servicio.
	 * @return vista "servicios" mediante la redirección.
	 */
	@GetMapping("/eliminar/{id}")
	public String EliminarServicio(@PathVariable(value="id")Long id) {
		Servicio servicioEncontrada= servicioService.getBy(id);
		servicioService.eliminar(servicioEncontrada);
		return "redirect:/servicio/servicios";
	}

}