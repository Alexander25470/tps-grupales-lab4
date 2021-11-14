<%@page import="presentacion.controller.servletCurso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
   <%@page import="java.util.ArrayList"%>
<%@page import="entidad.Curso"%>
<%@page import="entidad.Materia"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
    table{
        border-collapse: collapse;
    }
    td, th{
        padding: .25rem;
        border: 1px solid black;
    }
</style>
<title>Insert title here</title>
</head>
<body>
<% 
	ArrayList<Curso> listaCursos = (ArrayList<Curso>) servletCurso.obtenerCursos();
	String semestre;
 %>
	<a href="../inicio.jsp">
		<button>Inicio</button> 
	</a> 
	<h1>Cursos</h1>
    <form action="" method="get">
        buscar por año
        <input type="text">
        <button type="submit">Buscar</button>
    </form>
    <a href="agregar.jsp">
		<button>Agregar nuevo curso</button>
    </a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Materia</th>
                <th>Nombre Apellido profesor</th>
                <th>Semestre</th>
                <th>Año</th>
                <th>Accion</th>
            </tr>
        </thead>
        <tbody>
        <%
        if(listaCursos!=null)
			for(Curso cur : listaCursos) 
			{
			if(cur.getSemestre() == 1){
				semestre = "Primer semestre";
			}else{
				semestre = "Segundo semestre";
			};
			%>
            <tr>
                <td><%=cur.getId() %></td>
                <td><%=cur.getMateria().getNombre() %></td>
                <td><%=cur.getDocente().getNombreApellido() %></td>
                <td><%=semestre %></td>
                <td><%=cur.getAnio() %></td>
                <td><button>Ver alumnos</button> <button>Agregar alumnos</button></td>
            </tr>
          <%  } %>
        </tbody>
    </table>
</body>
</html>