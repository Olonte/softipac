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
@Table(name = "parentesco")
public class Parentesco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idparentesco")
	private Integer idParentesco;
	
	@Column(name = "parentesco")
	private String parentesco;
	
	@OneToMany
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Parentesco() {
	}

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
