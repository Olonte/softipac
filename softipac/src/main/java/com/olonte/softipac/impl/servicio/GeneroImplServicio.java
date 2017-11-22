package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Genero;
import com.olonte.softipac.repositorio.GeneroRepositorio;
import com.olonte.softipac.servicio.GeneroServicio;

@Service
public class GeneroImplServicio implements GeneroServicio {
	
	private GeneroRepositorio generoRepositorio;
	
	@Autowired
	public GeneroImplServicio(GeneroRepositorio generoRepositorio) {
		this.generoRepositorio = generoRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "generos")
	public Iterable<Genero> buscarTodos() {
		return this.generoRepositorio.findAll();
	}

}
