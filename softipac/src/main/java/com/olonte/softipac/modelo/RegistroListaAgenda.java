package com.olonte.softipac.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistroListaAgenda {
	
	private Integer idcita;
	private Integer idTipoCita;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaCitaIni;
	private String hora;
	private Integer idUsuario;
	private String nombres;
	private String primerApellido;
	private String telefonoFijo;
	private String telefonoCelular;	
	
	public RegistroListaAgenda() {
	}

	public RegistroListaAgenda(Integer idcita, Integer idTipoCita, LocalDate fechaCitaIni, String hora,
			Integer idUsuario, String nombres, String primerApellido, String telefonoFijo, String telefonoCelular) {
		this.idcita = idcita;
		this.idTipoCita = idTipoCita;
		this.fechaCitaIni = fechaCitaIni;
		this.hora = hora;
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.telefonoFijo = telefonoFijo;
		this.telefonoCelular = telefonoCelular;
	}

	public Integer getIdcita() {
		return idcita;
	}

	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
	}

	public Integer getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(Integer idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	public LocalDate getFechaCitaIni() {
		return fechaCitaIni;
	}

	public void setFechaCitaIni(LocalDate fechaCitaIni) {
		this.fechaCitaIni = fechaCitaIni;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

}
