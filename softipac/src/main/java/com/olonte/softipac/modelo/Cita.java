package com.olonte.softipac.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cita")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cita {
	
	@EmbeddedId
	private CitaId citaId;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fechacitaini")
	private LocalDate fechaCitaIni;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "hora_idhora", referencedColumnName = "idhora"),
		@JoinColumn(name = "hora_tipohora_idtipohora" , referencedColumnName = "tipohora_idtipohora")
		}
	)
	private Hora hora;

	public Cita() {
	}
	
	public CitaId getCitaId() {
		return citaId;
	}

	public void setCitaId(CitaId citaId) {
		this.citaId = citaId;
	}
	
	public LocalDate getFechaCitaIni() {
		return fechaCitaIni;
	}

	public void setFechaCitaIni(LocalDate fechaCitaIni) {
		this.fechaCitaIni = fechaCitaIni;
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
	 
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}
	
}
