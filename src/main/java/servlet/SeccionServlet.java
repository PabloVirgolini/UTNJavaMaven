package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Seccion;
import logic.GestionarSeccion;

/**
 * Servlet implementation class SeccionServlet
 */

@WebServlet(name = "SeccionServlet", urlPatterns={"/SeccionServlet","/seccionServlet","/seccion","/secciones"})

public class SeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/vistas/secciones.jsp").forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				Seccion sec= new Seccion();
				GestionarSeccion ctrl = new GestionarSeccion();
				
				int id = Integer.parseInt(request.getParameter("txtCodigo"));
				
				String nombre = request.getParameter("txtNombre");
				
				sec.setId(id);
				sec.setDescripcion(nombre);
				
				Boolean respuesta;
				String mensaje = "";
				if(request.getParameter("btnGuardar")!=null) {
					respuesta=ctrl.add(sec);
					if(respuesta !=false) {
						mensaje ="Registro agregado"; }
					
				}else if(request.getParameter("btnEditar")!=null) {
					respuesta=ctrl.update(sec);
					if(respuesta !=false) {
						mensaje ="Registro modificado"; }
					
				}else if(request.getParameter("btnEliminar")!=null) {
					respuesta=ctrl.remove(sec);
					if(respuesta !=false) {
						mensaje ="Registro eliminado"; }
				}
				
				request.setAttribute("message", mensaje);
				request.getRequestDispatcher("/vistas/secciones.jsp").forward(request,response);
				
				//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	}

}
