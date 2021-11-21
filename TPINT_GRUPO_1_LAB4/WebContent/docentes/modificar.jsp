<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Docente"%>
<%@page import="presentacion.controller.servletDocente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Localidad"%>
<%@page import="presentacion.controller.servletNacionalidades"%>
<%@page import="entidad.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/TPINT_GRUPO_1_LAB4/styles/styles.css">
</head>
<body>
	<%
		ArrayList<Nacionalidad> listaNacionalidades = (ArrayList<Nacionalidad>) servletNacionalidades.obtenerNacionalidades();
		ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) servletDocente.obtenerLocalidades();
	    String legajo = request.getParameter("legajo");
		Docente doc = servletDocente.obtenerDocente(Integer.parseInt(legajo));
		Usuario currentUser = (Usuario)(session.getAttribute("usuario"));
	 %>
	 <header>	 
	 	<h1>Usuario <%=currentUser.getNombre()%></h1>
		<form action="/TPINT_GRUPO_1_LAB4/servletUsuario" method="POST">
			<button type="submit" name="cerrarSesion">Cerrar sesión</button>
		</form>
	 </header>
	<a href="/TPINT_GRUPO_1_LAB4/inicio.jsp">
		<button>Inicio</button> 
	</a>
    <h1>Modificar docente</h1>
    
    <form action="/TPINT_GRUPO_1_LAB4/servletDocente" method="post">
        <input type="text" name="legajo" value="<%=legajo%>" hidden/>
        <table>
            <tr>
                <td>Legajo</td>
                <td><%= request.getParameter("legajo") %></td>
            </tr>
            <tr>
                <td>Dni</td>
                <td><input type="number" name="dni" value="<%=doc.getDni()%>"></td>
            </tr>
            <tr>
                <td>Nombre y apellido</td>
                <td><input type="text" name="nombreApellido" value="<%=doc.getNombreApellido()%>"></td>
            </tr>
            <tr>
            	<td>Fecha de nacimiento</td>
	             <td>
	            	 <input type="date" name="fechaNac" value="<%=doc.getFechaNac()%>">
	             </td>
            </tr>
            <tr>
                <td>Direccion</td>
                <td><input type="text" name="direccion" value="<%=doc.getDireccion()%>"></td>
            </tr>
            <tr>
                <td>Localidad</td>
                <td>
					<select name="idLocalidad">
						<%
						if(listaLocalidades!=null)
							for (Localidad loc : listaLocalidades) {
						%>
						<option value="<%=loc.getId()%>" <%=loc.getId()==doc.getLocalidad().getId()?"selected":"" %>><%=loc.getNombre()%></option>
						<%
							}
						%>
					</select>
				</td>
            </tr>
            <tr>
                <td>Nacionalidad</td>
                <td>
	                <select name="idNacionalidad">
						<%
						if(listaNacionalidades!=null)
							for (Nacionalidad nac : listaNacionalidades) {
						%>
						<option value="<%=nac.getId()%>" <%=nac.getId()==doc.getNacionalidad().getId()?"selected":"" %>><%=nac.getNombre()%></option>
						<%
							}
						%>
					</select>
				</td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="<%=doc.getEmail()%>"></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td><input type="number" name="telefono" value="<%=doc.getTelefono()%>"></td>
            </tr>
        </table>
        <a href="/TPINT_GRUPO_1_LAB4/docentes/listar.jsp">
        	<button type="button">Cancelar</button>
        </a>
        <button type="submit" name="modificar">Aceptar</button>
    </form> 

</body>
</html>