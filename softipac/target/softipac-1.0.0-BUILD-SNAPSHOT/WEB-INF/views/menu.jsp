<%@include file="/WEB-INF/views/template/header.jsp"%>

	</head>
	<body>
	 <div class="sidebar-container"> 
        <div class="logo">
            <h3><spring:message code="titulo.barra.apa"></spring:message></h3>
        </div><!-- .logo -->
        
        <div class="user-meta">
            <div class="dropdown">
                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
                    <spring:message code="menu.jsp.bienvenido"></spring:message>
                    <span>${usuarioLogueado}</span>
                    <i class="fa fa-angle-down"></i>
                </button>
                
                <div class="dropdown-menu">
                    <li>
                    	<a href="<spring:url value="/logout"></spring:url>" class="dropdown-item">
                    		<i class="fa fa-sign-out"></i>
                    		<spring:message code="menu.jsp.salir"></spring:message>
                    	</a>
                    </li>
                </div>
                
            </div> <!-- .dropdown-menu -->
        </div><!-- .user-meta -->
        
        <ul class="sidebar-nav">
            <li>
                <a href="<spring:url value="/panel"></spring:url>"><i class="fa fa-fw fa-dashboard"></i><spring:message code="menu.jsp.icono.menu.titulo"></spring:message></a>
            </li>
            
            <li>
                <a href="panel_usuario.php"><i class="fa fa-fw fa-male"></i> Usuarios</a>
            </li>
            
              <li>
                <a href="panel_citas.php"><i class="fa fa-fw fa-copy"></i> Citas</a>
            </li>
	 	</ul>
	</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>	