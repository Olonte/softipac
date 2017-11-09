package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.CitaFormulario;
import com.olonte.softipac.modelo.Usuario;

public interface UsuarioServcio {
	Usuario bucarPorNombreUsuario(String nombreUsuario);
	void guardarPaciente(CitaFormulario citaFormulario);
	void guardarUsuario(Usuario usuario);
}
