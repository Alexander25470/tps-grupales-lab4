<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="presentacion.controller.servletCurso"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
	<% 
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		String legajoaBuscar = request.getParameter("buscarLegajo");
		ArrayList<Alumno> listaAlumnos;
		
		if(legajoaBuscar != null && legajoaBuscar !=""){
			listaAlumnos = (ArrayList<Alumno>) servletCurso.obtenerAlumnosQueNoEstanEnCurso(idCurso,Integer.parseInt(legajoaBuscar));
		}else{
			listaAlumnos = (ArrayList<Alumno>) servletCurso.obtenerAlumnosQueNoEstanEnCurso(idCurso);
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
	<h1>Agregar almunos al curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="/TPINT_GRUPO_1_LAB4/cursos/agregarAlumnos.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" value="<%=legajoaBuscar%>" >
        <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
        <button type="submit" name="">Buscar</button>
    </form>

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
                <th>Acci�n</th>
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
	                <form action="/TPINT_GRUPO_1_LAB4/servletNota" method="post">
				        <input name="legajo" type ="text" hidden="true" value="<%=al.getLegajo()%>">
				        <input name="idCurso" type ="text" hidden="true" value="<%=request.getParameter("idCurso")%>">
				        <button name="btnAgregar" type="submit">Agregar</button>
				    </form>
				    </td>
				</tr>
			<%  } %>
        </tbody>
    </table>
    <script type="text/javascript">
	    	$(document).ready( () => {
			    $('#myTable').DataTable();
			} );
	 </script>
     <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button type="button">Volver</button>
</body>
</html>