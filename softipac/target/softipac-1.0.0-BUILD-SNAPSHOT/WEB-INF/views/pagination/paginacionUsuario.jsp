<div class="custom-pagination">
	<ul class="pagination pull-right">
		<c:url var="primeraUrl" value="/paginaUsuario/${paginaInicial}"></c:url>
		<c:url var="ultimaUrl" value="/paginaUsuario/${citas.size()}"></c:url>
		<c:url var="anteriorUrl" value="/paginaUsuario/${indiceActual - 1}"></c:url>
		<c:url var="siguienteUrl" value="/paginaUsuario/${indiceActual + 1}"></c:url>
		<c:choose>
			<c:when test="${indiceActual == 1}">
				<li class="disabled"><a href="#">&lt;&lt;</a></li>
				<li class="disabled"><a href="#">&lt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${primeraUrl}">&lt;&lt;</a></li>
				<li><a href="${anteriorUrl}">&lt;</a></li>						
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${indiceInicio}" end="${indiceFinal}">
			<c:url var="paginaUrl" value="/paginaAgenda/${i}"></c:url>
			<c:choose>
				<c:when test="${i == indiceActual}">
					<i class="active"><a href="${paginaUrl}"><c:out value="${i}"></c:out></a></i>
				</c:when>
				<c:otherwise>
					<li><a href="${paginaUrl}"><c:out value="${i}"></c:out></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${indiceActual == citas.size()}">
				<li class="disabled"><a href="#">&gt;</a></li>
				<li class="disabled"><a href="#">&gt;&gt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${siguienteUrl}">&gt;</a></li>
				<li><a href="${ultimaUrl}">&gt;&gt;</a></li>
			</c:otherwise>
		</c:choose>
	</ul><!-- .pagination pull-right -->
</div><!-- .custom-pagination -->
