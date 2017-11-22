/**
 * 
 */
$(document).ready( function() {
	
	/**
	 * Se le asigna el funcionalidad de la fecha 
	 */
	$('#fechaCitaIni').datepicker();
	
	/**
	 * Función que valida la disponibilidad de turnos para una cita
	 */
	$('#fechaCitaIni').change(function () {
		$ajax(
				{
					url:'/softipac/obtenerHora/' + $('#fechaCitaIni').val(),
					type:'GET',
					dataType:'json',
					success:function(horas) {
						$('#horas').empty().append($('<option> value="-1" label="Seleccione" </option>');
						
						if ( horas.length > 0 ) {
							$.each(horas, function(indice, valor) {
								$('#horas').append($('<option>').val(valor.idHora).text(valor.hora));
							});
						}else{
							alert('No existe hora disponible para la fecha seleccionada');
						}
					},
					error:function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
		   		 	}
				});
	});
	
	/**
	 * Función que obtiene los datos del paciente una vez se digite el número del documento
	 */
	$('#pacienteDocumento').change(function () {
		$.ajax(
				{
					url:'/softipac/obtenerPaciente/' + $("#pacienteDocumento").val(),
					type:'GET',
					dataType:'json',
					success:function(paciente) {
						var acudiente = 4;
						/**
						 * Datos del Paciente
						 */
						$('#idPaciente').val(paciente.idusuario);
						$('#pacienteidTipoDocumento').val(paciente.documento.tipoDocumento.idTipoDocumento);
						$('#pacienteDocumento').val(paciente.documento.documento);
						$('#pacienteNombres').val(paciente.nombres);
						$('#pacientePrimerApellido').val(paciente.primerApellido);
						$('#pacienteSegundoApellido').val(paciente.segundoApellido);
						$('#fechaNacimiento').val(paciente.fechaNacimiento);
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
						for (i = 0; i < paciente.afinidadUsuarios.length; i++) {
							if(paciente.afinidadUsuarios.[i]tipoUsuario.idTipoUsuario = acudiente){
								$('#idAcudiente').val(paciente.afinidadUsuarios[i].idUsuario);
								$('#acudienteidTipoDocumento').val(paciente.afinidadUsuarios[i].documento.tipoDocumento.idTipoDocumento);
								$('#acudienteDocumento').val(paciente.afinidadUsuario[i].documento.documento);
								$('#idParentesco').val(paciente.afinidadUsuario[i].parentesco.idParentesco);
								$('#acudienteNombres').val(paciente.afinidadUsuario[i].nombres);
								$('#acudientePrimerApellido').val(paciente.afinidadUsuario[i].primerApellido);
								$('#acudienteSegundoApellido').val(paciente.afinidadUsuario[i].segundoApellido);
								$('#direccion').val(paciente.afinidadUsuarios[i].direccion);
								$('#telefonoFijo').val(paciente.afinidadUsuarios[i].telefonoCelular);
								$('#email').val(paciente.afinidadUsuarios[i].email);
							}
						}
					
					}, 
					error:function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
		   		 	}
			 });
		
		$.ajax(
				{
					url:'/softipac/obtenerCita/' + $("#pacienteDocumento").val(),
					type:'GET',
					dataType:'json',
					success:function(cita) {
						$('#observacion').val(cita.observacion);
					},error:function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
		   		 	}
				});
	});
	
	
})