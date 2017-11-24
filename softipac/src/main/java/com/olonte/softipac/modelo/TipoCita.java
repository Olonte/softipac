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
@Table(name = "tipocita")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipocita")
	private Integer idTipoCita;
	
	@Column(name = "tipo")
	private String tipo;
	
	@OneToMany
	private Set<Cita> citas = new HashSet<Cita>(0);

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

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
	
}
