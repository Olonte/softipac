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
								<!-- *************************************Creacion Usuarios ******************************************************************** -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<a href="<spring:url value="/usuario"></spring:url>">
										<div class="box">
											<h5></h5>
											<h5>${crearUsuarioEtiqueta}<i class="fa fa-angle-right"></i></h5>
											<h4></h4>
											<div class="icon">
												<i class="fa fa-male"></i>
											</div><!-- .icon -->
										</div><!-- .box -->
									</a>
								</div><!-- .col-md-6 -->	
								<!-- *************************************Pagina Agenda******************************************************************** -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                	<a href="<spring:url value="/paginaUsuario/${paginaInicial}"></spring:url>">
                                    	<div class="box">
                                        	<h5> </h5>
                                            <h5>${paginaUsuarioEtiqueta}<i class="fa fa-angle-right"></i></h5>
                                            <h4></h4>
                                            <div class="icon">
                                                <i class="fa fa-users"></i>
                                            </div> <!-- .icon -->
                                        </div> <!-- .box -->   
                                    </a>
                                </div><!-- .col-md-3 -->			
							</div><!-- .row -->	
						</div><!-- .container-fluid -->
					</div><!-- .stat-boxes -->
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	