<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.TipoSeguroDao"%>
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

 %>

<form action="serverletSeguro" method="post">
    Descripcion <input type="text" name="descripcion" id="descripcion"><br/>
    Tipo de seguro <select name="idTipo" id="idTipo">
            <%  
              if(listaTiposSeguro!=null)
             for(TipoSeguro tipoSeguro : listaTiposSeguro) 
             {
             %>
             <option value="<%=tipoSeguro.getIdTipo() %>"><%=tipoSeguro.getDescripcion() %></option> 
         <%  } %>
    </select><br/>
    Costo contratacion <input type="text" name="costoContratacion" id="costoContratacion"><br/>
    Costo maximo asegurado <input type="text" name="costoAsegurado" id="costoAsegurado"><br/>
    <button type="submit">Aceptar</button>

<% boolean agregado=Boolean.TRUE == request.getAttribute("agregado"); %>

<% 
	
	if(agregado) 
	{
%>
		Usuario agregado con exito
<%} %>

</form>
</body>
</html>