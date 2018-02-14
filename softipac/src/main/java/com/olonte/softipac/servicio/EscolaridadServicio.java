package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Escolaridad;

public interface EscolaridadServicio {
	Iterable<Escolaridad> buscarTodos();
	Iterable<Escolaridad> buscarEscolaridadesUsuario();
}
