package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DocenteNeg;
import negocio.LocalidadNeg;
import negociolmpl.DocenteNeglmpl;
import negociolmpl.LocalidadNegImpl;
import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;


@WebServlet("/servletDocente")
public class servletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static DocenteNeg docNeg = new DocenteNeglmpl();  
    static LocalidadNeg LocNeg = new LocalidadNegImpl();
	
    public servletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas=0;
		System.out.println(request.getParameter("btnEliminar"));
		if(request.getParameter("btnEliminar")!=null) 
		{
			docNeg.eliminar(Integer.parseInt(request.getParameter("legajo")));
			request.setAttribute("eliminado", true);
			RequestDispatcher rd = request.getRequestDispatcher("/docentes/listar.jsp");   
	        rd.forward(request, response);    
			
		}else if(request.getParameter("btnAgregar")!=null)
		{
			Docente doc  =  new Docente();
			
			doc.setDni(request.getParameter("dni"));
			doc.setNombreApellido(request.getParameter("nombreApellido"));
			doc.setFechaNac(request.getParameter("fechaNac"));
			doc.setLocalidad(new Localidad(Integer.parseInt(request.getParameter("seleccionarLocalidad"))));
			doc.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("seleccionarNacionalidad"))));
			doc.setDireccion(request.getParameter("direccion"));
			doc.setEmail(request.getParameter("email"));
			doc.setTelefono(request.getParameter("telefono"));
			
			System.out.println(doc.getFechaNac());
			
			filas=docNeg.agregar(doc);
			//REQUESTDISPATCHER
			request.setAttribute("FilasAfectadas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/docentes/agregar.jsp");   
	        rd.forward(request, response);    
			
		}
		
	}
	
	public static ArrayList<Docente> obtenerDocentes() {
		return docNeg.obtenerTodos();
	}

	public static ArrayList<Docente> obtenerDocentes(String legajo) {
		return docNeg.obtenerTodos(Integer.parseInt(legajo));
	}
	
	public static ArrayList<Localidad> obtenerLocalidades() {
		return LocNeg.obtenerTodos();
	}
	
	public static Docente obtenerDocente(int legajo) {
		return docNeg.obtenerUno(legajo);
	}
	
}
