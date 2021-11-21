<%@page import="presentacion.controller.servletCurso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
   <%@page import="java.util.ArrayList"%>
<%@page import="entidad.Curso"%>
<%@page import="entidad.Materia"%>
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
		String semestre;
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		ArrayList<Curso> listaCursos;
		String anioABuscar = request.getParameter("anio"); 
		if(anioABuscar != null && anioABuscar !=""){
			listaCursos = (ArrayList<Curso>) servletCurso.obtenerCursos(anioABuscar);
		}else{
			listaCursos = (ArrayList<Curso>) servletCurso.obtenerCursos();
		}
	
	 %>
 	 <header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesi�n</button>
		</form>
	 </header>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
	<h1>Cursos</h1>
    <form action="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp" method="get">
        buscar por a�o
        <input type="number" name="anio" value="<%=request.getParameter("anio")%>">
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
                <th>A�o</th>
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
                <td> <a href="/TPINT_GRUPO_1_LAB4/cursos/listarAlumnos.jsp?idCurso=<%=cur.getId()%>"> <button>Ver alumnos</button></a> <a href="/TPINT_GRUPO_1_LAB4/cursos/agregarAlumnos.jsp?idCurso=<%=cur.getId()%>"><button>Agregar alumnos</button></a> </td>
            </tr>
          <%  } %>
        </tbody>
    </table>
</body>
</html>