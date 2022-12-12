<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="entities.Seccion"%>
<%@page import="entities.Persona"%>
<%@page import="data.SeccionDAO" %>
<%@page import="entities.Maquina"%>
<%@page import="data.MaquinaDAO" %>
<%@page import="data.DataPersona" %>
<%@page import="logic.GestionarIncidencia" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<% 

	if (session.getAttribute("usuario")!=null) { 
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta "http-equiv="X-UA-Compatible content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="http://getbootstrap.com/favicon.ico">
	
	<title>Gestion de Mantenimiento</title>
	
	<!--  Bootstrap core CSS -->
	<link href="style/bootstrap.css" rel="stylesheet">
	
	<!--  Custom styles for this template -->
	<link href="style/start.css" rel="stylesheet">
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
	
	<%
	Persona p= (Persona)session.getAttribute("usuario");
	Maquina m = (Maquina)request.getAttribute("maquinaIncidencia");
	%>
</head>

<body>
	<%! 
		SeccionDAO sDAO = new SeccionDAO();
		MaquinaDAO mDAO = new MaquinaDAO();
		DataPersona pDAO = new DataPersona();
		GestionarIncidencia ctrl = new GestionarIncidencia();
		// IncidenciaDAO iDAO = new IncidenciaDAO();
	%>
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
				<h1>Nueva Incidencia</h1>
			</div>
		</div>
		<hr>
		
		<form action="${pageContext.servletContext.contextPath}/CargarNuevaIncidenciaServlet" method="post" role="form">
        	<div class="row">
        		<div class="col-2">
        			<label>Maquina</label>
        			<input type="text" name="txtMaquina" class="form-control" id="txtMaquina" value="<%=m.getNombre()%>" readonly="true" >
        			<input type="hidden" name="idMaquina" class="form-control" id="idMaquina" value="<%=m.getId()%>" readonly="true" >
        		</div>
        	</div>
        	<br>
        	
        	<%
        		Boolean validarAsignacionEncargado = ctrl.validarAsignacionDeEncargado(p);
        	%>
       		<div class="row">
       			<div class="col-3">
       				<label>Asignar Persona para reparacion </label>
        			<select name="cbbPersonaReparacion" id="cbbPersonaReparacion" class="form-select" <%=(validarAsignacionEncargado)? ' ' :"disabled" %>>
					    <option value="">Seleccionar persona...</option>
					    <%  
					    	LinkedList<Persona> lista =ctrl.getEncargadosReparaciones();
					    	for(Persona pEncargado: lista) {
					    %>
					    		<option value="<%=pEncargado.getId()%>"> <%=pEncargado.getId() + " - " + pEncargado.getNombre() + " " + pEncargado.getApellido() %></option>
					    <% } %>
					</select>
       			</div>
        	</div>
        	
        	<div class="row">
        		<div class="col-2">
        		<br>
        			<label>Fecha de Apertura</label>
        			<input type="date" name="txtFechaApertura" class="form-control" id="txtFechaApertura">
        		</div>
        	</div>
        	<br>
       		<div class="row">
       			<label>Descripcion</label>
       			<textarea rows="5" name="txtDescripcion"></textarea>
       			
       		</div>
       		<br>
       		<div class="row">
       			<label>Fotos</label>
       			
       				<form method="POST" action="upload" enctype="multipart/form-data" >
			            FOTO:
			            <input type="file" name="file" id="file" /> <br/>
			            Destination:
			            <input type="text" value="/tmp" name="destination"/>
			            </br>
			            <input type="submit" value="Upload" name="upload" id="upload" />
			        </form>      			
       			
       			<input type="hidden" name="idPersonaApertura" class="form-control" id="idPersonaApertura" value="<%=p.getId()%>" readonly="true" >
       		</div>
        	
        	<br>
        	
        	<div class="row">
        		<div class="col-12">
        			<button type="submit" name="btnGuardar" class="btn btn-success btnOcultarGuardar">Guardar</button>
        			<button type="button" class="btn btn-info" data-bs-dismiss="modal" onclick="location.href='${pageContext.servletContext.contextPath}/maquinas'">Cancelar</button>
        		</div>
        	</div>
        	
        	
        	
        </form>
 
 	</div> <!--  Container -->
</body>
</html>
<%        
    } else {
        response.sendRedirect("index.jsp");
    }
%>