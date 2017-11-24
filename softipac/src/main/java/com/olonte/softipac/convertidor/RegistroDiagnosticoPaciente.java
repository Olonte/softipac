package com.olonte.softipac.convertidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.servicio.DiagnosticoServcio;

@Component
public class RegistroDiagnosticoPaciente implements Converter<Object, Diagnostico> {
	
	private DiagnosticoServcio diagnosticoServcio;
	
	@Autowired
	public RegistroDiagnosticoPaciente(DiagnosticoServcio diagnosticoServcio) {
		this.diagnosticoServcio = diagnosticoServcio;
	}

	@Override
	public Diagnostico convert(Object source) {
		Integer idDiagnostico = Integer.parseInt((String) source);
		Diagnostico diagnostico = this.diagnosticoServcio.bucarPorId(idDiagnostico);
		return diagnostico;
	}

}
