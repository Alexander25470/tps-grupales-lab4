package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Docente;
import dominio.DocenteDao;


@WebServlet("/servletDocente")
public class servletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int filas=0;
		if(request.getParameter("btnAgregar")!=null)
		{
			Docente doc  =  new Docente();
			
			doc.setDni(request.getParameter("tbxDNI"));
			doc.setNombreApellido(request.getParameter("tbxNombreApellido"));
			doc.setFechaNac("1992/09/19");
			doc.setId_nacionalidad(1);
			doc.setId_Localidad(1);
			doc.setDireccion(request.getParameter("tbxDireccion"));
			doc.setEmail(request.getParameter("tbxEmail"));
			doc.setTelefono(request.getParameter("tbxTelefono"));
			
			DocenteDao Docdao = new DocenteDao();
			try {
				filas=Docdao.agregarDocente(doc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/agregarDocente.jsp");   
	        rd.forward(request, response);    
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
