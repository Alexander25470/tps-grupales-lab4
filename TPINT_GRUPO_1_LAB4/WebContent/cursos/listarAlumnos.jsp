<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nota"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="presentacion.controller.servletNota"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
			const validateForm = () => {
				if(! document.querySelectorAll("input[name='chbkNotas']:checked").length>0){
				alert("Selecione almenos un alumno para modificar nota");
					return false;
				} else {
					return true;
				}
			}
	</script>
</head>
<body>
	<% 
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
		ArrayList<Nota> listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso);
		
		String legajoaBuscar = request.getParameter("buscarLegajo");
		
		if(legajoaBuscar != null && legajoaBuscar !=""){
			listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso, Integer.parseInt(legajoaBuscar));
		}else{
			listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso);
		}
		
	 %>
	<header>	 
	 	<h1>Bienvenido <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
	<h1>Alumnos en el curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="/TPINT_GRUPO_1_LAB4/cursos/listarAlumnos.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" min="0" value="<%=legajoaBuscar%>" >
        <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
        <button type="submit">Buscar</button>
    </form>

    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" onsubmit="return validateForm()" method="post">
	    <table id="myTable">
	        <thead>
	            <tr>
	                <th>Legajo</th>
	                <th>Apellido y nombre</th>
	                <th>Nota parcial 1</th>
	                <th>Nota parcial 2</th>
	                <th>Recuperatorio 1</th>
	                <th>Recuperatorio 2</th>
	                <th>Estado</th>
	                <%
	                if(!currentUser.isAdmin())
					{%>
		                <th>Modificar nota</th>
		                <th>Modificar estado</th>
					<%} %>
	            </tr>
	        </thead>
	        <tbody>
	            <%  
				if(listaNotas!=null)
				for(Nota nota : listaNotas) 
			{
			%>
				<tr>
					<td><%=nota.getAlumno().getLegajo() %></td>
	                <td><%=nota.getAlumno().getNombreApellido()%></td>
	                <td><%=nota.getParcial1()%></td>
	                <td><%=nota.getParcial2()%></td>
	                <td><%=nota.getRecuperatorio1()%></td>
	                <td><%=nota.getRecuperatorio2()%></td>
	                <td><%=nota.getEstado().getDescripcion()%></td>
	                <%
	                if(!currentUser.isAdmin())
					{%>
		                <td><input type="checkbox" name="chbkNotas" value="<%=nota.getAlumno().getLegajo() %>" /></td>
		                <td>
		                <form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" method="post"> 
		                	<select name="estado" value="<%=nota.getEstado().getId()%>"> 
				                <option value="1" <%=nota.getEstado().getId()==2?"selected":"" %>>Regular</option>
				                <option value="2" <%=nota.getEstado().getId()==2?"selected":"" %>>Libre</option>  
			                </select>
			                <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
			                <input name="legajo" type ="text"hidden="true" value="<%=nota.getAlumno().getLegajo()%>">
			                <button type="submit" name="btnGuardarEstado">Guardar estado</button> </td>
		                </form>
					</tr>
					<%} %>
			<%  } %>
	        </tbody>
	    </table>
		<script type="text/javascript">
	    	$(document).ready( () => {
			    $('#myTable').DataTable();
			} );
	    </script>
	    <%
         	if(!currentUser.isAdmin())
		{%>
	   		<p>Seleccione la nota a modificar/cargar</p>
	    	<select name="examen">
	    		<option value="parcial1">Nota parcial 1</option>
	    		<option value="parcial2">Nota parcial 2</option>
	    		<option value="recuperatorio1">Recuperatorio 1</option>
	    		<option value="recuperatorio2">Recuperatorio 2</option>
	    	</select>
	    	<input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
	    	<p>Ingrese la nota</p>
	    	<input type="number" name="nota" min="0" max="10" required/> <br/> <br/>
	        <button type="submit" name="btnModificar">Modificar</button>
		<%} %>
    </form>
    <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button type="button">Volver</button></a>
	
	<% 
     	int filas = -1;
     	if( request.getAttribute("filas") != null ){
	     	filas = (Integer)request.getAttribute("filas");
     	}
    	if(filas>0){
     %>
    	<p>Nota modificada con exito</p>
     <%}else if(filas == 0){
    	 %>
    	 <p>La nota no ha podido ser modificada</p>
     <%}%>
     
	
</body>
</html>