package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.lista.ListaProducto;
import ar.edu.unju.fi.model.Producto;


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
		model.addAttribute("producto", new Producto());
		return "nuevo_producto";
	}
	@PostMapping("/guardar")
	public ModelAndView setNuevaSucursal(@ModelAttribute("producto")Producto producto) {
		ModelAndView modelView = new ModelAndView("productos");
		listaProducto.getProductos().add(producto);
		modelView.addObject("productos",listaProducto.getProductos());
		return modelView;
	}
}