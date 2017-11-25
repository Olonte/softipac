package com.olonte.softipac.servicio;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;

public interface CitaServicio {
	void guardarCita(Agenda agenda);
	Cita buscarPorDocumento(String documento);
}
