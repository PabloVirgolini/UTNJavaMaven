<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="entities.Seccion"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Incidencia"%>
<%@page import="data.SeccionDAO" %>
<%@page import="entities.Maquina"%>
<%@page import="data.MaquinaDAO" %>
<%@page import="data.DataPersona" %>
<%@page import="logic.GestionarIncidencia" %>

<%@page import="java.util.LinkedList"%>


    
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta "http-equiv="X-UA-Compatible content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--  The above 3 meta tags *must* come first in the head; any other head content must come *after* -->
	
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
	
	
	<style>
      .flex-end {
        display: flex;
        justify-content: flex-end;
      }
     </style>
	
	
	
	
	
	
	
	<%
		Persona p= (Persona)session.getAttribute("usuario");
		LinkedList<Incidencia> listaIncidencias= (LinkedList<Incidencia>)request.getAttribute("listaIncidencias");
		Maquina m= (Maquina)request.getAttribute("maquinaIncidencia");
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
				<h1>Gestión de Mantenimiento</h1>
			</div>
			<div class="col-3" align-self-center>
				<div class="d-grid gap-2">
					<button type="button" class="btn btn-info" data-bs-dismiss="modal" onclick="location.href='${pageContext.servletContext.contextPath}/maquinas'">Volver</button>
					
				</div>
			</div>
		</div>
			
		<div class="table-responsive">
			<hr>
			<div class="col-9">
				<h4>INCIDENCIAS   -   Maquina: <%=m.getNombre()%></h4>
			</div>
			 
			<hr>
			
			<table class="table table-striped" id="tablaIncidenciasHistorial">
				<thead>
					<tr>
						<th>id</th>
						<th>maquina</th>
						<th>fechaApertura</th>
						<th>fechaCierre</th>
						<th>PersonaApertura</th>
						<th>PersonaAsignada</th>
					</tr>
				</thead>
				<tbody>
					<%
					for(Incidencia inc: listaIncidencias){
					%>
						<tr>
							<td class="id"><%=inc.getId()%></td>
							<td class="maquina"><%=inc.getMaquina().getNombre()%> </td>
							<td class="fechaApertura"><%=inc.getFechaApertura()%> </td>
							<td class="fechaCierre"><%=(inc.getFechaCierre()==null)?"-":inc.getFechaCierre()%> </td>
							<td class="PersonaApertura"><%=inc.getPersonaApertura().getNombre()+ " " +inc.getPersonaApertura().getApellido() %> </td>
							<td class="PersonaAsignada"><%=((inc.getPersonaAsignada() == null)? '-':(inc.getPersonaAsignada().getNombre()+ " " +inc.getPersonaAsignada().getApellido())) %> </td>
							<td>
								<button type="button" class="btn btn-info btnVerFila" data-bs-toggle="modal" data-bs-target="#exampleModal">Ver</button>
								<button type="button" class="btn btn-dark btnEditarFila" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
								<button type="button" class="btn btn-danger btnEliminarFila" data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
							</td>
						</tr>
					<% } %>
				</tbody>
			</table>
		</div>
			
	</div>	 <!--- Container -->
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Datos Incidencia</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        
		        <form action="${pageContext.servletContext.contextPath}/ConsultarHistorialIncidenciasServlet" method="post" role="form">
		        	<div class="row">
		        		<div class="col-3">
		        			<label>ID</label>
		        			<input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
		        		</div>
		        		<div class="col-6">
		        			<label>Maquina</label>
		        			<input type="text" name="txtMaquina" class="form-control" id="txtMaquina">
		        		</div>
		        	</div>
		        	<br>
		        	<div class="row">
		        		<div class="col-6">
		        			<label>Fecha de Alta</label>
		        			<input type="date" name="txtFechaAlta" class="form-control" id="txtFechaAlta">
		        		</div>
		        		<div class="col-6">
		        			<label>Fecha de Cierre</label>
		        			<div class="flex-end">
		        				<input type="date" name="txtFechaCierre" class="form-control" id="txtFechaCierre">
		        				<button type="submit" name="btnCerrar" class="btn btn-dark btnCerrarIncidencia">Cerrar</button>
		        			</div>
		        		</div>
		        	</div>
		        	<br>
		        	<div class="row">
		        		<div class="col-6">
		        			<label>DESCRIPCION</label>
		        			<input type="text" name="txtDescripcion" class="form-control" id="txtDescripcion">
		        		</div>
		        	</div>
		        	
		        	<br>
		        	<div class="row">
		       			<div class="col-6">
		       				<label>Asignar Persona para reparacion </label>
		       				<div class="flex-end">
			        			<select name="cbbPersonaReparacion" id="cbbPersonaReparacion" class="form-select">
								    <option value="">Seleccionar persona...</option>
								    <%  
								    	LinkedList<Persona> lista =ctrl.getEncargadosReparaciones();
								    	for(Persona pEncargado: lista) {
								    %>
								    		<option value="<%=pEncargado.getId()%>"> <%=pEncargado.getId() + " - " + pEncargado.getNombre() + " " + pEncargado.getApellido() %></option>
								    <% } %>
								</select>
			       				<button type="submit" name="btnAsignar" class="btn btn-dark btnAsignarPersona">Asignar</button>
		       				</div>
		       			</div>
		        	</div>		        	
		        	<hr>
		        	
		        	<div class="row">
		        		<div class="col-12">
		        			<button type="submit" name="btnEditar" class="btn btn-dark btnOcultarEditar">Editar</button>
		        			<button type="submit" name="btnEliminar" class="btn btn-danger btnOcultarEliminar">Eliminar</button>
		        			<button type="button" class="btn btn-info" data-bs-dismiss="modal">Volver</button>
		        		</div>
		        	</div>
		        </form>
		        
		      </div>
		     
		    </div>
		  </div>
		</div> <!-- /modal -->
		
		
	</div> <!-- /container -->
	
		
<!-- 	Agrego libreria de JQuery (CDNs) -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<!-- 	Agrego libreria de Bootstrap (CDNs) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<!-- 	Agrego librerias de JS de DataTables (CDNs) -->
	<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"> </script>
	<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"> </script>
	    
    <%
    	if (request.getAttribute("message")!=null){
    %>
    		<script>alert('<%= request.getAttribute("message")%>')</script>
    <%
    	}
    %>
	
	<script src="${pageContext.servletContext.contextPath}/js/incidenciasHistorial.js"></script>
	
	</body>
</html>
