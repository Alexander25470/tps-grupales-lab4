<%@page import="presentacion.controller.servletNacionalidades"%>
<%@page import="presentacion.controller.servletAlumnos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Provincia"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
	ArrayList<Provincia> listaProvincias = (ArrayList<Provincia>) servletAlumnos.obtenerProvincias();
 %>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Agregar alumno</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post">
        <table>
            <tr>
                <td>Dni</td>
                <td><input type="number" name="dni"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" name="nombreApellido"></td>
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
                <td>Nacionalidad</td>
                <td> <select name="seleccionarNacionalidad">
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
                <td> <select name="seleccionarProvincia">
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
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="number" name="telefono"></td>
            </tr>
        </table>
        <a></a>
        <a href="/TPINT_GRUPO_1_LAB4/alumnos/listar.jsp"><button type="button">Volver</button> <button type="submit" name="btnAgregar">Aceptar</button>
    </form> 
</body>
</html>