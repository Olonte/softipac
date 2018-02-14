package com.olonte.softipac.json;

import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.utilidad.Utilidad;

public class JSON {
	
	public JSON(){
	}
	
	public static UsuarioJSON obtenerUsuarioJSON(Usuario usuario) {
		UsuarioJSON usuarioJSON = new UsuarioJSON();
		if (usuario != null) {
			usuarioJSON.setTipousuario_idtipousuario(usuario.getTipousuario_idtipousuario());
			usuarioJSON.setEstado_idestado(usuario.getEstado_idestado());
			usuarioJSON.setIdUsuario(usuario.getIdUsuario());
			usuarioJSON.setDocumento_iddocumento(usuario.getDocumento_iddocumento());
			usuarioJSON.setNombres(usuario.getNombres());
			usuarioJSON.setPrimerApellido(usuario.getPrimerApellido());
			usuarioJSON.setSegundoApellido(usuario.getSegundoApellido());
			usuarioJSON.setFechaNacimiento(usuario.getFechaNacimiento());
	        if (usuario.getTipousuario_idtipousuario().getIdTipoUsuario() == Utilidad.USUARIO_PACIENTE) {
	        	usuarioJSON.setMeses(usuario.getMeses());
	        	usuarioJSON.setTutela(usuario.getTutela());
	   			usuarioJSON.setEps_ideps(usuario.getEps_ideps());
	   			for (Diagnostico diagnostico : usuario.getDiagnosticos()) {
	   				usuarioJSON.getDiagnosticos().add(diagnostico);
	   			}
	   			for (Afinidad afinidad : usuario.getUsuario_idusuario()) {
					usuarioJSON.getFamiliares().add(afinidad.getIdfamiliar());
				}
			}else {
				usuarioJSON.setNombreUsuario(usuario.getNombreUsuario());
				usuarioJSON.setLugarNacimiento(usuario.getLugarNacimiento());
				usuarioJSON.setOcupacion(usuario.getOcupacion());
				usuarioJSON.setDireccion(usuario.getDireccion());
				usuarioJSON.setTelefonoFijo(usuario.getTelefonoFijo());
				usuarioJSON.setTelefonoCelular(usuario.getTelefonoCelular());
				usuarioJSON.setEmail(usuario.getEmail());
				for (Rol rol: usuario.getRoles()){
					usuarioJSON.getRoles().add(rol);
				}
			}
			usuarioJSON.setEdad(usuario.getEdad());
			usuarioJSON.setGenero_idgenero(usuario.getGenero_idgenero());
			usuarioJSON.setEscolaridad_idescolaridad(usuario.getEscolaridad_idescolaridad());
		}
		return usuarioJSON;
	}
	
	public static CitaJSON obtenerCitaJSON(Cita cita){
		CitaJSON citaJSON = new CitaJSON();
		if (cita != null) {
			citaJSON.setCitaId(cita.getCitaId());
			citaJSON.setFechaCitaIni(cita.getFechaCitaIni());
			citaJSON.setHora(cita.getHora());
			citaJSON.setObservacion(cita.getObservacion());
			citaJSON.setMotivoConsulta(cita.getMotivoConsulta());
			citaJSON.setExpectativas(cita.getExpectativas());
			citaJSON.setRecomTenerCta(cita.getRecomTenerCta());
			citaJSON.setInFoGral(cita.getInFoGral());
		}
		return citaJSON;
	}
}
