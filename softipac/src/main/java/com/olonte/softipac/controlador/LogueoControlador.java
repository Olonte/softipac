package com.olonte.softipac.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogueoControlador {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/")
	public String authentication(){
		return "redirect:/login";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() { 
		return "login"; 
	}
	
	
}
