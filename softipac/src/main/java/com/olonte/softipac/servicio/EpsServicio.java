package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Eps;

public interface EpsServicio {
	Iterable<Eps> buscarTodos();
	List<Eps> buscarTodos(List<Datos> datos);
}
