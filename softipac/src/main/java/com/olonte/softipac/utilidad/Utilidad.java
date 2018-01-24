package com.olonte.softipac.utilidad;

public interface Utilidad {
	static final String EMAIL_PATTERN         = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	static final String STRING_PATTERN        = "[a-zA-Z]+";
	static final String HORA          	      = "cita.hora.horaId.idhora";
	static final String TIPO_DOC_PACIENTE     = "paciente.documento.tipoDocumento.idTipoDocumento";
	static final String GENERO         	      = "paciente.genero.idGenero";
	static final String ESCOLARIDAD_PACIENTE  = "paciente.escolaridad.idEscolaridad";
	static final String TUTELA             	  = "paciente.tutela";
	static final String EPS            	      = "paciente.eps.idEps";
	static final String DIAGNOSTICOS          = "paciente.diagnosticos";
	static final String PARENTESCO     	      = "acudiente.parentesco.idParentesco";
	static final String TIPO_DOC_ACUDIENTE    = "acudiente.documento.tipoDocumento.idTipoDocumento";
	static final String EMAIL_MADRE           = "madre.email";
	static final String EMAIL_PADRE           = "padre.email";
	static final String EMAIL_ACUDIENTE       = "acudiente.email";
	static final String TIPO_DOC_MADRE        = "madre.documento.tipoDocumento.idTipoDocumento";
	static final String ESCOLARIDAD_MADRE     = "madre.escolaridad.idEscolaridad";
	static final String TIPO_DOC_PADRE        = "padre.documento.tipoDocumento.idTipoDocumento";
	static final String ESCOLARIDAD_PADRE     = "padre.escolaridad.idEscolaridad";
	static final String ESCOLARIDAD_ACUDIENTE = "acudiente.escolaridad.idEscolaridad";
	static final int AGENDA_NUEVA      	   = 1;
	static final int AGENDA_PROCESADA  	   = 2;
	static final int AGENDA_EDITADA    	   = 3;
	static final int AGENDA_EDIT_PROC      = 4;
	static final boolean ES_CITA_AGENDA    = true;
	static final int CITA_INFO_NUEVA       = 5;
	static final int CITA_INFO_PROC        = 6;
	static final int CITA_INFO_EDIT_PROC   = 7;
	static final int CITA_AGENDA           = 1;
	static final int CITA_INFORMACION      = 2;
	static final int CITA_INFO_CREAR       = 8;
	static final int ESTADO_ACTIVO         = 1;
	static final int ESTADO_INACTIVO       = 2;
	static final int ESTADO_PENDIENTE      = 3;
	static final int ESTADO_CANCELADO      = 4;
	static final int ESTADO_TERMINADO      = 5;
	static final int USUARIO_PACIENTE      = 3;
	static final int USUARIO_PARIENTE      = 4;
	static final int USUARIO_ACUDIENTE     = 5;
	static final int HORA_AGENDA           = 1;
	static final int HORA_CITA_INFO        = 2;
	static final int HIJO                  = 1;
	static final int PADRE                 = 2;
	static final int MADRE                 = 3;
	static final int HERMANO_A             = 4;
	static final int ABUELO_A              = 5;
	static final int OTRO                  = 6;
	static final int SELECCION             = -1;
	static final int NUMERO_REGISTROS      = 7;
	static final int NUMERO_PAGINA_DEFECTO = 0;
	static final int NUMERO_PAGINA_INICIO  = 1;
	static final int TRANS_GUARDAR         = 1;
	static final int TRANS_ACTUALIZAR      = 2;
	static final int INDICE_DEFECTO        = 0;
	
	
	
}
