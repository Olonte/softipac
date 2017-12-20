package com.olonte.softipac.controlador;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	/**
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap modelMap) {
		modelMap.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}
	
	/**
	 * 
	 * @return
	 */
	private String getPrincipal() {
		String nombreUsuario = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			nombreUsuario = ((UserDetails)principal).getUsername();
		} else {
			nombreUsuario = principal.toString();
		}
		
		return nombreUsuario;
	}

}
