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
										<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/template/mensaje_exito.jsp"%></c:when>
										<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/template/mensaje_error.jsp"%></c:when>
									</c:choose>
									<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
									 <!-- **************************************************Id Cita**************************************************************** -->
									<form:input type="hidden" class="form-control" path="cita.idCita" id="idCita" name="idCita"></form:input>
									<!-- **************************************************Configuracion Fecha y Hora Cita************************************************************ -->
									<div class="card">
										<div class="card-header" role ="tab" id="headingTwo">
											<a data-toggle="collapse" data-parent="#accordion" 
												href="#collapseConfiguracion" aria-expanded="true" aria-controls="collapse">
												 <h5 class="mb-0">${horaEtiqueta}</h5>
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
														<div class="col-md-2">
															<div class="form-group">
																<form:label path="cita.hora.idHora">${horaEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="cita.hora.idHora" id="horas" class="form-control">
																		<form:option  value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options itemValue="idHora" itemLabel="hora"></form:options>
																	</form:select>
																</div><!-- .form-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-2 -->
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
														 <!-- **************************************************Id Paciente**************************************************************** -->
														<form:input type="hidden" cssClass="form-control" path="paciente.idUsuario" id="idPaciente" name="idPaciente"></form:input>
														 <!-- **************************************************Datos  Documento Paciente**************************************************************** -->
														<div class="col-md-4">
															 <div class="form-group">
							 									<form:label path="paciente.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="paciente.documento.tipoDocumento.idTipoDocumento" id="pacienteidTipoDocumento" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="paciente.documento.documento">${documentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:input type="text" cssClass="form-control" path="paciente.documento.documento" id="pacienteDocumento" name="documento" placeholder="${documentoMarcador}" required="required"></form:input>
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
																	<form:input type="text" cssClass="form-control" path="paciente.fechaNacimiento" id="fechaNacimiento" name="fechaNacimiento" placeholder="${fechaNacimientoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
													    <!-- ***********************************************Edad Paciente************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="paciente.edad">${edadEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="text" class="form-control" path="paciente.edad" id="edad" name="edad" placeholder="${edadMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														 <!-- **************************************************Datos  Genero Paciente**************************************************************** -->
														<div class="col-md-4">
															 <div class="form-group">
							 									<form:label path="paciente.genero.idGenero">${generoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="paciente.genero.idGenero" id="pacienteidGenero" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${generos}" itemValue="idGenero" itemLabel="genero"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
							   							</div><!-- .col-md-4 -->
							   							 <!-- **************************************************Datos  Escolaridad Paciente**************************************************************** -->
														<div class="col-md-4">
															 <div class="form-group">
							 									<form:label path="paciente.escolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="paciente.escolaridad.idEscolaridad" id="pacienteidEscolaridad" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
							   							</div><!-- .col-md-4 -->
							   							 <!-- **************************************************Datos  Tutela Paciente**************************************************************** -->
														<div class="col-md-4">
															 <div class="form-group">
							 									<form:label path="paciente.tutela">${tutelaEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="paciente.tutela" id="pacienteTutela" class="form-control">
																		<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																		<form:option value="N" label="${seleccionEtiqueta}"></form:option>
																		<form:option value="S">${tutelaSi}</form:option>
																		<form:option value="N">${tutelaNo}</form:option>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
							   							</div><!-- .col-md-4 -->
							   							<!-- **************************************************Datos  Eps Paciente**************************************************************** -->
														<div class="col-md-4">
															 <div class="form-group">
							 									<form:label path="paciente.eps.idEps">${epsEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="paciente.eps.idEps" id="pacienteidEps" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${eps}" itemValue="idEps" itemLabel="razonSocial"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
							   							</div><!-- .col-md-4 -->
							   							<!-- **************************************************Datos  Diagnosticos Paciente**************************************************************** -->
							   							<div class="col-md-4">
							   								<div class="form-group">
							   									<form:label path="diagnosticos">${diagnosticosEtiqueta}</form:label>
							   									<div class="input-group">
							   										<form:select path="paciente.diagnosticos" cssClass="form-control" items="${diagnosticos}" id="pacineteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
							   									</div><!-- .input-group -->
							   								</div><!-- .form-group -->
							   							</div><!-- .col-md-4 -->
							   							<div class="col-md-4">
							   								<div class="form-group">
							   									<form:label path="paciente.diagnosticos">${diagnosticosPacienteEtiqueta}</form:label>
							   									<div class="input-group">
							   										<form:select path="diagnosticos" cssClass="form-control" id="agendaDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
							   									</div><!-- .input-group -->
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
												<h5 class="mb-0"><spring:message code="agenda.jsp.acudiente.etiqueta"></spring:message></h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapseAcudiente" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
											<div class="card-block">
	                                    		<div class="card-body">
	                                    			<div class="row">
	                                    			   <!-- **************************************************Id Acuediente**************************************************************** -->
	                                    				<form:input type="hidden" cssClass="form-control" path="acudiente.idUsuario" id="idAcudiente" name="idAcudiente"></form:input>
	                                    			   <!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
	                                    				<div class="col-md-4">
	                                    					<div class="form-group">
							 									<form:label path="acudiente.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="acudiente.documento.tipoDocumento.idTipoDocumento" id="acudienteidTipoDocumento" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
	                                    				</div><!-- col-md-4 -->
	                                    				<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.documento.documento">${documentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:input type="text" cssClass="form-control" path="acudiente.documento.documento" id="acudienteDocumento" name="acudienteDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														 <!-- **************************************************Datos  Parentesco Acudiente**************************************************************** -->
	                                    				<div class="col-md-4">
	                                    					<div class="form-group">
							 									<form:label path="acudiente.parentesco.idParentesco">${parentescoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="acudiente.parentesco.idParentesco" id="idParentesco" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${parentescos}" itemValue="idParentesco" itemLabel="parentesco"></form:options>
																	</form:select>
																</div><!-- .input-group -->
							   								</div><!-- .form-group -->
	                                    				</div><!-- col-md-4 -->
	                                    				<!-- ***********************************************Nombres y Apellidos Acudiente************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.nombres">${nombresEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.nombres" id="acudienteNombres" name="acudienteNombres" placeholder="${nombresEtiqueta}" required="required"></form:input>
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
														<!-- ***********************************************Datos Direccion************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.direccion">${direccionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.direccion" id="direccion" name="direccion" placeholder="${direccionMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Telefonos************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.telefonoFijo" id="telefonoFijo" name="telefonoFijo" placeholder="${telefonoFijoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.telefonoCelular" id="telefonoCelular" name="telefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Correo Electronico************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="acudiente.email">${emailEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="acudiente.email" id="email" name="email" placeholder="${emailMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- *************************************************Observaciones************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="cita.observacion">${observacionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="cita.observacion" id="observacion" name="observacion" placeholder="${observacionMarcador}" required="required"></form:textarea>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
	                                   				</div><!-- .row -->
	                                    		</div><!-- .card-body -->
	                                    	</div><!-- .card-block -->            
										</div><!-- .collapse-show -->
									</div><!-- .card -->
									<div class="col-md-12">
										<input id="btnLogin" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}">
									</div><!-- .col-md-12 -->
								</form:form><!-- .form:form-->
							</div><!-- .row -->
						</div><!-- .container-fluid -->
					</div><!-- .content-inner -->
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>		   