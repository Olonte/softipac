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
@Table(name = "hora")
public class Hora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhora")
	private Integer idHora;
	
	@Column(name = "hora")
	private String hora;
	
	@OneToMany
	private Set<Cita> citas = new HashSet<Cita>();

	public Hora() {
	}

	public Integer getIdHora() {
		return idHora;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

}
