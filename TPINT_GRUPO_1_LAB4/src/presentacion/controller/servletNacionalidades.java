package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Materia;
import entidad.Nacionalidad;
import negocio.AlumnoNeg;
import negocio.NacionalidadNeg;
import negociolmpl.AlumnoNeglmpl;
import negociolmpl.NacionalidadNegImpl;

/**
 * Servlet implementation class servletNacionalidades
 */
@WebServlet("/servletNacionalidades")
public class servletNacionalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static NacionalidadNeg NacNeg = new NacionalidadNegImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletNacionalidades() {
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
		doGet(request, response);
	}

	public static ArrayList<Nacionalidad> obtenerNacionalidades() {
		return NacNeg.obtenerTodos();
	}
	
	
}
