package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Alumno;
import dominio.AlumnoDao;
import dominio.Docente;
import dominio.DocenteDao;

/**
 * Servlet implementation class servletAlumnos
 */
@WebServlet("/servletAlumnos")
public class servletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAlumnos() {
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
			Alumno al=  new Alumno();
			
			al.setDni(request.getParameter("dni"));
			al.setNombreApellido(request.getParameter("nombreApellido"));
			al.setFechaNac(request.getParameter("fechaNac"));
			al.setIdProvincia(Integer.parseInt(request.getParameter("idProvincia")));
			al.setIdNacionalidad(Integer.parseInt(request.getParameter("idNacionalidad")));
			al.setDireccion(request.getParameter("direccion"));
			al.setEmail(request.getParameter("email"));
			al.setTelefono(request.getParameter("telefono"));
			
			System.out.println(al.getFechaNac());
			
			AlumnoDao daoAl = new AlumnoDao();
			try {
				filas=daoAl.agregar(al);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/alumnos/agregar.jsp");   
	        rd.forward(request, response);    
			
		}
	}

}
