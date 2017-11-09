<%@include file="/WEB-INF/views/template/header.jsp"%>

	</head>
	<body>
		<div class="page-container">
		
			<%@include file="/WEB-INF/views/menu.jsp"%>
			
			<div class="page-title">	
				<div class="mobile-menu">
					<a href="#">
					<i class="fa fa-bars"></i>
					</a>
				</div><!-- .mobile-menu -->
				
				<div class="pull-left">
					<h3><spring:message code="titulo.barra.apa"></spring:message></h3>
					<ol>
						<li><spring:message code="panel.jsp.opciones "></spring:message></li>
					</ol>
				</div>			
			</div><!-- .page-title -->
			
			<div class="content-inner">
				<div class="stat-boxes">
					<div class="container-fluid">
						<div class="row">
							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<a href="<spring:url value="/usuario"></spring:url>">
									<div class="box">
										<h5></h5>
										<h5><spring:message code="panel.jsp.usuarios"></spring:message></h5>
										<h4></h4>
										<div class="icon">
											<i class="fa fa-male"></i>
										</div><!-- .icon -->
									</div><!-- .box -->
								</a>
							</div><!-- .col-md-6 -->
							
							  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <a href="<spring:url value="/cita"></spring:url>">
                                        <div class="box">
                                            <h5> </h5>
                                            <h5><spring:message code="panel.jsp.citas"></spring:message><i class="fa fa-angle-right"></i></h5>
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