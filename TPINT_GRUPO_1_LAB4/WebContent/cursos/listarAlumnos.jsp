<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nota"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="presentacion.controller.servletNota"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
        border-collapse: collapse;
    }
    td, th{
        padding: .25rem;
        border: 1px solid black;
    }
</style>
</head>
<body style="height: 335px; ">
<% 
	int idCurso = Integer.parseInt(request.getParameter("idCurso"));
	ArrayList<Nota> listaNotas = (ArrayList<Nota>) servletNota.obtenerNotasCurso(idCurso);
 %>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
	<h1>Alumnos en el curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="" method="get">
        Buscar por legajo
        <input type="text">
        <button type="submit">Buscar</button>
    </form>

    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnosCursos" method="post">
	    <table>
	        <thead>
	            <tr>
	                <th>Legajo</th>
	                <th>Apellido y nombre</th>
	                <th>Nota parcial 1</th>
	                <th>Nota parcial 2</th>
	                <th>Recuperatorio 1</th>
	                <th>Recuperatorio 2</th>
	                <th>Estado</th>
	                <th>Modificar nota</th>
	                <th>Modificar estado</th>
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
	                <td><input type="checkbox" name="chbkNotas" value="<%=nota.getAlumno().getLegajo() %>"/></td>
	                <td>  <form> <select name="estado"> <option value="1">Regular</option> </select> <button>Guardar estado</button> </form> </td>
				</tr>
			<%  } %>
	        </tbody>
	    </table>
   		<p>Seleccione la nota a modificar/cargar</p>
    	<select name="examen">
    		<option value="parcial1">Nota parcial 1</option>
    		<option value="parcial2">Nota parcial 2</option>
    		<option value="recuperatorio1">Recuperatorio 1</option>
    		<option value="recuperatorio2">Recuperatorio 2</option>
    	</select>
    	<input name="idCurso" type ="text" hidden="true" value="<%=idCurso%>">
    	<p>Ingrese la nota</p>
    	<input type="text" name="nota"/> <br/> <br/>
        <button type="submit" name="btnModificar">Modificar</button>
    </form>
    
    <button>Volver</button>

</body>
</html>