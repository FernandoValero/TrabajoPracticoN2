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
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	
	/* 
	 * Método para obtener la lista de sucursales y la agrega al modelo.
	 * Devuelve la página "sucursales".
	 */
	@GetMapping("/sucursales")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales",sucursalService.getListaSucursal());
		return "sucursales";
	}
	
	
	/* 
	 * Método para obtener la página de creación de una nueva sucursal.
	 * Devuelve la página "nueva_sucursal".
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	
	/*
	 * Método para guardar una nueva sucursal.
	 * Agrega la nueva sucursal a la lista de sucursales usando el método guardar.
	 * Actualiza el modelo con la lista actualizada de sucursales.
	 * Devuelve el objeto ModelAndView.
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_sucursal") ;
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		sucursalService.guardar(sucursal);
		modelView.addObject("sucursales", sucursalService.getListaSucursal());
		return modelView;
	}
	
	/*
	 * Método para obtener la página de edición de una sucursal existente.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales usando el método getBy.
	 * Establece la sucursal encontrada y el indicador de "edicion" en el modelo.
	 * Devuelve la página "nueva_sucursal".
	 */
	@GetMapping("/editar/{nombre}")
	public String getEditarSucursalPage(Model model, @PathVariable(value="nombre") String nombre) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = sucursalService.getBy(nombre);
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
		
	
	/*
	 * Método para editar una sucursal existente.
	 * Busca la sucursal con el mismo nombre en la lista de sucursales usando el método getBy.
	 * Actualiza los atributos de la sucursal encontrada con los valores proporcionados usando el método editar.
	 * Redirecciona a la página de sucural/sucursales.
	 */		
	@PostMapping("/editar")
	public String editarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		if(result.hasErrors()) {
			return "nueva_sucursal";
		}
		sucursalService.editar(sucursal);
		return "redirect:/sucursal/sucursales";
	}
	
	
	/*
	 * Método para eliminar una sucursal.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales usando el método getBy.
	 * Remueve la sucursal de la lista de sucursales usando el método eliminar.
	 * Redirecciona a la página de sucural/sucursales.
	 */
	@GetMapping("/eliminar/{nombre}")
	public String EliminarSucursal(@PathVariable(value="nombre") String nombre) {
		Sucursal sucursalEncontrada= sucursalService.getBy(nombre);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursal/sucursales";
	}
}