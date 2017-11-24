package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.TipoCita;
import com.olonte.softipac.predicado.TipoCitaPredicado;
import com.olonte.softipac.repositorio.TipoCitaRepositorio;
import com.olonte.softipac.servicio.TipoCitaServicio;

public class TipoCitaImplServicio implements TipoCitaServicio {
	
	private TipoCitaRepositorio tipoCitaRepositorio;
	
	@Autowired
	public TipoCitaImplServicio(TipoCitaRepositorio tipoCitaRepositorio) {
		this.tipoCitaRepositorio = tipoCitaRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "tipoCitaPorId")
	public TipoCita buscarPorId(Integer idTipoCita) {
		return this.tipoCitaRepositorio.findOne(TipoCitaPredicado.buscarPorId(idTipoCita));
	}

}
