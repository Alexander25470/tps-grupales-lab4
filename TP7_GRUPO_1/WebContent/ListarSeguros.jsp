<%@page import="dominio.Seguro"%>
<%@page import="dominio.SeguroDao"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.TipoSeguro"%>
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
<% 
	TipoSeguroDao tsDao = new TipoSeguroDao();
	ArrayList<TipoSeguro> listaTiposSeguro = (ArrayList<TipoSeguro>) tsDao.obtenerTiposSeguro();

 %>
<a href="Inicio.jsp">Inicio</a> 
<a href="AgregarSeguro.jsp">Agregar seguro</a>
<a href="serverletSeguro?Listar=true">Listar seguro</a>
<h1>"Tipo de seguros de la base de datos"</h1>

<form action="serverletSeguro" method="get">
Busqueda por tipo de Seguros: 
<select name="idTipoSeguro" id="idTipoSeguro">
<%  
if(listaTiposSeguro!=null)
for(TipoSeguro tipoSeguro : listaTiposSeguro) 
{
%>
   <option value="<%=tipoSeguro.getIdTipo() %>"><%=tipoSeguro.getDescripcion() %></option> 
<%  } %>
</select>
<button type="submit">Filtrar</button>
</form>

<% 
	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null)
	{
		listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaSeguros");
	}

 %>
 <table id="table_id" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Descripcion</th>
            <th>Tipo</th>
            <th>Costo contratacion</th>
            <th>Costo maximo asegurado</th>
        </tr>
    </thead>
    <tbody>
       <%  
     	if(listaSeguros!=null)
		for(Seguro seguro : listaSeguros) 
		{
		%>
		<tr>  
			<td><%=seguro.getIdSeguro() %></td> 
			<td><%=seguro.getDescripcion() %></td>   
			<td><%=seguro.getTipoSeguro().getDescripcion() %></td>
			<td><%=seguro.getCostoContratacion() %></td>
			<td><%=seguro.getCostoAsegurado() %></td>
		</tr>
	<%  } %>
    </tbody>
</table>

</body>
</html>