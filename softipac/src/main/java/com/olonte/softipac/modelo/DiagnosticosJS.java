package com.olonte.softipac.modelo;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class DiagnosticosJS {
	
	private Set<Diagnostico> diagnosticos;

	public DiagnosticosJS() {
	}

	public DiagnosticosJS(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	} 
	

}
