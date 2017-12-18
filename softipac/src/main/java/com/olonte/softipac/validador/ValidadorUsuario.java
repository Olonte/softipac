package com.olonte.softipac.validador;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.utilidad.Utilidad;

public class ValidadorUsuario implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Agenda.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Agenda agenda = (Agenda) target;
		
		if (agenda.getCita().getHora().getIdHora() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.HORA, "hora.validar.mensaje");
		}
		
		if (agenda.getPaciente().getDocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.TIPO_DOCUMENTO, "tipoDocumento.validar.mensaje ");
		}
		
		if (agenda.getPaciente().getGenero().getIdGenero() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.GENERO, "genero.validar.mensaje");
		}
		
		if (agenda.getPaciente().getEscolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.ESCOLARIDAD, "escolaridad.validar.mensaje");
		}
		
		if (agenda.getPaciente().getTutela() == Integer.toString(Utilidad.SELECCION)) {
			errors.rejectValue(Utilidad.TUTELA, "tutela.validar.mensaje");
		}
		
		if (agenda.getPaciente().getEps().getIdEps() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.EPS, "eps.validar.mensaje");
		}
		
		if (agenda.getPaciente().getDiagnosticos().isEmpty()) {
			errors.rejectValue(Utilidad.DIAGNOSTICOS, "diaganosticos.validar.mensaje");
		}
		
		if (agenda.getAcudiente().getParentesco().getIdParentesco() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.PARENTESCO, "parentesco.validador.mensaje");
		}
		
		if (!Validador.emailValido(agenda.getAcudiente().getEmail())) {
			errors.rejectValue(Utilidad.EMAIL, "email.validador.mensaje");
		}
	}

}
