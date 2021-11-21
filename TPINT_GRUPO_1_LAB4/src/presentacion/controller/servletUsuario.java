package presentacion.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import entidad.Usuario;
import negocio.UsuarioNeg;
import negociolmpl.UsuarioNegImpl;

/**
 * Servlet implementation class servletUsuario
 */
@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioNeg uNeg = new UsuarioNegImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(request.getParameter("cerrarSesion")!=null)
		{
			session.removeAttribute("usuario");
			System.out.println("cerrarSesion");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");   
	        rd.forward(request, response);
		}
		else if(request.getParameter("login")!=null)
		{
			Usuario user = uNeg.login(request.getParameter("usuario"), request.getParameter("contrasenia"));
			if(user != null) {
				System.out.println(user.getNombre());
				session.setAttribute("usuario", user);
				RequestDispatcher rd = request.getRequestDispatcher("/inicio.jsp");   
		        rd.forward(request, response);    
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");   
		        rd.forward(request, response);
			}

			//REQUESTDISPATCHER
			
		}
	}

}
