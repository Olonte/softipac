<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
			<div class="content-inner">
				<div class="table-responsive">
					<table id="citasUsuarios" class="table table-hover">
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
						    	<tr>
									<th>${cita.fechaCitaIni}</th>
									<th>${cita.hora}</th>
									<th>${cita.nombres}</th>
									<th>${cita.primerApellido}</th>
									<th>${cita.telefonoFijo}</th>
									<th>${cita.telefonoCelular}</th>
									<td>
										<div class="btn-group btn-actions">
		                                	<button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
		                                    	${accionEtiqueta}
		                                    </button>
		                                    <div class="dropdown-menu">
		                                    	<a href="<spring:url value="/editar/agenda?idUsuario=${cita.idUsuario}"/>" class="dropdown-item">
		                                    		<i class="fa fa-edit"></i>
		                                        	${editarEtiqueta}
		                                    	</a>
		                                    	<a href="<spring:url value="/citaInformacion?idUsuario=${cita.idUsuario}"/>" class="dropdown-item">
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
				</div><!-- .table-responsive -->
			</div><!-- .content-inner -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	