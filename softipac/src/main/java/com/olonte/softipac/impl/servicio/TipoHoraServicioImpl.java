package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.TipoHora;
import com.olonte.softipac.repositorio.TipoHoraRepositorio;
import com.olonte.softipac.servicio.TipoHoraServicio;

@Service
public class TipoHoraServicioImpl implements TipoHoraServicio {
	
	private TipoHoraRepositorio tipoHoraRepositorio;
	
	@Autowired
	public TipoHoraServicioImpl(TipoHoraRepositorio tipoHoraRepositorio) {
		this.tipoHoraRepositorio = tipoHoraRepositorio;
	}

	@Override
	@Transactional(readOnly = false)
	public TipoHora buscarPorId(Integer idTipoHora) {
		return this.tipoHoraRepositorio.findOne(idTipoHora);
	}


}
