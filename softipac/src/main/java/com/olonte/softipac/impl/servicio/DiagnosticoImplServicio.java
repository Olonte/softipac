package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.predicado.DiagnosticoPredicado;
import com.olonte.softipac.repositorio.DiagnosticoRepositorio;
import com.olonte.softipac.servicio.DiagnosticoServcio;

@Service
public class DiagnosticoImplServicio implements DiagnosticoServcio {
	
	private DiagnosticoRepositorio diagnosticoRepositorio;
	
	@Autowired
	public DiagnosticoImplServicio(DiagnosticoRepositorio diagnosticoRepositorio) {
		this.diagnosticoRepositorio = diagnosticoRepositorio;
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
	@Cacheable(value = "diagnosticoPorIds")
	public Iterable<Diagnostico> buscarPorIds(String idsDiagnostico) {
		return this.diagnosticoRepositorio.findAll(DiagnosticoPredicado.buscarPorIds(obtenerIdsDiagnostico(idsDiagnostico)));
	}
	
	private Number[] obtenerIdsDiagnostico(String idsDiagnostico) {
		Number ids [] = new Number[longitudArreglo(idsDiagnostico)];
		int pos = 0;
		for(int indiceInicio = 0; indiceInicio < idsDiagnostico.length(); indiceInicio++) {
   			if (!(idsDiagnostico.substring(indiceInicio,indiceInicio + 1).equals(","))) {
   				ids[pos] = Integer.parseInt(idsDiagnostico.substring(indiceInicio,indiceInicio + 1));
   				pos++;
   			}
   		 }
		return ids;
	}

	private int longitudArreglo(String idsDiagnostico) {
		int longitud = 0;
		String separador = ",";
		for( int indiceInicio = 0; indiceInicio < idsDiagnostico.length(); indiceInicio++ ) {
    		if ( !(idsDiagnostico.substring(indiceInicio,indiceInicio + 1).equals(separador)) ) {
    			longitud++;
    		}
    	}
		return longitud;
	}
	
}
