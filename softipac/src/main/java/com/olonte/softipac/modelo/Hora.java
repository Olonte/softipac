package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hora")
public class Hora {
	
	@EmbeddedId
	private HoraId horaId;
	
	@Column(name = "hora")
	private String hora;
	
	@OneToMany
	private Set<Cita> citas = new HashSet<Cita>(0);
	
	public Hora() {
	}

	public Hora(HoraId horaId, String hora) {
		this.horaId = horaId;
		this.hora = hora;
	}

	public HoraId getHoraId() {
		return horaId;
	}

	public void setHoraId(HoraId horaId) {
		this.horaId = horaId;
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
