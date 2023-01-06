<%@ page import="java.util.LinkedList"%>
<%@ page import="entities.Persona"%>
<%@ page import="entities.Cargo"%>
<%@ page import="data.CargoDAO"%>
<%@ page import="data.DataPersona"%>
<%@ page import="logic.ControlMenu"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
	Persona per=null;
	if (session.getAttribute("usuario")!=null){	
		per= (Persona)session.getAttribute("usuario");
	}
	%>
	
	<style>
		ul.nav{
		  margin: 0;
		  padding: 0;
		  float:left;
		  width: 100%;
		}
		ul li {
		    list-style: none;
		    float:left;
		    padding: 5px
		}
		ul li:last-child {
		     float: right;
		}
		.navbar-nav {
		    width: 100%;
		}
		
		.navbar-collapse ul li:last-child {      
		    float: right;
		}
		
		#menu > li:last-child
		{
		    float:right;
		}
     </style>



		
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
  
    <a class="navbar-brand">Mantenimiento</a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="menu">
      
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.servletContext.contextPath}/MenuPrincipalServlet">Home</a>
	        </li>
	        
	        <li class="nav-item">
	        	<a class="nav-link" href="${pageContext.servletContext.contextPath}/UsuariosServlet?usuario=<%= per%>&accion=<%="verUsuarios"%>"> Usuarios </a>
	        </li>
	          
	        <li class="nav-item">
	        	<a class="nav-link" href="${pageContext.servletContext.contextPath}/maquinas">Maquinas</a>
	        </li>        
	        
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Reportes</a>
	          
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#">Del Personal</a></li>
		            <li><a class="dropdown-item" href="#">De Maquinas</a></li>
		          </ul>
	        </li>
	        
	      	<li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">ABM BASES</a>
		          <ul class="dropdown-menu">
			            <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/secciones">Secciones</a></li>
			            <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/cargos">Cargos</a></li>
		          </ul>
	        </li>
	        
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><%=per.getNombre() %></a>
		          <ul class="dropdown-menu">
		            	<li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/UsuariosServlet?usuario=<%= per%>&accion=<%="cerrar"%>">Cerrar Sesion</a></li>
		          </ul>
	        </li>
		
		</ul>
    </div>
  </div>
</nav>