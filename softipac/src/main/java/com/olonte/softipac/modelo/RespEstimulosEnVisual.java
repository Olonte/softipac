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
@Table(name = "respestimulosenvisual")
public class RespEstimulosEnVisual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrespestimulosenvisual")
	private Integer idRespEstimulosEnVisual;
	
	@Column(name = "orientamirada")
	private String orientamirada;
	
	@Column(name = "buscamirada")
	private String buscamirada;
	
	@Column(name = "giraobjetos")
	private String giraobjetos;
	
	@Column(name = "miradaperdida")
	private String miradaperdida;
	
	@Column(name = "reojo")
	private String reojo;
	
	@Column(name = "acerca_aleja")
	private String acerca_aleja;
	
	@Column(name = "entrecierra")
	private String entrecierra;
	
	@Column(name = "perspectiva")
	private String perspectiva;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "historiaclinica_idhistoriaclinica", referencedColumnName = "idhistoriaclinica")
	private HistoriaClinica historiaclinica_idhistoriaclinica;

	public RespEstimulosEnVisual() {
	}

	public Integer getIdRespEstimulosEnVisual() {
		return idRespEstimulosEnVisual;
	}

	public void setIdRespEstimulosEnVisual(Integer idRespEstimulosEnVisual) {
		this.idRespEstimulosEnVisual = idRespEstimulosEnVisual;
	}

	public String getOrientamirada() {
		return orientamirada;
	}

	public void setOrientamirada(String orientamirada) {
		this.orientamirada = orientamirada;
	}

	public String getBuscamirada() {
		return buscamirada;
	}

	public void setBuscamirada(String buscamirada) {
		this.buscamirada = buscamirada;
	}

	public String getGiraobjetos() {
		return giraobjetos;
	}

	public void setGiraobjetos(String giraobjetos) {
		this.giraobjetos = giraobjetos;
	}

	public String getMiradaperdida() {
		return miradaperdida;
	}

	public void setMiradaperdida(String miradaperdida) {
		this.miradaperdida = miradaperdida;
	}

	public String getReojo() {
		return reojo;
	}

	public void setReojo(String reojo) {
		this.reojo = reojo;
	}

	public String getAcerca_aleja() {
		return acerca_aleja;
	}

	public void setAcerca_aleja(String acerca_aleja) {
		this.acerca_aleja = acerca_aleja;
	}

	public String getEntrecierra() {
		return entrecierra;
	}

	public void setEntrecierra(String entrecierra) {
		this.entrecierra = entrecierra;
	}

	public String getPerspectiva() {
		return perspectiva;
	}

	public void setPerspectiva(String perspectiva) {
		this.perspectiva = perspectiva;
	}

	public HistoriaClinica getHistoriaclinica_idhistoriaclinica() {
		return historiaclinica_idhistoriaclinica;
	}

	public void setHistoriaclinica_idhistoriaclinica(HistoriaClinica historiaclinica_idhistoriaclinica) {
		this.historiaclinica_idhistoriaclinica = historiaclinica_idhistoriaclinica;
	}

}
