package com.olonte.softipac.modelo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "afinidad")
@AssociationOverrides(
		{
			@AssociationOverride(         
					name = "afinidadUsuarioId.usuario_idusuario",
					joinColumns = {
							@JoinColumn(name = "usuario_idusuario",
									referencedColumnName = "idusuario")
					}),
			@AssociationOverride(
					name = "afinidadUsuarioId.idfamiliar",
					joinColumns = {
						@JoinColumn(name = "idfamiliar",
								referencedColumnName = "idusuario")	
					})
		})
public class Afinidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idafinidad")
	private Integer idAfinidad;
	
	private AfinidadUsuarioId afinidadUsuarioId = new AfinidadUsuarioId();
	
	public Afinidad() {
	}
	
	public Integer getIdAfinidad() {
		return idAfinidad;
	}

	public void setIdAfinidad(Integer idAfinidad) {
		this.idAfinidad = idAfinidad;
	}
	
	@EmbeddedId
	public AfinidadUsuarioId getAfinidadUsuarioId() {
		return afinidadUsuarioId;
	}

	public void setAfinidadUsuarioId(AfinidadUsuarioId afinidadUsuarioId) {
		this.afinidadUsuarioId = afinidadUsuarioId;
	}
	
	@Transient
	public Usuario getUsuario_idusuario() {
		return getAfinidadUsuarioId().getUsuario_idusuario();
	}

	public void setUsuario_idusuario(Usuario usuario_idusuario) {
		getAfinidadUsuarioId().setUsuario_idusuario(usuario_idusuario);
	}
	
	@Transient
	public Usuario getIdfamiliar() {
		return getAfinidadUsuarioId().getIdfamiliar();
	}

	public void setIdfamiliar(Usuario idfamiliar) {
		getAfinidadUsuarioId().setIdfamiliar(idfamiliar);
	}

}
