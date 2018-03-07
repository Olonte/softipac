package com.olonte.softipac.impl.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Parentesco;
import com.olonte.softipac.predicado.ParentescoPredicado;
import com.olonte.softipac.repositorio.ParentescoRepositorio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.utilidad.Utilidad;

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
		Integer idParentesco = 1;
		return this.parentescoRepositorio.findAll(ParentescoPredicado.buscarTodos(idParentesco));
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "parentescoPorId")
	public Parentesco buscarPorId(Integer idParentesco) {
		return this.parentescoRepositorio.findOne(idParentesco);
	}

	@Override
	public List<Parentesco> buscarTodos(List<Datos> datos) {
		List<Parentesco> parentescos = new ArrayList<>();
		for(Parentesco parentesco : datos.get(Utilidad.INDICE_DEFECTO).getParentescos()) {
			parentescos.add(parentesco);
		}
		return ordernarParentescos(parentescos);
	}
	
	private List<Parentesco> ordernarParentescos(List<Parentesco> parentescos) {		
		Collections.sort(parentescos, new Comparator<Parentesco>() {
			public int compare(Parentesco parentesco1, Parentesco parentesco2) {
				return Integer.valueOf(parentesco1.getIdParentesco().compareTo(parentesco2.getIdParentesco()));
			}
		});		
		return parentescos;
	}

}
