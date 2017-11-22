package com.olonte.softipac.modelo;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cita")
@AssociationOverrides(
		{
			@AssociationOverride(         
					name = "citaUsuarioId.usuario_idusuapl",
					joinColumns = {
							@JoinColumn(name = "usuario_idusuapl",
									referencedColumnName = "idusuario")
					}),
			@AssociationOverride(
					name = "citaUsuarioId.usuario_idusuario",
					joinColumns = {
						@JoinColumn(name = "usuario_idusuario",
								referencedColumnName = "idusuario")	
					})
		})
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcita")
	private Integer idCita;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fechacitaini")
	private LocalDate fechaCitaIni;
	
	@DateTimeFormat(pattern = "")
	@Column(name = "fechaevaluacion")
	private LocalDate fechaEvaluacion;
	
	@Column(name = "horaevaluacion")
	private String horaEvaluacion;
	
	@Column(name = "motivoconsulta")
	private String motivoConsulta;
	
	@Column(name = "expectativas")
	private String expectativas;
	
	@Column(name = "recomtenercta")
	private String recomTenerCta;
	
	@Column(name = "infogral")
	private String inFoGral;
	
	@Column(name = "observacion")
	private String observacion;
	
	private TipoCita tipoCita;
	
	private Hora hora;
	
	private Estado estado;
	
	private CitaUsuarioId citaUsuarioId = new CitaUsuarioId();

	public Cita() {
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}


	public LocalDate getFechaCitaIni() {
		return fechaCitaIni;
	}

	public void setFechaCitaIni(LocalDate fechaCitaIni) {
		this.fechaCitaIni = fechaCitaIni;
	}

	public LocalDate getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public String getHoraEvaluacion() {
		return horaEvaluacion;
	}

	public void setHoraEvaluacion(String horaEvaluacion) {
		this.horaEvaluacion = horaEvaluacion;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getExpectativas() {
		return expectativas;
	}

	public void setExpectativas(String expectativas) {
		this.expectativas = expectativas;
	}

	public String getRecomTenerCta() {
		return recomTenerCta;
	}

	public void setRecomTenerCta(String recomTenerCta) {
		this.recomTenerCta = recomTenerCta;
	}

	public String getInFoGral() {
		return inFoGral;
	}

	public void setInFoGral(String inFoGral) {
		this.inFoGral = inFoGral;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipocita_idtipocita", referencedColumnName = "idtipocita", nullable = false)
	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hora_idhora", referencedColumnName = "idhora", nullable = false)
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_idestado", referencedColumnName = "idestado", nullable = false)
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@EmbeddedId
	public CitaUsuarioId getCitaUsuarioId() {
		return citaUsuarioId;
	}

	public void setCitaUsuarioId(CitaUsuarioId citaUsuarioId) {
		this.citaUsuarioId = citaUsuarioId;
	}
	
	@Transient
	public Usuario getUsuario_idusuapl() {
		return getCitaUsuarioId().getUsuario_idusuapl();
	}

	public void setUsuario_idusuapl(Usuario usuario_idusuapl) {
		getCitaUsuarioId().setUsuario_idusuapl(usuario_idusuapl);
	}
	
	@Transient
	public Usuario getUsuario_idusuario() {
		return getCitaUsuarioId().getUsuario_idusuario();
	}

	public void setUsuario_idusuario(Usuario usuario_idusuario) {
		getCitaUsuarioId().setUsuario_idusuario(usuario_idusuario);
	}
	
}
