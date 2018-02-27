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
@Table(name = "repertoriobasico")
public class RepertorioBasico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrepertoriobasico")
	private Integer idRepertorioBasico;
	
	@Column(name = "contactovisual")
	private String contactovisual;
	
	@Column(name = "atencion")
	private String atencion;
	
	@Column(name = "imitacionmotora")
	private String imitacionmotora;

	@Column(name = "imitacionobjetos")
	private String imitacionobjetos;
	
	@Column(name = "seguinstrucciones")
	private String seguinstrucciones;
	
	@Column(name = "esqcorporal")
	private String esqcorporal;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "idhistoriaclinica")
	private HistoriaClinica historiaclinica_idhistoriaclinica;

	public RepertorioBasico() {
	}

	public Integer getIdRepertorioBasico() {
		return idRepertorioBasico;
	}

	public void setIdRepertorioBasico(Integer idRepertorioBasico) {
		this.idRepertorioBasico = idRepertorioBasico;
	}

	public String getContactovisual() {
		return contactovisual;
	}

	public void setContactovisual(String contactovisual) {
		this.contactovisual = contactovisual;
	}

	public String getAtencion() {
		return atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public String getImitacionmotora() {
		return imitacionmotora;
	}

	public void setImitacionmotora(String imitacionmotora) {
		this.imitacionmotora = imitacionmotora;
	}

	public String getImitacionobjetos() {
		return imitacionobjetos;
	}

	public void setImitacionobjetos(String imitacionobjetos) {
		this.imitacionobjetos = imitacionobjetos;
	}

	public String getSeguinstrucciones() {
		return seguinstrucciones;
	}

	public void setSeguinstrucciones(String seguinstrucciones) {
		this.seguinstrucciones = seguinstrucciones;
	}

	public String getEsqcorporal() {
		return esqcorporal;
	}

	public void setEsqcorporal(String esqcorporal) {
		this.esqcorporal = esqcorporal;
	}

	public HistoriaClinica getHistoriaclinica_idhistoriaclinica() {
		return historiaclinica_idhistoriaclinica;
	}

	public void setHistoriaclinica_idhistoriaclinica(HistoriaClinica historiaclinica_idhistoriaclinica) {
		this.historiaclinica_idhistoriaclinica = historiaclinica_idhistoriaclinica;
	}	

}
