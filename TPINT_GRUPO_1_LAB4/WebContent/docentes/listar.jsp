<%@page import="presentacion.controller.servletDocente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Docente"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>

<% 
	Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
	ArrayList<Docente> listaDocentes;
	String legajoaBuscar = request.getParameter("buscarLegajo");
	if(legajoaBuscar != null && legajoaBuscar !=""){
		listaDocentes = (ArrayList<Docente>) servletDocente.obtenerDocentes(request.getParameter("buscarLegajo"));
	}else{
		listaDocentes = (ArrayList<Docente>) servletDocente.obtenerDocentes();
	}
	
	
%>
<body>
	 <header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>

	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Listar docentes</h1>

    <form action="listar.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" value="<%=legajoaBuscar%>" >
        <button type="submit">Buscar</button>
    </form>
    <a href="agregar.jsp">
		<button>Agregar nuevo docente</button> 
    </a>
    <table id="myTable">
        <thead>
            <tr>
                <th>Legajo</th>
                <th>Dni</th>
                <th>Nombre y apellido</th>
                <th>Direccion</th>
                <th>Localidad</th>
                <th>Nacionalidad</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Accion</th>
            </tr>
        </thead>
        <tbody>
			<%  
			if(listaDocentes!=null)
			for(Docente doc : listaDocentes) 
			{
			%>
				<tr>
					<td><%=doc.getLegajo() %></td>
	                <td><%=doc.getDni() %></td>
	                <td><%=doc.getNombreApellido() %></td>
	                <td><%=doc.getDireccion() %></td>
	                <td><%=doc.getLocalidad().getNombre()%></td>
	                <td><%=doc.getNacionalidad().getNombre()%></td>
	                <td><%=doc.getEmail() %></td>
	                <td><%=doc.getTelefono() %></td>
	                <td> <a href="modificar.jsp?legajo=<%=doc.getLegajo() %>"><button>Modificar</button></a>
				    <form action="/TPINT_GRUPO_1_LAB4/servletDocente" method="post">
				        <input name="legajo" type ="text" hidden="true" value="<%=doc.getLegajo()%>">
				        <button name="btnEliminar" type="submit" value="eliminar">Eliminar</button>
				    </form>
				    </td>
				</tr>
			<%  } %>
        </tbody>
    </table>
</body>
</html>