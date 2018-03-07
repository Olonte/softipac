package com.olonte.softipac.utilidad;

public interface Utilidad {	
	static final String EMAIL_PATTERN         = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	static final String STRING_PATTERN        = "[a-zA-Z]+";
	static final String HORA          	      = "cita.hora.horaId.idhora";
	static final String TIPO_DOC_PACIENTE     = "paciente.documento_iddocumento.tipoDocumento.idTipoDocumento";
	static final String GENERO_PACIENTE       = "paciente.genero_idgenero.idGenero";
	static final String ESCOLARIDAD_PACIENTE  = "paciente.escolaridad_idescolaridad.idEscolaridad";
	static final String TUTELA             	  = "paciente.tutela";
	static final String EPS            	      = "paciente.eps_ideps.idEps";
	static final String DIAGNOSTICOS          = "paciente.diagnosticos";
	static final String PARENTESCO     	      = "acudiente.parentesco_idparentesco.idParentesco";
	static final String TIPO_DOC_ACUDIENTE    = "acudiente.documento_iddocumento.tipoDocumento.idTipoDocumento";
	static final String EMAIL_MADRE           = "madre.email";
	static final String EMAIL_PADRE           = "padre.email";
	static final String EMAIL_ACUDIENTE       = "acudiente.email";
	static final String TIPO_DOC_MADRE        = "madre.documento_iddocumento.tipoDocumento.idTipoDocumento";
	static final String ESCOLARIDAD_MADRE     = "madre.escolaridad_idescolaridad.idEscolaridad";
	static final String TIPO_DOC_PADRE        = "padre.documento_iddocumento.tipoDocumento.idTipoDocumento";
	static final String ESCOLARIDAD_PADRE     = "padre.escolaridad_idescolaridad.idEscolaridad";
	static final String ESCOLARIDAD_ACUDIENTE = "acudiente.escolaridad_idescolaridad.idEscolaridad";
	static final String TIPO_DOC_USUARIO      = "usuario.documento_iddocumento.tipoDocumento.idTipoDocumento";
	static final String GENERO_USUARIO        = "usuario.enero_idgenero.idGenero";
	static final String ESCOLARIDAD_USUARIO   = "usuario.escolaridad_idescolaridad.idEscolaridad";
	static final String EMAIL_USUARIO         = "usuario.email";
	static final String ROLES	              = "usuario.roles";
	static final String SELECCION_OPCION      = "Seleccione";
	static final String SEPARADOR             = "-";
	static final String CADENA_DEFAULT        = "";	
	static final int AGENDA_NUEVA      	   = 1;
	static final int AGENDA_PROCESADA  	   = 2;
	static final int AGENDA_EDITADA    	   = 3;
	static final int AGENDA_EDIT_PROC      = 4;
	static final int CITA_INFO_NUEVA       = 5;
	static final int CITA_INFO_PROC        = 6;
	static final int CITA_INFO_EDIT        = 7;
	static final int CITA_INFO_EDIT_PROC   = 8;
	static final int CITA_AGENDA           = 1;
	static final int CITA_INFORMACION      = 2;
	static final int CITA_INFO_CREAR       = 8;
	static final int ESTADO_ACTIVO         = 1;
	static final int ESTADO_INACTIVO       = 2;
	static final int ESTADO_PENDIENTE      = 3;
	static final int ESTADO_CANCELADO      = 4;
	static final int ESTADO_TERMINADO      = 5;
	static final int USUARIO_APLICACION    = 1;
	static final int USUARIO_SISTEMA       = 2;
	static final int USUARIO_PACIENTE      = 3;
	static final int USUARIO_PARIENTE      = 4;
	static final int USUARIO_ACUDIENTE     = 5;
	static final int USUARIO_NUEVO         = 1;
	static final int USUARIO_NUEVO_PROC    = 2;
	static final int USUARIO_EDITAR        = 3;
	static final int USUARIO_EDITAR_PROC   = 4;
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
	static final int INDICE_INICIAL		   = 0;
	static final int MAXIMO_PAGINA         = 5;
	static final int MINIMO_PAGINA         = 10;
	static final int REGISTRO_CIVIL        = 1;
	static final int TARJETA_IDENTIDAD     = 2;
	static final int JARDIN                = 1; 
	static final int INCLUSION_ESCOLAR     = 4;
	static final int LONGITUD_DEFECTO      = 1;
	static final int TIPO_DOC_REG_CV       = 1;
	static final int TIPO_DOC_TRJ_ID       = 2;
	static final int ESCOLARIDAD_JARDIN    = 1;
	static final int ESCOLARIDAD_INC_ESC   = 4;

}
