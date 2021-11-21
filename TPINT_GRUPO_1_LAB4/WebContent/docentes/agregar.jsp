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
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
<% 
	ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
	ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) servletDocente.obtenerLocalidades();
	Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
 %>
 	 <header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a>
    <h1>Agregar docente</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletDocente" method="post">
        <table>
            <tr>
                <td>Dni</td>
                <td><input type="number" name="dni"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" name= "nombreApellido"></td>
            </tr>
            <tr>
                <td>Fecha de nacimiento</td>
                <td><input type="date" name="fechaNac"></td>
            </tr>
            <tr>
                <td>Direccion</td>
                <td><input type="text" name="direccion"></td>
            </tr>
            <tr>
                <td>Localidad</td>
                <td>
	                <select name="seleccionarLocalidad">
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
	                <select name="seleccionarNacionalidad">
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
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="text" name="telefono"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/docentes/listar.jsp">
        	<button type="button">Cancelar</button>
        </a>
        <button type="submit" name = "btnAgregar">Aceptar</button>
    </form>
    
    <%
    int filas = 0;
    if(request.getAttribute("FilasAfectadas") != null){
    filas = (int)request.getAttribute("FilasAfectadas");
    }
    %>
    
    <% if(filas==1) 
	{
%>
		Usuario agregado con ï¿½xito
<%} %>
</body>
</html>