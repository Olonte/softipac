<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
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
											<h5>${agendaEtiqueta}<i class="fa fa-angle-right"></i></h5>
											<h4></h4>
											<div class="icon">
												<i class="fa fa-book"></i>
											</div><!-- .icon -->
										</div><!-- .box -->
									</a>
								</div><!-- .col-md-6 -->	
								<!-- *************************************Cita Informacion ******************************************************************** -->
								 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <a href="<spring:url value="/crear/citaInformacion"></spring:url>">
                                        <div class="box">
                                            <h5> </h5>
                                            <h5>${citaEtiqueta}<i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-newspaper-o"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-6 -->
								<!-- *************************************Pagina Agenda******************************************************************** -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                		<a href="<spring:url value="/paginaAgenda/${paginaInicial}"></spring:url>">
                                    	<div class="box">
                                            <h5> </h5>
                                            <h5>${paginaAgendaEtiqueta}<i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-list"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-3 -->
                                <!-- *************************************Pagina Cita Informacion******************************************************************** -->
								 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <a href="<spring:url value="/paginaCitaInformacion/${paginaInicial}"></spring:url>">
                                        <div class="box">
                                            <h5> </h5>
                                            <h5>${paginaCitaInformacionEtiqueta}<i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-list"></i>
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