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

import ar.edu.unju.fi.lista.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	
	@Autowired
	ListaSucursal listaSucursales;
	
	@Autowired
	private Sucursal sucursal;

	@GetMapping("/sucursales")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales",listaSucursales.getSucursales());
		return "sucursales";
	}
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
	
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
		
	
			
	@PostMapping("/editar")
	public String editarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
		for(Sucursal sucu:listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setHorario(sucursal.getHorario());
			}
		}
		return "redirect:/sucursal/sucursales";
	}
	
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