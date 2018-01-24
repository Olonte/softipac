package com.olonte.softipac.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.CitaInformacion;
import com.olonte.softipac.utilidad.Utilidad;

@Component
public class ValidadorUsuarioAgenda implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Agenda.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Agenda agenda = (Agenda) target;
		
		if (!CitaInformacion.class.isInstance(agenda)) {
			if (agenda.getCita().getHora().getHoraId().getIdhora() == Utilidad.SELECCION) {
				errors.rejectValue(Utilidad.HORA, "hora.validar.mensaje");
			}
		}
		
		if (agenda.getPaciente().getDocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.TIPO_DOC_PACIENTE, "tipoDocumento.validar.mensaje");
		}
		
		if (agenda.getPaciente().getGenero().getIdGenero() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.GENERO, "genero.validar.mensaje");
		}
		
		if (agenda.getPaciente().getEscolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.ESCOLARIDAD_PACIENTE, "escolaridad.validar.mensaje");
		}
		
		if (agenda.getPaciente().getTutela().equalsIgnoreCase(Integer.toString(Utilidad.SELECCION))) {
			errors.rejectValue(Utilidad.TUTELA, "tutela.validar.mensaje");
		}
		
		if (agenda.getPaciente().getEps().getIdEps() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.EPS, "eps.validar.mensaje");
		}
		
		if (agenda.getPaciente().getDiagnosticos().isEmpty()) {
			errors.rejectValue(Utilidad.DIAGNOSTICOS, "diagnosticos.validar.mensaje");
		}
		/**
		 * Validacion Campos CitaInformacion
		 */
		
		if (CitaInformacion.class.isInstance(agenda)) {
			
			/**
			 * Validacion Campos Madre
			 */
			
			if (((CitaInformacion)agenda).getMadre().getDocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
				errors.rejectValue(Utilidad.TIPO_DOC_MADRE, "tipoDocumento.validar.mensaje");
			}
			
			if (((CitaInformacion)agenda).getMadre().getEscolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
				errors.rejectValue(Utilidad.ESCOLARIDAD_MADRE, "escolaridad.validar.mensaje");
			}
			
			if (!((CitaInformacion)agenda).getMadre().getEmail().isEmpty()) {
				if (!Validador.emailValido(((CitaInformacion)agenda).getMadre().getEmail())) {
					errors.rejectValue(Utilidad.EMAIL_MADRE, "email.validador.mensaje");
				}
			}
			/**
			 * Validacion Campos Padre
			 */
			
			if (((CitaInformacion)agenda).getPadre().getDocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
				errors.rejectValue(Utilidad.TIPO_DOC_PADRE, "tipoDocumento.validar.mensaje");
			}
			
			if (((CitaInformacion)agenda).getPadre().getEscolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
				errors.rejectValue(Utilidad.ESCOLARIDAD_PADRE, "escolaridad.validar.mensaje");
			}
			
			if (!((CitaInformacion)agenda).getPadre().getEmail().isEmpty()) {
				if (!Validador.emailValido(((CitaInformacion)agenda).getPadre().getEmail())) {
					errors.rejectValue(Utilidad.EMAIL_PADRE, "email.validador.mensaje");
				}
			}
			
		}
		/**
		 * Validacion Campos Acudiente
		 */
		if (agenda.getAcudiente().getDocumento().getTipoDocumento().getIdTipoDocumento() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.TIPO_DOC_ACUDIENTE, "tipoDocumento.validar.mensaje");
		}
		
		if (agenda.getAcudiente().getParentesco().getIdParentesco() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.PARENTESCO, "parentesco.validador.mensaje");
		}
		
		if (agenda.getAcudiente().getEscolaridad().getIdEscolaridad() == Utilidad.SELECCION) {
			errors.rejectValue(Utilidad.ESCOLARIDAD_ACUDIENTE, "escolaridad.validar.mensaje");
		}
		
		if (!agenda.getAcudiente().getEmail().isEmpty()) {
			if (!Validador.emailValido(agenda.getAcudiente().getEmail())) {
				errors.rejectValue(Utilidad.EMAIL_ACUDIENTE, "email.validador.mensaje");
			}
		}
	}

}
