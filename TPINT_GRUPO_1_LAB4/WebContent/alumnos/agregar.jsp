<%@page import="presentacion.controller.servletNacionalidades"%>
<%@page import="presentacion.controller.servletAlumnos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Provincia"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
<% 
	ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
	ArrayList<Provincia> listaProvincias = (ArrayList<Provincia>) servletAlumnos.obtenerProvincias();
 %>
 	<% Usuario currentUser = (Usuario)(session.getAttribute("usuario"));%>
	 <header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	 
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Agregar alumno</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post">
        <table>
            <tr>
                <td>Dni</td>
                <td><input type="number" name="dni" required></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" name="nombreApellido" required></td>
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
                <td>Nacionalidad</td>
                <td> <select name="seleccionarNacionalidad" required>
						<%
						if(listaNacionalidades!=null)
							for (Nacionalidad nac : listaNacionalidades) {
						%>
						<option value="<%=nac.getId()%>"><%=nac.getNombre()%></option>
						<%
							}
						%>
				</select> </td>
            </tr>
            <tr>
                <td>Provincia</td>
                <td> <select name="seleccionarProvincia" required>
						<%
						if(listaProvincias!=null)
							for (Provincia prov : listaProvincias) {
						%>
						<option value="<%=prov.getId()%>"><%=prov.getNombre()%></option>
						<%
							}
						%>
				</select> </td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" required></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="number" name="telefono" required></td>
            </tr>
        </table>
        <a></a>
        <a href="/TPINT_GRUPO_1_LAB4/alumnos/listar.jsp"><button type="button">Volver</button> <button type="submit" name="btnAgregar">Aceptar</button>
    </form> 
</body>
</html>