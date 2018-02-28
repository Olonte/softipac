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
								<form:form id="agendaPaciente" name="agendaPaciente" modelAttribute="nuevaAgenda" method="post">
									<c:choose>
										<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/messages/mensaje_exito.jsp"%></c:when>
										<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/messages/mensaje_error.jsp"%></c:when>
									</c:choose>
									<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
									<!-- **************************************************Id - Tipo - Estado Cita**************************************************************** -->
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.idcita" id="citaIdCita" name="citaIdCita"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.tipocita_idtipocita.idTipoCita" id="citaIdTipoCita" name="citaIdTipoCita"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.estado_idestado.idEstado" id="citaIdEstado" name="citaIdEstado"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.hora.horaId.tipohora_idtipohora.idTipoHora" id="citaidTipoHora" name="citaidTipoHora"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.usuario_idusuario.idUsuario" id="citaIdUsuario" name="citaIdUsuario"></form:input>
									<form:input type="hidden" cssClass="form-control" path="cita.citaId.usuario_idusuapl.idUsuario" id="citaIdUsuarioApl" name="citaIdUsuarioApl"></form:input>
									<form:input type="hidden" cssClass="form-control" path="citaAgenda" id="citaAgenda" name="citaAgenda" value="${citaAgenda}"></form:input>
									<form:input type="hidden" cssClass="form-control" path="javaScript" id="javaScript" name="javaScript"></form:input>
									<c:set var="indiceActual" value="${indiceActual}"></c:set>
									<!-- **************************************************Configuracion Fecha y Hora Cita************************************************************ -->
									<div class="card">
										<div class="card-header" role ="tab" id="headingTwo">
											<a data-toggle="collapse" data-parent="#accordion" 
												href="#collapseConfiguracion" aria-expanded="true" aria-controls="collapse">
												<h5 class="mb-0">${confHoraEtiqueta}</h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapseConfiguracion" class="collapase show" role ="tabpanel" aria-labelledby="headingOne">
											<div class="card-block">
												<div class="card-body">
													<div class="row">
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="cita.fechaCitaIni">${fechaCitaEtiqueta}</form:label>
																<div class="input-group">											  
																	<form:input  type="text" cssClass="form-control" path="cita.fechaCitaIni" id="fechaCitaIni" name="fechaCitaIni"  placeholder="${fechaMarcador}" required="required"></form:input>
																</div><!-- .input-group-->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="cita.hora.horaId.idhora">${horaEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="cita.hora.horaId.idhora" id="horas" cssClass="form-control">
																		<form:option  value="${seleccion}" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${horas}" itemValue="horaId.idhora" itemLabel="hora"></form:options>
																	</form:select>
																</div><!-- .input-group -->
																<div class="has-error">
																	<form:errors path="cita.hora.horaId.idhora" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
													</div><!-- .row -->
												</div><!-- .card-body -->
											</div><!-- .card-block -->
										</div><!-- collapseConfiguracion -->
									</div><!-- .card -->
									<!-- *******************************************************Datos Paciente**************************************************************************************** -->
									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<a data-toggle="collapse" data-parent="#accordion" href="#collapsePaciente" aria-expanded="true" aria-controls="collapseOne">
												<h5 class="mb-0">${pacienteEtiqueta}</h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapsePaciente" class="collapse show" rol="tabpanel" aria-labelledy="headingOne">
											<div class="card-block">
												<div class="card-body">
													<div class="row">
														<!-- **************************************************Id - Tipo - Estado Paciente**************************************************************** -->
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
																	<form:input type="number" min="${numMin}" cssClass="form-control" path="paciente.documento_iddocumento.documento" id="pacienteDocumento" name="pacienteDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
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
																	<form:input type="text" cssClass="form-control" path="paciente.fechaNacimiento" id="pacienteFechaNacimiento" name="pacienteFechaNacimiento" placeholder="${fechaNacimientoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Edad y Meses Paciente************************************************************************** -->
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
								   					<!-- **************************************************Datos  Diagnosticos Paciente**************************************************************** -->
								   					<div class="row">
								   						<div class="col-md-4">
								   							<div class="form-group">
								   								<form:label path="diagnosticos">${diagnosticosEtiqueta}</form:label>
								   									<div class="input-group">																		
								   										<form:select path="paciente.diagnosticos" cssClass="form-control" items="${diagnosticos}" id="agendaCitaInfoDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
								   									</div><!-- .input-group -->
								   							</div><!-- .form-group -->
								   						</div><!-- .col-md-4 -->
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
								   						<div class="col-md-4">
								   							<div class="form-group">
								   								<form:label path="paciente.diagnosticos">${diagnosticosPacienteEtiqueta}</form:label>
								   								<div class="input-group">
								   									<form:select path="paciente.diagnosticos" cssClass="form-control" items="${diagnosticosPaciente}" id="pacienteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
								   								</div><!-- .input-group -->
								   								<div class="has-error">
																	<form:errors path="paciente.diagnosticos" cssClass="text-danger"></form:errors>
																</div><!-- .has-error -->
								   							</div><!-- .form-group -->
								   						</div><!-- .col-md-4 -->
													</div><!-- .row -->
												</div><!-- .card-body -->
											</div><!-- .card-block -->
										</div><!-- .collapse show -->
									</div><!-- .card -->
									<!-- *******************************************************Datos Acudiente**************************************************************************************** -->
									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<a data-toggle="collapse" data-parent="#accordion" href="#collapsePaciente" aria-expanded="true" aria-controls="collapseOne">
												<h5 class="mb-0">${acudienteEtiqueta}</h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapseAcudiente" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
											<div class="card-block">
		                                    	<div class="card-body">
		                                    		<div class="row">
		                                    	    	<!-- **************************************************Id - Tipo - Estado Acuediente**************************************************************** -->
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
														<!-- ***********************************************Datos Direccion************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.direccion">${direccionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.direccion" id="acudienteDireccion" name="acudioenteDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Telefonos************************************************************************* -->
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
														<!-- ***********************************************Datos Correo Electronico************************************************************************* -->
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
														<!-- *************************************************Observaciones************************************************************************** -->
														<div class="col-md-12">
															<div class="form-group">
																<form:label path="cita.observacion">${observacionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.observacion" id="observacion" name="observacion" placeholder="${observacionMarcador}"></form:textarea>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-12 -->
		                                   			</div><!-- .row -->
		                                    	</div><!-- .card-body -->
		                                    </div><!-- .card-block -->            
										</div><!-- .collapse-show -->
									</div><!-- .card -->
									<br>
									<div class="col-md-12">
										<center>
											<input id="btnAgenda" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}" style="float:center;">
										</center>
									</div><!-- .col-md-12 -->
								</form:form><!-- .form:form-->
							</div><!-- .row -->
						</div><!-- .container-fluid -->
					</div><!-- .stat-boxes -->
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
 	<%@include file="/WEB-INF/views/template/footer.jsp"%>		   