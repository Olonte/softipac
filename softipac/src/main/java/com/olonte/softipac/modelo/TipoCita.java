package com.olonte.softipac.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tipocita")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipocita")
	private Integer idTipoCita;
	
	@Column(name = "tipo")
	private String tipo;

	public TipoCita() {
	}

	public Integer getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(Integer idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
