package com.olonte.softipac.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.HoraServicio;
import com.olonte.softipac.utilidad.Utilidad;

@RestController
@Scope(value = "session")
public class CitaRestControlador {
	
	private HoraServicio horaServicio;
	
	private CitaServicio citaServicio;
	
	@Autowired
	public CitaRestControlador(HoraServicio horaServicio, CitaServicio citaServicio) {
		this.horaServicio = horaServicio;
		this.citaServicio = citaServicio;
	}

	/**
	 * 
	 * @param fecha
	 * @return
	 */

	@RequestMapping(value ="/obtenerHora/{fechaCitaIni}", method = RequestMethod.GET)
	public Iterable<Hora> buscarHorasDisponibles(@PathVariable("fechaCitaIni") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha) {
		return this.horaServicio.buscarAgendaPorFecha(fecha,Utilidad.CITA_AGENDA,Utilidad.HORA_AGENDA);
	}
	
	/**
	 * 
	 * @param documento
	 * @return
	 */
	@RequestMapping(value = "/obtenerCita/{parametros}", method = RequestMethod.GET)
	public CitaJSON obtenerCitaPorDocumento(@PathVariable("parametros") String parametros){
		return this.citaServicio.buscarPorDocumento(parametros);
	}
	
}
