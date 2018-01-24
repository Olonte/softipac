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
@Table(name = "tipohora")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoHora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipohora")
	private Integer idTipoHora;
	
	@Column(name = "tipo")
	private String tipo;

	public TipoHora() {
	}

	public Integer getIdTipoHora() {
		return idTipoHora;
	}

	public void setIdTipoHora(Integer idTipoHora) {
		this.idTipoHora = idTipoHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
