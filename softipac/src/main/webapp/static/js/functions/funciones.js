$(document).ready( function() {
	/*****************************************************************************************************************************************
	 * 																																		 *
	 * 															Scripts	agenda.jsp															 *
	 *****************************************************************************************************************************************/
	/**
	 * Se le asigna el funcionalidad de la fecha 
	 */
	$('#fechaCitaIni').datepicker();
	
	$('#fechaNacimiento').datepicker();
	
	$('#fechaCitaIniInfo').datepicker();
	
	/**
	 * Función que valida la disponibilidad de turnos para una cita
	 */
	$('#fechaCitaIni').change(function () { // fechaCitaIni 
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
	}); // fin fechaCitaIni
	
	/**
	 * Función para seleccionar los diagnósticos del paciente
	 */
	$('#pacienteDiagnosticos').change(function() { // pacienteDiagnosticos
		var diagnostico =  $('#pacienteDiagnosticos').val();
		if( diagnostico.length == 1 ) {
			$('#agendaDiagnosticos').empty();
			$('#agendaDiagnosticos').append($('<option>').val($("#pacienteDiagnosticos option:selected").val()).text($("#pacienteDiagnosticos option:selected").text()));
		}
	}); // fin pacienteDiagnosticos
	
	/**
	 * Función que obtiene los datos del paciente a partir del documento
	 */
	$('#pacienteDocumento').change(function () { // pacienteDocumento
		var pacienteDocumento = $('#pacienteDocumento').val();
		$.ajax({ //obtenerPaciente
			url:'/softipac/obtenerPaciente/' + pacienteDocumento,
			dataType:'json',
			success:function(paciente) {
				if (paciente.idUsuario != null) {
					$('#javaScript').val(true);
					var acudiente = 5;
					/**
					 * Datos del Paciente
					 */
					$('#pacienteIdUsuario').val(paciente.idUsuario);
					$('#pacienteidTipoUsuario').val(paciente.tipoUsuario.idTipoUsuario);
					$('#pacienteIdEstado').val(paciente.estado.idEstado);
					$('#pacienteIdTipoDocumento').val(paciente.documento.tipoDocumento.idTipoDocumento);
					$('#pacienteDocumento').val(paciente.documento.documento);
					$('#pacienteNombres').val(paciente.nombres);
					$('#pacientePrimerApellido').val(paciente.primerApellido);
					$('#pacienteSegundoApellido').val(paciente.segundoApellido);
					$('#fechaNacimiento').val(formatoFecha(paciente.fechaNacimiento));
					$('#pacienteEdad').val(paciente.edad);
					$('#pacienteIdGenero').val(paciente.genero.idGenero);
					$('#pacienteIdEscolaridad').val(paciente.escolaridad.idEscolaridad);
					$('#pacienteTutela').val(paciente.tutela);
					$('#pacienteidEps').val(paciente.eps.idEps);
					$.each(paciente.diagnosticos, function(indice, valor) {
							$('#agendaDiagnosticos').append( $('<option>').val(valor.idDiagnostico).text(valor.diagnostico) );
					});
					 $('#diagnosticosTemp').val(paciente.diagnosticos);
					 /**
					  * Datos del Acudiente
					 */
					 for (i = 0; i < paciente.familiares.length; i++) {
						 if (paciente.familiares[i].tipoUsuario.idTipoUsuario = acudiente) { 
							 $('#acudienteIdUsuario').val(paciente.familiares[i].idUsuario);
							 $('#acudienteIdTipoUsuario').val(paciente.familiares[i].tipoUsuario.idTipoUsuario);
							 $('#acudienteIdEstado').val(paciente.familiares[i].estado.idEstado);
							 $('#acudienteIdTipoDocumento').val(paciente.familiares[i].documento.tipoDocumento.idTipoDocumento);
							 $('#acudienteDocumento').val(paciente.familiares[i].documento.documento);
							 $('#acudienteIdParentesco').val(paciente.familiares[i].parentesco.idParentesco);
							 $('#acudienteNombres').val(paciente.familiares[i].nombres);
							 $('#acudientePrimerApellido').val(paciente.familiares[i].primerApellido);
							 $('#acudienteSegundoApellido').val(paciente.familiares[i].segundoApellido);
							 $('#acudienteEdad').val(paciente.familiares[i].edad);
							 $('#acudienteIdEscolaridad').val(paciente.familiares[i].escolaridad.idEscolaridad);
							 $('#acudienteOcupacion').val(paciente.familiares[i].ocupacion);
							 $('#direccion').val(paciente.familiares[i].direccion);
							 $('#telefonoFijo').val(paciente.familiares[i].telefonoFijo);
							 $('#telefonoCelular').val(paciente.familiares[i].telefonoCelular);
							 $('#email').val(paciente.familiares[i].email); 
						 }
					 } 
				}
			},
			error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			}	 
		}); // fin ajax obtenerPaciente
			
		$.ajax({ //obtenerCita
			url:'/softipac/obtenerCita/' + pacienteDocumento,
			type:'GET',
			dataType:'json',
			success:function(cita) {
				if (cita.citaId.idcita != null) {
					$('#citaIdCita').val(cita.citaId.idcita);
					$('#citaIdTipoCita').val(cita.citaId.tipocita_idtipocita.idTipoCita);
					$('#citaIdEstado').val(cita.citaId.estado_idestado.idEstado);
					$('#citaidTipoHora').val(cita.hora.horaId.tipohora_idtipohora.idTipoHora);
					$('#citaIdUsuarioApl').val(cita.citaId.usuario_idusuapl.idUsuario);
					$('#citaIdUsuario').val(cita.citaId.usuario_idusuario.idUsuario);
					$('#fechaCitaIni').val(formatoFecha(cita.fechaCitaIni));
					
					if($('#citaAgenda').val()) {
						if (cita.horas.length > 0 ) {
		   			 		$.each(cita.horas, function(indice, valor) {
		   			 			$('#horas').append($('<option>').val(valor.horaId.idhora).text(valor.hora));
		   			 		});
		   			 		$('#horas').val(cita.hora.horaId.idhora);
		   			 	}
						$('#observacion').val(cita.observacion);
					}
					
				}
			},error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
		   	  }
		}); // fin obtenerCita
		
	});// Fin pacienteDocumento
  /***************************************************************************************************************************************************************/
	function formatoFecha(fecha) {
		var dia = fecha.dayOfMonth.toString();
	    var mes = fecha.monthValue.toString();
	    
		if (dia.length < 2) 
			dia = "0" + dia;
		
		if (mes.length < 2) 
			mes = "0" + mes;

		return dia + "-" + mes + "-" + fecha.year;
	}
});