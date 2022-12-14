package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Maquina;
import logic.GestionarIncidencia;

/**
 * Servlet implementation class NuevaIncidenciaServlet
 */
@WebServlet(urlPatterns={"/NuevaIncidenciaServlet","/nuevaincidenciaServlet", "/nuevaincidenciaservlet","/nuevaIncidenciaServlet"})
public class NuevaIncidenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaIncidenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		System.out.println("Servlet NuevaIncidenciaServlet - POST");
		
		
		int idMaquina= Integer.parseInt(request.getParameter("nroMaquina"));
		GestionarIncidencia ctr = new GestionarIncidencia();
		
		Maquina maq = new Maquina();
		maq.setId(idMaquina);
		maq = ctr.validarMaquina(maq);
		
		System.out.println(maq);
		
		if (maq!=null) {
			request.setAttribute("maquinaIncidencia", maq);
			request.getRequestDispatcher("vistas/nuevaIncidencia.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/MaquinaServlet").forward(request,response);
		}
		
		
	}

}
