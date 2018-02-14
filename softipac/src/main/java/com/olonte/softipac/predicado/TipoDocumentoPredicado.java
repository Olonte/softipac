package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QTipoDocumento;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;

public class TipoDocumentoPredicado {
	
	private TipoDocumentoPredicado() {
	}
	
	public static Predicate buscarTiposDocumentosUsuario() {
		return QTipoDocumento.tipoDocumento.idTipoDocumento.notIn(Utilidad.REGISTRO_CIVIL, Utilidad.TARJETA_IDENTIDAD);
	}

}
