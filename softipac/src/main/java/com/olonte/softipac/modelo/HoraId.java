package com.olonte.softipac.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class HoraId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idhora")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idhora;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipohora_idtipohora", referencedColumnName = "idtipohora")
	private TipoHora tipohora_idtipohora;

	public HoraId() {
	}

	public HoraId(Integer idhora, TipoHora tipohora_idtipohora) {
		this.idhora = idhora;
		this.tipohora_idtipohora = tipohora_idtipohora;
	}

	public Integer getIdhora() {
		return idhora;
	}

	public void setIdhora(Integer idhora) {
		this.idhora = idhora;
	}

	public TipoHora getTipohora_idtipohora() {
		return tipohora_idtipohora;
	}

	public void setTipohora_idtipohora(TipoHora tipohora_idtipohora) {
		this.tipohora_idtipohora = tipohora_idtipohora;
	}
	
}
