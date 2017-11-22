package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Parentesco;
import com.olonte.softipac.repositorio.ParentescoRepositorio;
import com.olonte.softipac.servicio.ParentescoServicio;

@Service
public class ParentescoImplServicio implements ParentescoServicio {
	
	private ParentescoRepositorio parentescoRepositorio;
	
	@Autowired
	public ParentescoImplServicio(ParentescoRepositorio parentescoRepositorio) {
		this.parentescoRepositorio = parentescoRepositorio;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "parentescos")
	public Iterable<Parentesco> buscarTodos() {
		return this.parentescoRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "parentescoPorId")
	public Parentesco bucarPorId(Integer idParentesco) {
		return this.parentescoRepositorio.findOne(idParentesco);
	}

}
