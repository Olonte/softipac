package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.TipoUsuario;
import com.olonte.softipac.predicado.TipoUsuarioPredicado;
import com.olonte.softipac.repositorio.TipoUsuarioRepositorio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;

@Service
public class TipoUsuarioImplServicio implements TipoUsuarioServicio {
	
	private TipoUsuarioRepositorio tipoUsuarioRepositorio;
	
	@Autowired
	public TipoUsuarioImplServicio(TipoUsuarioRepositorio tipoUsuarioRepositorio) {
		this.tipoUsuarioRepositorio = tipoUsuarioRepositorio;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tiposUsuario")
	public Iterable<TipoUsuario> buscarTodos() {
		return this.tipoUsuarioRepositorio.findAll(TipoUsuarioPredicado.buscarTodos());
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tipoUsuarioPorId")
	public TipoUsuario buscarPorId(Integer idTipoUsuario) {
		return this.tipoUsuarioRepositorio.findOne(idTipoUsuario);
	}

}
