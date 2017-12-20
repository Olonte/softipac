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
import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.HoraServicio;
import com.olonte.softipac.servicio.UsuarioServicio;

@RestController
@Scope(value = "session")
public class CitaRestControlador {
	
	private UsuarioServicio usuarioServicio;
	
	private HoraServicio horaServicio;
	
	private CitaServicio citaServicio;
	
	private DiagnosticoServcio diagnosticoServcio;
	
	@Autowired
	public CitaRestControlador(UsuarioServicio usuarioServicio, HoraServicio horaServicio, CitaServicio citaServicio,
			DiagnosticoServcio diagnosticoServcio) {
		this.usuarioServicio = usuarioServicio;
		this.horaServicio = horaServicio;
		this.citaServicio = citaServicio;
		this.diagnosticoServcio = diagnosticoServcio;
	}
	
	/**
	 * 
	 * @param fecha
	 * @return
	 */

	@RequestMapping(value ="/obtenerHora/{fechaCitaIni}", method = RequestMethod.GET)
	public Iterable<Hora> buscarHorasDisponibles(@PathVariable("fechaCitaIni") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha){
		return this.horaServicio.buscarAgendaPorFecha(fecha);
	}
	
	/**
	 * 
	 * @param documento
	 * @return
	 */
	@RequestMapping(value = "/obtenerPaciente/{pacienteDocumento}", method = RequestMethod.GET)
	public UsuarioJSON obtenerUsuarioPorDocumento(@PathVariable("pacienteDocumento") String documento){
		return this.usuarioServicio.bucarPorDocumento(documento);
	}
	
	/**
	 * 
	 * @param documento
	 * @return
	 */
	@RequestMapping(value = "/obtenerCita/{pacienteDocumento}", method = RequestMethod.GET)
	public CitaJSON obtenerCitaPorDocumento(@PathVariable("pacienteDocumento") String documento){
		return this.citaServicio.buscarPorDocumento(documento);
	}
}
