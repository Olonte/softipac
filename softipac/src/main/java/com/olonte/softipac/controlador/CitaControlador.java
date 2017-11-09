package com.olonte.softipac.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CitaControlador {
	
	
	
	@RequestMapping(value="/panelCita")
	public String panelCita(){
		return "panelCita";
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String crearNuevaCita(Model model) {
		return "agenda";
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.POST)
	public String procesarNuevaCita(){
		return "redirect:/agenda";
	}
	
	

}
