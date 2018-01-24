<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%>
			<div class="pagination">
				<div class="content-inner">
					<div class="table-responsive">
						<table id="citasUsuarios" class="table table-hover">
							<c:choose>
								<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/messages/mensaje_exito.jsp"%></c:when>
								<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/messages/mensaje_error.jsp"%></c:when>
							</c:choose>
							<thead>
								<tr>
						    		<th>${fechaEtiqueta}</th>
	                            	<th>${horaEtiqueta}</th>
	                            	<th>${listAgendaNombresEtiqueta}</th>
	                            	<th>${apellidoEtiqueta}</th>
	                            	<th>${telefonofijoEtiqueta}</th>
	                            	<th>${celularEtiqueta}</th>
	                            	<th>${accionesEtiqueta}</th>
								</tr>
							</thead><!-- .thead -->
							<tbody>
								<c:forEach items="${citas}" var ="cita">
									<%@include file="/WEB-INF/views/modals/modal_cancelarCita.jsp"%> 
							    	<tr>
										<th>${cita.fechaCitaIni}</th>
										<th>${cita.hora}</th>
										<th>${cita.nombres}</th>
										<th>${cita.primerApellido}</th>
										<th>${cita.telefonoFijo}</th>
										<th>${cita.telefonoCelular}</th>
										<td>
											<div class="btn-group btn-actions">
			                                	<button type="button" class="btn dropdown-toggle" data-toggle="dropdown">${accionEtiqueta}</button>
			                                    <div class="dropdown-menu">
			                                    	<a href="<spring:url value="/editar/agenda?idUsuario=${cita.idUsuario}"></spring:url>" class="dropdown-item">
			                                    		<i class="fa fa-edit"></i>
			                                        	${editarEtiqueta}
			                                    	</a>
			                                    		<a href="" data-target="#modalCancelarCita_${cita.idUsuario}_${indiceActual}" data-toggle="modal" class="dropdown-item">
			                                    		<i class="fa fa-eraser"></i>
			                                        	${cancelarEtiqueta}
			                                    	</a>
			                                    	<a href="<spring:url value="/citaInformacion?idUsuario=${cita.idUsuario}"></spring:url>" class="dropdown-item">
			                                    		<i class="fa fa-file-text-o"></i>
			                                        	${citaInformacionEtiqueta}
			                                    	</a>
			          							</div><!-- .dropdown-menu -->
			                                </div><!-- .btn-group -->
										</td>
									 </tr>
								</c:forEach>
							</tbody><!-- .tbody -->
						</table><!-- .table-responsive -->
						<%@include file="/WEB-INF/views/pagination/paginacion.jsp"%>	
					</div><!-- .table-responsive -->
				</div><!-- .content-inner -->
			</div><!-- .page-container -->
		</div><!-- .pagination -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	