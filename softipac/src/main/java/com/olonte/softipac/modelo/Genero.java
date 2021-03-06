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
@Table(name = "genero")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgenero")
	private Integer idGenero;
	
	@Column(name = "genero")
	private String genero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datos_iddatos", referencedColumnName = "iddatos")
	private Datos datos_iddatos;
	
	public Genero() {
	}

	public Integer getIdGenero() {
		return idGenero;
	}
	
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Datos getDatos_iddatos() {
		return datos_iddatos;
	}

	public void setDatos_iddatos(Datos datos_iddatos) {
		this.datos_iddatos = datos_iddatos;
	}
	
}
