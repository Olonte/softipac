package com.olonte.softipac.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cita")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcita")
	private Integer idCita;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fechacitaini")
	private LocalDate fechaCitaIni;
	
	@DateTimeFormat(pattern = "")
	@Column(name = "fechaevaluacion")
	private LocalDate fechaEvaluacion;
	
	@Column(name = "horaevaluacion")
	private String horaEvaluacion;
	
	@Column(name = "motivoconsulta")
	private String motivoConsulta;
	
	@Column(name = "expectativas")
	private String expectativas;
	
	@Column(name = "recomtenercta")
	private String recomTenerCta;
	
	@Column(name = "infogral")
	private String inFoGral;
	
	@Column(name = "observacion")
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "tipocita_idtipocita", nullable = false)
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "hora_idhora", nullable = false)
	private Hora hora;

	public Cita() {
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}


	public LocalDate getFechaCitaIni() {
		return fechaCitaIni;
	}

	public void setFechaCitaIni(LocalDate fechaCitaIni) {
		this.fechaCitaIni = fechaCitaIni;
	}

	public LocalDate getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public String getHoraEvaluacion() {
		return horaEvaluacion;
	}

	public void setHoraEvaluacion(String horaEvaluacion) {
		this.horaEvaluacion = horaEvaluacion;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getExpectativas() {
		return expectativas;
	}

	public void setExpectativas(String expectativas) {
		this.expectativas = expectativas;
	}

	public String getRecomTenerCta() {
		return recomTenerCta;
	}

	public void setRecomTenerCta(String recomTenerCta) {
		this.recomTenerCta = recomTenerCta;
	}

	public String getInFoGral() {
		return inFoGral;
	}

	public void setInFoGral(String inFoGral) {
		this.inFoGral = inFoGral;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

}
