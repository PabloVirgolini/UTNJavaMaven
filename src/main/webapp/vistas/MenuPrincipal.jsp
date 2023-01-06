
<%@ page import="entities.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<% 

	if (session.getAttribute("usuario")!=null) { 
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta "http-equiv="X-UA-Compatible content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--  The above 3 meta tags *must* come first in the head; any other head content must come *after* -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="http://getbootstrap.com/favicon.ico">
	
	<title>MENU PRINCIPAL</title>
	
	<!--  Bootstrap core CSS -->
	<link href="style/bootstrap.css" rel="stylesheet">
	
	<!--  Custom styles for this template -->
	<link href="style/start.css" rel="stylesheet">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
	
	<%
		Persona p= (Persona)session.getAttribute("usuario"); 
	%>
	
</head>
<body>
		
	<div class="container">
		
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
	</div> <!--  CONTAINER -->
	
</body>
</html>
<%        
    } else {
        response.sendRedirect("../index.jsp");
    }
%>