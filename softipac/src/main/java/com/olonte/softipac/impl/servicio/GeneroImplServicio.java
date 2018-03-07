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
import com.olonte.softipac.modelo.Genero;
import com.olonte.softipac.repositorio.GeneroRepositorio;
import com.olonte.softipac.servicio.GeneroServicio;
import com.olonte.softipac.utilidad.Utilidad;

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

	@Override
	public List<Genero> buscarTodos(List<Datos> datos) {		
		List<Genero> generos = new ArrayList<>();		
		for(Genero genero : datos.get(Utilidad.INDICE_DEFECTO).getGeneros()) {
			generos.add(genero);
		}		
		return ordernarGeneros(generos);
	}
	
	private List<Genero> ordernarGeneros(List<Genero> generos) {		
		Collections.sort(generos, new Comparator<Genero>() {
			public int compare(Genero genero1, Genero genero2) {
				return Integer.valueOf(genero1.getIdGenero().compareTo(genero2.getIdGenero()));
			}
		});		
		return generos;
	}

}
