package com.olonte.softipac.servicio;

import java.util.List;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.TipoDocumento;

public interface TipoDocumentoServicio {
	Iterable<TipoDocumento> buscarTodos();
	Iterable<TipoDocumento> buscarTiposDocumentoUsuario();
	List<TipoDocumento> buscarTodos(List<Datos> datos);
	List<TipoDocumento> buscarTiposDocumentoUsuario(List<Datos> datos);
}
