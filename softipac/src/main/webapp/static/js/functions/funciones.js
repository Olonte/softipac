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
	
	$('#fechaNacimiento').datepicker();
	
	
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
	}); // fin fechaCitaIni
	
	
	/**
	 * Función para seleccionar los diagnósticos del paciente
	 */
	if ($('#citaAgenda').val() == citaAgenda) {
		
		$('#pacienteDiagnosticos').change(function() { // pacienteDiagnosticos
			var diagnostico =  $('#pacienteDiagnosticos').val();
			if( diagnostico.length == 1 ) {
				$('#agendaCitaInfoDiagnosticos').empty();
				$('#agendaCitaInfoDiagnosticos').append($('<option>').val($("#pacienteDiagnosticos option:selected").val()).text($("#pacienteDiagnosticos option:selected").text()));
			}
		}); // fin pacienteDiagnosticos
	}

	
	/**
	 * Función que obtiene los datos del paciente a partir del documento
	 * 
	 */
	$('#pacienteDocumento').change(function () { // pacienteDocumento
		var pacienteDocumento = $('#pacienteDocumento').val();
		var paciente = 3;
		$.ajax({ //obtenerPaciente
			url:'/softipac/obtenerPaciente/' + pacienteDocumento + "-" + paciente,
			type:"GET",
			dataType:'json',
			success:function(paciente) {
				if (paciente.idUsuario != null) {
					$('#javaScript').val(true);
					/**
					 * Datos del Paciente
					 */
					$('#pacienteIdUsuario').val(paciente.idUsuario);
					$('#pacienteIdTipoUsuario').val(paciente.tipoUsuario.idTipoUsuario);
					$('#pacienteIdEstado').val(paciente.estado.idEstado);
					$('#pacienteIdTipoDocumento').val(paciente.documento.tipoDocumento.idTipoDocumento);
					$('#pacienteDocumento').val(paciente.documento.documento);
					$('#pacienteNombres').val(paciente.nombres);
					$('#pacientePrimerApellido').val(paciente.primerApellido);
					$('#pacienteSegundoApellido').val(paciente.segundoApellido);
					$('#fechaNacimiento').val(formatoFecha(paciente.fechaNacimiento));
					$('#pacienteEdad').val(paciente.edad);
					if($('#citaAgenda').val() == citaInformacion){
						if (paciente.meses != null) {
							$('#meses').val(paciente.meses);
						}
					}
					$('#pacienteIdGenero').val(paciente.genero.idGenero);
					$('#pacienteIdEscolaridad').val(paciente.escolaridad.idEscolaridad);
					$('#pacienteTutela').val(paciente.tutela);
					$('#pacienteIdEps').val(paciente.eps.idEps);
					$.each(paciente.diagnosticos, function(indice, valor) {
						$('#pacienteDiagnosticos').append( $('<option>').val(valor.idDiagnostico).text(valor.diagnostico));
					});
					
					/**
					 * Se debe revisar si es necesario eliminar esta linea de codigo porque no se hace referencia 
					 * ni en agenda.jsp ni citaInformacion.jsp
					 */
					 //$('#diagnosticosTemp').val(paciente.diagnosticos); 
					
					 /**
					  * Datos del Acudiente
					 */
					
					 for (i = 0; i < paciente.familiares.length; i++) {
						 if (paciente.familiares[i].tipoUsuario.idTipoUsuario == acudiente) { 
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
							 $('#acudienteDireccion').val(paciente.familiares[i].direccion);
							 $('#acudienteTelefonoFijo').val(paciente.familiares[i].telefonoFijo);
							 $('#acudienteTelefonoCelular').val(paciente.familiares[i].telefonoCelular);
							 $('#acudienteEmail').val(paciente.familiares[i].email); 
							 
							 if ($('#citaAgenda').val() == citaInformacion) {
								 datosFamiliar(paciente, paciente.familiares[i].parentesco.idParentesco);
							 }
						 }else{
							 if($('#citaAgenda').val() == citaInformacion) {
								 datosFamiliar(paciente, paciente.familiares[i].parentesco.idParentesco);
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
				 $('#madreIdTipoUsuario').val(paciente.familiares[i].tipoUsuario.idTipoUsuario);
				 $('#madreIdEstado').val(paciente.familiares[i].estado.idEstado);
				 $('#madreIdTipoDocumento').val(paciente.familiares[i].documento.tipoDocumento.idTipoDocumento);
				 $('#madreDocumento').val(paciente.familiares[i].documento.documento);
				 $('#madreIdParentesco').val(paciente.familiares[i].parentesco.idParentesco);
				 $('#madreNombres').val(paciente.familiares[i].nombres);
				 $('#madrePrimerApellido').val(paciente.familiares[i].primerApellido);
				 $('#madreSegundoApellido').val(paciente.familiares[i].segundoApellido);
				 $('#madreEdad').val(paciente.familiares[i].edad);
				 $('#madreIdEscolaridad').val(paciente.familiares[i].escolaridad.idEscolaridad);
				 $('#madreOcupacion').val(paciente.familiares[i].ocupacion);
				 $('#madreDireccion').val(paciente.familiares[i].direccion);
				 $('#madreTelefonoFijo').val(paciente.familiares[i].telefonoFijo);
				 $('#madreTelefonoCelular').val(paciente.familiares[i].telefonoCelular);
				 $('#madreEmail').val(paciente.familiares[i].email); 
				 break;
			case padre:
				 $('#padreIdUsuario').val(paciente.familiares[i].idUsuario);
				 $('#padreIdTipoUsuario').val(paciente.familiares[i].tipoUsuario.idTipoUsuario);
				 $('#padreIdEstado').val(paciente.familiares[i].estado.idEstado);
				 $('#padreIdTipoDocumento').val(paciente.familiares[i].documento.tipoDocumento.idTipoDocumento);
				 $('#padreDocumento').val(paciente.familiares[i].documento.documento);
				 $('#padreIdParentesco').val(paciente.familiares[i].parentesco.idParentesco);
				 $('#padreNombres').val(paciente.familiares[i].nombres);
				 $('#padrePrimerApellido').val(paciente.familiares[i].primerApellido);
				 $('#padreSegundoApellido').val(paciente.familiares[i].segundoApellido);
				 $('#padreEdad').val(paciente.familiares[i].edad);
				 $('#padreIdEscolaridad').val(paciente.familiares[i].escolaridad.idEscolaridad);
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
	 * Función Adiconar y Eliminar diagnósticos del paciente
	 */
	
	$(function () {
		
		function moverItems(origen, destino) {
			$(origen).find(':selected').appendTo(destino);
		}
		
		$('#btnAgregar').click(function() {
			moverItems('#agendaCitaInfoDiagnosticos', '#pacienteDiagnosticos');
		});
		
		$('#btnEliminar').click(function() {
			moverItems('#pacienteDiagnosticos', '#agendaCitaInfoDiagnosticos');
		});
	});
	
});