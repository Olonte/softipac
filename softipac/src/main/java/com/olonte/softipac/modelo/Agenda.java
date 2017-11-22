package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
	
	private Cita cita;
	
	private Usuario paciente;
	
	private Usuario aucudiente;
	
	private Set<Diagnostico> diagnosticos = new HashSet<Diagnostico>(0);

	public Agenda() {
	}

	public Agenda(Cita cita, Usuario paciente, Usuario aucudiente, Set<Diagnostico> diagnosticos) {
		this.cita = cita;
		this.paciente = paciente;
		this.aucudiente = aucudiente;
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

	public Usuario getAucudiente() {
		return aucudiente;
	}

	public void setAucudiente(Usuario aucudiente) {
		this.aucudiente = aucudiente;
	}

	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}
