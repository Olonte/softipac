<div class="modal fade" id="modalActivarUsuario_${usuario.idUsuario}_${idEstadoActivo}_${indiceActual}" tabindex="-1" role="dialog" aria-hidden="true" >
	<div class="modal-dialog" role="document">
		<div class="modal-content">
	   		<div class="modal-header alert alert-info">
	   			<h4 class="modal-title" id="modalLabel">${activarEtiqueta}</h4>
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	        <p><h4>${actUsuarioMsjEtiqueta}</h4></p>
	      </div>
	      <div class="modal-footer">
	      		<a href="<spring:url value="/activarDesactivar/usuario/?idUsuario=${usuario.idUsuario}&idEstado=${idEstadoActivo}&indiceActual=${indiceActual}"></spring:url>" class="btn btn-blue">${botonConfirmarEtiqueta}</a>
	        	<button type="button" class="btn btn-blue" data-dismiss="modal">${cerrarEtiqueta}</button>
	    	</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->