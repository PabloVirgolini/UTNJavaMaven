package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Documento;
import entities.Persona;
import logic.GestionarPersona;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
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
 
		System.out.println("Servlet PersonaServlet - POST");
		
		Persona per= new Persona();
		GestionarPersona ctrl = new GestionarPersona();
		
		int id = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String email = request.getParameter("txtEmail");
		String telefono = request.getParameter("txtTelefono");
		String dni = request.getParameter("txtDNI");
		String tipoDni = request.getParameter("txtTipoDoc");
		
		
		Documento doc = new Documento();
		doc.setNro(dni);
		doc.setTipo(tipoDni);
		
		per.setId(id);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setEmail(email);
		per.setTel(telefono);
		per.setDocumento(doc);
		
		request.getSession().setAttribute("usuario", per);
		
		Boolean respuesta;
		String mensaje = "";
		if(request.getParameter("btnGuardar")!=null) {
			respuesta=ctrl.add(per);
			if(respuesta !=false) {
				mensaje ="Registro agregado"; }
			
		}else if(request.getParameter("btnEditar")!=null) {
			respuesta=ctrl.update(per);
			if(respuesta !=false) {
				mensaje ="Registro modificado"; }
			
		}else if(request.getParameter("btnEliminar")!=null) {
			respuesta=ctrl.remove(per);
			if(respuesta !=false) {
				mensaje ="Registro eliminado"; }
		}
		
		request.setAttribute("message", mensaje);
		
		LinkedList<Persona> personas = ctrl.getAll();
		request.setAttribute("listaPersonas", personas);
		request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request,response);
		
		
		//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	
	}

}
