<%@page import="dominio.Docente"%>
<%@page import="dominio.DocenteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<button>Inicio</button> 
    <h1>Agregar docente</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletDocente" method="get">
        <table>
            <tr>
                <td>Legajo</td>
                <td>0001</td>
            </tr>
            <tr>
                <td>Dni</td>
                <td><input type="text" name= "tbxDNI"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" name= "tbxNombreApellido"></td>
            </tr>
            <tr>
                <td>Direccion</td>
                <td><input type="text" name= "tbxDireccion"></td>
            </tr>
            <tr>
                <td>Localidad</td>
                <td><select name = "ddlLocalidad"><option value= "1">San Fernando</select></td>
            </tr>
            <tr>
                <td>Nacionalidad</td>
                <td><select name = "ddlNacionalidad"><option value= "1">Argentina</select></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name= "tbxEmail"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="text" name= "tbxTelefono"></td>
            </tr>
        </table>
        <button>Cancelar</button><button type="submit" name = "btnAgregar">Aceptar</button>
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
		Usuario agregado con éxito
<%} %>
</body>
</html>