package serverlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;

/**
 * Servlet implementation class serverletSeguro
 */
@WebServlet("/serverletSeguro")
public class serverletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if((request.getParameter("Listar")!=null) || (request.getParameter("idTipoSeguro")!=null))
		{
			SeguroDao sdao = new SeguroDao();
			ArrayList<Seguro> lista= null;
			if(request.getParameter("idTipoSeguro")==null) {				
				lista = sdao.obtenerSeguros();
			}else {
				lista = sdao.obtenerSegurosPorTipo( Integer.parseInt(request.getParameter("idTipoSeguro")) );
			}
			
			request.setAttribute("listaSeguros", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
	        rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Seguro seguro = new Seguro();

		seguro.setDescripcion(request.getParameter("descripcion"));
		seguro.setIdTipo( Integer.parseInt(request.getParameter("idTipo")));
		seguro.setCostoContratacion(Float.parseFloat(request.getParameter("costoContratacion")));
		seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("costoAsegurado")));
		
		SeguroDao sDao = new SeguroDao();
		int filas=0;
		filas=sDao.agregarSeguro(seguro);
		
		//REQUESTDISPATCHER
		request.setAttribute("agregado", filas>0);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
        rd.forward(request, response);    
		
	}

}
