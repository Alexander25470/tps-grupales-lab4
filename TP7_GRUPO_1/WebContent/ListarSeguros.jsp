<%@page import="dominio.Seguro"%>
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

<a href="serverletSeguro?Listar=true"> Listar Seguros</a>

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
       <%  if(listaSeguros!=null)
		for(Seguro seguro : listaSeguros) 
		{
	%>
		<tr>  
		    <form name="formulario" action="servletSeguro?idSeguro=<%=seguro.getIdSeguro()%>" method="get">
				<td><%=seguro.getIdSeguro() %> <input type="hidden" name="idUsuario" value="<%=seguro.getIdSeguro()%>"> </td> 
				<td><%=seguro.getDescripcion() %></td>   
				<td><%=seguro.getIdTipo() %></td>
				<td><%=seguro.getCostoContratacion() %></td>
				<td><%=seguro.getCostoAsegurado() %></td>
			</form> 
		</tr>
	<%  } %>
    </tbody>
</table>

</body>
</html>