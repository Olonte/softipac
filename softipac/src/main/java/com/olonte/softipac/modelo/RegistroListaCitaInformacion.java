package com.olonte.softipac.modelo;

public class RegistroListaCitaInformacion {
	
	private Integer idcita;
	private Integer idTipoCita;
	private String documento;
	private Integer idUsuario;
	private String nombres;
	private String primerApellido;
	private String eps;
	private String escolaridad;
	private String telefonoCelular;
	
	public RegistroListaCitaInformacion() {
	}

	public RegistroListaCitaInformacion(Integer idcita, Integer idTipoCita, String documento, Integer idUsuario,
			String nombres, String primerApellido, String eps, String escolaridad, String telefonoCelular) {
		this.idcita = idcita;
		this.idTipoCita = idTipoCita;
		this.documento = documento;
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.eps = eps;
		this.escolaridad = escolaridad;
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


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
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


	public String getEps() {
		return eps;
	}


	public void setEps(String eps) {
		this.eps = eps;
	}


	public String getEscolaridad() {
		return escolaridad;
	}


	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}


	public String getTelefonoCelular() {
		return telefonoCelular;
	}


	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

}
