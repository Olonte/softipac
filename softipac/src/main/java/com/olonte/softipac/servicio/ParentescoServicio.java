package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Parentesco;

public interface ParentescoServicio {
	Iterable<Parentesco> buscarTodos();
	Parentesco buscarPorId(Integer idParentesco);
}
