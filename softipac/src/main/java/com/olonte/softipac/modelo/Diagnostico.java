package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddiagnostico")
	private Integer idDiagnostico;
	
	@Column(name = "diagnostico")
	private String diagnostico;
	
	@ManyToOne
	@JoinColumn(name = "tipodiagnostico_idtipodiagnostico", nullable = false)
	private TipoDiagnostico tipoDiagnostico;
	
	@ManyToMany(mappedBy = "diagnosticos")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Diagnostico() {
	}

	public Integer getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Integer idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}



	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public TipoDiagnostico getTipoDiagnostico() {
		return tipoDiagnostico;
	}

	public void setTipoDiagnostico(TipoDiagnostico tipoDiagnostico) {
		this.tipoDiagnostico = tipoDiagnostico;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
