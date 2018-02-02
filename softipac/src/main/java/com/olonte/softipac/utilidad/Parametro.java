package com.olonte.softipac.utilidad;

public class Parametro {
	
	private String parametros;
	
	private String documento;
	
	private Integer id;

	public Parametro() {
	}

	public Parametro(String parametros) {
		this.parametros = parametros;
		this.documento = parametros.substring(Utilidad.INDICE_INICIAL, parametros.indexOf(Utilidad.SEPARADOR));
		this.id =  Integer.parseInt(parametros.substring(parametros.indexOf(Utilidad.SEPARADOR) + 1, parametros.length()));
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
