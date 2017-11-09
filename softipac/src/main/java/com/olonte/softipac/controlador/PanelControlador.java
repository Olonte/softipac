package com.olonte.softipac.controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioLoqueado;

@Controller
public class PanelControlador {
	
	@RequestMapping(value = "/panel")
	public String iniciar(Model model) {
		model.addAttribute("usuarioLogueado", obtenerUsuarioLogueado());
		return "panel";
	}
	
	@RequestMapping(value = "/logout")
	public String salirPagina() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/login?logout";
	}
	
	private String obtenerUsuarioLogueado() {
		Usuario usuario = ((UsuarioLoqueado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
		return usuario.getNombres() + " " + usuario.getPrimerApellido();
	}
	
}
