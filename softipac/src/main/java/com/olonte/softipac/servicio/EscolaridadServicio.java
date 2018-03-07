package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Escolaridad;

public interface EscolaridadServicio {
	Iterable<Escolaridad> buscarTodos();
	Iterable<Escolaridad> buscarEscolaridadesUsuario();
	List<Escolaridad> buscarTodos(List<Datos> datos);
	List<Escolaridad> buscarEscolaridadesUsuario(List<Datos> datos);
}
