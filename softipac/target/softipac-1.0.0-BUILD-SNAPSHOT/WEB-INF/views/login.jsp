<%@include file="/WEB-INF/views/template/header.jsp"%>
    <title><spring:message code="login.form.title.label"></spring:message></title>
    </head>
	<body>
		<div class="login-page">
			
			<div class="header">
				<h1><spring:message code="login.form.system.name"></spring:message></h1>
				<h2><spring:message code="login.form.data.information"></spring:message></h2>
			</div> <!-- header -->
			
			<div class="form-box">
				<c:url var="loginUrl" value="/login"></c:url>
				<form action="${loginUrl}" method="post" class="validate"> 
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p><spring:message code="login.form.validate.user.pass"></spring:message></p>
						</div>
					</c:if>
								
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p><spring:message code="login.form.user.logout"></spring:message></p>
						</div>
					</c:if>
							
					<c:if test="${param.accessDenied != null }">
						<div class="alert alert-danger">
							<p><spring:message code="login.form.access.denied"></spring:message></p>
						</div>
					</c:if>	
							
					<div class="form-group">
						<label><spring:message code="login.form.user.label"></spring:message></label>
						<div class="input-group">
							<input type="text" class="form-control" id="username" name="username" placeholder="<spring:message code="login.form.user.placeholder.label"></spring:message>" required>
							<div class="input-group-addon">
								<i class="fa fa-user"></i>
							</div>
						</div>
					</div><!-- .form-group -->
								
					<div class="form-group">
						<label><spring:message code="login.form.password.label"></spring:message></label>
						<div class="input-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code="login.form.password.placeholder.label"></spring:message>" required>
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div>
						</div>
					</div> <!-- .form-group -->
							
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
							
					<div class="form-group">
						<input type="submit" class="btn btn-blue" value="Loguin">
					</div> <!-- .form-group -->
					
				</form> <!-- .form -->
				
			</div> <!-- .form-box -->
			
		</div> <!-- .login-page  -->
<%@include file="/WEB-INF/views/template/footer.jsp"%>	
	

