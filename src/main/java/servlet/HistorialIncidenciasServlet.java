package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Incidencia;
import entities.Maquina;
import logic.GestionarIncidencia;

/**
 * Servlet implementation class HistorialIncidenciasServlet
 */
@WebServlet("/HistorialIncidenciasServlet")
public class HistorialIncidenciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialIncidenciasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Servlet HistorialIncidenciasServlet - POST");
		
		
		int idMaquina= Integer.parseInt(request.getParameter("nroMaquina"));
		GestionarIncidencia ctr = new GestionarIncidencia();
		
		Maquina maq = new Maquina();
		maq.setId(idMaquina);
		maq = ctr.validarMaquina(maq);
		
		if (maq!=null) {
			
			LinkedList<Incidencia> incidencias = ctr.getPorMaquina(maq);

			request.setAttribute("maquinaIncidencia", maq);
			request.setAttribute("listaIncidencias", incidencias);
			request.getRequestDispatcher("vistas/incidenciasHistorial.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/MaquinaServlet").forward(request,response);
		}

		
		
	}

}
