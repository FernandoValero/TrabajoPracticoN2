package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/consejos")
public class ConsejosController {
	
	@GetMapping(value = "/consejos")
	public String getPaginaConsejo(Model model) {
	    return "consejos";
	}
	


}