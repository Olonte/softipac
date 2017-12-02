package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.repositorio.AfinidadRepositorio;
import com.olonte.softipac.servicio.AfinidadServicio;

@Service
public class AfinidadImplServicio implements AfinidadServicio {
	
	private AfinidadRepositorio afinidadRepositorio;
	
	@Autowired
	public AfinidadImplServicio(AfinidadRepositorio afinidadRepositorio) {
		this.afinidadRepositorio = afinidadRepositorio;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void guardar(Afinidad afinidad) {
		this.afinidadRepositorio.save(afinidad);
	}

}
