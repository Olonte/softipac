<div class="modal fade" id="modalCancelarCita_${cita.idUsuario}" tabindex="-1" role="dialog" aria-hidden="true" >
	<div class="modal-dialog" role="document">
		<div class="modal-content">
	   		<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="modalLabel">Cancelar Cita</h4>
	      </div>
	      <div class="modal-body">
	        <p>Desea cancelar la Cita ?</p>
	      </div>
	      <div class="modal-footer">
	        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        	<a href="<spring:url value="/cancelar/agenda/?idUsuario=${cita.idUsuario}"></spring:url>" class="btn btn-danger">Cancelar</a>
	    	</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->