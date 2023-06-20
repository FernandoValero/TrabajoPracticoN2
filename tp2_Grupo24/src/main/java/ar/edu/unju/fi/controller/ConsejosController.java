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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejosController {
	
	@Autowired
	@Qualifier("consejoServiceMysql")
	private IConsejoService consejoService;
	
	/**
	 * Método para obtener la lista de consejos y lo agrega al modelo.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "consejos".
	 */
	@GetMapping("/consejos")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",consejoService.getListaConsejo());
		return "consejos";
	}
	
	/**
	 * Método para obtener la página de creación de un nuevo consejo.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @return el nombre de la vista "nuevo_consejo".
	 */
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	/**
	 * Método para guardar un nuevo consejo.
	 * Lo agrega a la lista de consejos usando el método guardar.
	 * Actualiza el modelo con la lista actualizada de consejos.
	 * 
	 * @param consejo el objeto "consejo" que se va a guardar.
	 * @return el objeto ModelAndView, que redirecciona a la página de lista de consejos.
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
	 * Muestra la página para editar un consejo existente.
	 * 
	 * @param model el objeto Model que se utilizará para pasar datos a la vista.
	 * @param nombre el nombre del consejo que se va a editar.
	 * @return el nombre de la vista "nuevo_consejo".
	 */
	@GetMapping("/editar/{id}")
	public String getEditarConsejoPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion=true;
		Consejo consejoEncontrada = consejoService.getBy(id);
		model.addAttribute("consejo", consejoEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	/*
	 * Método para editar un consejo existente.
	 * Busca el consejo con el mismo nombre en la lista de consejos usando el método getBy.
	 * Actualiza los atributos del consejo encontrado con los valores proporcionados usando el método editar.
	 * Redirecciona a la página de consejo/consejos.
	 */	
	@PostMapping("/editar")
	public String editarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
		if(result.hasErrors()){
			return "nuevo_consejo";
		}
		consejoService.editar(consejo);
		return "redirect:/consejo/consejos";
	}
	
	/*
	 * Método para eliminar un consejo.
	 * Busca el consejo con el nombre proporcionado en la lista de consejos usando el método getBy.
	 * Remueve el consejo de la lista de consejos usando el método eliminar.
	 * Redirecciona a la página de consejo/consejos.
	 */
	@GetMapping("/eliminar/{id}")
	public String EliminarConsejo(@PathVariable(value = "id") Long id) {
		Consejo consejoEncontrada = consejoService.getBy(id);
		consejoService.eliminar(consejoEncontrada);
		return "redirect:/consejo/consejos";
	}
}