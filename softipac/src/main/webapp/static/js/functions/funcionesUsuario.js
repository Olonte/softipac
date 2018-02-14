/**
 * 
 */
$(document).ready( function() {
	
	$('#usuarioFechaNacimiento').datepicker();
	
	$('#usuarioFechaNacimiento').change(function () {
		calcularEdad($('#usuarioFechaNacimiento').val().substring(6,10) + "-" 
				+ $('#usuarioFechaNacimiento').val().substring(3,5) + "-" 
				+ $('#usuarioFechaNacimiento').val().substring(0,2));

	});
	
	$('#usuarioDocumento').change(function () { // UsuarioDocumento
		var documento = $('#usuarioDocumento').val();
		var usuarioAplicacion = 1;
		var usuarioSistema = 2;
		$.ajax({ //obtenerPaciente
			url:'/softipac/obtenerUsuario/' + documento + "-" + usuarioAplicacion + "-" + usuarioSistema,
			type:"GET",
			dataType:'json',
			success:function(usuario) {
				if (usuario.idUsuario != null) {
					$('#usuariojavaScript').val(true);
					$('#usuarioIdUsuario').val(usuario.idUsuario);
					$('#usuarioIdEstado').val(usuario.estado_idestado.idEstado)
					$('#usarioIdTipoDocumento').val(usuario.documento_iddocumento.tipoDocumento.idTipoDocumento);
					$('#usuarioDocumento').val(usuario.documento_iddocumento.documento);
					$('#usuarioNombres').val(usuario.nombres);
					$('#usuarioPrimerApellido').val(usuario.primerApellido);
					$('#usuarioSegundoApellido').val(usuario.segundoApellido);
					$('#nombreUsuario').val(usuario.nombreUsuario);
					$('#usuarioFechaNacimiento').val(formatoFecha(usuario.fechaNacimiento));
					$('#usuarioLugarNacimiento').val(usuario.lugarNacimiento);
					$('#usuarioEdad').val(usuario.edad);
					$('#usuarioIdGenero').val(usuario.genero_idgenero.idGenero);
					$('#usuarioIdEscolaridad').val(usuario.escolaridad_idescolaridad.idEscolaridad);
					$('#usuarioOcupacion').val(usuario.ocupacion);
					$('#usuarioDireccion').val(usuario.direccion);
					$('#usuarioTelefonoFijo').val(usuario.telefonoFijo);
					$('#usuarioTelefonoCelular').val(usuario.telefonoCelular);
					$('#usuarioEmail').val(usuario.email);
					$('#usuarioIdTipoUsuario').val(usuario.tipousuario_idtipousuario.idTipoUsuario);
					$.each(usuario.roles, function(indice, valor){
						$('#rolesUsuario').append( $('<option>').val(valor.idRol).text(valor.rol) );
					});
				}
			},
			error:function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			}
		});
	});
	
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
      
        $('#usuarioEdad').val(edad);
 
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
	 * Función Adiconar y Eliminar items
	 */
	
	$(function () {
		function moverItems(origen, destino) {
			$(origen).find(':selected').appendTo(destino);
		}
			
		$('#btnAgregarRol').click(function() {
			moverItems('#roles', '#rolesUsuario');
		});
			
		$('#btnEliminarRol').click(function() {
			moverItems('#rolesUsuario', '#roles');
		});
	});
	
});