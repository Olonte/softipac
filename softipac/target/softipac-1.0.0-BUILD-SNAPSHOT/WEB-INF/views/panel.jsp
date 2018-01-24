<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
			<div class="content-inner">
				<div class="stat-boxes">
					<div class="container-fluid">
						<div class="row">
							<!-- **************************************Usuario****************************************************************** -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<a href="<spring:url value="/panelUsuario"></spring:url>">
									<div class="box">
										<h5></h5>
										<h5>${usuariosEtiqueta}<i class="fa fa-angle-right"></i></h5>
										<h4></h4>
										<div class="icon">
											<i class="fa fa-male"></i>
										</div><!-- .icon -->
									</div><!-- .box -->
								</a>
							</div><!-- .col-md-6 -->
							<!-- **************************************Cita****************************************************************** -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            	<a href="<spring:url value="/panelCita"></spring:url>">
                                	<div class="box">
                                    	<h5> </h5>
                                        <h5>${citasEtiqueta}<i class="fa fa-angle-right"></i></h5>
                                        <h4></h4>
                                        <div class="icon">
                                        	<i class="fa fa-copy"></i>
                                        </div> <!-- .icon -->
                                    </div> <!-- .box -->   
                           		</a>
                           </div><!-- .col-md-9 -->
						</div><!-- .row -->
					</div><!-- .container-fluid -->
				</div><!-- .stat-boxes -->
			</div><!-- .content-inner -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	