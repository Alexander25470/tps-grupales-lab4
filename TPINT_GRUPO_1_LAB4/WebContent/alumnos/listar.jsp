<%@page import="presentacion.controller.servletAlumnos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<title>Listar alumnos</title>
	<script type="text/javascript">
		const confirmacionEliminar = (na)=> confirm("¿Está seguro de que desea eliminar al alumno "+na+"?");
	</script>
</head>
<% 
Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
if(currentUser==null){
	response.sendRedirect("/TPINT_GRUPO_1_LAB4/login.jsp");
	System.out.println("No hay usuario");
} else {%>
<% 
	ArrayList<Alumno> listaAlumnos;
	String legajoaBuscar = request.getParameter("buscarLegajo"); 
	if(legajoaBuscar != null && legajoaBuscar !=""){
		listaAlumnos = (ArrayList<Alumno>) servletAlumnos.obtenerAlumnos(legajoaBuscar);
	}else{
		listaAlumnos = (ArrayList<Alumno>) servletAlumnos.obtenerAlumnos();
	}

%>
<body>
 	
	<header class="card shadows">	 
		<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
			<button class="common-button">Inicio</button> 
		</a> 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button class="common-button danger" type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
  	
    <h1>Listar alumnos</h1>

    <form action="listar.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" value="<%=legajoaBuscar%>" >
        <button class="common-button secondary" type="submit">Buscar</button>
    </form>
    <a href="agregar.jsp">
		<button class="common-button secondary">Agregar nuevo alumno</button>
    </a>
    <div class="card shadows">
	    <table id="myTable">
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
	                <th>Acciones</th>
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
		                <td><a href="/TPINT_GRUPO_1_LAB4/alumnos/modificar.jsp?legajo=<%=al.getLegajo()%>"><button class="common-button secondary">Modificar</button></a>
		                <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post" onsubmit="return confirmacionEliminar('<%=al.getNombreApellido()%>')">
					        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
					        <button class="common-button danger" name="btnEliminar" type="submit" value="eliminar">Eliminar</button>
					    </form>
					    </td>
					</tr>
				<%  } %>
	        </tbody>
	    </table>
    </div>
     <% int filasEliminado = -1;
     	if( request.getAttribute("filasEliminado") != null ){
	     	filasEliminado = (Integer)request.getAttribute("filasEliminado");
     	}
    	if(filasEliminado>0){
     %>
    	<script type="text/javascript">
			alert("El alumno ha sido eliminado con exito");
		</script>
     <%}else if(filasEliminado == 0){
    	 %>
    	 <script type="text/javascript">
			alert("El alumno no ha podido ser eliminado");
		</script>
     <%}%>
    <script type="text/javascript">
    	$(document).ready( () => {
		    $('#myTable').DataTable({
			    	searching: false,
			    });
		} );
    </script>
</body>
<%  } %>
</html>