<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
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
								 <!-- **************************************************Id Cita**************************************************************** -->
								<form:input type="hidden" class="form-control" path="cita.idCita" id="idCita" name="idCita"></form:input>
								<!-- **************************************************Configuracion Fecha y Hora Cita************************************************************ -->
								<div class="card">
									<div class="card-header" role ="tab" id="headingTwo">
										<a data-toggle="collapse" data-parent="#accordion" 
											href="#collapseConfiguracion" aria-expanded="true" aria-controls="collapse">
											 <h5 class="mb-0"><spring:message code="agenda.jsp.conf.hora.etiqueta"></spring:message></h5>
										</a>
									</div><!-- .card-header -->
									<div id="collapseConfiguracion" class="collapase show" role ="tabpanel" aria-labelledby="headingOne">
										<div class="card-block">
											<div class="card-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="cita.fechaCitaIni"><spring:message code="agenda.jsp.fecha.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:input type="text" class="form-control" path="cita.fechaCitaIni" id="fechaCitaIni" name="fechaCitaIni"  placeholder="<spring:message code="agenda.jsp.fecha.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group-->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-2">
														<div class="form-group">
															<form:label path="cita.hora.idHora"><spring:message code="agenda.jsp.hora.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="cita.hora.idHora" id="horas" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
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
											<h5 class="mb-0"><spring:message code="agenda.jsp.paciente.etiqueta"></spring:message></h5>
										</a>
									</div><!-- .card-header -->
									<div id="collapsePaciente" class="collapse show" rol="tabpanel" aria-labelledy="headingOne">
										<div class="card-block">
											<div class="card-body">
												<div class="row">
													 <!-- **************************************************Id Paciente**************************************************************** -->
													<form:input type="hidden" class="form-control" path="paciente.idUsuario" id="idPaciente" name="idPaciente"></form:input>
													 <!-- **************************************************Datos  Documento Paciente**************************************************************** -->
													<div class="col-md-4">
														 <div class="form-group">
						 									<form:label path="paciente.documento.tipodocumento.idTipoDocumento"><spring:message code="agenda.jsp.tipdocumento.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="paciente.documento.tipodocumento.idTipoDocumento" id="pacienteidTipoDocumento" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.documento.documento"><spring:message code="agenda.jsp.documento.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:input type="text" class="form-control" path="paciente.documento.documento" id="pacienteDocumento" name="documento" placeholder="<spring:message code="agenda.jsp.documento.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Nombres y Apellidos Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.nombres"><spring:message code="agenda.jsp.nombres.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="paciente.nombres" id="pacienteNombres" name="pacienteNombres" placeholder="<spring:message code="agenda.jsp.nombres.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.primerApellido"><spring:message code="agenda.jsp.primerapellido.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="paciente.primerApellido" id="pacientePrimerApellido" name="pacientePrimerApellido" placeholder="<spring:message code="agenda.jsp.primerapellido.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.sedundoApellido"><spring:message code="agenda.jsp.segundoapellido.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="paciente.segundoApellido" id="pacienteSegundoApellido" name="pacienteSegundoApellido" placeholder="<spring:message code="agenda.jsp.segundoapellido.marcador"></spring:message>"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Fecha Nacimiento Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.fechaNacimiento"><spring:message code="agenda.jsp.fechanacimiento.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="paciente.fechaNacimiento" id="fechaNacimiento" name="fechaNacimiento" placeholder="<spring:message code="agenda.jsp.fecha.marcador"></spring:message>"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
												    <!-- ***********************************************Edad Paciente************************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.edad"><spring:message code="agenda.jsp.edad.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="paciente.edad" id="edad" name="edad" placeholder="<spring:message code="agenda.jsp.edad.marcador"></spring:message>"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													 <!-- **************************************************Datos  Genero Paciente**************************************************************** -->
													<div class="col-md-4">
														 <div class="form-group">
						 									<form:label path="paciente.genero.idGenero"><spring:message code="agenda.jsp.genero.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="paciente.genero.idGenero" id="pacienteidGenero" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${generos}" itemValue="idGenero" itemLabel="genero"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
						   							</div><!-- .col-md-4 -->
						   							 <!-- **************************************************Datos  Escolaridad Paciente**************************************************************** -->
													<div class="col-md-4">
														 <div class="form-group">
						 									<form:label path="paciente.escolaridad.idEscolaridad"><spring:message code="agenda.jsp.escolaridad.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="paciente.escolaridad.idEscolaridad" id="pacienteidEscolaridad" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
						   							</div><!-- .col-md-4 -->
						   							 <!-- **************************************************Datos  Tutela Paciente**************************************************************** -->
													<div class="col-md-4">
														 <div class="form-group">
						 									<form:label path="paciente.tutela"><spring:message code="agenda.jsp.tutela.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="paciente.tutela" id="pacienteTutela" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="N" label="${selEtiqueta}"></form:option>
																	<form:option value="S"><spring:message code="agenda.jsp.tutela.si"></spring:message></form:option>
																	<form:option value="N"><spring:message code="agenda.jsp.tutela.no"></spring:message></form:option>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
						   							</div><!-- .col-md-4 -->
						   							<!-- **************************************************Datos  Eps Paciente**************************************************************** -->
													<div class="col-md-4">
														 <div class="form-group">
						 									<form:label path="paciente.eps.idEps"><spring:message code="agenda.jsp.eps.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="paciente.eps.idEps" id="pacienteidEps" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${eps}" itemValue="idEps" itemLabel="razonSocial"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
						   							</div><!-- .col-md-4 -->
						   							<!-- **************************************************Datos  Diagnosticos Paciente**************************************************************** -->
						   							<div class="col-md-4">
						   								<div class="form-group">
						   									<form:label path="diagnosticos"><spring:message code="agenda.jsp.diagnosticos.etiqueta"></spring:message></form:label>
						   									<div class="input-group">
						   										<form:select path="paciente.diagnosticos" items="${diagnosticos}" id="pacineteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
						   									</div><!-- .input-group -->
						   								</div><!-- .form-group -->
						   							</div><!-- .col-md-4 -->
						   							<div class="col-md-4">
						   								<div class="form-group">
						   									<form:label path="paciente.diagnosticos"><spring:message code="agenda.jsp.diagnosticosPaciente.etiqueta"></spring:message></form:label>
						   									<div class="input-group">
						   										<form:select path="diagnosticos" id="agendaDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
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
                                    				<form:input type="hidden" class="form-control" path="acudiente.idUsuario" id="idAcudiente" name="idAcudiente"></form:input>
                                    			   <!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
                                    				<div class="col-md-4">
                                    					<div class="form-group">
						 									<form:label path="acudiente.documento.tipodocumento.idTipoDocumento"><spring:message code="agenda.jsp.tipdocumento.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="acudiente.documento.tipodocumento.idTipoDocumento" id="acudienteidTipoDocumento" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
                                    				</div><!-- col-md-4 -->
                                    				<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.documento.documento"><spring:message code="agenda.jsp.documento.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:input type="text" class="form-control" path="acudiente.documento.documento" id="acudienteDocumento" name="acudienteDocumento" placeholder="<spring:message code="agenda.jsp.documento.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													 <!-- **************************************************Datos  Parentesco Acudiente**************************************************************** -->
                                    				<div class="col-md-4">
                                    					<div class="form-group">
						 									<form:label path="acudiente.parentesco.idParentesco"><spring:message code="agenda.jsp.parentesco.etiqueta"></spring:message></form:label>
															<div class="input-group">
																<form:select path="acudiente.parentesco.idParentesco" id="idParentesco" class="form-control">
																	<spring:message code="seleccion.etiqueta" var="selEtiqueta"></spring:message>
																	<form:option value="-1" label="${selEtiqueta}"></form:option>
																	<form:options items="${parentescos}" itemValue="idParentesco" itemLabel="idParentesco"></form:options>
																</form:select>
															</div><!-- .input-group -->
						   								</div><!-- .form-group -->
                                    				</div><!-- col-md-4 -->
                                    				<!-- ***********************************************Nombres y Apellidos Acudiente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.nombres"><spring:message code="agenda.jsp.nombres.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.nombres" id="acudienteNombres" name="acudienteNombres" placeholder="<spring:message code="agenda.jsp.nombres.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.primerApellido"><spring:message code="agenda.jsp.primerapellido.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.primerApellido" id="acudientePrimerApellido" name="acudientePrimerApellido" placeholder="<spring:message code="agenda.jsp.primerapellido.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.sedundoApellido"><spring:message code="agenda.jsp.segundoapellido.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.segundoApellido" id="acudienteSegundoApellido" name="acudienteSegundoApellido" placeholder="<spring:message code="agenda.jsp.segundoapellido.marcador"></spring:message>"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Datos Direccion************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.direccion"><spring:message code="agenda.jsp.direccion.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.direccion" id="direccion" name="direccion" placeholder="<spring:message code="agenda.jsp.direccion.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Datos Telefonos************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.telefonoFijo"><spring:message code="agenda.jsp.telefonoFijo.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.telefonoFijo" id="telefonoFijo" name="telefonoFijo" placeholder="<spring:message code="agenda.jsp.telefonoFijo.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.telefonoCelular"><spring:message code="agenda.jsp.telefonoCelular.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.telefonoCelular" id="telefonoCelular" name="telefonoCelular" placeholder="<spring:message code="agenda.jsp.telefonoCelular.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Datos Correo Electronico************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="acudiente.email"><spring:message code="agenda.jsp.email.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="acudiente.email" id="email" name="email" placeholder="<spring:message code="agenda.jsp.email.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- *************************************************Observaciones************************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="cita.observacion"><spring:message code="agenda.jsp.observacion.etiqueta"></spring:message></form:label>
															<div class="input-group">    
																<form:input type="text" path="cita.observacion" id="observacion" name="observacion" placeholder="<spring:message code="agenda.jsp.observacion.marcador"></spring:message>" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
                                   				</div><!-- .row -->
                                    		</div><!-- .card-body -->
                                    	</div><!-- .card-block -->            
									</div><!-- .collapse-show -->
								</div><!-- .card -->
							</form:form><!-- .form:form-->
						</div><!-- .row -->
					</div><!-- .container-fluid -->
				</div><!-- .content-inner -->
			</div><!-- .content-inner -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	
