package com.olonte.softipac.utilidad;

import org.springframework.util.StringUtils;

public class Parametro {
	
	private String parametros;
	
	private String documento;
	
	private Number[] ids;

	public Parametro() {
	}

	public Parametro(String parametros) {
		this.parametros = parametros;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public String getDocumento() {
		this.documento = this.parametros.substring(Utilidad.INDICE_INICIAL, this.parametros.indexOf(Utilidad.SEPARADOR));
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Number[] getIds() {
		if (StringUtils.countOccurrencesOf(this.parametros, Utilidad.SEPARADOR) > 1) {
			this.ids = obtenerUsuarioIds(this.parametros.substring(this.parametros.indexOf(Utilidad.SEPARADOR) + 1, this.parametros.length()));
		}else {
			Number _ids [] = new Number[Utilidad.LONGITUD_DEFECTO];
			_ids[Utilidad.INDICE_INICIAL] = Integer.parseInt(this.parametros.substring(this.parametros.indexOf(Utilidad.SEPARADOR) + 1, this.parametros.length()));
			this.ids = _ids;
		}
		return ids;
	}

	public void setIds(Number[] ids) {
		this.ids = ids;
	}
	
	private Number[] obtenerUsuarioIds(String idsUsuario) {
		Number ids [] = new Number[longitudArreglos(idsUsuario)];
		int pos = 0;
	   	for( int beginIndex = 0; beginIndex < idsUsuario.length(); beginIndex++ ) {
	   		if (!(idsUsuario.substring(beginIndex,beginIndex + 1).equals(Utilidad.SEPARADOR))) {
	   			ids[pos] = Integer.parseInt(idsUsuario.substring(beginIndex,beginIndex + 1));
	   			pos++;
	   		}
	   	}
		return ids;
	}
	
	private int longitudArreglos(String idsUsuario) {
		int longitud = 0;
		for( int beginIndex = 0; beginIndex < idsUsuario.length(); beginIndex++ ) {
			if ( !(idsUsuario.substring(beginIndex,beginIndex + 1).equals(Utilidad.SEPARADOR))) {
				longitud++;
			 }
		}
		return longitud;
	}
	
}
