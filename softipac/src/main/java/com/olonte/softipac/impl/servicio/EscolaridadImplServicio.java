package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Escolaridad;
import com.olonte.softipac.predicado.EscolaridadPredicado;
import com.olonte.softipac.repositorio.EscolaridadRepositorio;
import com.olonte.softipac.servicio.EscolaridadServicio;

@Service
public class EscolaridadImplServicio implements EscolaridadServicio {

	private EscolaridadRepositorio escolaridadRepositorio;
	
	@Autowired
	public EscolaridadImplServicio(EscolaridadRepositorio escolaridadRepositorio) {
		this.escolaridadRepositorio = escolaridadRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "escolaridades")
	public Iterable<Escolaridad> buscarTodos() {
		return this.escolaridadRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value ="escolaridadesUsuario")
	public Iterable<Escolaridad> buscarEscolaridadesUsuario() {
		return this.escolaridadRepositorio.findAll(EscolaridadPredicado.buscarEscolaridadesUsuario());
	}

}
