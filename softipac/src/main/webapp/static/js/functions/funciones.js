$(document).ready( function() {
	
	/**
	 * Se le asigna el funcionalidad de la fecha 
	 */
	$('#fechaCitaIni').datepicker();
	$('#fechaNacimiento').datepicker();
	
	/**
	 * Función que valida la disponibilidad de turnos para una cita
	 */
	$('#fechaCitaIni').change(function () {
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
	});
	
});