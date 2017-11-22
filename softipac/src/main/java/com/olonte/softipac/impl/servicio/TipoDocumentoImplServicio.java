package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.TipoDocumento;
import com.olonte.softipac.repositorio.TipoDocumentoRepositorio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;

@Service
public class TipoDocumentoImplServicio implements TipoDocumentoServicio {
	
	private TipoDocumentoRepositorio tipoDocumentoRepositorio;

	@Autowired
	public TipoDocumentoImplServicio(TipoDocumentoRepositorio tipoDocumentoRepositorio) {
		this.tipoDocumentoRepositorio = tipoDocumentoRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tiposDocumento")
	public Iterable<TipoDocumento> buscarTodos() {
		return this.tipoDocumentoRepositorio.findAll();
	}

}
