package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Rol;

public interface RolServicio {
	Iterable<Rol> buscarTodos();
	Rol buscarPorId(Integer idRol);
}
