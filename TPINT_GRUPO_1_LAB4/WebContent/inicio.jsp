<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
<% 
Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
if(currentUser==null){
	response.sendRedirect("/TPINT_GRUPO_1_LAB4/login.jsp");
	System.out.println("No hay usuario");
} else {%>
  	<header class="card shadows">
  		<p></p>
	 	<h1>Bienvenido <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion" class="common-button danger">Cerrar sesión</button>
		</form>
	 </header>
	 <section id="inicio" class="row">	 
		<div class="col card shadows">
			<div class="row-center">
				<h2>Seleccione que desea ver</h2>
			</div>
			<div class="row-center ">
				<% 
				if(currentUser.isAdmin())
				{%>
				<a href="/TPINT_GRUPO_1_LAB4/alumnos/listar.jsp">
					<button class="common-button">Alumnos</button>
				</a>
				<a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp">
					<button class="common-button">Cursos</button>
				</a>
				<a href="/TPINT_GRUPO_1_LAB4/docentes/listar.jsp">
					<button class="common-button">Docentes</button>
				</a>
				<%} else
				{ %>
				<a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp">
					<button class="common-button">Cursos</button>
				</a>
				<%} %>
			</div>
		</div>
	 </section>
</body>
<%  } %>
</html>