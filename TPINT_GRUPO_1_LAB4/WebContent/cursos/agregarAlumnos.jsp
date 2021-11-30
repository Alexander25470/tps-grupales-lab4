<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Curso"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="presentacion.controller.servletCurso"%>
<%@page import="presentacion.controller.servletCurso"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Agregar Alumnos a Curso</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	
	<script type="text/javascript">
	const confirmacionAgregar = (na)=> confirm("¿Está seguro que desea agregar al alumno "+na+"?");
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
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		Curso cur = servletCurso.obtenerCurso(idCurso);
		String legajoaBuscar = request.getParameter("buscarLegajo");
		ArrayList<Alumno> listaAlumnos;
		
		if(legajoaBuscar != null && legajoaBuscar !=""){
			listaAlumnos = (ArrayList<Alumno>) servletCurso.obtenerAlumnosQueNoEstanEnCurso(idCurso,Integer.parseInt(legajoaBuscar));
		}else{
			listaAlumnos = (ArrayList<Alumno>) servletCurso.obtenerAlumnosQueNoEstanEnCurso(idCurso);
		}
	 %>
	 <header class="card shadows">
		<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
			<button class="common-button">Inicio</button> 
		</a> 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button class="common-button danger" type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	
	<h1>Alumnos en el curso: <%=cur.toString() %></h1>

    <form action="/TPINT_GRUPO_1_LAB4/cursos/agregarAlumnos.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" min="0" value="<%=legajoaBuscar%>" >
        <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
        <button class="common-button secondary" type="submit" name="">Buscar</button>
    </form>
    
	<div class="card shadows">
	    <table  id="myTable">
	        <thead>
	            <tr>
	                <th>Legajo</th>
	                <th>Dni</th>
	                <th>Nombre y apellido</th>
	                <th>Direccion</th>
	                <th>Nacionalidad</th>
	                <th>Provincia</th>
	                <th>Email</th>
	                <th>Telefono</th>
	                <th>Acción</th>
	            </tr>
	        </thead>
	        <tbody>
	           	<%  
					if(listaAlumnos!=null)
					for(Alumno al : listaAlumnos) 
				{
				%>
					<tr>
						<td><%=al.getLegajo() %></td>
		                <td><%=al.getDni() %></td>
		                <td><%=al.getNombreApellido() %></td>
		                <td><%=al.getDireccion() %></td>
		                <td><%=al.getNacionalidad().getNombre()%></td>
		                <td><%=al.getProvincia().getNombre() %></td>
		                <td><%=al.getEmail() %></td>
		                <td><%=al.getTelefono() %></td>
		                <td>
		                <form action="/TPINT_GRUPO_1_LAB4/servletNota" method="post" onsubmit="return confirmacionAgregar('<%=al.getNombreApellido()%>')">
					        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
					        <input name="idCurso" type ="text" hidden="true" value="<%=request.getParameter("idCurso")%>">
					        <button class="common-button" name="btnAgregar" type="submit">Agregar</button>
					    </form>
					    </td>
					</tr>
				<%  } %>
	        </tbody>
	    </table>
	</div>
    <% int filas = -1;
     	if( request.getAttribute("filas") != null ){
	     	filas = (Integer)request.getAttribute("filas");
     	}
    	if(filas>0){
     %>
    	<script type="text/javascript">
			alert("El alumno ha sido agregado al curso con exito");
		</script>
     <%}else if(filas == 0){
    	 %>
    	 <script type="text/javascript">
			alert("El alumno no ha podido ser agregado al curso");
		</script>
     <%}%>
    <script type="text/javascript">
	    	$(document).ready( () => {
			    $('#myTable').DataTable({
			    	searching: false,
			    });
			} );
	 </script>
     <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button class="common-button danger" type="button">Volver</button>
</body>
<%} %>
</html>