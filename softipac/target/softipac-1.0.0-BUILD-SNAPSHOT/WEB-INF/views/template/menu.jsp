<%@include file="/WEB-INF/views/template/etiquetas_marcadores.jsp"%> 
<div class="page-container">
	<div class="sidebar-container"> 
		<div class="logo">
			<h3>${barraApa}</h3>
		</div><!-- .logo -->
		<div class="user-meta">
			<div class="dropdown">
		    	<button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
		        	${bienvenido}
		            <span>${usuarioLogueado.obtenerNombresApellidos()}</span>
		            <i class="fa fa-angle-down"></i>
		        </button>   
		        <div class="dropdown-menu">
		        	<li>
		            	<a href="<spring:url value="/logout"></spring:url>" class="dropdown-item">
		                	<i class="fa fa-sign-out"></i>
		                    ${menuSalir}
		                </a>
		            </li>
		        </div><!-- .dropdown-menu -->        
		  </div> <!-- .dropdown-menu -->
		</div><!-- .user-meta -->
		<ul class="sidebar-nav">
			<li>
		    	<a href="<spring:url value="/panel"></spring:url>">
		    		<i class="fa fa-th"></i>
		    		${icono}
		    	</a>
		    </li>
		    <li>
		    	<a href="<spring:url value="/panelUsuario"></spring:url>"><i class="fa fa-users"></i> Usuarios</a>
		    </li>
		    <li>
		        <a href="<spring:url value="/panelCita"></spring:url>"><i class="fa fa-list-alt"></i> Citas</a>
		    </li>
		</ul>
	</div><!-- .sidebar-container -->
</div><!-- .page-container -->
