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
 * Servlet implementation class ConsultarHistorialIncidenciasServlet
 */
@WebServlet("/ConsultarHistorialIncidenciasServlet")
public class ConsultarHistorialIncidenciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarHistorialIncidenciasServlet() {
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
				GestionarIncidencia ctrl = new GestionarIncidencia();
				
				System.out.println("Estoy en el Servlet ConsultarHistorialIncidencias");
				Boolean respuesta;
				String mensaje = "";
				if(request.getParameter("btnGuardar")!=null) {
					respuesta=ctrl.add(inc);
					if(respuesta !=false) {
						mensaje ="Registro agregado"; }
					
				}else if(request.getParameter("btnEditar")!=null) {
					respuesta=ctrl.update(inc);
					if(respuesta !=false) {
						mensaje ="Registro modificado"; }
					
				}else if(request.getParameter("btnEliminar")!=null) {
					respuesta=ctrl.remove(inc);
					if(respuesta !=false) {
						mensaje ="Registro eliminado"; }
				}
				
				
	}

}
