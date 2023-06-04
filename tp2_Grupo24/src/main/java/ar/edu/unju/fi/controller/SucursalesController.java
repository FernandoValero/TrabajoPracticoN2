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

import ar.edu.unju.fi.lista.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	
	@Autowired
	ListaSucursal listaSucursales;
	
	@Autowired
	private Sucursal sucursal;
	
	
	/* 
	 * Método para obtener la lista de sucursales y la agrega al modelo.
	 * Devuelve la página "sucursales".
	 */
	@GetMapping("/sucursales")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales",listaSucursales.getSucursales());
		return "sucursales";
	}
	
	
	/* 
	 * Método para obtener la página de creación de una nueva sucursal.
	 * Devuelve la página "nueva_sucursal".
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	
	/*
	 * Método para guardar una nueva sucursal.
	 * Agrega la nueva sucursal a la lista de sucursales.
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
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
	
	/*
	 * Método para obtener la página de edición de una sucursal existente.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales.
	 * Establece la sucursal encontrada y el indicador de "edicion" en el modelo.
	 * Devuelve la página "nueva_sucursal".
	 */
	@GetMapping("/editar/{nombre}")
	public String getEditarSucursalPage(Model model, @PathVariable(value="nombre") String nombre) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = new Sucursal();
		for(Sucursal sucursal:listaSucursales.getSucursales()) {
			if(sucursal.getNombre().equals(nombre)) {
				sucursalEncontrada=sucursal;
				break;
			}	
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
		
	
	/*
	 * Método para editar una sucursal existente.
	 * Busca la sucursal con el mismo nombre en la lista de sucursales.
	 * Actualiza los atributos de la sucursal encontrada con los valores proporcionados.
	 * Redirecciona a la página de sucural/sucursales.
	 */		
	@PostMapping("/editar")
	public String editarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		if(result.hasErrors()) {
			return "nueva_sucursal";
		}
		for(Sucursal sucu:listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setHorario(sucursal.getHorario());
			}
		}
		return "redirect:/sucursal/sucursales";
	}
	
	
	/*
	 * Método para eliminar una sucursal.
	 * Busca la sucursal con el nombre proporcionado en la lista de sucursales.
	 * Remueve la sucursal de la lista de sucursales.
	 * Redirecciona a la página de sucural/sucursales.
	 */
	@GetMapping("/eliminar/{nombre}")
	public String EliminarSucursal(@PathVariable(value="nombre") String nombre) {
		for(Sucursal sucursal:listaSucursales.getSucursales()) {
			if(sucursal.getNombre().equals(nombre)) {
				listaSucursales.getSucursales().remove(sucursal);
				break;
			}	
		}
		return "redirect:/sucursal/sucursales";
	}
}