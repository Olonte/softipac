<%@include file="/WEB-INF/views/template/header.jsp"%>
	</head>
	<body>
		<div class="page-container">
			<%@include file="/WEB-INF/views/template/menu.jsp"%> 
			<div class="content-container">
				<%@include file="/WEB-INF/views/template/page-title.jsp"%> 
				<div class="content-inner">
					<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
					<span>Apreciado <strong>${loggedinuser}</strong>${accesoDenegadoMSJ} </span>
				</div><!-- .content-inner -->
			</div><!-- .content-container -->
		</div><!-- .page-container -->
 	<%@include file="/WEB-INF/views/template/footer.jsp"%>		   