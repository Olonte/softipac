package com.olonte.softipac.json;

import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.Usuario;

public class JSON {
	
	public JSON(){
	}
	
	public static UsuarioJSON obtenerUsuarioJSON(Usuario usuario) {
		UsuarioJSON usuarioJSON = new UsuarioJSON();
		if (usuario != null) {
			usuarioJSON.setTipoUsuario(usuario.getTipoUsuario());
			usuarioJSON.setEstado(usuario.getEstado());
			usuarioJSON.setIdUsuario(usuario.getIdUsuario());
			usuarioJSON.setDocumento(usuario.getDocumento());
			usuarioJSON.setNombres(usuario.getNombres());
			usuarioJSON.setPrimerApellido(usuario.getPrimerApellido());
			usuarioJSON.setSegundoApellido(usuario.getSegundoApellido());
			usuarioJSON.setFechaNacimiento(usuario.getFechaNacimiento());
			usuarioJSON.setEdad(usuario.getEdad());
			usuarioJSON.setGenero(usuario.getGenero());
			usuarioJSON.setEscolaridad(usuario.getEscolaridad());
			usuarioJSON.setTutela(usuario.getTutela());
			usuarioJSON.setEps(usuario.getEps());
			for (Diagnostico diagnostico : usuario.getDiagnosticos()) {
				usuarioJSON.getDiagnosticos().add(diagnostico);
			}
			
			for (Afinidad afinidad : usuario.getUsuario_idusuario()) {
				usuarioJSON.getFamiliares().add(afinidad.getIdfamiliar());
			}
			
		}
		return usuarioJSON;
	}
	
	public static CitaJSON obtenerCitaJSON(Cita cita){
		CitaJSON citaJSON = new CitaJSON();
		if (cita != null) {
			citaJSON.setIdCita(cita.getIdCita());
			citaJSON.setFechaCitaIni(cita.getFechaCitaIni());
			citaJSON.setHora(cita.getHora());
			citaJSON.setObservacion(cita.getObservacion());
		}
		return citaJSON;
	}
}
