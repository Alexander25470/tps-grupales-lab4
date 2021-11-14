package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.CursoNeg;
import negociolmpl.CursoNeglmpl;
import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import entidad.Nacionalidad;
import entidad.Provincia;

/**
 * Servlet implementation class servletCurso
 */
@WebServlet("/servletCurso")
public class servletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CursoNeg CurNeg = new CursoNeglmpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCurso() {
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
		int filas=0;
		if(request.getParameter("btnAgregar")!=null)
		{
			Curso cur=  new Curso();
			
			cur.setSemestre(Integer.parseInt(request.getParameter("semestre")));
			
			cur.setAnio((Integer.parseInt(request.getParameter("año"))));
			
			cur.setMateria(new Materia(Integer.parseInt(request.getParameter("idmateria"))));
			cur.setDocente(new Docente(Integer.parseInt(request.getParameter("legajo"))));
			
			filas=CurNeg.agregar(cur);
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/cursos/agregar.jsp");   
	        rd.forward(request, response);    
			
		}
		
		
	}
	
	public static ArrayList<Curso> obtenerCursos() {
		return CurNeg.obtenerTodos();
	}
	
	public static ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso) {
		return CurNeg.obtenerAlumnosQueNoEstanEnCurso(idCurso);
	}
}

