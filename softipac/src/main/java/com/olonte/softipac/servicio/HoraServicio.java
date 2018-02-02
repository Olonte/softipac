package com.olonte.softipac.servicio;

import java.time.LocalDate;
import java.util.List;

import com.olonte.softipac.modelo.Hora;

public interface HoraServicio {
	Iterable<Hora> buscarAgendaPorFecha(LocalDate fecha, Integer idTipoCita, Integer idTipoHora);
	Iterable<Hora> buscarEvaluacionPorFecha(LocalDate fecha);
	List<Hora> buscarHoraPorDocumento(String parametros);
}
