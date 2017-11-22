package com.olonte.softipac.impl.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.predicado.HoraPredicado;
import com.olonte.softipac.repositorio.HoraRepositorio;
import com.olonte.softipac.servicio.HoraServicio;

@Service
public class HoraImplServicio implements HoraServicio {
	
	private HoraRepositorio horaRepositorio;
	
	@Autowired
	public HoraImplServicio(HoraRepositorio horaRepositorio) {
		this.horaRepositorio = horaRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Hora> buscarPorFecha(LocalDate fecha) {
		return this.horaRepositorio.findAll(HoraPredicado.buscarPorFecha(fecha));
	}

}
