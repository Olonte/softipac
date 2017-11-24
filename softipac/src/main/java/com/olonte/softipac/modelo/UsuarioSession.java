package com.olonte.softipac.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class UsuarioSession extends Usuario {
	public String obtenerNombresApellidos() {
		return getNombres() + " " + getPrimerApellido();
	}
}
