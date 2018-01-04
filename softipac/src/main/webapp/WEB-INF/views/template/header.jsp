<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf">
		<title><spring:message code="titulo.barra.apa"></spring:message></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.10, minimum-scale=1.0,  maximum-scale=1.0, user-scalable=0">
        
        <link href="//fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">
        <link href="<c:url value="/static/css/bootstrap/bootstrap.min.css"></c:url>" rel="stylesheet">
       	<link href="<c:url value="/static/css/font-awesome.min.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="/static/css/style/style.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="/static/css/datepicker/bootstrap-datepicker.min.css"></c:url>" rel="stylesheet">  
	    <link href="<c:url value="/static/css/datepicker/bootstrap-datepicker.min.css.map"></c:url>"rel="stylesheet">
       
        <link href="<c:url value="/static/css/datatables/jquery.dataTables.min.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="/static/css/datatables/dataTables.fontAwesome.css"></c:url>" rel="stylesheet">
      	<link href="<c:url value="/static/css/datatables/dataTables.bootstrap.min.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="/static/css/chosen/chosen.min.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="/static/css/chosen/formValidation.min.css"></c:url>" rel="stylesheet">   
		<link href="<c:url value="/static/css/jquery/jquery-ui.css"></c:url>"rel="stylesheet"> 
		
		<c:set var="seleccion" value="${-1}"></c:set>
		<c:set var="paginaInicial" value="${1}"></c:set>
