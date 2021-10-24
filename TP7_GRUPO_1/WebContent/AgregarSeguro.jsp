<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.SeguroDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> 
<a href="AgregarSeguro.jsp">Agregar seguro</a>
<a href="serverletSeguro?Listar=true">Listar seguro</a>
<h1>Agregar seguros</h1>
<% 
	TipoSeguroDao tsDao = new TipoSeguroDao();
	ArrayList<TipoSeguro> listaTiposSeguro = (ArrayList<TipoSeguro>) tsDao.obtenerTiposSeguro();
	int maxId = SeguroDao.obtenerMaxId();

 %>

<form action="serverletSeguro" method="post">
    <table>
        <tbody>
            <tr>
                <td>Id Seguro</td>
                <td><%=maxId%> </td>
            </tr>
            <tr>
                <td>Descripcion</td>
                <td><input type="text" name="descripcion" id="descripcion"></td>
            </tr>
            <tr>
                <td>Tipo de seguro</td>
                <td>
                    <select name="idTipo" id="idTipo">
                        <%  
                          if(listaTiposSeguro!=null)
                         for(TipoSeguro tipoSeguro : listaTiposSeguro) 
                         {
                         %>
                         <option value="<%=tipoSeguro.getIdTipo() %>"><%=tipoSeguro.getDescripcion() %></option> 
                     <%  } %>
                </select>
                </td>
            </tr>
            <tr>
                <td>Costo contratacion</td>
                <td><input type="text" name="costoContratacion" id="costoContratacion"></td>
            </tr>
            <tr>
                <td>Costo maximo asegurado</td>
                <td><input type="text" name="costoAsegurado" id="costoAsegurado"></td>
            </tr>
        </tbody>
    </table>
    <button type="submit">Aceptar</button>
</form>
<% boolean agregado=Boolean.TRUE == request.getAttribute("agregado"); %>

<% 
    
    if(agregado) 
    {
%>
        Usuario agregado con exito
<%} %>
</body>
</html>