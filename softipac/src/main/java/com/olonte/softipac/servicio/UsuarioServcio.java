package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Usuario;

public interface UsuarioServcio {
	Usuario bucarPorNombreUsuario(String nombreUsuario);
	void guardarUsuario(Usuario usuario);
	Usuario bucarPorDocumento(String documento);
}
