package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cargo;
import entities.Seccion;
import logic.GestionarCargo;
import logic.GestionarSeccion;

/**
 * Servlet implementation class SeccionServlet
 */

@WebServlet(name = "CargoServlet", urlPatterns={"/CargoServlet","/cargoServlet","/cargo","/cargos"})

public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/vistas/cargos.jsp").forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet CargoServlet - POST");

		int id = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		
		Cargo sec= new Cargo();
		sec.setIdCargo(id);
		sec.setDescripcion(nombre);
		
		Boolean respuesta;
		String mensaje = "";
		
		GestionarCargo ctrl = new GestionarCargo();
		
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
		request.getRequestDispatcher("/vistas/cargos.jsp").forward(request,response);
		
		//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	}

}
