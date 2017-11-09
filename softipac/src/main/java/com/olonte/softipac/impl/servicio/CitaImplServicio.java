package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.repositorio.CitaRepositorio;
import com.olonte.softipac.servicio.CitaServicio;

@Service
public class CitaImplServicio implements CitaServicio {
	
	private CitaRepositorio citaRepositorio;
	
	@Autowired
	public CitaImplServicio(CitaRepositorio citaRepositorio) {
		this.citaRepositorio = citaRepositorio;
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarCita(Cita cita) {
		this.citaRepositorio.save(cita);

	}

}
