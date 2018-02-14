package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.repositorio.RolRepositorio;
import com.olonte.softipac.servicio.RolServicio;

@Service
public class RolServicioImpl implements RolServicio {
	
	private RolRepositorio rolRepositorio;

	@Autowired
	public RolServicioImpl(RolRepositorio rolRepositorio) {
		this.rolRepositorio = rolRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "roles")
	public Iterable<Rol> buscarTodos() {
		return this.rolRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "rolPorId")
	public Rol buscarPorId(Integer idRol) {
		return this.rolRepositorio.findOne(idRol);
	}

}
