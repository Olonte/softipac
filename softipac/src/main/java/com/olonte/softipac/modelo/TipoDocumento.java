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
@Table(name = "tipodocumento")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipodocumento")
	private Integer idTipoDocumento;
	
	@Column(name = "tipo")
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "datos_iddatos", referencedColumnName = "iddatos") 
	private Datos datos_iddatos;
	
	public TipoDocumento() {
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Datos getDatos_iddatos() {
		return datos_iddatos;
	}

	public void setDatos_iddatos(Datos datos_iddatos) {
		this.datos_iddatos = datos_iddatos;
	}

}
