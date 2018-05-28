package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Estado;
import com.olonte.softipac.repositorio.EstadoRepositorio;
import com.olonte.softipac.servicio.EstadoServicio;

@Service
public class EstadoImplServicio implements EstadoServicio {
	
	private EstadoRepositorio estadoRepositorio;
	
	@Autowired
	public EstadoImplServicio(EstadoRepositorio estadoRepositorio) {
		this.estadoRepositorio = estadoRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "estados")
	public Iterable<Estado> buscarTodos() {
		return this.estadoRepositorio.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "estadoPorId")
	public Estado buscarporId(Integer idEstado) {
		return this.estadoRepositorio.findOne(idEstado);
	}

}
