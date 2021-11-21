<%@page import="presentacion.controller.servletCurso"%>
<%@page import="presentacion.controller.servletDocente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="entidad.Materia"%>
<%@page import="entidad.Docente"%>
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
		ArrayList<Materia> listaMaterias = (ArrayList<Materia>) servletCurso.obtenerMaterias();
		ArrayList<Docente> listaDocentes = (ArrayList<Docente>) servletDocente.obtenerDocentes();
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
    <h1>Agregar curso</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletCurso" method="post">
        <table>
            <tr>
                <td>Materia</td>
                <td>
                    <select name="seleccionarMateria">
						<%
						if(listaMaterias!=null)
							for (Materia mat : listaMaterias) {
						%>
						<option value="<%=mat.getId()%>"><%=mat.getNombre()%></option>
						<%
							}
						%>
				</select>
                </td>
            </tr>
             <tr>
                <td>Semestre</td>
                <td>
                    <select name="semestre">
                        <option value="1">Primer semestre</option>
                        <option value="2">Segundo semestre</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Docente</td>
                <td>
                    <select name="seleccionarProfesor">
						<%
						if(listaDocentes!=null)
							for (Docente doc : listaDocentes) {
						%>
						<option value="<%=doc.getLegajo()%>"><%=doc.getNombreApellido()%></option>
						<%
							}
						%>
				</select>
                </td>
            </tr>
            <tr>
                <td>Año</td>
                <td><input type="number" name="año"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button type="button">Cancelar</button></a><button type="submit" name="btnAgregar">Aceptar</button>
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
		Usuario agregado con exito
<%} %>
     
</body>
</html>