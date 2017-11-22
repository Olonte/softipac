<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
			<div class="content-inner">
				<div class="table-responsive">
					<table id="citasUsuarios" class="table table-hober">
						<thead>
							<tr>
					    		<th><spring:message code="listadoAgenda.jsp.fecha.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.hora.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.nombres.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.apellido.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.telfonofijo.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.celular.etiqueta"></spring:message></th>
                            	<th><spring:message code="listadoAgenda.jsp.acciones.etiqueta"></spring:message></th>
							<tr>
						</thead><!-- .thead -->
						<tbody>
							<c:forEach items="${citas}" var ="cita">
							</c:forEach>
						</tbody><!-- .tbody -->
					</table><!-- .table-responsive -->
				</div><!-- .table-responsive -->
			</div><!-- .content-inner -->
		</div><!-- .page-container -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	