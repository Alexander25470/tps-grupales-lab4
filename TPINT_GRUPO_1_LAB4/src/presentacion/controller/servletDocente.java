package presentacion.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DocenteNeg;
import negociolmpl.DocenteNeglmpl;
import entidad.Docente;


@WebServlet("/servletDocente")
public class servletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DocenteNeg DocNeg = new DocenteNeglmpl();  
	
    public servletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas=0;
		if(request.getParameter("btnAgregar")!=null)
		{
			Docente doc  =  new Docente();
			
			doc.setDni(request.getParameter("dni"));
			doc.setNombreApellido(request.getParameter("nombreApellido"));
			doc.setFechaNac(request.getParameter("fechaNac"));
			doc.setId_Localidad(Integer.parseInt(request.getParameter("idLocalidad")));
			doc.setId_nacionalidad(Integer.parseInt(request.getParameter("idNacionalidad")));
			doc.setDireccion(request.getParameter("direccion"));
			doc.setEmail(request.getParameter("email"));
			doc.setTelefono(request.getParameter("telefono"));
			
			System.out.println(doc.getFechaNac());
			
			filas=DocNeg.agregar(doc);
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/docentes/agregarDocente.jsp");   
	        rd.forward(request, response);    
			
		}
		
	}

}
