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
@Table(name = "estado")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestado")
	private Integer idEstado;
	
	@Column(name = "estado")
	private String estado;

	public Estado() {
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/Olonte/softipac
}
