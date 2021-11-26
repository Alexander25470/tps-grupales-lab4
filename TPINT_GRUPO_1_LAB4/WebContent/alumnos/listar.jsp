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
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<title>Listar alumnos</title>
	<script type="text/javascript">
		const confirmacionEliminar = (na)=> confirm("�Est� seguro de que desea eliminar al alumno "+na+"?");
	</script>
</head>

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
 	<% Usuario currentUser = (Usuario)(session.getAttribute("usuario"));%>
	<header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesi�n</button>
		</form>
	 </header>
  	
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Listar alumnos</h1>

    <form action="listar.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" value="<%=legajoaBuscar%>" >
        <button type="submit">Buscar</button>
    </form>
    <a href="agregar.jsp">
		<button>Agregar nuevo alumno</button>
    </a>
    
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
	                <td><a href="/TPINT_GRUPO_1_LAB4/alumnos/modificar.jsp?legajo=<%=al.getLegajo()%>"><button>Modificar</button></a>
	                <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post" onsubmit="return confirmacionEliminar('<%=al.getNombreApellido()%>')">
				        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
				        <button name="btnEliminar" type="submit" value="eliminar">Eliminar</button>
				    </form>
				    </td>
				</tr>
			<%  } %>
        </tbody>
    </table>
    <script type="text/javascript">
    	$(document).ready( () => {
		    $('#myTable').DataTable({
			    	searching: false,
			    });
		} );
    </script>
</body>
</html>