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
import ar.edu.unju.fi.lista.ListaServicio;
import ar.edu.unju.fi.model.Servicio;


@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	ListaServicio listaServicios;
	
	@Autowired
	private Servicio servicio;
	
	@GetMapping("/servicios")
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "servicios";
	}
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicio", servicio);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarServicioPage(@ModelAttribute("servicios")Servicio servicio) {
		ModelAndView ModelView = new ModelAndView("servicios");
		listaServicios.getServicios().add(servicio);
		ModelView.addObject("servicios", listaServicios.getServicios());
		return ModelView;
	}
	@GetMapping("/editar/{paseador}")
	public String getEditarServicioPage1(Model model, @PathVariable(value="paseador")String paseador) {
		Servicio servicioEncontrada = new Servicio();
		boolean edicion = true;
		for(Servicio serv : listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				servicioEncontrada = serv;
				break;
			}	
		}
		model.addAttribute("servicio", servicioEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	@PostMapping("/editar")
	public String editarServicio(@ModelAttribute("servicio")Servicio servicio) {
		for(Servicio serv: listaServicios.getServicios()) {
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setDia(servicio.getDia());
				serv.setPaseador(servicio.getPaseador());
				serv.setHorario(servicio.getHorario());
			}
		}
		return "redirect:/servicio/servicios";
	}
	
	@GetMapping("/eliminar/{paseador}")
	public String EliminarServicio(@PathVariable(value="paseador")String paseador) {
		for(Servicio serv:listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}
		return "redirect:/servicio/servicios";
	}

}