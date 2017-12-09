package com.olonte.softipac.servicio;

import java.time.LocalDate;

import com.olonte.softipac.modelo.Hora;

public interface HoraServicio {
	Iterable<Hora> buscarAgendaPorFecha(LocalDate fecha);
	Iterable<Hora> buscarEvaluacionPorFecha(LocalDate fecha);
}
