<%@page import="entidad.Docente"%>
<%@page import="dao.DocenteDao"%>
<%@page import="presentacion.controller.servletDocente"%>
<%@page import="presentacion.controller.servletNacionalidades"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Localidad"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Agregar Docente</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<script type="text/javascript">
			const validateForm = () => {
				if(document.getElementById("password").value != document.getElementById("confirmPassword").value){
				alert("Las contraseñas deben ser iguales");
					return false;
				} else {
					return true;
				}
			}
			const confirmacionAgregar = () => {
				let name = document.getElementById("nombreApellido").value;
				return confirm("¿Está seguro que desea agregar el docente "+name+"?")
			};
	</script>
</head>
<% 
Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
if(currentUser==null){
	response.sendRedirect("/TPINT_GRUPO_1_LAB4/login.jsp");
	System.out.println("No hay usuario");
} else {%>
<body>
<% 
	ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
	ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) servletDocente.obtenerLocalidades();
	
 %>
 	 <header class="card shadows">	 
		<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
			<button class="common-button">Inicio</button> 
		</a>
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button class="common-button" type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
    <div class="row">
		<div class="form-table card shadows">
		    <h1>Agregar docente</h1>
		    <form action="/TPINT_GRUPO_1_LAB4/servletDocente" method="post" onsubmit="return confirmacionAgregar() && validateForm()">
		        <table>
		            <tr>
		                <td>Dni</td>
		                <td><input type="number" min="0" name="dni" required></td>
		            </tr>
		            <tr>
		                <td>Contraseña</td>
		                <td><input type="password" id="password" name="password" required></td>
		            </tr>
		            <tr>
		                <td>Confirmar contraseña</td>
		                <td><input type="password" id="confirmPassword" name="password2" required></td>
		            </tr>
		            <tr>
		                <td>Nombre y apellido</td>
		                <td><input type="text" name= "nombreApellido" id="nombreApellido" required></td>
		            </tr>
		            <tr>
		                <td>Fecha de nacimiento</td>
		                <td><input type="date" name="fechaNac" required></td>
		            </tr>
		            <tr>
		                <td>Direccion</td>
		                <td><input type="text" name="direccion" required></td>
		            </tr>
		            <tr>
		                <td>Localidad</td>
		                <td>
			                <select name="seleccionarLocalidad" required>
								<%
								if(listaLocalidades!=null)
									for (Localidad loc : listaLocalidades) {
								%>
								<option value="<%=loc.getId()%>"><%=loc.getNombre()%></option>
								<%
									}
								%>
							</select>
						</td>
		            </tr>
		            <tr>
		                <td>Nacionalidad</td>
		                <td>
			                <select name="seleccionarNacionalidad" required>
								<%
								if(listaNacionalidades!=null)
									for (Nacionalidad nac : listaNacionalidades) {
								%>
								<option value="<%=nac.getId()%>"><%=nac.getNombre()%></option>
								<%
									}
								%>
							</select>
						</td>
		            </tr>
		            <tr>
		                <td>Email</td>
		                <td><input type="email" name="email" required></td>
		            </tr>
		            <tr>
		                <td>Telefono</td>
		                <td><input type="number" name="telefono" required></td>
		            </tr>
		        </table>
		        <div class="row">		        
			        <a href="/TPINT_GRUPO_1_LAB4/docentes/listar.jsp">
			        	<button class="common-button danger" type="button">Cancelar</button>
			        </a>
			        <button class="common-button danger" type="submit" name = "btnAgregar">Aceptar</button>
		        </div>
		    </form>
		    
		    <% 
		     	int filas = -1;
		     	if( request.getAttribute("filas") != null ){
			     	filas = (Integer)request.getAttribute("filas");
		     	}
		    	if(filas>0){
		     %>
		    	<p>Docente agregado con exito</p>
		     <%}else if(filas == 0){
		    	 %>
		    	 <p class="danger">El docente no ha podido ser agregado</p>
		     <%}%>
		
		</div>
	</div>
</body>
<%  } %>
</html>