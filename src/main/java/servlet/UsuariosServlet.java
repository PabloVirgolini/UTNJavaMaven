package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cargo;
import entities.Persona;
import entities.Seccion;
import logic.GestionarCargo;
import logic.GestionarSeccion;

/**
 * Servlet implementation class SeccionServlet
 */

@WebServlet(name = "UsuariosServlet", urlPatterns={"/UsuariosServlet","/usuariosServlet","/usuarios","/usuario"})

public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("DO GET del ServLet USUARIOSSERVLET");
		
		Persona p= (Persona) request.getSession().getAttribute("usuario");
		System.out.println(p);
		if (p.isHabilitado()) {
			request.setAttribute("email",p.getEmail());
			request.setAttribute("password",p.getPassword());
			
			request.getRequestDispatcher("/Signin").forward(request,response);
		}else {
			
			request.getRequestDispatcher("vistas/MenuPrincipal.jsp").forward(request,response);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST del ServLet USUARIOSSERVLET");
		try {
			LinkedList<Persona> lp= (LinkedList<Persona>)request.getAttribute("listaPersonas");
			if (lp!=null) {
				System.out.println("Entra 1");
				request.setAttribute("listaPersonas", lp);
				request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request,response);
				
			}else {
				System.out.println("Entra 2");
				Persona p= (Persona) request.getSession().getAttribute("usuario");
				request.setAttribute("email",p.getEmail());
				request.setAttribute("password",p.getPassword());
				request.getRequestDispatcher("/Signin").forward(request,response);
			}
		} catch(Exception e) {
			System.out.println("Entra 3");
			Persona p= (Persona) request.getSession().getAttribute("usuario");
			request.setAttribute("email",p.getEmail());
			request.setAttribute("password",p.getPassword());
			request.getRequestDispatcher("/Signin").forward(request,response);
		}
					
				//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	}

}
