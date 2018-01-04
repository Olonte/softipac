package com.olonte.softipac.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.modelo.RegistroListaAgenda;

public interface CitaServicio {
	void guardar(Agenda agenda);
	void actualizar(Agenda agenda);
	CitaJSON buscarPorDocumento(String documento);
	//Iterable<RegistroListaAgenda> buscarTodos();
	Agenda buscarUsuarioAgenda(Integer idUsuario);
	Cita buscarPorIdPaciente(Integer idUsuario);
	ArrayList<Hora> obtenerHoras(Agenda agenda);
	ArrayList<String> obtenerMeses();
	void cancelarCita(Integer idUsuario);
	List<RegistroListaAgenda> buscarTodos();
}
