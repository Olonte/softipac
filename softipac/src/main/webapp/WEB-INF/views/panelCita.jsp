<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<div class="content-container">
				<div class="content-inner">
					<div class="stat-boxes">
						<div class="container-fluid">
							<div class="row">
								<!-- *************************************Agenda ******************************************************************** -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<a href="<spring:url value="/agenda"></spring:url>">
										<div class="box">
											<h5></h5>
											<h5><spring:message code="panelCita.jsp.agenda.etiqueta"></spring:message><i class="fa fa-angle-right"></i></h5>
											<h4></h4>
											<div class="icon">
												<i class="fa fa-book"></i>
											</div><!-- .icon -->
										</div><!-- .box -->
									</a>
								</div><!-- .col-md-6 -->	
								<!-- *************************************Cita Informacion ******************************************************************** -->
								 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <a href="<spring:url value="/cita"></spring:url>">
                                        <div class="box">
                                            <h5> </h5>
                                            <h5><spring:message code="panelCita.jsp.cita.etiqueta"></spring:message><i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-copy"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-6 -->
								<!-- *************************************Listado Agenda******************************************************************** -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                	<a href="<spring:url value="/listadoAgenda"></spring:url>">
                                    	<div class="box">
                                            <h5> </h5>
                                            <h5><spring:message code="panelCita.jsp.listado-agenda.etiqueta"></spring:message><i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-reorder"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-3 -->
                                <!-- *************************************Listado Cita Informacion******************************************************************** -->
								 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <a href="<spring:url value="/listadoCita"></spring:url>">
                                        <div class="box">
                                            <h5> </h5>
                                            <h5><spring:message code="panelCita.jsp.listado-cita.etiqueta"></spring:message><i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-reorder"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-6 -->
							</div><!-- .row -->	
						</div><!-- .container-fluid -->
					</div><!-- .stat-boxes -->
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	