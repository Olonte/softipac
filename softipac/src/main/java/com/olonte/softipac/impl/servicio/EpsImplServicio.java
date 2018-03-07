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
import com.olonte.softipac.modelo.Eps;
import com.olonte.softipac.repositorio.EpsRepositorio;
import com.olonte.softipac.servicio.EpsServicio;
import com.olonte.softipac.utilidad.Utilidad;

@Service
public class EpsImplServicio implements EpsServicio {
	
	private EpsRepositorio epsRepositorio;
	
	@Autowired
	public EpsImplServicio(EpsRepositorio epsRepositorio) {
		this.epsRepositorio = epsRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "epses")
	public Iterable<Eps> buscarTodos() {
		return this.epsRepositorio.findAll();
	}

	@Override
	public List<Eps> buscarTodos(List<Datos> datos) {
		List<Eps> epsListado = new ArrayList<>();
		for(Eps eps : datos.get(Utilidad.INDICE_DEFECTO).getEps()) {
			epsListado.add(eps);
		}
		return ordernarEpsListado(epsListado);
	}
	
	private List<Eps> ordernarEpsListado(List<Eps> epsListado) {		
		Collections.sort(epsListado, new Comparator<Eps>() {
			public int compare(Eps eps1, Eps eps2) {
				return Integer.valueOf(eps1.getIdEps().compareTo(eps2.getIdEps()));
			}
		});		
		return epsListado;
	}
	
}
