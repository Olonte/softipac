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
@Table(name = "resistenciacambio")
public class ResistenciaCambio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idresistenciacambio")
	private Integer idResistenciaCambio;
	
	@Column(name = "cambioshorarios")
	private String cambioshorarios;
	
	@Column(name = "rutas")
	private String rutas;
	
	@Column(name = "ubicacionesp")
	private String ubicacionesp;
	
	@Column(name = "apegoobjetos")
	private String apegoobjetos;
	
	@Column(name = "actvrepetiivas")
	private String actvrepetiivas;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "idhistoriaclinica")
	private HistoriaClinica historiaclinica_idhistoriaclinica;

	public ResistenciaCambio() {
	}

	public Integer getIdResistenciaCambio() {
		return idResistenciaCambio;
	}

	public void setIdResistenciaCambio(Integer idResistenciaCambio) {
		this.idResistenciaCambio = idResistenciaCambio;
	}

	public String getCambioshorarios() {
		return cambioshorarios;
	}

	public void setCambioshorarios(String cambioshorarios) {
		this.cambioshorarios = cambioshorarios;
	}

	public String getRutas() {
		return rutas;
	}

	public void setRutas(String rutas) {
		this.rutas = rutas;
	}

	public String getUbicacionesp() {
		return ubicacionesp;
	}

	public void setUbicacionesp(String ubicacionesp) {
		this.ubicacionesp = ubicacionesp;
	}

	public String getApegoobjetos() {
		return apegoobjetos;
	}

	public void setApegoobjetos(String apegoobjetos) {
		this.apegoobjetos = apegoobjetos;
	}

	public String getActvrepetiivas() {
		return actvrepetiivas;
	}

	public void setActvrepetiivas(String actvrepetiivas) {
		this.actvrepetiivas = actvrepetiivas;
	}

	public HistoriaClinica getHistoriaclinica_idhistoriaclinica() {
		return historiaclinica_idhistoriaclinica;
	}

	public void setHistoriaclinica_idhistoriaclinica(HistoriaClinica historiaclinica_idhistoriaclinica) {
		this.historiaclinica_idhistoriaclinica = historiaclinica_idhistoriaclinica;
	}

}
