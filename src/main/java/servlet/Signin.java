package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		doPost(request,response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("DO POST del ServLet SIGNIN");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		
		Persona per = new Persona();
		ControlLogin ctrl = new ControlLogin();
		
		per.setEmail(email);
		per.setPassword(password);
		per = ctrl.validateUser(per);
		
		if (per!=null) {
			request.getSession().setAttribute("usuario", per);
			
			if (ctrl.validatePermisos(per, 1)==true) {
								
				LinkedList<Persona> personas = ctrl.getAll();
				
				request.setAttribute("listaPersonas", personas);
				
				request.getRequestDispatcher("/UsuariosServlet").forward(request,response);
				
				
			} else if(ctrl.validatePermisos(per, 2)) {
				
				request.getRequestDispatcher("vistas/MenuPrincipal.jsp").forward(request,response);
				
				
			} 
		}else {	
			request.getRequestDispatcher("/vistas/loginIncorrecto.jsp").forward(request,response);
		}

	}

}
