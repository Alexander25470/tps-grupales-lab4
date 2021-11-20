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
    <h1>Modificar docente</h1>
    
    <form action="" method="post">
        <table>
            <tr>
                <td>Legajo</td>
                <td><%= request.getParameter("legajo") %></td>
                <input type="text" name="legajo" value="<%= request.getParameter("legajo") %>" hidden="true"/>
            </tr>
            <tr>
                <td>Dni</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>Direccion</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>Localidad</td>
                <td><select><option>San Fernando</select></td>
            </tr>
            <tr>
                <td>Nacionalidad</td>
                <td><select><option>Argentina</select></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="text"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/docentes/listar.jsp"><button type="button">Cancelar</button></a><button type="submit">Aceptar</button>
    </form> 

</body>
</html>