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
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
	<script type="text/javascript">
		const validateForm = () => {
			if(! document.querySelectorAll("input[name='chbkNotas']:checked").length>0){
			alert("Selecione almenos un alumno para modificar nota.");
				return false;
			} else {
				return true;
			}
		}
		const validateFormEstadoMasivo = () => {
			if(! document.querySelectorAll("input[name='chbkEstado']:checked").length>0){
			alert("Selecione almenos un alumno para modificar estado.");
				return false;
			} else {
				return true;
			}
		}
		const confirmacionModificarEstado = (na)=> confirm("¿Está seguro de que desea el estado del alumno "+na+"?");
		const confirmacionModificarEstadoMasivo = ()=> confirm("¿Está seguro de que desea modificar el estado de los alumnos?");
		const confirmacionModificarNota = ()=> confirm("¿Está seguro de que desea modificar la nota de los alumnos?");
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
		
		ArrayList<Nota> listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso);
		
		String legajoaBuscar = request.getParameter("buscarLegajo");
		
		if(legajoaBuscar != null && legajoaBuscar !=""){
			listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso, Integer.parseInt(legajoaBuscar));
		}else{
			listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso);
		}
		
	 %>
	<header class="card shadows">	 
	 	<h1>Bienvenido <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button class="common-button" type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button class="common-button">Inicio</button> 
	</a> 
	<h1>Alumnos en el curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="/TPINT_GRUPO_1_LAB4/cursos/listarAlumnos.jsp" method="get">
        Buscar por legajo
        <input type="number" name="buscarLegajo" min="0" value="<%=legajoaBuscar%>" >
        <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
        <button class="common-button secondary" type="submit">Buscar</button>
    </form>
    <div>    
	    <%  
		if(listaNotas!=null && !currentUser.isAdmin())
			for(Nota nota : listaNotas) 
		{
		%>
	    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" method="post" id="formularioEstado-<%=nota.getAlumno().getLegajo()%>" onsubmit="return confirmacionModificarEstado('<%=nota.getAlumno().getNombreApellido()%>')"></form>
		<%} %>
		<form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" method="post" id="formularioEstadoMasivo" onsubmit="return validateFormEstadoMasivo() && confirmacionModificarEstadoMasivo()"></form>
    </div>

    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" onsubmit="return validateForm() && confirmacionModificarNota()" method="post" name="formularioNota">
    <div class="card shadows">
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
		                <th>Modificar estado individual</th>
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
			                <td><input type="checkbox" name="chbkEstado" value="<%=nota.getAlumno().getLegajo() %>" form="formularioEstadoMasivo" /></td>
			                <td>
				                	<select name="estado" form="formularioEstado-<%=nota.getAlumno().getLegajo()%>" value="<%=nota.getEstado().getId()%>"> 
						                <option value="1" <%=nota.getEstado().getId()==2?"selected":"" %>>Regular</option>
						                <option value="2" <%=nota.getEstado().getId()==2?"selected":"" %>>Libre</option>  
					                </select>
					                <input name="idCurso" type ="text" hidden="true" form="formularioEstado-<%=nota.getAlumno().getLegajo()%>" value="<%=idCurso%>">
					                <input name="legajo" type ="text"hidden="true" form="formularioEstado-<%=nota.getAlumno().getLegajo()%>" value="<%=nota.getAlumno().getLegajo()%>">
					                <button type="submit" name="btnGuardarEstado" form="formularioEstado-<%=nota.getAlumno().getLegajo()%>">Guardar estado</button>
			                </td>
						<%} %>
					</tr>
				<%  } %>
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
	    <%
         	if(!currentUser.isAdmin())
		{%>
		<h2>Modificacion masiva</h2>
		<div class="row">
			<div class="col">
				<h3>Notas</h3>
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
		        	<% 
				     	int filasNotas = -1;
				     	if( request.getAttribute("filasNotas") != null ){
					     	filasNotas = (Integer)request.getAttribute("filasNotas");
				     	}
				    	if(filasNotas>0){
				     %>
				    	<p>Nota modificada con exito</p>
				     <%}else if(filasNotas == 0){
				    	 %>
				    	 <p>La nota no ha podido ser modificada</p>
				     <%}%>
			</div>
			<div class="col">
				<h3>Estado</h3>
				<select name="estado"  form="formularioEstadoMasivo" > 
	                <option value="1">Regular</option>
	                <option value="2">Libre</option>  
                </select>
                <input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>"  form="formularioEstadoMasivo">
                <button type="submit" name="btnGuardarEstadoMasivo"  form="formularioEstadoMasivo" >Guardar estado</button>
                <% 
				     	int filasEstadoMasivo = -1;
				     	if( request.getAttribute("filasEstadoMasivo") != null ){
					     	filasEstadoMasivo = (Integer)request.getAttribute("filasEstadoMasivo");
				     	}
				    	if(filasEstadoMasivo>0){
				     %>
				    	<p>Estado modificado con exito</p>
				     <%}else if(filasEstadoMasivo == 0){
				    	 %>
				    	 <p>El estado no ha podido ser modificado</p>
				     <%}%>
			</div>
		</div>
		<%} %>
    </form>
    <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button class="common-button danger" type="button">Volver</button></a>
	
    <% int filasEstado = -1;
     	if( request.getAttribute("filasEstado") != null ){
	     	filasEstado = (Integer)request.getAttribute("filasEstado");
     	}
    	if(filasEstado>0){
     %>
    	<script type="text/javascript">
			alert("El estado del alumno ha sido modificado con exito");
		</script>
     <%}else if(filasEstado == 0){
    	 %>
    	 <script type="text/javascript">
			alert("El estado del alumno no ha podido ser modificado");
		</script>
     <%}%>
     
	
</body>
<%  } %>
</html>