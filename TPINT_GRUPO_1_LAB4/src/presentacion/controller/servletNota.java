package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Nota;
import negocio.DocenteNeg;
import negocio.NotaNeg;
import negociolmpl.DocenteNeglmpl;
import negociolmpl.NotaNegImpl;

/**
 * Servlet implementation class servletNota
 */
@WebServlet("/servletNota")
public class servletNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static NotaNeg notaNeg = new NotaNegImpl();  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletNota() {
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
		if(request.getParameter("btnAgregar")!=null)
		{
			int filas=0;
			int legajoAlumno = Integer.parseInt(request.getParameter("legajo"));
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			
			notaNeg.agregar(legajoAlumno, idCurso);
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/cursos/agregarAlumnos.jsp");   
	        rd.forward(request, response);    
			
		}
		
		
		doGet(request, response);
	}

	public static ArrayList<Nota> obtenerNotasCurso(int idCurso) {
		return notaNeg.obtenerNotasCurso(idCurso);
	}
	

}
