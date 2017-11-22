package com.olonte.softipac.servicio;

import java.time.LocalDate;

import com.olonte.softipac.modelo.Hora;

public interface HoraServicio {
	Iterable<Hora> buscarPorFecha(LocalDate fecha);
}
