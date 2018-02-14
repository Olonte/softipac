<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<div class="content-container">
				<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
				<div class="content-inner">
					<div class="stat-boxes">
						<div class="container-fluid">
							<div class ="row">
								<form:form id="nuevoUsuario" name="nuevoUsuario" modelAttribute="nuevoUsuario" method="post">
									<c:choose>
										<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/messages/mensaje_exito.jsp"%></c:when>
										<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/messages/mensaje_error.jsp"%></c:when>
									</c:choose>
									<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
									<div class="card ">
								    	<div class="card-header" role="tab" id="headingUsuario">
										 	<a data-toggle="collapse" data-parent="#accordion" href="#collapseUsuario" aria-expanded="true" aria-controls="collapseUsuario">
                                            	<h5 class="mb-0">${usuarioTituloEtiqueta}</h5>
                                        	</a>
										 </div>
									     <div id="collapseUsuario" class="collapse show" role="tabpanel" aria-labelledby="headingUsuario">
	                                        <div class="card-block">
	                                            <div class="card-body">
	                                                <div class="row">
	                                                	<form:input type="hidden" cssClass="form-control" path="usuario.idUsuario" id="usuarioIdUsuario" name="usuarioIdUsuario"></form:input>
														<form:input type="hidden" cssClass="form-control" path="usuario.estado_idestado.idEstado" id="usuarioIdEstado" name="usuarioIdEstado"></form:input>
														<form:input type="hidden" cssClass="form-control" path="javaScript" id="usuariojavaScript" name="usuariojavaScript"></form:input>
														<c:set var="indiceActual" value="${indiceActual}"></c:set>
	                                                    <!-- **************************************************Datos  Documento Usuario**************************************************************** -->
	                                                    <div class="col-md-4">
	                                                        <div class="form-group">
		                                                        <form:label path="usuario.documento_iddocumento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="usuario.documento_iddocumento.tipoDocumento.idTipoDocumento" id="usarioIdTipoDocumento" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposDocumentoUsuario}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="usuario.documento_iddocumento.tipoDocumento.idTipoDocumento" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->	                                                        
	                                                    	</div><!-- .form-group -->
	                                                	</div><!-- .col-md-4 -->
	                                                	<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.documento_iddocumento.documento">${documentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:input type="number" min="${numMin}" cssClass="form-control" path="usuario.documento_iddocumento.documento" id="usuarioDocumento" name="usuarioDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Nombres y Apellidos Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.nombres">${nombresEtiqueta}</form:label>
																<div class="input-group"> 
																	<form:input type="text" cssClass="form-control" path="usuario.nombres" id="usuarioNombres" name="usuarioNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.primerApellido">${primerApellidoEtiqueta}</form:label>
																<div class="input-group">   
																	<form:input type="text" cssClass="form-control" path="usuario.primerApellido" id="usuarioPrimerApellido" name="usuarioPrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.segundoApellido" id="usuarioSegundoApellido" name="usuarioSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
													   <!-- ***********************************************NombreUsuario y Password Usuario****************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.nombreUsuario">${usuarioEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.nombreUsuario" id="nombreUsuario" name="nombreUsuario" placeholder="${usuarioMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.password">${claveEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="password" cssClass="form-control" path="usuario.password" id="password" name="password" placeholder="${claveMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Fecha de Nacimiento Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.fechaNacimiento">${fechaNacimientoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.fechaNacimiento" id="usuarioFechaNacimiento" name="usuarioFechaNacimiento" placeholder="${fechaNacimientoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Edad Usuario************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.edad">${edadEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="number" min="${numMin}" cssClass="form-control" path="usuario.edad" id="usuarioEdad" name="usuarioEdad" placeholder="${edadMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Lugar de Nacimiento Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.lugarNacimiento">${lugarNacimientoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.lugarNacimiento" id="usuarioLugarNacimiento" name="usuarioLugarNacimiento" placeholder="${lugarNacimientoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- **************************************************Datos  Genero Usuario**************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
									 							<form:label path="usuario.genero_idgenero.idGenero">${generoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="usuario.genero_idgenero.idGenero" id="usuarioIdGenero" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${generos}" itemValue="idGenero" itemLabel="genero"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="usuario.genero_idgenero.idGenero" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   					<!-- **************************************************Datos  Escolaridad Usuario**************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
									 							<form:label path="usuario.escolaridad_idescolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="usuario.escolaridad_idescolaridad.idEscolaridad" id="usuarioIdEscolaridad" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${escolaridadesUsuario}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="usuario.escolaridad_idescolaridad.idEscolaridad" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   					<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.ocupacion">${ocupacionEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="text" cssClass="form-control" path="usuario.ocupacion" id="usuarioOcupacion" name="usuarioOcupacion" placeholder="${ocupacionMarcador}" required="requiered"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Direccion Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.direccion">${direccionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.direccion" id="usuarioDireccion" name="usuarioDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Telefonos Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.telefonoFijo" id="usuarioTelefonoFijo" name="usuarioTelefonoFijo" placeholder="${telefonoFijoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.telefonoCelular" id="usuarioTelefonoCelular" name="usuarioTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Correo Electronico Usuario************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="usuario.email">${emailEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="usuario.email" id="usuarioEmail" name="usuarioEmail" placeholder="${emailMarcador}"></form:input>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="usuario.email" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ****************************************************** Datos TipoUsario ************************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
									 							<form:label path="usuario.tipousuario_idtipousuario.idTipoUsuario">${tipoUsarioEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="usuario.tipousuario_idtipousuario.idTipoUsuario" id="usuarioIdTipoUsuario" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposUsuario}" itemValue="idTipoUsuario" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="usuario.tipousuario_idtipousuario.idTipoUsuario" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   				</div><!-- .row -->
									   				<!-- **************************************************Roles Usuario**************************************************************** -->
									   				<div class="row">
									   					<div class="col-md-4">
									   						<div class="form-group">
									   							<form:label path="roles">${rolEtiqueta}</form:label>
									   							<div class="input-group">																		
									   								<form:select path="roles" cssClass="form-control" items="${roles}" id="roles" multiple="true" itemValue="idRol" itemLabel="rol"></form:select>
									   							</div><!-- .input-group -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   					<div class="form-group col-md-2">
											   					<br>
											   					<br>
											   					<br>
											   					<center>
											   							<input id="btnAgregarRol" type="button" class="btn btn-blue" value="${botonAdicionarEtiqueta}">
											   					</center>
											   					<br>
											   					<center>
											   						<input id="btnEliminarRol" type="button" class="btn btn-blue" value="${botonEliminarEtiqueta}">
											   					</center>
											   			</div><!-- .col-md-2 -->
									   					<div class="col-md-4">
									   						<div class="form-group">
									   							<form:label path="usuario.roles">${rolesUsuarioEtiqueta}</form:label>
									   							<div class="input-group">
									   								<form:select path="usuario.roles" cssClass="form-control" items="${rolesUsuario}" id="rolesUsuario" multiple="true" itemValue="idRol" itemLabel="rol"></form:select>
									   							</div><!-- .input-group -->
									   							<div class="has-error">
																	<form:errors path="usuario.roles" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
		                                            </div><!-- .row -->
	                                    		</div><!-- .card-body -->
	                                		</div><!-- .card-block -->
										</div><!-- .collap show -->
									</div><!-- .card -->
									<br>
									<div class="col-md-12">
										<center>
											<input id="btnUsuario" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}" style="float:center;">
										</center>
									</div><!-- .col-md-12 -->
								</form:form><!-- .form:form-->
							</div><!-- .row -->
						</div><!-- .container-fluid -->
					</div><!-- stat-boxes -->
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
 	<%@include file="/WEB-INF/views/template/footer.jsp"%>		   