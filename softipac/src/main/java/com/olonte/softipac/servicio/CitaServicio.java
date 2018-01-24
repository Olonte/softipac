package com.olonte.softipac.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.modelo.RegistroListaAgenda;

public interface CitaServicio {
	void guardarActualizar(int tipoCita, int transaccion, Integer idEstado, Agenda agenda);
	CitaJSON buscarPorDocumento(String documento);
	Agenda buscarUsuarioAgenda(Integer idUsuario, Integer idTipoUsuario, Integer idTipoCita);
	Cita buscarPorIdPaciente(Integer idUsuario, Integer idTipoCita);
	ArrayList<Hora> obtenerHoras(Agenda agenda, Integer idTipoHora);
	ArrayList<String> obtenerMeses();
	void cambiarEstadoCita(Integer idUsuario, Integer idTipoCita, Integer idEstado);
	LocalDate obtenerFechaCitaIni(Integer idUsuario, Integer idTipoCita);
	List<RegistroListaAgenda> buscarTodos();
}
