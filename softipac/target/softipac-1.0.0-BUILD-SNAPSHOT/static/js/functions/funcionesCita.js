$(document).ready( function() {
	var citaAgenda = 1;
	var citaInformacion = 2;
	var padre = 2;
	var madre = 3;
	var acudiente = 5;
	/*****************************************************************************************************************************************
	 * 																																		 *
	 * 															Scripts	agenda.jsp															 *
	 *****************************************************************************************************************************************/
	/**
	 * Se le asigna el funcionalidad de la fecha 
	 */
	$('#fechaCitaIni').datepicker();
	
	$('#pacienteFechaNacimiento').datepicker();
	/**
	 * Se calcula la edad del Paciente
	 */
	$('#pacienteFechaNacimiento').change(function () {
		calcularEdad($('#pacienteFechaNacimiento').val().substring(6,10) + "-" 
				+ $('#pacienteFechaNacimiento').val().substring(3,5) + "-" 
				+ $('#pacienteFechaNacimiento').val().substring(0,2));

	});
	
	/**
	* Función que valida la disponibilidad de turnos para una cita
	*/
	$('#fechaCitaIni').change(function () { // fechaCitaIni 
		/**
		* Si se ingresa a agenda.jsp se hace la consulta de la disponibilidad de las horas 
		*/
		if ($('#citaAgenda').val() == citaAgenda) {
		
			var fechaCitaIni = $('#fechaCitaIni').val();
			$.ajax({
				url:'/softipac/obtenerHora/' + fechaCitaIni,
				type:'GET',
				dataType:'json',
				success:function(horas){
					$('#horas').empty().append('<option value="-1" label="Seleccione"> </option>');
					if (horas.length > 0 ) {
						$.each(horas, function(indice, valor) {
							$('#horas').append($('<option>').val(valor.horaId.idhora).text(valor.hora));
			   			 });
			   		}else {
			   			alert('No existe hora disponible para la fecha seleccionada');
			   		}
				},
				error:function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
			   	}
			});
		}
	}); // fin fechaCitaInI
	
	/**
	 * Función que obtiene los datos del paciente a partir del documento
	 * 
	 */
	$('#pacienteDocumento').change(function () { // pacienteDocumento
		var pacienteDocumento = $('#pacienteDocumento').val();
		var paciente = 3;
		$.ajax({ //obtenerPaciente
			url:'/softipac/obtenerUsuario/' + pacienteDocumento + "-" + paciente,
			type:"GET",
			dataType:'json',
			success:function(paciente) {
				if (paciente.idUsuario != null) {
					$('#javaScript').val(true);
					/**
					 * Datos del Paciente
					 */
					$('#pacienteIdUsuario').val(paciente.idUsuario);
					$('#pacienteIdTipoUsuario').val(paciente.tipousuario_idtipousuario.idTipoUsuario);
					$('#pacienteIdEstado').val(paciente.estado_idestado.idEstado);
					$('#pacienteIdTipoDocumento').val(paciente.documento_iddocumento.tipoDocumento.idTipoDocumento);
					$('#pacienteDocumento').val(paciente.documento_iddocumento.documento);
					$('#pacienteNombres').val(paciente.nombres);
					$('#pacientePrimerApellido').val(paciente.primerApellido);
					$('#pacienteSegundoApellido').val(paciente.segundoApellido);
					$('#pacienteFechaNacimiento').val(formatoFecha(paciente.fechaNacimiento));
					$('#pacienteEdad').val(paciente.edad);
					$('#pacienteMeses').val(paciente.meses);
					$('#pacienteIdGenero').val(paciente.genero_idgenero.idGenero);
					$('#pacienteIdEscolaridad').val(paciente.escolaridad_idescolaridad.idEscolaridad);
					$('#pacienteTutela').val(paciente.tutela);
					$('#pacienteIdEps').val(paciente.eps_ideps.idEps);
					$.each(paciente.diagnosticos, function(indice, valor) {
						$('#pacienteDiagnosticos').append( $('<option>').val(valor.idDiagnostico).text(valor.diagnostico));
					});
					
					 /**
					  * Datos del Acudiente
					 */
					
					 for (i = 0; i < paciente.familiares.length; i++) {
						 if (paciente.familiares[i].tipousuario_idtipousuario.idTipoUsuario == acudiente) { 
							 $('#acudienteIdUsuario').val(paciente.familiares[i].idUsuario);
							 $('#acudienteIdTipoUsuario').val(paciente.familiares[i].tipousuario_idtipousuario.idTipoUsuario);
							 $('#acudienteIdEstado').val(paciente.familiares[i].estado_idestado.idEstado);
							 $('#acudienteIdTipoDocumento').val(paciente.familiares[i].documento_iddocumento.tipoDocumento.idTipoDocumento);
							 $('#acudienteDocumento').val(paciente.familiares[i].documento_iddocumento.documento);
							 $('#acudienteIdParentesco').val(paciente.familiares[i].parentesco_idparentesco.idParentesco);
							 $('#acudienteNombres').val(paciente.familiares[i].nombres);
							 $('#acudientePrimerApellido').val(paciente.familiares[i].primerApellido);
							 $('#acudienteSegundoApellido').val(paciente.familiares[i].segundoApellido);
							 $('#acudienteEdad').val(paciente.familiares[i].edad);
							 $('#acudienteIdEscolaridad').val(paciente.familiares[i].escolaridad_idescolaridad.idEscolaridad);
							 $('#acudienteOcupacion').val(paciente.familiares[i].ocupacion);
							 $('#acudienteDireccion').val(paciente.familiares[i].direccion);
							 $('#acudienteTelefonoFijo').val(paciente.familiares[i].telefonoFijo);
							 $('#acudienteTelefonoCelular').val(paciente.familiares[i].telefonoCelular);
							 $('#acudienteEmail').val(paciente.familiares[i].email); 
							 
							 if ($('#citaAgenda').val() == citaInformacion) {
								 datosFamiliar(paciente, paciente.familiares[i].parentesco_idparentesco.idParentesco);
							 }
						 }else{
							 if($('#citaAgenda').val() == citaInformacion) {
								 datosFamiliar(paciente, paciente.familiares[i].parentesco_idparentesco.idParentesco);
							 }
						 }
					 } 
				}
			},
			error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			}	 
		}); // fin ajax obtenerPaciente
			
		$.ajax({ //obtenerCita
			url:'/softipac/obtenerCita/' + pacienteDocumento + "-" + $('#citaAgenda').val(),
			type:'GET',
			dataType:'json',
			success:function(cita) {
				if (cita.citaId.idcita != null) {
					$('#citaIdCita').val(cita.citaId.idcita);
					$('#citaIdTipoCita').val(cita.citaId.tipocita_idtipocita.idTipoCita);
					$('#citaIdEstado').val(cita.citaId.estado_idestado.idEstado);
					$('#citaIdUsuarioApl').val(cita.citaId.usuario_idusuapl.idUsuario);
					$('#citaIdUsuario').val(cita.citaId.usuario_idusuario.idUsuario);
					$('#fechaCitaIni').val(formatoFecha(cita.fechaCitaIni));
					
					if($('#citaAgenda').val() == citaAgenda) {
						$('#citaidTipoHora').val(cita.hora.horaId.tipohora_idtipohora.idTipoHora);
						if (cita.horas.length > 0 ) {
		   			 		$.each(cita.horas, function(indice, valor) {
		   			 			$('#horas').append($('<option>').val(valor.horaId.idhora).text(valor.hora));
		   			 		});
		   			 		$('#horas').val(cita.hora.horaId.idhora);
		   			 	}
						$('#observacion').val(cita.observacion);
					}else{
						$('#motivoConsulta').val(cita.motivoConsulta);
						$('#expectativas').val(cita.expectativas);
						$('#recomTenerCta').val(cita.recomTenerCta);
						$('#inFoGral').val(cita.inFoGral);
					}
					
				}
			},error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
		   	  }
		}); // fin obtenerCita
		
	});// Fin pacienteDocumento
	
	function datosFamiliar(paciente, idParentesco) {
		switch(idParentesco){
			case madre:
				 $('#madreIdUsuario').val(paciente.familiares[i].idUsuario);
				 $('#madreIdTipoUsuario').val(paciente.familiares[i].tipousuario_idtipousuario.idTipoUsuario);
				 $('#madreIdEstado').val(paciente.familiares[i].estado_idestado.idEstado);
				 $('#madreIdTipoDocumento').val(paciente.familiares[i].documento_iddocumento.tipoDocumento.idTipoDocumento);
				 $('#madreDocumento').val(paciente.familiares[i].documento_iddocumento.documento);
				 $('#madreIdParentesco').val(paciente.familiares[i].parentesco_idparentesco.idParentesco);
				 $('#madreNombres').val(paciente.familiares[i].nombres);
				 $('#madrePrimerApellido').val(paciente.familiares[i].primerApellido);
				 $('#madreSegundoApellido').val(paciente.familiares[i].segundoApellido);
				 $('#madreEdad').val(paciente.familiares[i].edad);
				 $('#madreIdEscolaridad').val(paciente.familiares[i].escolaridad_idescolaridad.idEscolaridad);
				 $('#madreOcupacion').val(paciente.familiares[i].ocupacion);
				 $('#madreDireccion').val(paciente.familiares[i].direccion);
				 $('#madreTelefonoFijo').val(paciente.familiares[i].telefonoFijo);
				 $('#madreTelefonoCelular').val(paciente.familiares[i].telefonoCelular);
				 $('#madreEmail').val(paciente.familiares[i].email); 
				 break;
			case padre:
				 $('#padreIdUsuario').val(paciente.familiares[i].idUsuario);
				 $('#padreIdTipoUsuario').val(paciente.familiares[i].tipousuario_idtipousuario.idTipoUsuario);
				 $('#padreIdEstado').val(paciente.familiares[i].estado_idestado.idEstado);
				 $('#padreIdTipoDocumento').val(paciente.familiares[i].documento_iddocumento.tipoDocumento.idTipoDocumento);
				 $('#padreDocumento').val(paciente.familiares[i].documento_iddocumento.documento);
				 $('#padreIdParentesco').val(paciente.familiares[i].parentesco_idparentesco.idParentesco);
				 $('#padreNombres').val(paciente.familiares[i].nombres);
				 $('#padrePrimerApellido').val(paciente.familiares[i].primerApellido);
				 $('#padreSegundoApellido').val(paciente.familiares[i].segundoApellido);
				 $('#padreEdad').val(paciente.familiares[i].edad);
				 $('#padreIdEscolaridad').val(paciente.familiares[i].escolaridad_idescolaridad.idEscolaridad);
				 $('#padreOcupacion').val(paciente.familiares[i].ocupacion);
				 $('#padreDireccion').val(paciente.familiares[i].direccion);
				 $('#padreTelefonoFijo').val(paciente.familiares[i].telefonoFijo);
				 $('#padreTelefonoCelular').val(paciente.familiares[i].telefonoCelular);
				 $('#padreEmail').val(paciente.familiares[i].email); 
				break;
			default:
				break;
		}
	}
	
  /***************************************************************************************************************************************************************/
	/**
	 * Función para calcular la edad 
	 */
	function calcularEdad(fecha) {
        var values = fecha.split("-");
        var dia = values[2];
        var mes = values[1];
        var ano = values[0];

        // cogemos los valores actuales
        var fecha_hoy = new Date();
        var ahora_ano = fecha_hoy.getYear();
        var ahora_mes = fecha_hoy.getMonth() + 1;
        var ahora_dia = fecha_hoy.getDate();

        // realizamos el calculo
        var edad = (ahora_ano + 1900) - ano;
        if (ahora_mes < mes) {
            edad--;
        }
        if ((mes == ahora_mes) && (ahora_dia < dia)) {
            edad--;
        }
        if (edad > 1900) {
            edad -= 1900;
        }

        // calculamos los meses
        var meses = 0;

        if (ahora_mes > mes && dia > ahora_dia)
            meses = ahora_mes - mes - 1;
        else if (ahora_mes > mes)
            meses = ahora_mes - mes
        if (ahora_mes < mes && dia < ahora_dia)
            meses = 12 - (mes - ahora_mes);
        else if (ahora_mes < mes)
            meses = 12 - (mes - ahora_mes + 1);
        if (ahora_mes == mes && dia > ahora_dia)
            meses = 11;

        // calculamos los dias
        var dias = 0;
        if (ahora_dia > dia)
            dias = ahora_dia - dia;
        if (ahora_dia < dia) {
            ultimoDiaMes = new Date(ahora_ano, ahora_mes - 1, 0);
            dias = ultimoDiaMes.getDate() - (dia - ahora_dia);
        }
      
        $('#pacienteEdad').val(edad);
        $('#pacienteMeses').val(meses);
    
    }
	/**
	 * Función genera el formato de la fecha
	 */
	function formatoFecha(fecha) {
		var dia = fecha.dayOfMonth.toString();
	    var mes = fecha.monthValue.toString();
	    
		if (dia.length < 2) 
			dia = "0" + dia;
		
		if (mes.length < 2) 
			mes = "0" + mes;

		return dia + "-" + mes + "-" + fecha.year;
	}
	
	/**
	 * Función Adicionar y Eliminar items
	 */
	
	$(function () {
		
		function moverItems(origen, destino) {
			$(origen).find(':selected').appendTo(destino);
		}
			
		$('#btnAgregarDiagnostico').click(function() {
				moverItems('#agendaCitaInfoDiagnosticos', '#pacienteDiagnosticos');
			});
			
		$('#btnEliminarDiagnostico').click(function() {
				moverItems('#pacienteDiagnosticos', '#agendaCitaInfoDiagnosticos');
			});
	});

});