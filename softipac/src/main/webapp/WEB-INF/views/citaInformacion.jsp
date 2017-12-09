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
									<c:when test="${not empty msj_ext}"><%@include file="/WEB-INF/views/template/mensaje_exito.jsp"%></c:when>
									<c:when test="${not empty msj_err}"><%@include file="/WEB-INF/views/template/mensaje_error.jsp"%></c:when>
								</c:choose>
								<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
								<!-- **************************************************Cita Inicial de Informacion Datos**************************************************************** -->
								<div class="card ">
									<!-- **************************************************Id Cita**************************************************************** -->
									<form:input type="hidden" class="form-control" path="citaInformacion.cita.idCita" id="idCita" name="idCita"></form:input>
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
                                                        	<form:label path="citaInformacion.cita.fechaCitaIni">${fechaCitaEtiqueta}</form:label><br>
                                                            <c:set var="fecha" value="citaInformacion.cita.fechaCitaIni"></c:set>
                                                            <form:input  type="text" cssClass="form-control" path="citaInformacion.cita.fechaCitaIni" disable="${fecha}" id="fechaCitaIni" name="fechaCitaIni"></form:input>
                                                        </div><!-- .form-group -->
                                                    </div><!-- .col-md-4 -->
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                        	<form:label path="citaInformacion.usuarioAplica">${aplicaEtiqueta}</form:label>
                                                        	<c:set var="usuarioAplica" value="citaInformacion.usuarioAplica"">></c:set>
                                                            <form:input  type="text" cssClass="form-control" path="citaInformacion.usuarioAplica" disable="${usuarioAplica}" id="usuarioAplica" name="usuarioAplica"></form:input>
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
									<div id="collapseDatosPaciente" class="collapse show" rol="tabpanel" aria-labelledy="headingPaciente">
										<div class="card-block">
											<div class="card-body">
												<div class="row">
													<!-- **************************************************Id Paciente**************************************************************** -->
													<form:input type="hidden" cssClass="form-control" path="citaInformacion.paciente.idUsuario" id="idPaciente" name="idPaciente"></form:input>
													<!-- **************************************************Datos  Documento Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="citaInformacion.paciente.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="citaInformacion.paciente.documento.tipoDocumento.idTipoDocumento" id="pacienteIdTipoDocumento" class="form-control">
																	<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																</form:select>
															</div><!-- .input-group -->
								   						</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="citaInformacion.paciente.documento.documento">${documentoEtiqueta}</form:label>
															<div class="input-group">
																<form:input type="text" cssClass="form-control" path="citaInformacion.paciente.documento.documento" id="pacienteDocumento" name="documento" placeholder="${documentoMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Nombres y Apellidos Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="citaInformacion.paciente.nombres">${nombresEtiqueta}</form:label>
															<div class="input-group"> 
																<form:input type="text" cssClass="form-control" path="citaInformacion.paciente.nombres" id="pacienteNombres" name="pacienteNombres" placeholder="${nombresMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.primerApellido">${primerApellidoEtiqueta}</form:label>
															<div class="input-group">   
																<form:input type="text" cssClass="form-control" path="citaInformacion.paciente.primerApellido" id="pacientePrimerApellido" name="pacientePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="paciente.segundoApellido">${segundoApellidoEtiqueta}</form:label>
															<div class="input-group">    
																<form:input type="text" cssClass="form-control" path="citaInformacion.paciente.segundoApellido" id="pacienteSegundoApellido" name="pacienteSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Fecha Nacimiento Paciente************************************************************************* -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="citaInformacion.paciente.fechaNacimiento">${fechaNacimientoEtiqueta}</form:label>
															<div class="input-group">    
																<form:input type="text" cssClass="form-control" path="citaInformacion.paciente.fechaNacimiento" id="fechaNacimiento" name="fechaNacimiento" placeholder="${fechaNacimientoMarcador}"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<!-- ***********************************************Edad Paciente************************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
															<form:label path="citaInformacion.paciente.edad">${edadEtiqueta}</form:label>
															<div class="input-group">  
																<form:input type="text" class="form-control" path="citaInformacion.paciente.edad" id="edadPaciente" name="edadPaciente" placeholder="${edadMarcador}"></form:input>
															</div><!-- .input-group -->
														</div><!-- .form-group -->
													</div><!-- .col-md-4 -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="citaInformacion.paciente.meses">${mesesEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="citaInformacion.paciente.meses" id="meses" class="form-control">
																	<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${meses}" itemValue="meses" itemLabel="meses"></form:options>
																</form:select>
															</div><!-- .input-group -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->	
													<!-- **************************************************Datos  Genero Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="citaInformacion.paciente.genero.idGenero">${generoEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="citaInformacion.paciente.genero.idGenero" id="pacienteIdGenero" class="form-control">
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
																<form:select path="paciente.escolaridad.idEscolaridad" id="pacienteIdEscolaridad" class="form-control">
																	<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																</form:select>
															</div><!-- .input-group -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   					<!-- **************************************************Datos  Tutela Paciente**************************************************************** -->
													<div class="col-md-4">
														<div class="form-group">
								 							<form:label path="citaInformacion.paciente.tutela">${tutelaEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="citaInformacion.paciente.tutela" id="pacienteTutela" class="form-control">
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
								 							<form:label path="citaInformacion.paciente.eps.idEps">${epsEtiqueta}</form:label>
															<div class="input-group">
																<form:select path="citaInformacion.paciente.eps.idEps" id="pacienteIdEps" class="form-control">
																	<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																	<form:options items="${eps}" itemValue="idEps" itemLabel="razonSocial"></form:options>
																</form:select>
															</div><!-- .input-group -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   				</div><!-- .row -->
								   				<!-- **************************************************Datos  Diagnosticos Paciente**************************************************************** -->
								   				<div class="row">
								   					<div class="col-md-4">
								   						<div class="form-group">
								   							<form:label path="citaInformacion.diagnosticos">${diagnosticosEtiqueta}</form:label>
								   								<div class="input-group">
								   									<form:select path="citaInformacion.paciente.diagnosticos" cssClass="form-control" items="${diagnosticos}" id="pacienteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
								   								</div><!-- .input-group -->
								   						</div><!-- .form-group -->
								   					</div><!-- .col-md-4 -->
								   					<div class="col-md-4">
								   						<div class="form-group">
								   							<form:label path="citaInformacion.paciente.diagnosticos">${diagnosticosPacienteEtiqueta}</form:label>
								   							<div class="input-group">
								   								<form:select path="citaInformacion.diagnosticos" cssClass="form-control" items="${diagnosticosPaciente}" id="agendaDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
								   							</div><!-- .input-group -->
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
											<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseDatosMadre" aria-expanded="false" aria-controls="collapseDatosMadre">
												<h5 class="mb-0">${madreEtiqueta}</h5>
											</a>
										</div><!-- .card-header -->
										<div id="collapseDatosMadre" class="collapse show" role="tabpanel" aria-labelledby="headingDatosMadre">
											<div class="card-block">
		                                    	<div class="card-body">
		                                    		<div class="row">
		                                    	    	<!-- **************************************************Id Madre**************************************************************** -->
		                                    			<form:input type="hidden" cssClass="form-control" path="citaInformacion.madre.idUsuario" id="idMadre" name="idMadre"></form:input>
		                                    			<!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
		                                    			<div class="col-md-4">
		                                    				<div class="form-group">
								 								<form:label path="citaInformacion.madre.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="citaInformacion.madre.documento.tipoDocumento.idTipoDocumento" id="madreIdTipoDocumento" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																	</form:select>
																</div><!-- .input-group -->
								   							</div><!-- .form-group -->
		                                    			</div><!-- col-md-4 -->
		                                    			<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.documento.documento">${documentoEtiqueta}</form:label>
																<div class="input-group">
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.documento.documento" id="madreDocumento" name="madreDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
			                                    		<!-- ***********************************************Nombres y Apellidos Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.nombres">${nombresEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.nombres" id="madreNombres" name="madreNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.primerApellido">${primerApellidoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.primerApellido" id="madrePrimerApellido" name="madrePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.segundoApellido" id="madreSegundoApellido" name="madreSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Edad Madre************************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.edad">${edadEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="text" class="form-control" path="citaInformacion.madre.edad" id="madreEdad" name="madreEdad" placeholder="${edadMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- **************************************************Datos  Escolaridad Madre**************************************************************** -->
														<div class="col-md-4">
															<div class="form-group">
									 							<form:label path="citaInformacion.madre.escolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																<div class="input-group">
																	<form:select path="citaInformacion.madre.escolaridad.idEscolaridad" id="madreIdEscolaridad" class="form-control">
																		<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																		<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																	</form:select>
																</div><!-- .input-group -->
									   						</div><!-- .form-group -->
									   					</div><!-- .col-md-4 -->
									   					<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.ocupacion">${ocupacionEtiqueta}</form:label>
																<div class="input-group">  
																	<form:input type="text" class="form-control" path="citaInformacion.madre.ocupacion" id="madreOcupacion" name="madreOcupacion" placeholder="${ocupacionMarcador}"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Direccion Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.direccion">${direccionEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.direccion" id="madreDireccion" name="madreDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Telefonos Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.telefonoFijo" id="madreTelefonoFijo" name="madreTelefonoFijo" placeholder="${telefonoFijoMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.telefonoCelular" id="madreTelefonoCelular" name="madreTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
															</div><!-- .form-group -->
														</div><!-- .col-md-4 -->
														<!-- ***********************************************Datos Correo Electronico Madre************************************************************************* -->
														<div class="col-md-4">
															<div class="form-group">
																<form:label path="citaInformacion.madre.email">${emailEtiqueta}</form:label>
																<div class="input-group">    
																	<form:input type="text" cssClass="form-control" path="citaInformacion.madre.email" id="madreEmail" name="madreEmail" placeholder="${emailMarcador}" required="required"></form:input>
																</div><!-- .input-group -->
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
												<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseDatosPadre" aria-expanded="false" aria-controls="collapseDatosPadre">
													<h5 class="mb-0">${padreEtiqueta}</h5>
												</a>
											</div><!-- .card-header -->
											<div id="collapseDatosPadre" class="collapse show" role="tabpanel" aria-labelledby="headingDatosPadre">
												<div class="card-block">
		                                    		<div class="card-body">
		                                    			<div class="row">
		                                    	    		<!-- **************************************************Id Padre**************************************************************** -->
		                                    				<form:input type="hidden" cssClass="form-control" path="citaInformacion.padre.idUsuario" id="idPadre" name="idPadre"></form:input>
		                                    				<!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
		                                    				<div class="col-md-4">
		                                    					<div class="form-group">
								 									<form:label path="citaInformacion.padre.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="citaInformacion.padre.documento.tipoDocumento.idTipoDocumento" id="padreIdTipoDocumento" class="form-control">
																			<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
								   								</div><!-- .form-group -->
		                                    				</div><!-- col-md-4 -->
		                                    				<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.documento.documento">${documentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.documento.documento" id="padreDocumento" name="padreDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
			                                    			<!-- ***********************************************Nombres y Apellidos Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.nombres">${nombresEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.nombres" id="padreNombres" name="padreNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.primerApellido">${primerApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.primerApellido" id="padrePrimerApellido" name="padrePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.segundoApellido" id="padreSegundoApellido" name="padreSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Edad Padre************************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.edad">${edadEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" class="form-control" path="citaInformacion.padre.edad" id="padreEdad" name="padreEdad" placeholder="${edadMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Escolaridad Padre**************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
									 								<form:label path="citaInformacion.padre.escolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="citaInformacion.padre.escolaridad.idEscolaridad" id="padreIdEscolaridad" class="form-control">
																			<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
									   							</div><!-- .form-group -->
									   						</div><!-- .col-md-4 -->
									   						<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.ocupacion">${ocupacionEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" class="form-control" path="citaInformacion.padre.ocupacion" id="padreOcupacion" name="padreOcupacion" placeholder="${ocupacionMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Direccion Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.direccion">${direccionEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.direccion" id="padreDireccion" name="padreDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Telefonos Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.telefonoFijo" id="padreTelefonoFijo" name="padreTelefonoFijo" placeholder="${telefonoFijoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.telefonoCelular" id="padreTelefonoCelular" name="padreTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Correo Electronico Padre************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.padre.email">${emailEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.padre.email" id="padreEmail" name="padreEmail" placeholder="${emailMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
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
												<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseDatosAcudiente" aria-expanded="false" aria-controls="collapseDatosAcudiente">
													<h5 class="mb-0">${padreEtiqueta}</h5>
												</a>
											</div><!-- .card-header -->
											<div id="collapseDatosAcudiente" class="collapse show" role="tabpanel" aria-labelledby="headingDatosAcudiente">
												<div class="card-block">
		                                    		<div class="card-body">
		                                    			<div class="row">
		                                    	    		<!-- **************************************************Id Acudiente**************************************************************** -->
		                                    				<form:input type="hidden" cssClass="form-control" path="citaInformacion.acudiente.idUsuario" id="idAcudiente" name="idAcudiente"></form:input>
		                                    				<!-- **************************************************Datos  Documento Acudiente**************************************************************** -->
		                                    				<div class="col-md-4">
		                                    					<div class="form-group">
								 									<form:label path="citaInformacion.acudiente.documento.tipoDocumento.idTipoDocumento">${tipoDocumentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="citaInformacion.acudiente.documento.tipoDocumento.idTipoDocumento" id="acudienteIdTipoDocumento" class="form-control">
																			<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${tiposDocumento}" itemValue="idTipoDocumento" itemLabel="tipo"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
								   								</div><!-- .form-group -->
		                                    				</div><!-- col-md-4 -->
		                                    				<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.documento.documento">${documentoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.documento.documento" id="acudienteDocumento" name="acudienteDocumento" placeholder="${documentoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Parentesco Acudiente**************************************************************** -->
			                                    			<div class="col-md-4">
			                                    				<div class="form-group">
									 								<form:label path="citaInformacion.acudiente.parentesco.idParentesco">${parentescoEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="citaInformacion.acudiente.parentesco.idParentesco" id="acudienteIdParentesco" class="form-control">
																			<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${parentescos}" itemValue="idParentesco" itemLabel="parentesco"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
									   							</div><!-- .form-group -->
			                                    			</div><!-- col-md-4 -->
			                                    			<!-- ***********************************************Nombres y Apellidos Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.nombres">${nombresEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.nombres" id="padreNombres" name="acudienteNombres" placeholder="${nombresMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.primerApellido">${primerApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.primerApellido" id="acudientePrimerApellido" name="acudientePrimerApellido" placeholder="${primerApellidoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.segundoApellido">${segundoApellidoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.segundoApellido" id="acudienteSegundoApellido" name="acudienteSegundoApellido" placeholder="${segundoApellidoMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Edad Acudiente************************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.edad">${edadEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" class="form-control" path="citaInformacion.acudiente.edad" id="acudienteEdad" name="acudienteEdad" placeholder="${edadMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- **************************************************Datos  Escolaridad Acudiente**************************************************************** -->
															<div class="col-md-4">
																<div class="form-group">
									 								<form:label path="citaInformacion.acudiente.escolaridad.idEscolaridad">${escolaridadEtiqueta}</form:label>
																	<div class="input-group">
																		<form:select path="citaInformacion.acudiente.escolaridad.idEscolaridad" id="acudienteIdEscolaridad" class="form-control">
																			<form:option value="-1" label="${seleccionEtiqueta}"></form:option>
																			<form:options items="${escolaridades}" itemValue="idEscolaridad" itemLabel="escolaridad"></form:options>
																		</form:select>
																	</div><!-- .input-group -->
									   							</div><!-- .form-group -->
									   						</div><!-- .col-md-4 -->
									   						<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.ocupacion">${ocupacionEtiqueta}</form:label>
																	<div class="input-group">  
																		<form:input type="text" class="form-control" path="citaInformacion.acudiente.ocupacion" id="acudienteOcupacion" name="acudienteOcupacion" placeholder="${ocupacionMarcador}"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Direccion Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.direccion">${direccionEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.direccion" id="acudienteDireccion" name="acudienteDireccion" placeholder="${direccionMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Telefonos Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.telefonoFijo">${telefonoFijoEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.telefonoFijo" id="acudienteTelefonoFijo" name="acudienteTelefonoFijo" placeholder="${telefonoFijoMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.telefonoCelular">${telefonoCelularEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.telefonoCelular" id="acudienteTelefonoCelular" name="acudienteTelefonoCelular" placeholder="${telefonoCelularMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
																</div><!-- .form-group -->
															</div><!-- .col-md-4 -->
															<!-- ***********************************************Datos Correo Electronico Acudiente************************************************************************* -->
															<div class="col-md-4">
																<div class="form-group">
																	<form:label path="citaInformacion.acudiente.email">${emailEtiqueta}</form:label>
																	<div class="input-group">    
																		<form:input type="text" cssClass="form-control" path="citaInformacion.acudiente.email" id="acudienteEmail" name="acudienteEmail" placeholder="${emailMarcador}" required="required"></form:input>
																	</div><!-- .input-group -->
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
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="citaInformacion.cita.motivoConsulta" id="motivoConsulta" name="motivoConsulta" placeholder="${motivoConsultaMarcador}" required="required"></form:textarea>
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
                                    		<div class="row">
												<div class="form-group col-md-4">
								   					<form:label path="diagnosticos">${diagnosticosEtiqueta}</form:label>
								   					<div class="input-group">
								   						<form:select path="citaInformacion.paciente.diagnosticos" cssClass="form-control" items="${diagnosticos}" id="pacienteDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico"></form:select>
								   					</div><!-- .input-group -->
								   				</div><!-- .form-group col-md-4 -->
								   				<div class="form-group col-md-2">
								   					<br>
								   					<center>
								   						<input id="btnagregar" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}">
								   					</center>
								   				</div>
								   				<div class="form-group col-md-4">
								   					<form:label path="citaInformacion.paciente.diagnosticos">${diagnosticosPacienteEtiqueta}</form:label>
								   					<div class="input-group">
								   						<form:select path="diagnosticos" cssClass="form-control" items="${diagnosticosPaciente}" id="citaInformacionDiagnosticos" multiple="true" itemValue="idDiagnostico" itemLabel="diagnostico" class="form-control"></form:select>
								   					</div><!-- .input-group -->
								   				</div><!-- .form-group col-md-4 -->
											</div><!-- .row -->
                                    	</div><!-- .card -->
                                    	<!-- ***********************************************Datos  Expectativas************************************************************************* -->
										<div class="card ">
		                                	<div class="card-header" role="tab" id="headingExpectativas">
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseExpectativas" aria-expanded="false" aria-controls="collapseExpectativas">
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
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="citaInformacion.cita.expectativas" id="expectativas" name="expectativas" placeholder="${expectativasMarcador}" required="required"></form:textarea>
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
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseRecomendaciones" aria-expanded="false" aria-controls="collapseRecomendaciones">
		                                        	<h5 class="mb-0">${recomendacioneEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseRecomendaciones" class="collapse" role="tabpanel" aria-labelledby="headingRecomendaciones">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="citaInformacion.cita.recomendaciones" id="recomendaciones" name="recomendaciones" placeholder="${recomendacionesMarcador}" required="required"></form:textarea>
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
		                                    	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="collapseInfGeneral" aria-expanded="false" aria-controls="collapseInfGeneral">
		                                        	<h5 class="mb-0">${InformarcionGenEtiqueta}</h5>
		                                        </a>
		                                    </div><!-- .card-header -->
		                                    <div id="collapseInfGeneral" class="collapse" role="tabpanel" aria-labelledby="collapseInfGeneral">
		                                        <div class="card-block">
		                                            <div class="card-body">
		                                                <div class="row">
		                                                    <div class="col-md-12">
		                                                        <div class="form-group">
		                                                            <div class="input-group">    
																		<form:textarea type="text" cssClass="form-control" rows="10" cols="100" path="citaInformacion.cita.recomendaciones" id="recomendaciones" name="recomendaciones" placeholder="${informaciongenMarcador}"></form:textarea>
																	</div><!-- .input-group -->
		                                                        </div><!-- .form-group -->
		                                                    </div><!-- .col-md-12 -->
		                                                </div><!-- .row -->
		                                            </div><!-- card-body -->
		                                        </div><!-- .card-block -->
		                                    </div><!-- .collapse -->
                                		</div><!-- .card -->
                   						<div class="col-md-12">
											<center>
												<input id="btnLogin" type="submit" class="btn btn-blue" value="${botonGuardarEtiqueta}" style="float:center;">
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