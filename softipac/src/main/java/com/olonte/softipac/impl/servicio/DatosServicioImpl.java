package com.olonte.softipac.impl.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.repositorio.DatosRepositorio;
import com.olonte.softipac.servicio.DatosServicio;

@Service
public class DatosServicioImpl implements DatosServicio {
	
	private DatosRepositorio datosRepositorio;
		
	@Autowired
	public DatosServicioImpl(DatosRepositorio datosRepositorio) {
		this.datosRepositorio = datosRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "datos")
	public List<Datos> buscarTodos() {		
		return this.datosRepositorio.findAll();
	}

}
