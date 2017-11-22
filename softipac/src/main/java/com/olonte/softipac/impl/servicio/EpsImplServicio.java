package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Eps;
import com.olonte.softipac.repositorio.EpsRepositorio;
import com.olonte.softipac.servicio.EpsServicio;

@Service
public class EpsImplServicio implements EpsServicio {
	
	private EpsRepositorio epsRepositorio;
	
	@Autowired
	public EpsImplServicio(EpsRepositorio epsRepositorio) {
		this.epsRepositorio = epsRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "eps")
	public Iterable<Eps> buscarTodos() {
		return this.epsRepositorio.findAll();
	}

}
