<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<div class="content-container">
				<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
				<div class="stat-boxes">
					<div class="container-fluid">
						<div class="row">
							<form:form id="citaInformacion" name="citaInformacion" modelAttribute="citaInformacion" method="post">
								<c:choose>
									<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/messages/mensaje_exito.jsp"%></c:when>
									<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/messages/mensaje_error.jsp"%></c:when>
								</c:choose>
								<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
								<!-- **************************************************Id - Tipo - Estado  Cita**************************************************************** -->
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.idcita" id="citaIdCita" name="citaIdCita"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.tipocita_idtipocita.idTipoCita" id="citaIdTipoCita" name="citaIdTipoCita"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.estado_idestado.idEstado" id="citaIdEstado" name="citaIdEstado"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.usuario_idusuapl.idUsuario" id="citaIdUsuarioApl" name="citaIdUsuarioApl"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.usuario_idusuario.idUsuario" id="citaIdUsuario" name="citaIdUsuario"></form:input>
									<form:input type="hidden" cssClass="form-control" path="citaAgenda" id="citaAgenda" name="citaAgenda" value="${citaInformacion}"></form:input>
									<form:input type="hidden" cssClass="form-control" path="javaScript" id="javaScript" name="javaScript"></form:input>
									<c:set var="indiceActual" value="${indiceActual}"></c:set>
								<div class="card ">
                                    <div class="card-header" role="tab" id="headingInformacion">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseInformacion" aria-expanded="true" aria-controls="collapseInformacion">
                                            <h5 class="mb-0">${citaInfoTituloEtiqueta}</h5>
                                        </a>
                                    </div><!-- .card-header -->
                                    <div id="collapseInformacion" class="collapse show" role="tabpanel" aria-labelledby="headingInformacion">
                                        <div class="card-block">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                        	<form:label path="cita.fechaCitaIni">${fechaCitaEtiqueta}</form:label><br>
                                                            <form:input  type="text" cssClass="form-control" path="cita.fechaCitaIni" readonly="true" id="fechaCitaIni" name="fechaCitaIni"></form:input> 
                                                        </div><!-- .form-group -->
                                                    </div><!-- .col-md-4 -->
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                        	<form:label path="usuarioAplica">${aplicaEtiqueta}</form:label>
                                                            <form:input  type="text" cssClass="form-control" path="usuarioAplica" readonly="true" id="usuarioAplica" name="usuarioAplica"></form:input>
                                                        </div><!-- .form-group -->
                                                    </div><!-- .col-md-4 -->
                                                </div><!-- .row -->
                                            </div><!-- .card-body -->
                                        </div><!-- .card-block -->
                                    </div><!-- .collapse show -->
                                </div><!-- .card -->
                                <!-- *******************************************************Datos Paciente**************************************************************************************** -->
								<div class="card">
									<div class="card-header" role="tab" id="headingPaciente">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseDatosPaciente" aria-expanded="true" aria-controls="collapseDatosPaciente">
											<h5 class="mb-0">${pacienteEtiqueta}</h5>
										</a>
									</div><!-- .card-header -->
									<div id="collapseDatosPaciente" class="collapse show" role="tabpanel" aria-labelledy="headingPaciente">
										<div class="card-block">
											<div class="card-body">
												<div class="row">
													<!-- **************************************************Id Tipo - Estado Paciente**************************************************************** -->
													<form:input type="hidden" cssClass="form-control" path="paciente.idUsuario" id="pacienteIdUsuario" name="pacienteIdUsuario"></form:input>
													<form:input type="hidden" cssClass="form-control" path="paciente.tipousuario_idtipousuario.idTipoUsuario" id="pacienteIdTipoUsuario" name="pacienteIdTipoUsuario"></form:input>
													<form:input type="hidden" cssClass="form-control" path="paciente.estado_idestado.idEstado" id="pacienteIdEstado" name="pacienteIdEstado"></form:input>
													<!-- **************************************************Datos  Documento Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="paciente.documento_iddocumento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="paciente.documento_iddocumento.tipoDocumento.idTipoDocumento" id="pacienteIdTipoDocumento" cssClass="form-control">
																	<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																</form:select>
															</div><!-- .input-group -->
															<div class="has-error">
																<form:errors path="paciente.documento_iddocumento.tipoDocumento.idTipoDocumento" cssClass="text-danger"></form:errors>
															</div><!-- .has-error -->
								   						</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.documento_iddocumento.documento">${documentoEtiqueta}</form:label>
															<div class="input-group">
																<form:input type="number" min="${numMin}" cssClass="form-control" path="paciente.documento_iddocumento.documento" id="pacienteDocumento" name="documento" placeholder="${documentoMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Nombres y Apellidos Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.nombres">${nombresEtiqueta}</form:label>
															<div class="input-group"> 
																<form:input type="text" cssClass="form-control" path="paciente.nombres" id="pacienteNombres" name="pacienteNombres" placeholder="${nombresMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.primerApellido">${primerApellidoEtiqueta}</form:label>
															<div class="input-group">   
																<form:input type="text" cssClass="form-control" path="paciente.primerApellido" id="pacientePrimerApellido" name="pacientePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.segundoApellido">${segundoApellidoEtiqueta}</form:label>
															<div class="input-group">    
																<form:input type="text" cssClass="form-control" path="paciente.segundoApellido" id="pacienteSegundoApellido" name="pacienteSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Fecha Nacimiento Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.fechaNacimiento">${fechaNacimientoEtiqueta}</form:label>
															<div class="input-group">    
																<form:input type="text" cssClass="form-control" path="paciente.fechaNacimiento" id="fechaNacimiento" name="fechaNacimiento" placeholder="${fechaNacimientoMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Edad Paciente************************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.edad">${edadEtiqueta}</form:label>
															<div class="input-group">  
																<form:input type="number" min="${numMin}" cssClass="form-control" path="paciente.edad" id="pacienteEdad" name="pacienteEdad" placeholder="${edadMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.meses">${mesesEtiqueta}</form:label>
															<div class="input-group">  
																<form:input type="number" min="${numMin}" cssClass="form-control" path="paciente.meses" id="pacienteMeses" name="pacienteMeses" placeholder="${mesesMarcador}"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- **************************************************Datos  Genero Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="paciente.genero_idgenero.idGenero">${generoEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="paciente.genero_idgenero.idGenero" id="pacienteIdGenero" cssClass="form-control">
																	<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${generos}" itemValue="idGenero" itemLabel="genero"></form:options>
																</form:select>
															</div><!-- .input-group -->
															<div class="has-error">
																<form:errors path="paciente.genero_idgenero.idGenero" cssClass="text-danger"></form:errors>
															</div><!-- .has-error -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   					<!-- **************************************************Datos  Escolaridad Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="paciente.escolaridad_idescolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="paciente.escolaridad_idescolaridad.idEscolaridad" id="pacienteIdEscolaridad" cssClass="form-control">
																	<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																</form:select>
															</div><!-- .input-group -->
															<div class="has-error">
																<form:errors path="paciente.escolaridad_idescolaridad.idEscolaridad" cssClass="text-danger"></form:errors>
															</div><!-- .has-error -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   					<!-- **************************************************Datos  Tutela Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="paciente.tutela">${tutelaEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="paciente.tutela" id="pacienteTutela" cssClass="form-control">
																	<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																	<form:option value="S">${tutelaSi}</form:option>
																	<form:option value="N">${tutelaNo}</form:option>
																</form:select>
															</div><!-- .input-group -->
															<div class="has-error">
																<form:errors path="paciente.tutela" cssClass="text-danger"></form:errors>
															</div><!-- .has-error -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   					<!-- **************************************************Datos  Eps Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="paciente.eps_ideps.idEps">${epsEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="paciente.eps_ideps.idEps" id="pacienteIdEps" cssClass="form-control">
																	<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${eps}" itemValue="idEps" itemLabel="razonSocial"></form:options>
																</form:select>
															</div><!-- .input-group -->
															<div class="has-error">
																<form:errors path="paciente.eps_ideps.idEps" cssClass="text-danger"></form:errors>
															</div><!-- .has-error -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   				</div><!-- .row -->
											</div><!-- .card-body -->
										</div><!-- .card-block -->
									</div><!-- .collapse show -->
								</div><!-- .card -->
						        <!-- *******************************************************Datos Padres y Acudiente**************************************************************************************** -->
								<div id="accordion" role="tablist" aria-multiselectable="true">
									<!-- *******************************************************Datos Madre**************************************************************************************** -->
									<div class="card">
										<div class="card-header" role="tab" id="headingDatosMadre">
											<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseDatosMadre" aria-expanded="false" aria-controls="collapseDatosMadre">
												<h5 class="mb-0">${madreEtiqueta}</h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapseDatosMadre" class="collapse" role="tabpanel" aria-labelledby="headingDatosMadre">
											<div class="card-block">
		                                    	<div class="card-body">
		                                    		<div class="row">
		                                    	    	<!-- **************************************************Id - Tipo - Estado Madre**************************************************************** -->
		                                    			<form:input type="hidden" cssClass="form-control" path="madre.idUsuario" id="madreIdUsuario" name="madreIdUsuario"></form:input>
		                                    			<form:input type="hidden" cssClass="form-control" path="madre.tipousuario_idtipousuario.idTipoUsuario" id="madreIdTipoUsuario" name="madreIdTipoUsuario"></form:input>
		                                    			<form:input type="hidden" cssClass="form-control" path="madre.estado_idestado.idEstado" id="madreIdEstado" name="madreIdEstado"></form:input>
		                                    			<form:input type="hidden" cssClass="form-control" path="madre.parentesco_idparentesco.idParentesco" id="madreIdParentesco" name="madreIdParentesco"></form:input>
		                                    			<!-- **************************************************Datos  Documento Madre**************************************************************** -->
		                                    			<div class="col-md-4">
		                                    				<div class="form-group">
								 								<form:label path="madre.documento_iddocumento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="madre.documento_iddocumento.tipoDocumento.idTipoDocumento" id="madreIdTipoDocumento" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposDocumentoUsuario}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="madre.documento_iddocumento.tipoDocumento.idTipoDocumento" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
								   							</div><!-- .form-group -->
		                                    			</div><!-- col-md-4 -->
		                                    			<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.documento_iddocumento.documento">${documentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:input type="number" cssClass="form-control" path="madre.documento_iddocumento.documento" id="madreDocumento" name="madreDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
			                                    		<!-- ***********************************************Nombres y Apellidos Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.nombres">${nombresEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.nombres" id="madreNombres" name="madreNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.primerApellido">${primerApellidoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.primerApellido" id="madrePrimerApellido" name="madrePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.segundoApellido" id="madreSegundoApellido" name="madreSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Edad Madre************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.edad">${edadEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="number" min="${numMin}" cssClass="form-control" path="madre.edad" id="madreEdad" name="madreEdad" placeholder="${edadMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- **************************************************Datos  Escolaridad Madre**************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
									 							<form:label path="madre.escolaridad_idescolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="madre.escolaridad_idescolaridad.idEscolaridad" id="madreIdEscolaridad" cssClass="form-control">
																		<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${escolaridadesUsuario}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="madre.escolaridad_idescolaridad.idEscolaridad" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   					<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.ocupacion">${ocupacionEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="text" cssClass="form-control" path="madre.ocupacion" id="madreOcupacion" name="madreOcupacion" placeholder="${ocupacionMarcador}" required="requiered"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Direccion Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.direccion">${direccionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.direccion" id="madreDireccion" name="madreDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Telefonos Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.telefonoFijo" id="madreTelefonoFijo" name="madreTelefonoFijo" placeholder="${telefonoFijoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.telefonoCelular" id="madreTelefonoCelular" name="madreTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Correo Electronico Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="madre.email">${emailEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="madre.email" id="madreEmail" name="madreEmail" placeholder="${emailMarcador}"></form:input>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="madre.email" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
			                                   		</div><!-- .row -->
			                                   	</div><!-- .card-body -->
			                                   </div><!-- .card-block -->            
											</div><!-- .collapse-show -->
										</div><!-- .card -->
										<!-- *******************************************************Datos Padre**************************************************************************************** -->
										<div class="card">
											<div class="card-header" role="tab" id="headingDatosPadre">
												<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseDatosPadre" aria-expanded="false" aria-controls="collapseDatosPadre">
													<h5 class="mb-0">${padreEtiqueta}</h5>
												</a>
											</div><!-- .card-header -->
											<div id="collapseDatosPadre" class="collapse show" role="tabpanel" aria-labelledby="headingDatosPadre">
												<div class="card-block">
		                                    		<div class="card-body">
		                                    			<div class="row">
		                                    	    		<!-- **************************************************Id - Tipo - Estado Padre**************************************************************** -->
		                                    				<form:input type="hidden" cssClass="form-control" path="padre.idUsuario" id="padreIdUsuario" name="padreIdUsuario"></form:input>
		                                    				<form:input type="hidden" cssClass="form-control" path="padre.tipousuario_idtipousuario.idTipoUsuario" id="padreIdTipoUsuario" name="padreIdTipoUsuario"></form:input>
		                                    				<form:input type="hidden" cssClass="form-control" path="padre.estado_idestado.idEstado" id="padreIdEstado" name="padreIdEstado"></form:input>
		                                    				<form:input type="hidden" cssClass="form-control" path="padre.parentesco_idparentesco.idParentesco" id="padreIdParentesco" name="padreIdParentesco"></form:input>
		                                    				<!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
		                                    				<div class="col-md-4">
		                                    					<div class="form-group">
								 									<form:label path="padre.documento_iddocumento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="padre.documento_iddocumento.tipoDocumento.idTipoDocumento" id="padreIdTipoDocumento" cssClass="form-control">
																			<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${tiposDocumentoUsuario}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="padre.documento_iddocumento.tipoDocumento.idTipoDocumento" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
								   								</div><!-- .form-group -->
		                                    				</div><!-- col-md-4 -->
		                                    				<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.documento_iddocumento.documento">${documentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:input type="number" min="${numMin}" cssClass="form-control" path="padre.documento_iddocumento.documento" id="padreDocumento" name="padreDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
			                                    			<!-- ***********************************************Nombres y Apellidos Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.nombres">${nombresEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.nombres" id="padreNombres" name="padreNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.primerApellido">${primerApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.primerApellido" id="padrePrimerApellido" name="padrePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.segundoApellido" id="padreSegundoApellido" name="padreSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Edad Padre************************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.edad">${edadEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="number" min="${numMin}" cssClass="form-control" path="padre.edad" id="padreEdad" name="padreEdad" placeholder="${edadMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Escolaridad Padre**************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
									 								<form:label path="padre.escolaridad_idescolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="padre.escolaridad_idescolaridad.idEscolaridad" id="padreIdEscolaridad" cssClass="form-control">
																			<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${escolaridadesUsuario}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="padre.escolaridad_idescolaridad.idEscolaridad" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
									   							</div><!-- .form-group -->
									   						</div><!-- .col-md-4 -->
									   						<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.ocupacion">${ocupacionEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" cssClass="form-control" path="padre.ocupacion" id="padreOcupacion" name="padreOcupacion" placeholder="${ocupacionMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Direccion Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.direccion">${direccionEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.direccion" id="padreDireccion" name="padreDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Telefonos Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.telefonoFijo" id="padreTelefonoFijo" name="padreTelefonoFijo" placeholder="${telefonoFijoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.telefonoCelular" id="padreTelefonoCelular" name="padreTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Correo Electronico Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="padre.email">${emailEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="padre.email" id="padreEmail" name="padreEmail" placeholder="${emailMarcador}"></form:input>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="padre.email" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
			                                   			</div><!-- .row -->
			                                    	</div><!-- .card-body -->
			                                    </div><!-- .card-block -->            
											</div><!-- .collapse-show -->
										</div><!-- .card -->
										<!-- *******************************************************Datos Acudiente**************************************************************************************** -->
										<div class="card">
											<div class="card-header" role="tab" id="headingDatosAcudiente">
												<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseDatosAcudiente" aria-expanded="false" aria-controls="collapseDatosAcudiente">
													<h5 class="mb-0">${acudienteEtiqueta}</h5>
												</a>
											</div><!-- .card-header -->
											<div id="collapseDatosAcudiente" class="collapse show" role="tabpanel" aria-labelledby="headingDatosAcudiente">
												<div class="card-block">
		                                    		<div class="card-body">
		                                    			<div class="row">
		                                    	    		<!-- **************************************************Id Tipo Estado Acudiente**************************************************************** -->
		                                    				<form:input type="hidden" cssClass="form-control" path="acudiente.idUsuario" id="acudienteIdUsuario" name="acudienteIdUsuario"></form:input>
		                                    				<form:input type="hidden" cssClass="form-control" path="acudiente.tipousuario_idtipousuario.idTipoUsuario" id="acudienteIdTipoUsuario" name="acudienteIdTipoUsuario"></form:input>
		                                    				<form:input type="hidden" cssClass="form-control" path="acudiente.estado_idestado.idEstado" id="acudienteIdEstado" name="acudienteIdEstado"></form:input>
		                                    				<!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
		                                    				<div class="col-md-4">
		                                    					<div class="form-group">
								 									<form:label path="acudiente.documento_iddocumento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="acudiente.documento_iddocumento.tipoDocumento.idTipoDocumento" id="acudienteIdTipoDocumento" cssClass="form-control">
																			<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${tiposDocumentoUsuario}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="acudiente.documento_iddocumento.tipoDocumento.idTipoDocumento" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
								   								</div><!-- .form-group -->
		                                    				</div><!-- col-md-4 -->
		                                    				<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.documento_iddocumento.documento">${documentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:input type="number" min="${numMin}" cssClass="form-control" path="acudiente.documento_iddocumento.documento" id="acudienteDocumento" name="acudienteDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Parentesco Acudiente**************************************************************** -->
			                                    			<div class="col-md-4">
			                                    				<div class="form-group">
									 								<form:label path="acudiente.parentesco_idparentesco.idParentesco">${parentescoEtiqueta}</form:label>
																	<div class="input-group">									 
																		<form:select path="acudiente.parentesco_idparentesco.idParentesco" id="acudienteIdParentesco" cssClass="form-control">
																			<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${parentescos}" itemValue="idParentesco" itemLabel="parentesco"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="acudiente.parentesco_idparentesco.idParentesco" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
									   							</div><!-- .form-group -->
			                                    			</div><!-- col-md-4 -->
			                                    			<!-- ***********************************************Nombres y Apellidos Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.nombres">${nombresEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.nombres" id="acudienteNombres" name="acudienteNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.primerApellido">${primerApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.primerApellido" id="acudientePrimerApellido" name="acudientePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.segundoApellido" id="acudienteSegundoApellido" name="acudienteSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Edad Acudiente************************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.edad">${edadEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="number" min="${numMin}" cssClass="form-control" path="acudiente.edad" id="acudienteEdad" name="acudienteEdad" placeholder="${edadMarcador}" requiered="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Escolaridad Acudiente**************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
									 								<form:label path="acudiente.escolaridad_idescolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="acudiente.escolaridad_idescolaridad.idEscolaridad" id="acudienteIdEscolaridad" cssClass="form-control">
																			<form:option value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${escolaridadesUsuario}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="acudiente.escolaridad_idescolaridad.idEscolaridad" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
									   							</div><!-- .form-group -->
									   						</div><!-- .col-md-4 -->
									   						<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.ocupacion">${ocupacionEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" cssClass="form-control" path="acudiente.ocupacion" id="acudienteOcupacion" name="acudienteOcupacion" placeholder="${ocupacionMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Direccion Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.direccion">${direccionEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.direccion" id="acudienteDireccion" name="acudienteDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Telefonos Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.telefonoFijo" id="acudienteTelefonoFijo" name="acudienteTelefonoFijo" placeholder="${telefonoFijoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.telefonoCelular" id="acudienteTelefonoCelular" name="acudienteTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Correo Electronico Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="acudiente.email">${emailEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="acudiente.email" id="acudienteEmail" name="acudienteEmail" placeholder="${emailMarcador}"></form:input>
																	</div><!-- .input-group -->
																	<div class="has-error">
																		<form:errors path="acudiente.email" cssClass="text-danger"></form:errors>
																	</div><!-- .has-error -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
			                                   			</div><!-- .row -->
			                                    	</div><!-- .card-body -->
			                                    </div><!-- .card-block -->            
											</div><!-- .collapse-show -->
										</div><!-- .card -->
										<!-- ***********************************************Datos Motivo Consulta************************************************************************* -->
										<div class="card ">
		                                	<div class="card-header" role="tab" id="headingMotivo">
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseMotivo" aria-expanded="false" aria-controls="collapseMotivo">
		                                        	<h5 class="mb-0">${motivoConsultaEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseMotivo" class="collapse" role="tabpanel" aria-labelledby="headingMotivo">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.motivoConsulta" id="motivoConsulta" name="motivoConsulta" placeholder="${motivoConsultaMarcador}" required="required"></form:textarea>
																	</div><!-- .input-group -->
		                                                        </div><!-- .form-group -->
		                                                    </div><!-- .col-md-12 -->
		                                                </div><!-- .row -->
		                                            </div><!-- card-body -->
		                                        </div><!-- .card-block -->
		                                    </div><!-- .collapse -->
                                		</div><!-- .card -->
                                		<!-- ***********************************************Datos Diagnosticos************************************************************************* -->
                                		<div class="card ">
                                    		<div class="card-header" role="tab" id="headingDiagnostico">
                                        		<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseDiagnostico" aria-expanded="false" aria-controls="collapseDiagnostico">
                                            		<h5 class="mb-0">${diagnosticosPrevEtiqueta}</h5>
                                        		</a>
                                    		</div><!-- .card-header -->
                                    		<div id="collapseDiagnostico" class="collapse" role="tabpanel" aira-labelledby="headingDiagnostico">
                                    			<div class="card-block">
                                    				<div class="card-body">
		                                    			<div class="row">
															<div class="form-group col-md-4">
										   						<form:label path="diagnosticos">${diagnosticosEtiqueta}</form:label>
										   						<div class="input-group">																
										   							<form:select path="diagnosticos" cssClass="form-control" items="${diagnosticos}" id="agendaCitaInfoDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
										   						</div><!-- .input-group -->
										   					</div><!-- .form-group col-md-4 -->
										   					<div class="form-group col-md-2">
										   						<br>
										   						<br>
										   						<br>
										   						<center>
										   							 <input id="btnAgregarDiagnostico" type="button" class="btn btn-blue" value="${botonAdicionarEtiqueta}">
										   						</center>
										   						<br>
										   						<center>
										   							<input id="btnEliminarDiagnostico" type="button" class="btn btn-blue" value="${botonEliminarEtiqueta}">
										   						</center>
										   					</div><!-- .col-md-2 -->
										   					<div class="form-group col-md-4">
										   						<form:label path="paciente.diagnosticos">${diagnosticosPacienteEtiqueta}</form:label>
										   						<div class="input-group">
										   							<form:select path="paciente.diagnosticos" cssClass="form-control" items="${diagnosticosPaciente}" id="pacienteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
										   						</div><!-- .input-group -->
										   						<div class="has-error">
																	<form:errors path="paciente.diagnosticos" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
										   					</div><!-- .form-group col-md-4 -->
														</div><!-- .row -->
													</div><!-- .card-body -->
												</div><!-- .card-block -->
											</div><!-- .collapse -->
                                    	</div><!-- .card -->
                                    	<!-- ***********************************************Datos  Expectativas************************************************************************* -->
										<div class="card ">
		                                	<div class="card-header" role="tab" id="headingExpectativas">
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseExpectativas" aria-expanded="false" aria-controls="collapseExpectativas">
		                                        	<h5 class="mb-0">${expectativasEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseExpectativas" class="collapse" role="tabpanel" aria-labelledby="headingExpectativas">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.expectativas" id="expectativas" name="expectativas" placeholder="${expectativasMarcador}" required="required"></form:textarea>
																	</div><!-- .input-group -->
		                                                        </div><!-- .form-group -->
		                                                    </div><!-- .col-md-12 -->
		                                                </div><!-- .row -->
		                                            </div><!-- card-body -->
		                                        </div><!-- .card-block -->
		                                    </div><!-- .collapse -->
                                		</div><!-- .card -->
                                		<!-- ***********************************************Datos  Recomendaciones****************************************************************************************************************************** -->
										<div class="card ">
		                                	<div class="card-header" role="tab" id="headingRecomendaciones">
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseRecomendaciones" aria-expanded="false" aria-controls="collapseRecomendaciones">
		                                        	<h5 class="mb-0">${recomTenerCtaEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseRecomendaciones" class="collapse" role="tabpanel" aria-labelledby="headingRecomendaciones">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.recomTenerCta" id="recomTenerCta" name="recomTenerCta" placeholder="${recomTenerCtaMarcador}" required="required"></form:textarea>
																	</div><!-- .input-group -->
		                                                        </div><!-- .form-group -->
		                                                    </div><!-- .col-md-12 -->
		                                                </div><!-- .row -->
		                                            </div><!-- card-body -->
		                                        </div><!-- .card-block -->
		                                    </div><!-- .collapse -->
                                		</div><!-- .card -->
                                		<!-- ***********************************************Datos  Informacion****************************************************************************************************************************** -->
										<div class="card ">
		                                	<div class="card-header" role="tab" id="headingInfGeneral">
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseInfGeneral" aria-expanded="false" aria-controls="collapseInfGeneral">
		                                        	<h5 class="mb-0">${inFoGralEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseInfGeneral" class="collapse" role="tabpanel" aria-labelledby="collapseInfGeneral">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.inFoGral" id="inFoGral" name="inFoGral" placeholder="${inFoGralMarcador}"></form:textarea>
																	</div><!-- .input-group -->
		                                                        </div><!-- .form-group -->
		                                                    </div><!-- .col-md-12 -->
		                                                </div><!-- .row -->
		                                            </div><!-- card-body -->
		                                        </div><!-- .card-block -->
		                                    </div><!-- .collapse -->
                                		</div><!-- .card -->
                                		<br>
                   						<div class="col-md-12">
											<center>
												<input id="btnCitaInfo" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}" style="float:center;">
											</center>
										</div><!-- .col-md-12 -->
									</div><!-- .accordion -->
								</form:form><!-- .form -->
							</div><!-- .row -->
						</div><!-- .container-fluid -->
					</div><!-- .stat-boxes -->
				</div><!-- .content-container -->
			</div><!-- .page-container -->
	<%@include file="/WEB-INF/views/template/footer.jsp"%>	