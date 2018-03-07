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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "escolaridad")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Escolaridad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idescolaridad")
	private Integer idEscolaridad;
	
	@Column(name = "escolaridad")
	private String escolaridad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datos_iddatos", referencedColumnName = "iddatos")
	private Datos datos_iddatos;

	public Escolaridad() {
	}

	public Integer getIdEscolaridad() {
		return idEscolaridad;
	}

	public void setIdEscolaridad(Integer idEscolaridad) {
		this.idEscolaridad = idEscolaridad;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public Datos getDatos_iddatos() {
		return datos_iddatos;
	}

	public void setDatos_iddatos(Datos datos_iddatos) {
		this.datos_iddatos = datos_iddatos;
	}
	
}
