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
						    		<th>${documentoPaginaEtiqueta}</th>
	                            	<th>${nombresPaginaEtiqueta}</th>
	                            	<th>${apellidoPaginaEtiqueta}</th>
	                            	<th>${celularPaginaEtiqueta}</th>
	                            	<th>${accionesEtiqueta}</th>
								</tr>
							</thead><!-- .thead -->
							<tbody>
								<c:forEach items="${usuarios}" var ="usuario">
									<%@include file="/WEB-INF/views/modals/modal_activarUsuario.jsp"%> 
									<%@include file="/WEB-INF/views/modals/modal_desactivarUsuario.jsp"%> 
							    	<tr>
							    		<c:choose>
							    			<c:when test="${usuario.estado_idestado.idEstado == idEstadoActivo}">
							    				<th>${usuario.documento_iddocumento.documento}</th>
												<th>${usuario.nombres}</th>
												<th>${usuario.primerApellido}</th>
												<th>${usuario.telefonoCelular}</th>
							    			</c:when>
							    			<c:when test="${usuario.estado_idestado.idEstado == idEstadoInactivo}">
							    				<th><font color="gray">${usuario.documento_iddocumento.documento}</font></th>
												<th><font color="gray">${usuario.nombres}</font></th>
												<th><font color="gray">${usuario.primerApellido}</font></th>
												<th><font color="gray">${usuario.telefonoCelular}</font></th>
							    			</c:when>
							    		</c:choose>
										<td>
											<div class="btn-group btn-actions">
			                                	<button type="button" class="btn dropdown-toggle" data-toggle="dropdown">${accionEtiqueta}</button>
			                                    <div class="dropdown-menu">
			                                    	<a href="<spring:url value="/editar/usuario?idUsuario=${usuario.idUsuario}&indiceActual=${indiceActual}"></spring:url>" class="dropdown-item">
			                                    		<i class="fa fa-edit"></i>
			                                        	${editarEtiqueta}
			                                    	</a>
			                                    		<a href="" data-target="#modalActivarUsuario_${usuario.idUsuario}_${idEstadoActivo}_${indiceActual}" data-toggle="modal" class="dropdown-item">
			                                    		<i class="fa fa-user-plus"></i>
			                                        	${activarEtiqueta}
			                                    	</a>
			                                    	</a>
			                                    		<a href="" data-target="#modalDesactivarUsuario_${usuario.idUsuario}_${idEstadoInactivo}_${indiceActual}" data-toggle="modal" class="dropdown-item">
			                                    		<i class="fa fa-user-times"></i>
			                                        	${desActivarEtiqueta}
			                                    	</a>
			          							</div><!-- .dropdown-menu -->
			                                </div><!-- .btn-group -->
										</td>
									 </tr>
								</c:forEach>
							</tbody><!-- .tbody -->
						</table><!-- .table-responsive -->
						<%@include file="/WEB-INF/views/pagination/paginacionUsuario.jsp"%>	
					</div><!-- .table-responsive -->
				</div><!-- .content-inner -->
			</div><!-- .page-container -->
		</div><!-- .pagination -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	