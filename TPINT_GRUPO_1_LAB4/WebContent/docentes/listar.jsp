<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
	<button>Inicio</button> 
    <h1>Listar docentes</h1>

    <form action="" method="get">
        Buscar por legajo
        <input type="text">
        <button type="submit">Buscar</button>
    </form>
	<button>Agregar nuevo docente</button> 
    <table>
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
            <tr>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td> <button>Modificar</button> <button>Eliminar</button> </td>
            </tr>
            <tr>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td> <button>Modificar</button> <button>Eliminar</button> </td>
            </tr>
            <tr>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td>texto</td>
                <td> <button>Modificar</button> <button>Eliminar</button> </td>
            </tr>
        </tbody>
    </table>
</body>
</html>