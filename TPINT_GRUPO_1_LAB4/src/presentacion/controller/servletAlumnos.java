package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.AlumnoNeg;
import negocio.ProvinciaNeg;
import negociolmpl.AlumnoNeglmpl;
import negociolmpl.ProvinciaNegImpl;
import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;
import entidad.Provincia;


/**
 * Servlet implementation class servletAlumnos
 */
@WebServlet("/servletAlumnos")
public class servletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static AlumnoNeg aluNeg = new AlumnoNeglmpl();
	static ProvinciaNeg ProvNeg = new ProvinciaNegImpl();
       
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
		System.out.println(request.getParameter("btnEliminar"));
		if(request.getParameter("btnEliminar")!=null) 
		{
			aluNeg.eliminar(Integer.parseInt(request.getParameter("legajo")));
			request.setAttribute("eliminado", true);
			RequestDispatcher rd = request.getRequestDispatcher("/alumnos/listar.jsp");   
	        rd.forward(request, response);    
			
		}else if(request.getParameter("btnAgregar")!=null)
		{
			Alumno al=  new Alumno();
			
			al.setDni(request.getParameter("dni"));
			al.setNombreApellido(request.getParameter("nombreApellido"));
			al.setFechaNac(request.getParameter("fechaNac"));

			al.setProvincia(new Provincia(Integer.parseInt(request.getParameter("seleccionarProvincia"))));
			al.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("seleccionarNacionalidad"))));
			
			al.setDireccion(request.getParameter("direccion"));
			al.setEmail(request.getParameter("email"));
			al.setTelefono(request.getParameter("telefono"));
			
			System.out.println(al.getFechaNac());
			
			filas=aluNeg.agregar(al);
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/alumnos/agregar.jsp");   
	        rd.forward(request, response);    
			
		}
		
	}
	
	public static ArrayList<Alumno> obtenerAlumnos() {
		return aluNeg.obtenerTodos();
	}
	
	public static ArrayList<Alumno> obtenerAlumnos(String legajo) {
		return aluNeg.obtenerTodos(Integer.parseInt(legajo));
	}
	
	public static ArrayList<Provincia> obtenerProvincias() {
		return ProvNeg.obtenerTodos();
	}

	public static Alumno obtenerAlumno(int legajo) {
		return aluNeg.obtenerUno(legajo);
	}
	
}
