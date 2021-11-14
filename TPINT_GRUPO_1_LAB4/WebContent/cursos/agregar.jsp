<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Agregar curso</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletCurso" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td>0001</td>
            </tr>
            <tr>
                <td>Materia</td>
                <td>
                    <select name="idmateria">
                        <option value="1">LAB 4</option>
                    </select>
                </td>
            </tr>
             <tr>
                <td>Semestre</td>
                <td>
                    <select name="semestre">
                        <option value="1">Primer semestre</option>
                        <option value="2">Segundo semestre</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Docente</td>
                <td>
                    <select name="docente">
                        <option value="1">nombre apellido legajo</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Año</td>
                <td><input type="number" name="año"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/cursos/listar.jsp"><button type="button">Cancelar</button></a><button type="submit" name="btnAgregar">Aceptar</button>
    </form>
    
	 <%
    int filas = 0;
    if(request.getAttribute("FilasAfectadas") != null){
    filas = (int)request.getAttribute("FilasAfectadas");
    }
    %>
    
    <% if(filas==1) 
	{
%>
		Usuario agregado con exito
<%} %>
     
</body>
</html>