package com.olonte.softipac.servicio;

import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.modelo.Usuario;

public interface UsuarioServicio {
	Usuario bucarPorNombreUsuario(String nombreUsuario);
	void guardar(Usuario usuario);
	UsuarioJSON bucarPorDocumento(String documento);
	Usuario buscarPacientePorId(Integer idUsuario);
	Usuario buscarAcudientePorId(Integer idUsuario);
}
