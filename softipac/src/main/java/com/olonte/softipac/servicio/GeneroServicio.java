package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Genero;

public interface GeneroServicio {
	Iterable<Genero> buscarTodos();
	List<Genero> buscarTodos(List<Datos> datos);
}
