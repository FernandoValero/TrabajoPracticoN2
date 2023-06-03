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
import ar.edu.unju.fi.lista.ListaProducto;
import ar.edu.unju.fi.model.Producto;


@Controller
@RequestMapping("/producto")
public class ProductosController {
	
	@Autowired
	private ListaProducto listaProducto;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	@GetMapping("/nuevo")
	public String getNuevoiProductoPage(Model model) {
		boolean edicion= false;
		String boton="Guardar";
		model.addAttribute("producto", producto);
		model.addAttribute("edicion", edicion);
		model.addAttribute("boton", boton);
		return "nuevo_producto";
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto")Producto producto) {
		ModelAndView modelAndView = new ModelAndView("productos");
		listaProducto.getProductos().add(producto);
		modelAndView.addObject("productos",listaProducto.getProductos());
		return modelAndView;
	}
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
		boolean edicion= true;
		String boton="Editar";
		Producto productoEncontrado = new Producto();
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()==codigo) {
				productoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		model.addAttribute("boton", boton);
		return "nuevo_producto";
	}
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto")Producto producto) {
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()==producto.getCodigo()) {
				prod.setNombre(producto.getNombre());
				prod.setPrecio(producto.getPrecio());
				prod.setCategoria(producto.getCategoria());
				prod.setDescuento(producto.getDescuento());
				break;
			}
		}
		return "redirect:/producto/listado";
	}
	@GetMapping("/eliminar/{codigo}")
	public String elimanarProducto(@PathVariable(value="codigo")int codigo) {
		for (Producto prod : listaProducto.getProductos()) {
			if(prod.getCodigo()==codigo) {
				listaProducto.getProductos().remove(prod);
				break;
			}
		}
		return "redirect:/producto/listado";
	}
}