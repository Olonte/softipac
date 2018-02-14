package com.olonte.softipac.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.olonte.softipac.modelo.UsuarioForma;
import com.olonte.softipac.utilidad.Utilidad;

@Component
public class ValidadorUsuario implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForma.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UsuarioForma usuarioForma = (UsuarioForma)target;
		
		if (usuarioForma.getUsuario().getDocumento_iddocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.TIPO_DOC_USUARIO, "tipoDocumento.validar.mensaje");
		}
		
		if (usuarioForma.getUsuario().getGenero_idgenero().getIdGenero() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.GENERO_USUARIO, "genero.validar.mensaje");
		}
		
		if (usuarioForma.getUsuario().getEscolaridad_idescolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.ESCOLARIDAD_USUARIO, "escolaridad.validar.mensaje");
		}
		
		if (!usuarioForma.getUsuario().getEmail().isEmpty()) {
			if (!Validador.emailValido(usuarioForma.getUsuario().getEmail())) {
				errors.rejectValue(Utilidad.EMAIL_USUARIO, "email.validador.mensaje");
			}
		}
		
		if(!usuarioForma.isJavaScript()){
			if (usuarioForma.getUsuario().getRoles().isEmpty()) {
				errors.rejectValue(Utilidad.ROLES, "rol.validador.mensaje");
			}
		}
	}

}
