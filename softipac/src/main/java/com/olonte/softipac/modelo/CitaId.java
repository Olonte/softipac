package com.olonte.softipac.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CitaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcita")
	private Integer idcita;
	
	@ManyToOne
	@JoinColumn(name = "tipocita_idtipocita", referencedColumnName = "idtipocita")
	private TipoCita tipocita_idtipocita;
	
	@ManyToOne
	@JoinColumn(name = "estado_idestado", referencedColumnName = "idestado")
	private Estado estado_idestado;
	
	@ManyToOne
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
	private Usuario usuario_idusuario;
	
	@ManyToOne
	@JoinColumn(name = "usuario_idusuapl", referencedColumnName = "idusuario")
	private Usuario usuario_idusuapl;

	public CitaId() {
	}

	public CitaId(TipoCita tipocita_idtipocita, Estado estado_idestado, Usuario usuario_idusuario,
			Usuario usuario_idusuapl) {
		this.tipocita_idtipocita = tipocita_idtipocita;
		this.estado_idestado = estado_idestado;
		this.usuario_idusuario = usuario_idusuario;
		this.usuario_idusuapl = usuario_idusuapl;
	}

	public Integer getIdcita() {
		return idcita;
	}

	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
	}

	public TipoCita getTipocita_idtipocita() {
		return tipocita_idtipocita;
	}

	public void setTipocita_idtipocita(TipoCita tipocita_idtipocita) {
		this.tipocita_idtipocita = tipocita_idtipocita;
	}

	public Estado getEstado_idestado() {
		return estado_idestado;
	}

	public void setEstado_idestado(Estado estado_idestado) {
		this.estado_idestado = estado_idestado;
	}

	public Usuario getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(Usuario usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}

	public Usuario getUsuario_idusuapl() {
		return usuario_idusuapl;
	}

	public void setUsuario_idusuapl(Usuario usuario_idusuapl) {
		this.usuario_idusuapl = usuario_idusuapl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdcita(), getTipocita_idtipocita(), getEstado_idestado());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if(!(obj instanceof CitaId))
			return false;
		CitaId citaId = (CitaId) obj;
		return Objects.equals(getIdcita(), citaId.getIdcita()) &&
				Objects.equals(getTipocita_idtipocita(), citaId.getTipocita_idtipocita()) &&
				Objects.equals(getEstado_idestado(), citaId.getEstado_idestado());
	}
}
