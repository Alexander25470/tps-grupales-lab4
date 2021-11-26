package presentacion.controller;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Nota;
import negocio.NotaNeg;
import negociolmpl.NotaNegImpl;

/**
 * Servlet implementation class servletAlumnosCursos
 */
@WebServlet("/servletAlumnosCursos")
public class servletAlumnosCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static NotaNeg notaNeg = new NotaNegImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAlumnosCursos() {
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
		
		
		if(request.getParameter("btnModificar")!=null) 
		{
			
			String[] aluSeleccionados = request.getParameterValues("chbkNotas");
			int filas=0;
			
			List<String> lista = Arrays.asList(aluSeleccionados);
			int nota = Integer.parseInt(request.getParameter("nota"));
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			
			
			for(String s : lista) {
			
			
			int legajoAlumno = Integer.parseInt(s); 
			
			
			
			String seleccion = request.getParameter("examen");
			
			
			filas += notaNeg.modificarNota(legajoAlumno,nota,seleccion, idCurso);
			
			}
			//REQUESTDISPATCHER
			request.setAttribute("idCurso", idCurso);
			request.setAttribute("filasNotas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/cursos/listarAlumnos.jsp");   
	        rd.forward(request, response);    
			
		}else if(request.getParameter("btnGuardarEstadoMasivo")!=null) {
			int filas=0;
			int estado = Integer.parseInt(request.getParameter("estado"));
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			String[] aluSeleccionados = request.getParameterValues("chbkEstado");
			List<String> lista = Arrays.asList(aluSeleccionados);
			
			for(String s : lista) {
				int legajoAlumno = Integer.parseInt(s); 
				filas+= notaNeg.modificarEstado(legajoAlumno, estado, idCurso);
			}
			//REQUESTDISPATCHER
			request.setAttribute("idCurso", idCurso);
			request.setAttribute("filasEstadoMasivo", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/cursos/listarAlumnos.jsp");   
	        rd.forward(request, response);    
			
		} else if(request.getParameter("btnGuardarEstado")!=null) {
			
			int estado = Integer.parseInt(request.getParameter("estado"));
			int idCurso = Integer.parseInt(request.getParameter("idCurso"));
			int legajo = Integer.parseInt(request.getParameter("legajo"));
			int filas=0;
			
			filas = notaNeg.modificarEstado(legajo, estado, idCurso);
			
			request.setAttribute("idCurso", idCurso);
			request.setAttribute("filasEstado", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/cursos/listarAlumnos.jsp");   
	        rd.forward(request, response); 
			
		}
	}

}
	

