package com.olonte.softipac.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estimulo")
public class Estimulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestimulo")
	private Integer idEstimulo;
	
	@Column(name = "estimulo")
	private String estimulo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoestimulo_idtipoestimulo", referencedColumnName = "idtipoestimulo" , nullable = false)
	private TipoEstimulo tipoEstimulo;

	public Estimulo() {
	}

	public Integer getIdEstimulo() {
		return idEstimulo;
	}

	public void setIdEstimulo(Integer idEstimulo) {
		this.idEstimulo = idEstimulo;
	}

	public String getEstimulo() {
		return estimulo;
	}

	public void setEstimulo(String estimulo) {
		this.estimulo = estimulo;
	}

	public TipoEstimulo getTipoEstimulo() {
		return tipoEstimulo;
	}

	public void setTipoEstimulo(TipoEstimulo tipoEstimulo) {
		this.tipoEstimulo = tipoEstimulo;
	}

}
