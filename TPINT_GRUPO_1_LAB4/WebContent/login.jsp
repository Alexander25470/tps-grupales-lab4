<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
	<div class="row">
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST"  class="card shadows login">
			<p>Usuario</p>
			<input type="text" name="usuario" required/>
			<p>Constraseña</p>
			<input type="password" name="contrasenia" required/>
			<button class="common-button" type="submit" name="login">Ingresar</button>
				<%
					if(request.getAttribute("noEncontrado") != null){
				%>
					<p class="danger">Credenciales invalidas.</p>
				<%}%>
		</form>
	</div>

</body>
</html>