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

@Entity
@Table(name = "tipodiagnostico")
public class TipoDiagnostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipodiagnostico")
	private Integer idTipoDiagnostico;
	
	@Column(name = "tipo")
	private String tipo;
	
	@OneToMany
	private Set<Diagnostico> diagnosticos = new HashSet<Diagnostico>();

	public TipoDiagnostico() {
	}

	public Integer getIdTipoDiagnostico() {
		return idTipoDiagnostico;
	}

	public void setIdTipoDiagnostico(Integer idTipoDiagnostico) {
		this.idTipoDiagnostico = idTipoDiagnostico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}
