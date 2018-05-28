package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Estado;

public interface EstadoServicio {
	Iterable<Estado> buscarTodos();
	Estado buscarporId(Integer idEstado);
}
