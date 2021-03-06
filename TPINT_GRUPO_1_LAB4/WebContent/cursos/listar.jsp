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
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listar Cursos</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
	<% 
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		if(session.getAttribute("usuario") == null){
			response.sendRedirect("/TPINT_GRUPO_1_LAB4/login.jsp");
			System.out.println("No hay usuario");
		} else {
			String anioABuscar = request.getParameter("anio");
			listaCursos = (ArrayList<Curso>) servletCurso.obtenerCursos(anioABuscar, currentUser.getLegajoDocente());
		}
		
	 %>
 	 <%if(currentUser != null) {%>
	 	 <header class="card shadows">
		 	 <a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
				<button class="common-button">Inicio</button> 
			</a> 
		 	<h1>Usuario <%=currentUser.getNombre()%></h1>
			<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
				<button class="common-button danger" type="submit" name="cerrarSesion">Cerrar sesi?n</button>
			</form>
		 </header>
	<%} %>
	
	<h1>Cursos</h1>
    <form action="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp" method="get">
        Buscar por a?o
        <input type="number" name="anio" min="0" value="<%=request.getParameter("anio")%>">
       <button class="common-button secondary" type="submit">Buscar</button>
    </form>
    <br/>
    <% 
	if(currentUser != null && currentUser.isAdmin())
	{%>	
	    <a href="agregar.jsp">
			<button class="common-button secondary">Agregar nuevo curso</button>
	    </a>
	<%} %>
    <div class="card shadows">
	    <table id="myTable">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>Materia</th>
	                <th>Nombre Apellido profesor</th>
	                <th>Semestre</th>
	                <th>A?o</th>
	                <th>Accion</th>
	            </tr>
	        </thead>
	        <tbody>
	        <%
	        if(listaCursos!=null)
				for(Curso cur : listaCursos) 
				{
					String semestre;
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
	                <td>
	                
		                <a href="/TPINT_GRUPO_1_LAB4/cursos/listarAlumnos.jsp?idCurso=<%=cur.getId()%>">
		               	 <button class="common-button secondary">Ver alumnos</button>
		                </a>
		                <% 
						if(currentUser != null && currentUser.isAdmin())
						{%>	
		                <a href="/TPINT_GRUPO_1_LAB4/cursos/agregarAlumnos.jsp?idCurso=<%=cur.getId()%>">
		                	<button class="common-button secondary">Agregar alumnos</button>
		                </a>
		                <%} %>
	                </td>
	            </tr>
	          <% } %>
		        </tbody>
		    </table>
    </div>
        <script type="text/javascript">
	    	$(document).ready( () => {
			    $('#myTable').DataTable({
			    	searching: false,
			    });
			} );
	    </script>
</body>
</html>