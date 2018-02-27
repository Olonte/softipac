package com.olonte.softipac.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "remision")
public class Remision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idremision")
	private Integer idRemision;
	
	@Column(name = "remitidopor")	
	private String remitidoPor;
	
	@Column(name = "motivo")	
	private String motivo;	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "idhistoriaclinica")
	private HistoriaClinica historiaclinica_idhistoriaclinica;

	public Remision() {
	}

	public Integer getIdRemision() {
		return idRemision;
	}

	public void setIdRemision(Integer idRemision) {
		this.idRemision = idRemision;
	}

	public String getRemitidoPor() {
		return remitidoPor;
	}

	public void setRemitidoPor(String remitidoPor) {
		this.remitidoPor = remitidoPor;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public HistoriaClinica getHistoriaclinica_idhistoriaclinica() {
		return historiaclinica_idhistoriaclinica;
	}

	public void setHistoriaclinica_idhistoriaclinica(HistoriaClinica historiaclinica_idhistoriaclinica) {
		this.historiaclinica_idhistoriaclinica = historiaclinica_idhistoriaclinica;
	}
	
}
