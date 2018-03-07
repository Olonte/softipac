package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "diagnostico")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Diagnostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddiagnostico")
	private Integer idDiagnostico;
	
	@Column(name = "diagnostico")
	private String diagnostico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipodiagnostico_idtipodiagnostico",  referencedColumnName = "idtipodiagnostico", nullable = false)
	private TipoDiagnostico tipoDiagnostico;
	
	@ManyToMany(mappedBy = "diagnosticos")
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datos_iddatos", referencedColumnName = "iddatos")
	private Datos datos_iddatos;

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

	public Datos getDatos_iddatos() {
		return datos_iddatos;
	}

	public void setDatos_iddatos(Datos datos_iddatos) {
		this.datos_iddatos = datos_iddatos;
	}

}
