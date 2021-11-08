<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<button>Inicio</button>
	<h1>Alumnos en el curso PROG 4 2020 SEMESTRE 2</h1>

    <form action="" method="get">
        Buscar por legajo
        <input type="text">
        <button type="submit">Buscar</button>
    </form>

    <form action="" method="get">
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
	            <tr>
	                <td>texto</td>
	                <td>texto</td>
	                <td>10</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td><input type="checkbox"/></td>
	                <td>  <form> <select> <option>Regular</option> </select> <button>Guardar estado</button> </form> </td>
	            </tr>
	            <tr>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td><input type="checkbox"/></td>
	                <td>  <form> <select> <option>Libre</option> </select> <button>Guardar estado</button> </form> </td>
	            </tr>
	            <tr>
	                <td>texto</td>
	                <td>texto</td>
	                <td>10</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td>texto</td>
	                <td><input type="checkbox"/></td>
	                <td>  <form> <select> <option>Regular</option> </select> <button>Guardar estado</button> </form> </td>
	            </tr>
	        </tbody>
	    </table>
   		<p>Seleccione la nota a modificar/cargar</p>
    	<select>
    		<option>Nota parcial 1</option>
    		<option>Nota parcial 2</option>
    		<option>Recuperatorio 1</option>
    		<option>Recuperatorio 2</option>
    	</select>
    	<p>Ingrese la nota</p>
    	<input type="text"/> <br/> <br/>
        <button type="submit">Modificar</button>
    </form>
    
    <button>Volver</button>

</body>
</html>