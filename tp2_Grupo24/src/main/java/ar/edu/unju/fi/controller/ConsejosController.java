package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.lista.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/consejo")
public class ConsejosController {
	
	ListaConsejo listaConsejos= new ListaConsejo();

	@GetMapping("/consejos")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",listaConsejos.getConsejos());
		return "consejos";
	}
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("consejo", new Consejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@ModelAttribute("consejos")Consejo consejo) {
		ModelAndView modelView = new ModelAndView("consejos");
		listaConsejos.getConsejos().add(consejo);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return modelView;
	}
	
	@GetMapping("/editar/{nombre}")
	public String getEditarConsejoPage(Model model, @PathVariable(value = "nombre") String nombre) {
		boolean edicion=true;
		Consejo consejoEncontrada = new Consejo();
		for(Consejo consejo:listaConsejos.getConsejos()) {
			if(consejo.getTitulo().equals(nombre)) {
				consejoEncontrada=consejo;
				break;
			}	
		}
		model.addAttribute("consejo", consejoEncontrada);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
		
	@PostMapping("/editar")
	public String editarConsejo(@ModelAttribute("consejo")Consejo consejo) {
		for(Consejo conse:listaConsejos.getConsejos()) {
			if(conse.getTitulo().equals(consejo.getTitulo())) {
				conse.setDescripcion(consejo.getDescripcion());
			}
		}
		return "redirect:/consejo/consejos";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String EliminarConsejo(@PathVariable(value = "nombre") String nombre) {
		for(Consejo consejo:listaConsejos.getConsejos()) {
			if(consejo.getTitulo().equals(nombre)) {
				listaConsejos.getConsejos().remove(consejo);
				break;
			}	
		}
		return "redirect:/consejo/consejos";
	}
}