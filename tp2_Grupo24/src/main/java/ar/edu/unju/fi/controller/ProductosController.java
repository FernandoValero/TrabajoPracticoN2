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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * La clase ProductosController es un controlador que maneja las solicitudes relacionadas con los productos.
 * @author Grupo_24
 */
@Controller
@RequestMapping("/producto")
public class ProductosController {
	/**Inytección de una intancia de la intefaz IProductoService*/ 
	@Autowired
	private IProductoService productoService;
	
	/**
	 * Método para obtener la lista de productos.
	 * @return vista "productos".
	 */
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", productoService.getLista());
		return "productos";
	}
	/**
	 * Método para obtener la página formulario para la creación de un nuevo producto.
	 * @return la vista "nuevo_producto".
	 */
	@GetMapping("/nuevo")
	public String getNuevoiProductoPage(Model model) {
		boolean edicion= false;
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	/**
	 * Método para guardar un producto.
	 * @return Un objeto ModelAndView que representa la vista "producto" o "nuevo_producto".
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("producto", producto);
			return modelAndView;
		}
		productoService.guardar(producto);
		modelAndView.addObject("productos",productoService.getLista());
		return modelAndView;
	}
	/**
	 * Método para obtener la página de modificación de un producto.
	 * @return La vista "nuevo_producto".
	 */
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
		boolean edicion= true;
		model.addAttribute("producto", productoService.getBy(codigo));
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	/**
	 * Método para modificar un producto existente.
	 * @return vista "listado" mediante la redirección.
	 */
	@PostMapping("/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("edicion", true);
			return "nuevo_producto";
		}
		productoService.modificar(producto);
		return "redirect:/producto/listado";
	}
	/**
	 * Método para eliminar un producto.
	 * @return vista "listado" mediante la redirección.
	 */
	@GetMapping("/eliminar/{codigo}")
	public String elimanarProducto(@PathVariable(value="codigo")int codigo) {
		for (Producto prod : productoService.getLista()) {
			if(prod.getCodigo()==codigo) {
				productoService.eliminar(prod);
				break;
			}
		}
		return "redirect:/producto/listado";
	}
}