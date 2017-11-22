package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.TipoUsuario;

public interface TipoUsuarioServicio {
	Iterable<TipoUsuario> buscarTodos();
	TipoUsuario buscarPorId(Integer idTipoUsuario);
}
