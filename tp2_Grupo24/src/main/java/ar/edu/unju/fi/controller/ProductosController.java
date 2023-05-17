package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.lista.ListaProducto;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/producto")
public class ProductosController {
	ListaProducto listaProducto = new ListaProducto();
	@GetMapping("/listado")
	public String getListaSucursalPage(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("productos", new Sucursal());
		return "nuevo_producto";
	}
	
	
}