<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	    <link rel="icon" href="https://getbootstrap.com/favicon.ico">
		<!-- Bootstrap core CSS -->
	    <link href="style/bootstrap.css" rel="stylesheet">
	    <!-- Custom styles for this template -->
	    <link href="style/signin.css" rel="stylesheet">
	
	    <title>Mantenimiento - SignIn</title>
  </head>

	<body class="text-center">
		
		<div class="contenido">
			<div>
				<a href="#"><b>Sistema de Mantenimiento</b></a>
			</div>
			
			<div>
				<p> Iniciar Sesion </p>
			    <form class="form-signin" action="signin?accion=verificar" method="post">
				      <img class="mb-4" src="style/bootstrap-solid.html" alt="" width="72" height="72">
				      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				      
				      <label for="inputEmail" class="sr-only">Email address</label>
				      <input id="inputEmail" name="email" class="form-control" placeholder="Email address" required="" autofocus="" type="email">
				      
				      <label for="inputPassword" class="sr-only">Password</label>
				      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required="" type="password">
				     
				      <div class="row">
				      	<div class="col-xs-8">
				      		<div class="checkbox">
				      			<label>
				      				<input type="checkbox"> Recordarme
				      			</label>
				      		</div>
				      	</div>
				      </div>
				      
				      <input type="submit" name="verificar" value="Verificar" class="btn btn-primary btn-block"/>
				      
				      <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>   -->
		      
				     
			    </form> 
	    		
		   		<div class="text-center">
			    	<p> - Verificacion de Credenciales- </p>
			    	
			    	<% 
			    		String msje= (String)session.getAttribute("msje");
					%>
			    	
			    	<a href="#" class="btn btn-block"> <p style="color: red"> <i> Mensaje: ${msje} </i> </p> </a>
		    	</div>
			    <a href="#"> Olvide la contraseña </a><br>
			    <a href="#" class="text-center"> Registrar un nuevo usuario </a>
		   	</div>
		   	<p class="mt-5 mb-3 text-muted">© 2022</p>
   		</div>
	    
	    </center>
	</body>
</html>