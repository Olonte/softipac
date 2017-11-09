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
@Table(name = "serviciosalud")
public class ServicioSalud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idserviciosalud")
	private Integer idServicioSalud;
	
	@Column(name = "servicio")
	private String servicio;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "rips")
	private String rips;
	
	@OneToMany
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public ServicioSalud() {
	}
	
	public Integer getIdServicioSalud() {
		return idServicioSalud;
	}

	public void setIdServicioSalud(Integer idServicioSalud) {
		this.idServicioSalud = idServicioSalud;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRips() {
		return rips;
	}

	public void setRips(String rips) {
		this.rips = rips;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
