package com.olonte.softipac.impl.servicio;

import java.time.LocalDate;
import java.util.List;

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
	public Iterable<Hora> buscarAgendaPorFecha(LocalDate fecha, Integer idTipoCita, Integer idTipoHora) {
		return this.horaRepositorio.findAll(HoraPredicado.buscarAgendaPorFecha(fecha,idTipoCita,idTipoHora));
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Hora> buscarEvaluacionPorFecha(LocalDate fecha) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hora> buscarHoraPorDocumento(String documento) {
		return (List<Hora>) this.horaRepositorio.findAll(HoraPredicado.buscarHorasPorDocumento(documento));
	}

}
