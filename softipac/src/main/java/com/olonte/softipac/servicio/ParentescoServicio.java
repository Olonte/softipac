package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Parentesco;

public interface ParentescoServicio {
	Iterable<Parentesco> buscarTodos();
	List<Parentesco> buscarTodos(List<Datos> datos);
	Parentesco buscarPorId(Integer idParentesco);
}
