<%@ page import="java.util.*"%>
<%@ page import="entities.Persona"%>
<%@ page import="entities.Rol"%>
<%@ page import="entities.Cargo"%>
<%@ page import="logic.ControlMenu"%>
<%@ page import="logic.GestionarPersona"%>
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
		LinkedList<Persona> lp= (LinkedList<Persona>)request.getAttribute("listaPersonas");
	%>
	
</head>

<body>
	<% 
		GestionarPersona ctrl = new GestionarPersona();
	%> 
	<div class="container">
	
		<% if (p.isHabilitado()) { %>
			<%@include file="../template/menu.jsp" %>	
		<%} else { %>
			<%@include file="../template/menu2.jsp" %>
		<%} %>
		
		<hr>
		<div class="row align-items-start">
			<div class="col-9">
				<h1>Gestión de Mantenimiento</h1>
			</div>
		</div>

		<div class="table-responsive">		
			<hr>
			<div class="row align-items-start">
				<div class="col-9">
					<h4>USUARIOS</h4>
				</div>
				<div class="col-3" align-self-center>
					<div class="d-grid gap-2">
						<button type="button" class="btn btn-success btnAdd" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
					</div>
				</div>
			</div>
			<br>
			
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>nombre</th>
						<th>apellido</th>
						<th>email</th>
						<th>tel</th>
						<th>habilitado</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
					<%
					for(Persona per: lp){ 
					%>
					<tr>
						<td class="id"><%=per.getId()%></td>
						<td class="nombre"><%=per.getNombre()%> </td>
						<td class="apellido"><%=per.getApellido()%> </td>
						<td class="email"><%=per.getEmail()%> </td>
						<td class="telefono"><%=per.getTel()%> </td>
						<td class="tipoDoc" style="display:none;"><%=per.getDocumento().getTipo()%> </td>
						<td class="dni" style="display:none;"><%=per.getDocumento().getNro()%> </td>
						<td class="cargo" style="display:none;"><%=per.getCargo().getDescripcion().trim()%> </td>
						<td>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="defaultDisabled" <%=per.isHabilitado()?"checked":""%> disabled>
								<label class="custom-control-label" for="defaultDisabled"><%=per.isHabilitado()?"Si":"No"%></label>
							</div>
						</td>
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
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Datos Persona</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        
		        <form action="${pageContext.servletContext.contextPath}/PersonaServlet" method="post" role="form">
		        	<div class="row">
		        		<div class="col-6">
		        			<label>ID</label>
		        			<input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
		        		</div>
		        		<div class="col-6">
		        			<label>Nombre</label>
		        			<input type="text" name="txtNombre" class="form-control" id="txtNombre">
		        		</div>
		        		<div class="col-6">
		        			<label>Apellido</label>
		        			<input type="text" name="txtApellido" class="form-control" id="txtApellido">
		        		</div>
		        		<div class="col-6">
		        			<label>Email</label>
		        			<input type="text" name="txtEmail" class="form-control" id="txtEmail">
		        		</div>
		        		<div class="col-6">
		        			<label>Telefono</label>
		        			<input type="text" name="txtTelefono" class="form-control" id="txtTelefono">
		        		</div>
		        		<div class="col-6">
		        			<label>Documento</label>
		        			<input type="text" name="txtDNI" class="form-control" id="txtDNI">
		        		</div>
		        		<div class="col-6">
		        			<label>Tipo DOC</label>
		        			<input type="text" name="txtTipoDoc" class="form-control" id="txtTipoDoc">
		        		</div>
		        		
		        		<div class="col-6">
		        			<label>Cargo</label>
		        			<div class="flex-end">
			        			<select name="cbbCargo" class="form-select cbbCargo" id="txtCargo">
								    <option value="">Seleccionar Cargo...</option>
								    <%  
							    	LinkedList<Cargo> lista = ctrl.getAllCargos();
								    	for(Cargo c: lista) {
								    %>
								    	<option value="<%=c.getIdCargo()%>"> <%=c.getDescripcion()%></option>
								    <% } %>
								  </select>
								  <button type="submit" name="btnAsignarCargo" class="btn btn-dark btnAsignarCargo">Asignar</button>
							  </div>
		        		</div>
		        	</div>
<!-- __________________________  ROLES  __________________________________  -->		        	
		        	<hr>
		        	<div class="row">
		        		<div class="col-md-6">
		        			<label>Roles Activos</label>
		        		</div>
		        		<div class="col-md-6">
		        			<label>Roles Restantes</label>
		        		</div>
		        	</div>
		        	
		        	<div class="row">
		        	 	<div class="col-md-3">
		        	 		<div style="max-width:90%;">
			        	 		<select name="rolesActivos" id="listboxRolesActuales" class="listboxRolesActuales" multiple="multiple" >
			        	 		
			        	 		
<!-- 		        	CORREGIR ESTO QUE VIENE DESPUÉS. SIEMPRE MUESTRA LOS ROLES DEL USUARIO LOGUEADO, NO DEL SELECCIONADO -->
			        			    <%  
			        			    	//Acá hay que cambiar el p por la persona indicada. ¿Cómo indicar la persona?
								    	ArrayList<Rol> listaRolesActuales = ctrl.getAllRoles(p);
								    	for(Rol r: listaRolesActuales) {
								    %>
								    	<option value="<%=r.getId() %>"> <%=r.getDescripcion() %></option>
								    <% } %>
								    
								    
				        		</select>
				        		<input type="hidden" name="txtRolRetirar" class="form-control" id="txtRolRetirar" readonly="true">
			        		</div>
			        	</div>
			        	<div class="col-md-3">	
				        	<div>	
								<button type="submit" name="btnAgregarRol" class="btn btn-success btnAgregar">Agregar</button>
							</div>
							<div>
			        			<button type="submit" name="btnEliminarRol" class="btn btn-danger btnEliminar">Eliminar</button>
			        		</div>
		        		</div>
	        			<div class="col-md-3">
	        				<div style="max-width:90%;">
		        				<select name="rolesRestantes" id="listboxRolesRestantes" multiple="multiple" class="listboxRolesRestantes" style="max-width:90%;">
			        			    <%  					
								    	ArrayList<Rol> listaRolesRestantes = ctrl.getAllRolesRestantes(p);
								    	for(Rol rl: listaRolesRestantes) {
								    %>
								    	<option value="<%=rl.getId() %>"> <%=rl.getDescripcion() %></option>
								    <% } %>
				        		</select>
				        		<input type="hidden" name="txtRolAgregar" class="form-control" id="txtRolAgregar" readonly="true">
	        				</div>
		        	 		
		        		</div>
		        	</div>
<!-- __________________________ FIN ROLES  __________________________________  -->

		        	<hr>
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
    
    <script src="${pageContext.servletContext.contextPath}/js/userManagement.js"></script>
	
	
	</body>
</html>
<%        
    } else {
        response.sendRedirect("index.jsp");
    }
%>
