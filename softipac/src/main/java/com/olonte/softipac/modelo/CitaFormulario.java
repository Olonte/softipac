package com.olonte.softipac.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CitaFormulario {
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaCitaIni;
	
	private Integer idHora;
	
	private Usuario paciente;
	
	private Usuario familiarPaciente;

	public CitaFormulario() {
	}

	public CitaFormulario(LocalDate fechaCitaIni, int idHora, Usuario paciente, Usuario familiarPaciente) {
		this.fechaCitaIni = fechaCitaIni;
		this.idHora = idHora;
		this.paciente = paciente;
		this.familiarPaciente = familiarPaciente;
	}

	public LocalDate getFechaCitaIni() {
		return fechaCitaIni;
	}

	public void setFechaCitaIni(LocalDate fechaCitaIni) {
		this.fechaCitaIni = fechaCitaIni;
	}

	public Integer getIdHora() {
		return idHora;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}

	public Usuario getFamiliarPaciente() {
		return familiarPaciente;
	}

	public void setFamiliarPaciente(Usuario familiarPaciente) {
		this.familiarPaciente = familiarPaciente;
	}
	
}
