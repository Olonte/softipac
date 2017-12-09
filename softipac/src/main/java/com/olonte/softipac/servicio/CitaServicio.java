package com.olonte.softipac.servicio;

import java.util.ArrayList;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.modelo.RegistroListaAgenda;

public interface CitaServicio {
	void guardar(Agenda agenda);
	CitaJSON buscarPorDocumento(String documento);
	Iterable<RegistroListaAgenda> buscarTodos();
	Agenda buscarUsuarioAgenda(Integer idUsuario);
	Cita buscarPorIdPaciente(Integer idUsuario);
	ArrayList<Hora> obtenerHoras(Agenda agenda);
	ArrayList<String> obtenerMeses();
}
