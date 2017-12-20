package com.olonte.softipac.servicio;

import java.util.Set;

import com.olonte.softipac.modelo.Diagnostico;

public interface DiagnosticoServcio {
	Iterable<Diagnostico> buscarTodos();
	Diagnostico bucarPorId(Integer idDiagnostico);
	Iterable<Diagnostico> buscarPorIds(String idsDiagnostico);
	//Set<Diagnostico> buscarPorIdPaciente(Integer idUsuario);
}
