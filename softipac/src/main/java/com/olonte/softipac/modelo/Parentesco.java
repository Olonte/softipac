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
@Table(name = "parentesco")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Parentesco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idparentesco")
	private Integer idParentesco;
	
	@Column(name = "parentesco")
	private String parentesco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datos_iddatos", referencedColumnName = "iddatos")
	private Datos datos_iddatos;

	public Parentesco() {
	}

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	public Datos getDatos_iddatos() {
		return datos_iddatos;
	}

	public void setDatos_iddatos(Datos datos_iddatos) {
		this.datos_iddatos = datos_iddatos;
	}

}
