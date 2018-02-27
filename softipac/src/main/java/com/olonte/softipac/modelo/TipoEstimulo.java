package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tipoestimulo")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoEstimulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipoestimulo")
	private Integer idTipoEstimulo;
	
	@Column(name= "tipo")
	private String tipo;
	
	@OneToMany
	private Set<Estimulo> estimulos = new HashSet<Estimulo>(0);

	public TipoEstimulo() {
	}

	public Integer getIdTipoEstimulo() {
		return idTipoEstimulo;
	}

	public void setIdTipoEstimulo(Integer idTipoEstimulo) {
		this.idTipoEstimulo = idTipoEstimulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Estimulo> getEstimulos() {
		return estimulos;
	}

	public void setEstimulos(Set<Estimulo> estimulos) {
		this.estimulos = estimulos;
	}
	
}
