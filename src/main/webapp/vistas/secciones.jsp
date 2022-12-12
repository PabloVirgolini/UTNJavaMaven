<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="entities.Seccion"%>
<%@page import="entities.Persona"%>
<%@page import="data.SeccionDAO" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<% 

	if (session.getAttribute("usuario")!=null) { 
%>
<html>
<head>
	<meta charset="UTF-8">
	
   	<%
		Persona p= (Persona)session.getAttribute("usuario");
	%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<title>Mantenimiento - Secciones</title>
	
</head>

<body>
	<%! 
		SeccionDAO seccionDAO = new SeccionDAO();
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
				<h1>Secciones</h1>
			</div>
			<div class="col-3" align-self-center>
				<div class="d-grid gap-2">
					<button type="button" class="btn btn-success btnAdd" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
				</div>
			</div>
		</div>
		
		<hr>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<th>id</th>
					<th>descripcion</th>

				</thead>
				<tbody>
					<%
					LinkedList<Seccion> lm = seccionDAO.getAll();
					for (Seccion m: lm) {
					%>
					<tr>
						<td class="id"><%= m.getId()%></td>
						<td class="nombre"><%= m.getDescripcion()%></td>
						  
						<td>
							<button type="button" class="btn btn-dark btnEditarFila" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
							<button type="button" class="btn btn-danger btnEliminarFila" data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>	
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Datos Seccion</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      
		        <form action="${pageContext.servletContext.contextPath}/SeccionServlet" method="post" role="form">
		        	<div class="row">
		        		<div class="col-6">
		        			<label>Codigo</label>
		        			<input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
		        		</div>
		        		<div class="col-6">
		        			<label>Descripcion</label>
		        			<input type="text" name="txtNombre" class="form-control" id="txtNombre">
		        		</div>

		        	</div>
		        	<br>
		        	
		        	<div class="row">
		        		<div class="col-12">
		        			<button type="submit" name="btnGuardar" class="btn btn-success btnOcultarGuardar">Guardar</button>
		        			<button type="submit" name="btnEditar" class="btn btn-dark btnOcultarEditar">Editar</button>
		        			<button type="submit" name="btnEliminar" class="btn btn-danger btnOcultarEliminar">Eliminar</button>
		        			<button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
		        		</div>
		        	</div>
		        </form>
		      </div>
		     
		    </div>
		  </div>
		</div>
	</div>
    	
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
    
    <script src="${pageContext.servletContext.contextPath}/js/seccion.js"></script>
    
</body>

</html>
<%        
    } else {
        response.sendRedirect("index.jsp");
    }
%>