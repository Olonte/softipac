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
import com.olonte.softipac.modelo.Escolaridad;
import com.olonte.softipac.predicado.EscolaridadPredicado;
import com.olonte.softipac.repositorio.EscolaridadRepositorio;
import com.olonte.softipac.servicio.EscolaridadServicio;
import com.olonte.softipac.utilidad.Utilidad;

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

	@Override
	public List<Escolaridad> buscarTodos(List<Datos> datos) {
		List<Escolaridad> escolaridades = new ArrayList<>();
		for(Escolaridad escolaridad : datos.get(Utilidad.INDICE_DEFECTO).getEscolaridades()) {
			escolaridades.add(escolaridad);
		}
		return ordernarEscolaridades(escolaridades);
	}

	@Override
	public List<Escolaridad> buscarEscolaridadesUsuario(List<Datos> datos) {
		List<Escolaridad> escolaridades = new ArrayList<>();
		for(Escolaridad escolaridad : datos.get(Utilidad.INDICE_DEFECTO).getEscolaridades()) {
			if (escolaridad.getIdEscolaridad() != Utilidad.ESCOLARIDAD_JARDIN &&
					escolaridad.getIdEscolaridad() != Utilidad.ESCOLARIDAD_INC_ESC) {
				escolaridades.add(escolaridad);
			}			
		}
		return ordernarEscolaridades(escolaridades);
	}
	
	private List<Escolaridad> ordernarEscolaridades(List<Escolaridad> escolaridades) {		
		Collections.sort(escolaridades, new Comparator<Escolaridad>() {
			public int compare(Escolaridad escolaridad1, Escolaridad escolaridad2) {
				return Integer.valueOf(escolaridad1.getIdEscolaridad().compareTo(escolaridad2.getIdEscolaridad()));
			}
		});		
		return escolaridades;
	}

}
