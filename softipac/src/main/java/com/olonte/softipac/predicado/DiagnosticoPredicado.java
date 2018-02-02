package com.olonte.softipac.predicado;


import com.olonte.softipac.modelo.QDiagnostico;
import com.querydsl.core.types.Predicate;

public class DiagnosticoPredicado {
	
	private DiagnosticoPredicado(){
	}
	
	public static Predicate buscarPorIds(Number[] idsDiagnostico) {
		return QDiagnostico.diagnostico1.idDiagnostico.in(idsDiagnostico);
	}


}
