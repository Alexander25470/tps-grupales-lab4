<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="presentacion.controller.servletCurso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	int idCurso = Integer.parseInt(request.getParameter("idCurso"));
	ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) servletCurso.obtenerAlumnosQueNoEstanEnCurso(idCurso);
 %>
	<a href="../inicio.jsp">
		<button>Inicio</button> 
	</a> 
	<h1>Agregar almunos al curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="" method="get">
        Buscar por legajo
        <input type="text">
        <button type="submit">Buscar</button>
    </form>

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
	                <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post">
				        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
				        <button name="btnAgregar" type="submit" value="eliminar">Agregar</button>
				    </form>
				    </td>
				</tr>
			<%  } %>
        </tbody>
    </table>
     <a href="listar.jsp"><button type="button">Volver</button>
</body>
</html>