package com.olonte.softipac.servicio;

import java.util.List;
import java.util.Set;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Diagnostico;

public interface DiagnosticoServcio {
	Iterable<Diagnostico> buscarTodos();
	List<Diagnostico> buscarTodos(List<Datos> datos);
	Diagnostico bucarPorId(Integer idDiagnostico);
	Set<Diagnostico> buscarPorIdUsuario(Integer idUsuario);
}
