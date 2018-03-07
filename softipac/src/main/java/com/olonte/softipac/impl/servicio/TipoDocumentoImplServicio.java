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
import com.olonte.softipac.modelo.TipoDocumento;
import com.olonte.softipac.predicado.TipoDocumentoPredicado;
import com.olonte.softipac.repositorio.TipoDocumentoRepositorio;
import com.olonte.softipac.servicio.TipoDocumentoServicio;
import com.olonte.softipac.utilidad.Utilidad;

@Service
public class TipoDocumentoImplServicio implements TipoDocumentoServicio {
	
	private TipoDocumentoRepositorio tipoDocumentoRepositorio;

	@Autowired
	public TipoDocumentoImplServicio(TipoDocumentoRepositorio tipoDocumentoRepositorio) {
		this.tipoDocumentoRepositorio = tipoDocumentoRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tiposDocumento")
	public Iterable<TipoDocumento> buscarTodos() {
		return this.tipoDocumentoRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tiposDocumentoUsuario")
	public Iterable<TipoDocumento> buscarTiposDocumentoUsuario() {
		return this.tipoDocumentoRepositorio.findAll(TipoDocumentoPredicado.buscarTiposDocumentosUsuario());
	}

	@Override
	public List<TipoDocumento> buscarTodos(List<Datos> datos) {
		List<TipoDocumento> tipoDocumentos = new ArrayList<>();		
		for (TipoDocumento tipoDocumento : datos.get(Utilidad.INDICE_DEFECTO).getTipoDocumentos()) {
			tipoDocumentos.add(tipoDocumento);
		}
		return ordernarTipoDocumentos(tipoDocumentos);
	}

	@Override
	public List<TipoDocumento> buscarTiposDocumentoUsuario(List<Datos> datos) {
		List<TipoDocumento> tipoDocumentos = new ArrayList<>();		
		for(TipoDocumento tipoDocumento : datos.get(Utilidad.INDICE_DEFECTO).getTipoDocumentos()) {
			if (tipoDocumento.getIdTipoDocumento() != Utilidad.TIPO_DOC_REG_CV && 
					tipoDocumento.getIdTipoDocumento() != Utilidad.TIPO_DOC_TRJ_ID ) {
				tipoDocumentos.add(tipoDocumento);
			}
		}				
		return ordernarTipoDocumentos(tipoDocumentos);
	}
	
	private List<TipoDocumento> ordernarTipoDocumentos(List<TipoDocumento> tipoDocumentos) {		
		Collections.sort(tipoDocumentos, new Comparator<TipoDocumento>() {
			public int compare(TipoDocumento tipoDocumento1, TipoDocumento tipoDocumento2) {
				return Integer.valueOf(tipoDocumento1.getIdTipoDocumento().compareTo(tipoDocumento2.getIdTipoDocumento()));
			}
		});		
		return tipoDocumentos;
	}
	
}
