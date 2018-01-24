	<%@include file="/WEB-INF/views/template/header.jsp"%>
	<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
    <title>${titulo}</title>
    </head>
	<body>
		<div class="login-page">
			<div class="header">
				<div style="display:inline-block">
						<img src="<c:url value="/resources/images/apaLogo.gif"></c:url>" alt="image" style="width:100%"/>
					<h1>${nombreSistema}</h1>
				</div><!-- .inline-block -->
				<h2>${datosInformacion}</h2>
			</div> <!-- .header -->
			<div class="form-box">
				<c:url var="loginUrl" value="/login"></c:url>
				<form action="${loginUrl}" method="post" class="validate"> 
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>${usuarioSalir}</p>
						</div><!-- .alert-success -->
					</c:if><!-- .success -->
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>${usuarioClave}</p>
						</div><!-- .alert-danger -->
					</c:if><!-- .danger -->
					<c:if test="${param.accessDenied != null }">
						<div class="alert alert-danger">
							<p>${accesoDenegado}</p>
						</div><!-- .alert-danger -->
					</c:if><!-- .accessDenied -->
					<div class="form-group">
						<label>${usuarioEtiqueta}</label>
						<div class="input-group">
							<input type="text" class="form-control" id="username" name="username" placeholder="${usuarioMarcador}" required>
							<div class="input-group-addon">
								<i class="fa fa-user"></i>
							</div><!-- .input-group-addon -->
						</div><!-- .input-group -->
					</div><!-- .form-group -->		
					<div class="form-group">
						<label>${claveEtiqueta}</label>
						<div class="input-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="${claveMarcador}" required>
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div><!-- .input-group-addon -->
						</div><!-- input-group -->
					</div> <!-- .form-group -->	
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
					<div class="form-group">
						<input id="btnLogin" type="submit" class="btn btn-blue" value="${botonLoguinEtiqueta}">
					</div> <!-- .form-group -->
				</form> <!-- .form -->
			</div> <!-- .form-box -->
		</div> <!-- .login-page  -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	
	

