<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Alumno"%>
<%@page import="presentacion.controller.servletAlumnos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Provincia"%>
<%@page import="presentacion.controller.servletNacionalidades"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
		ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
		ArrayList<Provincia> listaProvincias = (ArrayList<Provincia>) servletAlumnos.obtenerProvincias();
	    String legajo = request.getParameter("legajo");
		Alumno al = servletAlumnos.obtenerAlumno(Integer.parseInt(legajo));
	 %>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a> 
    <h1>Modificar alumno</h1>
    <form action="/TPINT_GRUPO_1_LAB4/servletAlumnos" method="post">
    <input type="text" name="legajo" value="<%=legajo%>" hidden/>
        <table>
            <tr>
                <td>Legajo</td>
                <td><%= request.getParameter("legajo") %></td>
            </tr>
            <tr>
                <td>Dni</td>
                <td><input type="number" value="<%=al.getDni()%>" name="dni"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" value="<%=al.getNombreApellido()%>" name="nombreApellido"></td>
            </tr>
            <tr>
                <td>Fecha de nacimiento</td>
                <td><input type="date" name="fechaNac"  value="<%=al.getFechaNac()%>"></td>
            </tr>
            <tr>
                <td>Direccion</td>
                <td><input type="text" value="<%=al.getDireccion()%>" name="direccion"></td>
            </tr>
            <tr>
                <td>Nacionalidad</td>
                 <td>
	                <select name="idNacionalidad">
						<%
						if(listaNacionalidades!=null)
							for (Nacionalidad nac : listaNacionalidades) {
						%>
						<option value="<%=nac.getId()%>" <%=nac.getId()==al.getNacionalidad().getId()?"selected":"" %>><%=nac.getNombre()%></option>
						<%
							}
						%>
					</select>
				</td>
            </tr>
            <tr>
                <td>Provincia</td>
                <td>
					<select name="idProvincia">
						<%
						if(listaProvincias!=null)
							for (Provincia pro : listaProvincias) {
						%>
						<option value="<%=pro.getId()%>" <%=pro.getId()==al.getProvincia().getId()?"selected":"" %>><%=pro.getNombre()%></option>
						<%
							}
						%>
					</select>
				</td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" value="<%=al.getEmail()%>" name="email"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="number" value="<%=al.getTelefono()%>" name="telefono"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/alumnos/listar.jsp">
        	<button type="button">Cancelar</button>
        </a>
        <button type="submit"  name="modificar">Aceptar</button>
    </form> 

</body>
</html>