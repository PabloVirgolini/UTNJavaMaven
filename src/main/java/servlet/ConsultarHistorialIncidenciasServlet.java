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
				System.out.println("Servlet ConsultarHistorialIncidencias - POST");
				
				int id = Integer.parseInt(request.getParameter("txtCodigo"));
				int idMaquina = Integer.parseInt(request.getParameter("idMaquinaModal").trim());
				
				GestionarIncidencia ctrl = new GestionarIncidencia();
				Incidencia inc = new Incidencia();
				inc.setId(id);
				
				Maquina m = new Maquina();
				m.setId(idMaquina);
				m=ctrl.validarMaquina(m);
				
				Boolean respuesta;
				String mensaje = "";
				if(request.getParameter("btnGuardar")!=null) {
					respuesta=ctrl.add(inc);
					if(respuesta !=false) {
						mensaje ="Registro agregado"; }
//					
//				}else if(request.getParameter("btnEditar")!=null) {
//					respuesta=ctrl.update(inc);
//					if(respuesta !=false) {
//						mensaje ="Registro modificado"; }
//					
//				}else if(request.getParameter("btnEliminar")!=null) {
//					respuesta=ctrl.remove(inc);
//					if(respuesta !=false) {
//						mensaje ="Registro eliminado"; }
				}else if(request.getParameter("btnCerrar")!=null) {
					respuesta=ctrl.cerrarIncidencia(inc);
					if(respuesta !=false) {
						mensaje ="Incidencia cerrada correctamente"; }
				}
				
				request.setAttribute("message", mensaje);
				request.setAttribute("maquinaIncidencia", m);
				request.getRequestDispatcher("/vistas/incidenciasHistorial.jsp").forward(request,response);
				
				
	}

}
