package com.olonte.softipac.modelo;

import java.util.Set;

public class CitaInformacion extends Agenda {
	
	private Usuario padre;
	private Usuario madre;
	private String usuarioAplica;
	
	public CitaInformacion() {
	}

	public CitaInformacion(Cita cita, Usuario paciente, Usuario acudiente, Set<Diagnostico> diagnosticos,
			boolean citaAgenda, boolean javaScript) {
		super(cita, paciente, acudiente, diagnosticos, citaAgenda, javaScript);
	}

	public CitaInformacion(Usuario padre, Usuario madre, String usuarioAplica) {
		this.padre = padre;
		this.madre = madre;
		this.usuarioAplica = usuarioAplica;
	}

	public Usuario getPadre() {
		return padre;
	}

	public void setPadre(Usuario padre) {
		this.padre = padre;
	}

	public Usuario getMadre() {
		return madre;
	}

	public void setMadre(Usuario madre) {
		this.madre = madre;
	}

	public String getUsuarioAplica() {
		return usuarioAplica;
	}

	public void setUsuarioAplica(String usuarioAplica) {
		this.usuarioAplica = usuarioAplica;
	}

}
