package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
	
	private Cita cita;
	
	private Usuario paciente;
	
	private Usuario acudiente;
	
	private Set<Diagnostico> diagnosticos = new HashSet<Diagnostico>(0);

	public Agenda() {
	}
   
	public Agenda(Cita cita, Usuario paciente, Usuario acudiente, Set<Diagnostico> diagnosticos) {
		this.cita = cita;
		this.paciente = paciente;
		this.acudiente = acudiente;
		this.diagnosticos = diagnosticos;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}

	public Usuario getAcudiente() {
		return acudiente;
	}

	public void setAcudiente(Usuario acudiente) {
		this.acudiente = acudiente;
	}

	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}
