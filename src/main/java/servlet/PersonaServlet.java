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
import entities.Rol;
import logic.GestionarPersona;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	
	GestionarPersona ctrl = null;
	
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
		
		GestionarPersona ctrl = new GestionarPersona();
		
		Persona per= null;
		Rol rol = null;
		
		per = this.obtenerPersona(request);
		
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
			
		}else if(request.getParameter("btnEliminarRol")!=null) {
			rol = new Rol();
			rol=this.obtenerRol(request);
			
			respuesta=ctrl.removeRol(per, rol);
			if(respuesta !=false) {
				mensaje ="Rol eliminado"; }
			
		}else if(request.getParameter("btnAgregarRol")!=null) {
			rol = new Rol();
			rol=this.obtenerRol(request);
			
			respuesta=ctrl.addRol(per, rol);
			if(respuesta !=false) {
				mensaje ="Rol agregado"; }
		
		}
		
		request.getSession().setAttribute("usuario", per);
		request.setAttribute("message", mensaje);
		
		LinkedList<Persona> personas = ctrl.getAll();
		request.setAttribute("listaPersonas", personas);
		request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request,response);
		
		
		//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	
	}
	
	private Persona obtenerPersona(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("Estoy dentro del ObtenerPersona del PersonaServlet");
		
		Persona per = new Persona();
		
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
		
		return per;
	}
	
	private Rol obtenerRol(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("Estoy dentro del obtenerRol del PersonaServlet");
		
		String nombreRol = null;
		
		GestionarPersona ctrl = new GestionarPersona();
		
		if(request.getParameter("btnAgregarRol")!=null) {
			nombreRol = request.getParameter("txtRolAgregar");
		}else if(request.getParameter("btnEliminarRol")!=null) {
			nombreRol = request.getParameter("txtRolEliminar");
		}
		
		Rol r= new Rol();
		r.setDescripcion(nombreRol);
		r=ctrl.getRol(r);
		
		return r;
	}
	
	

}
