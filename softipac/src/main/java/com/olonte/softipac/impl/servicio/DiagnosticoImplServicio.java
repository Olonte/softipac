package com.olonte.softipac.impl.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Datos;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.repositorio.DiagnosticoRepositorio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;

@Service
public class DiagnosticoImplServicio implements DiagnosticoServcio {
	
	private DiagnosticoRepositorio diagnosticoRepositorio;
	
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	public DiagnosticoImplServicio(DiagnosticoRepositorio diagnosticoRepositorio, UsuarioServicio usuarioServicio) {
		this.diagnosticoRepositorio = diagnosticoRepositorio;
		this.usuarioServicio = usuarioServicio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "diagnosticos")
	public Iterable<Diagnostico> buscarTodos() {
		return this.diagnosticoRepositorio.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "diagnosticoPorId")
	public Diagnostico bucarPorId(Integer idDiagnostico) {
		return this.diagnosticoRepositorio.findOne(idDiagnostico);
	}
  
	@Override
	@Transactional(readOnly = true)
	public Set<Diagnostico> buscarPorIdUsuario(Integer idUsuario) {
		return this.usuarioServicio.buscarPacientePorId(idUsuario).getDiagnosticos();
	}

	@Override
	public List<Diagnostico> buscarTodos(List<Datos> datos) {
		List<Diagnostico> diagnosticos = new ArrayList<>();
		for(Diagnostico diagnostico : datos.get(Utilidad.INDICE_DEFECTO).getDiagnosticos()) {
			diagnosticos.add(diagnostico);
		}
		return ordernarDiagnosticos(diagnosticos);
	}
	
	private List<Diagnostico> ordernarDiagnosticos(List<Diagnostico> diagnosticos) {		
		Collections.sort(diagnosticos, new Comparator<Diagnostico>() {
			public int compare(Diagnostico diagnosticos1, Diagnostico diagnosticos2) {
				return Integer.valueOf(diagnosticos1.getIdDiagnostico().compareTo(diagnosticos2.getIdDiagnostico()));
			}
		});		
		return diagnosticos;
	}
	
}
