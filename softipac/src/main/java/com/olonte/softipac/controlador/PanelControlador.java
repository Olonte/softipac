package com.olonte.softipac.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.olonte.softipac.modelo.UsuarioLoqueado;
import com.olonte.softipac.modelo.UsuarioSession;

@Controller
@Scope(value = "session")
public class PanelControlador {
	
	private UsuarioSession usuarioSession;
	
	@Autowired
	public PanelControlador(UsuarioSession usuarioSession) {
		this.usuarioSession = usuarioSession;
	}

	@RequestMapping(value = "/panel")
	public String iniciar(Model model) {
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
	
	@ModelAttribute(value = "usuarioLogueado")
	public UsuarioSession getUsuarioSession() {
		usuarioSession.setNombres(((UsuarioLoqueado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario().getNombres());
		usuarioSession.setPrimerApellido(((UsuarioLoqueado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario().getPrimerApellido());
		return usuarioSession;
	}
	
}
