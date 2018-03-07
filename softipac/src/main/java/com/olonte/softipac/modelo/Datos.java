package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "datos")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Datos {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddatos") 
	private Integer idDatos;	
	
	@Column(name = "datoscol", nullable = false)
	private String datosCol;	
	
	@OneToMany(mappedBy = "datos_iddatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TipoDocumento> tipoDocumentos = new HashSet<TipoDocumento>(0);
	
	@OneToMany(mappedBy = "datos_iddatos", fetch = FetchType.EAGER)
	private Set<Genero> generos = new HashSet<Genero>(0);
	
	@OneToMany(mappedBy = "datos_iddatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Escolaridad> escolaridades = new HashSet<Escolaridad>(0);
	
	@OneToMany(mappedBy = "datos_iddatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Diagnostico> diagnosticos = new HashSet<Diagnostico>(0);
	
	@OneToMany(mappedBy = "datos_iddatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Eps> eps = new HashSet<Eps>(0);

	@OneToMany(mappedBy = "datos_iddatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Parentesco> parentescos = new HashSet<Parentesco>(0);
	
	public Datos() {
	}
	
	public Integer getIdDatos() {
		return idDatos;
	}

	public void setIdDatos(Integer idDatos) {
		this.idDatos = idDatos;
	}
		
	public String getDatosCol() {
		return datosCol;
	}

	public void setDatosCol(String datosCol) {
		this.datosCol = datosCol;
	}

	public Set<TipoDocumento> getTipoDocumentos() {
		return tipoDocumentos;
	}

	public void setTipoDocumentos(Set<TipoDocumento> tipoDocumentos) {
		this.tipoDocumentos = tipoDocumentos;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}
	
	public Set<Escolaridad> getEscolaridades() {
		return escolaridades;
	}

	public void setEscolaridades(Set<Escolaridad> escolaridades) {
		this.escolaridades = escolaridades;
	}

	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public Set<Eps> getEps() {
		return eps;
	}

	public void setEps(Set<Eps> eps) {
		this.eps = eps;
	}

	public Set<Parentesco> getParentescos() {
		return parentescos;
	}

	public void setParentescos(Set<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}
	
}
