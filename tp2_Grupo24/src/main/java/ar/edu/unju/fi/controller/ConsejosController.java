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
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejosController {
	
	@Autowired
	private IConsejoService consejoService;
	
	/**
	 * Método que maneja la solicitud GET "/consejo/consejos" y muestra la página de lista de consejos.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "consejos" que se mostrará al usuario.
	 */
	@GetMapping("/consejos")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",consejoService.getListaConsejo());
		return "consejos";
	}
	
	/**
	 * Método que maneja la solicitud GET "/consejo/nuevo" y muestra la página para crear un nuevo consejo.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "nuevo_consejo" que se mostrará al usuario.
	 */
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	/**
	 * Método que maneja la solicitud POST "/consejo/guardar" y guarda un nuevo consejo en la lista de consejos.
	 * 
	 * @param consejo el objeto Consejo que se va a guardar.
	 * @return un objeto ModelAndView que redirecciona a la página de lista de consejos.
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()){
			modelView.setViewName("nuevo_consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		consejoService.guardar(consejo);
		modelView.addObject("consejos", consejoService.getListaConsejo());
		return modelView;
	}
	
	
	/**
	 * Método que maneja la solicitud GET "/consejo/editar/{nombre}" y muestra la página para editar un consejo existente.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @param nombre el nombre del consejo que se va a editar.
	 * @return el nombre de la vista "nuevo_consejo" que se mostrará al usuario.
	 */
	@GetMapping("/editar/{nombre}")
	public String getEditarConsejoPage(Model model, @PathVariable(value = "nombre") String nombre) {
		boolean edicion=true;
		Consejo consejoEncontrada = consejoService.getBy(nombre);
		model.addAttribute("consejo", consejoEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
		
	@PostMapping("/editar")
	public String editarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
		if(result.hasErrors()){
			return "nuevo_consejo";
		}
		consejoService.editar(consejo);
		return "redirect:/consejo/consejos";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String EliminarConsejo(@PathVariable(value = "nombre") String nombre) {
		Consejo consejoEncontrada = consejoService.getBy(nombre);
		consejoService.eliminar(consejoEncontrada);
		return "redirect:/consejo/consejos";
	}
}