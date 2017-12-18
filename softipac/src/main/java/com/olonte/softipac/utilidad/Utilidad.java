package com.olonte.softipac.utilidad;

public interface Utilidad {
	static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	static final String STRING_PATTERN = "[a-zA-Z]+";
	static final String HORA           = "cita.hora.idHora";
	static final String TIPO_DOCUMENTO = "paciente.documento.tipoDocumento.idTipoDocumento";
	static final String GENERO         = "paciente.genero.idGenero";
	static final String ESCOLARIDAD    = "paciente.escolaridad.idEscolaridad";
	static final String TUTELA         = "paciente.tutela";
	static final String EPS            = "paciente.eps.idEps";
	static final String DIAGNOSTICOS   = "paciente.diagnosticos";
	static final String EMAIL          = "acudiente.email";
	static final String PARENTESCO     = "acudiente.parentesco.idParentesco";
	static final int CITA_AGENDA       = 1;
	static final int CITA_INFORMACION  = 2;
	static final int ESTADO_INACTIVO   = 2;
	static final int USUARIO_ACUDIENTE = 5;
	static final int HORA_AGENDA       = 1;
	static final int HORA_CITA_INFO    = 2;
	static final int PADRE             = 2;
	static final int MADRE             = 3;
	static final int HERMANO_A         = 4;
	static final int ABUELO_A          = 5;
	static final int OTRO              = 6;
	static final int SELECCION         = -1;
	
}
