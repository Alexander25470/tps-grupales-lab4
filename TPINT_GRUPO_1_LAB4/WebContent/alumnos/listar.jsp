<%@page import="presentacion.controller.servletAlumnos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
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
	<a href="../inicio.jsp">
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
    
    <table>
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
	                <td><a href="modificar.jsp?legajo=<%=al.getLegajo()%>"><button>Modificar</button></a>
	                <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post">
				        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
				        <button name="btnEliminar" type="submit" value="eliminar">Eliminar</button>
				    </form>
				    </td>
				</tr>
			<%  } %>
        </tbody>
    </table>
</body>
</html>