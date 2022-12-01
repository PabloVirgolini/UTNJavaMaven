package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataPersona;
import data.DataRol;
import entities.Persona;
import entities.Rol;
import logic.ControlLogin;
import logic.ControlMenu;

/**
 * Servlet implementation class Signin
 */
@WebServlet({"/signin", "/Signin"})

public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET del ServLet SIGNIN");
		doPost(request,response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("DO POST del ServLet SIGNIN");
		
		String accion = request.getParameter("accion");
		System.out.println("accion: " + accion);
		
		
		try {
			if (accion!=null) {
				switch(accion) {
					case "verificar":
						System.out.println("Entra a Verificar");
						verificar(request,response);
						break;					
					
					case "cerrar":
						System.out.println("Entra a CerrarSesion");
						cerrarSession(request,response);
						break;
					
					default:
						response.sendRedirect("index.jsp");
				}
			}else {
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) {
			try {
				this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request,response);
			} catch(Exception ex) {
				System.out.println("Error " + e.getMessage());
			}
		}
			

	}

	private void cerrarSession(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("usuario", null);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		HttpSession session;
		ControlLogin ctrl= new ControlLogin();
		Persona p = null;
		p = this.obtenerPersona(request);
		System.out.println("PERSONA ANTES DE VALIDAR:" + p);
		p=ctrl.validateUser(p);
		System.out.println("PERSONA DESPUES DE VALIDAR:" + p);
		if(p!=null && ctrl.validatePermisos(p,1) ) {
			session=request.getSession();
			session.setAttribute("usuario", p);
			request.setAttribute("msje", "Bienvenido al sistema");
			LinkedList<Persona> lista=ctrl.getAll();
			request.setAttribute("listaPersonas", lista);
			this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/UserManagement.jsp").forward(request,response);
		}else if(p!=null && ctrl.validatePermisos(p,2)){
			session=request.getSession();
			session.setAttribute("consulta",p);
			this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/MenuPrincipal.jsp").forward(request,response);
		}else {
			request.setAttribute("msje", "Credenciales incorrectas");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
	
	private Persona obtenerPersona(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("Estoy dentro del ObtenerPersona");
		
		
		Persona p = new Persona();
		p.setEmail(request.getParameter("email"));
		p.setPassword(request.getParameter("password"));
		return p;
	}

}
