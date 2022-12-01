<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Persona"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
	
	<title>MENU PRINCIPAL</title>
	
		<%
		Persona p= (Persona)session.getAttribute("usuario"); 
		%>
</head>
<body>
	<div class="container">
	
		<%-- 		 <%@include file="../template/menu.jsp" %> --%>
		
		<% if (p.isHabilitado()) { %>
			<jsp:include page="../template/menu.jsp" />		
		<%} else {%>
			<jsp:include page="../template/menu2.jsp" />
		<%} %>
		
		<hr>
		<div class="row align-items-start">
			<div class="col-9">
				<h1>Gestión de Mantenimiento</h1>
			</div>
		</div>
</body>
</html>