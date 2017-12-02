$(document).ready( function() {
	
	/**
	 * Se le asigna el funcionalidad de la fecha 
	 */
	$('#fechaCitaIni').datepicker();
	$('#fechaNacimiento').datepicker();
	
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
   			 			$('#horas').append($('<option>').val(valor.idHora).text(valor.hora));
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
	 * Función que valida la disponibilidad de turnos para una cita
	 */
	$('#pacienteDocumento').change(function () { // pacienteDocumento
		var pacienteDocumento = $('#pacienteDocumento').val();
		$.ajax({ //obtenerPaciente
			url:'/softipac/obtenerPaciente/' + pacienteDocumento,
			dataType:'json',
			success:function(paciente) {
				if (paciente.idUsuario != null) {
					var acudiente = 5;
					/**
					 * Datos del Paciente
					 */
					$('#idPaciente').val(paciente.idUsuario);
					$('#pacienteidTipoDocumento').val(paciente.documento.tipoDocumento.idTipoDocumento);
					$('#pacienteDocumento').val(paciente.documento.documento);
					$('#pacienteNombres').val(paciente.nombres);
					$('#pacientePrimerApellido').val(paciente.primerApellido);
					$('#pacienteSegundoApellido').val(paciente.segundoApellido);
					$('#fechaNacimiento').val(paciente.fechaNacimiento.monthValue + "/" +
								paciente.fechaNacimiento.dayOfMonth + "/" + 
								paciente.fechaNacimiento.year);
					 $('#edad').val(paciente.edad);
					 $('#pacienteidGenero').val(paciente.genero.idGenero);
					 $('#pacienteidEscolaridad').val(paciente.escolaridad.idEscolaridad);
					 $('#pacienteTutela').val(paciente.tutela);
					 $('#pacienteidEps').val(paciente.eps.idEps);
					 $.each(paciente.diagnosticos, function(indice, valor) {
							$('#agendaDiagnosticos').append( $('<option>').val(valor.idDiagnostico).text(valor.diagnostico) );
					});
					 
					 /**
					  * Datos del Acudiente
					 */
					 for (i = 0; i < paciente.familiares.length; i++) {
						 if (paciente.familiares[i].tipoUsuario.idTipoUsuario = acudiente) { 
							 $('#idAcudiente').val(paciente.familiares[i].idUsuario);
							 $('#acudienteidTipoDocumento').val(paciente.familiares[i].documento.tipoDocumento.idTipoDocumento);
							 $('#acudienteDocumento').val(paciente.familiares[i].documento.documento);
							 $('#idParentesco').val(paciente.familiares[i].parentesco.idParentesco);
							 $('#acudienteNombres').val(paciente.familiares[i].nombres);
							 $('#acudientePrimerApellido').val(paciente.familiares[i].primerApellido);
							 $('#acudienteSegundoApellido').val(paciente.familiares[i].segundoApellido);
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
				if (cita.idCita != null) {
					$('#idCita').val(cita.idCita);
					$('#fechaCitaIni').val(cita.fechaCitaIni.monthValue + "/" +
							cita.fechaCitaIni.dayOfMonth + "/" + 
							cita.fechaCitaIni.year);
					$('#horas').append( $('<option>').val(cita.hora.idHora).text(cita.hora.hora) );
					$('#observacion').val(cita.observacion);
				}
			},error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
		   	  }
		}); // fin obtenerCita
		
	});// Fin pacienteDocumento

});