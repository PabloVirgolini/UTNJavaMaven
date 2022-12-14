package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Maquina;
import entities.Persona;
import entities.Seccion;
import logic.GestionarMaquina;

@WebServlet(name = "MaquinaServlet", urlPatterns={"/MaquinaServlet","/maquinaservlet","/maquina","/maquinas"})

/**
 * Servlet implementation class MaquinaServlet
 */
public class MaquinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaquinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/vistas/maquinas.jsp").forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet MaquinaServlet - POST");
		
		Maquina maq= new Maquina();
		GestionarMaquina ctrl = new GestionarMaquina();
		
		int id = Integer.parseInt(request.getParameter("txtCodigo").trim());
		
		String nombre = request.getParameter("txtNombre");
		
		String fechaAltaStr = request.getParameter("txtFechaAlta");
		LocalDate fechaAlta = null;
		fechaAlta = LocalDate.parse(fechaAltaStr);
				
		int seccionAsignada = Integer.parseInt(request.getParameter("cbbSector"));
				
		Seccion sec = new Seccion();
		sec.setId(seccionAsignada);
		sec = ctrl.validate(sec);
		maq.setId(id);
		maq.setNombre(nombre);
		maq.setFechaAlta(fechaAlta);
		maq.setFechaBaja(null);
		maq.setSeccionAsignada(sec);
		
		Boolean respuesta;
		String mensaje = "";
		if(request.getParameter("btnGuardar")!=null) {
			respuesta=ctrl.add(maq);
			if(respuesta !=false) {
				mensaje ="Registro agregado"; }
			
		}else if(request.getParameter("btnEditar")!=null) {
			respuesta=ctrl.update(maq);
			if(respuesta !=false) {
				mensaje ="Registro modificado"; }
			
		}else if(request.getParameter("btnEliminar")!=null) {
			respuesta=ctrl.remove(maq);
			if(respuesta !=false) {
				mensaje ="Registro eliminado"; }
		}
		
		request.setAttribute("message", mensaje);
		request.getRequestDispatcher("/vistas/maquinas.jsp").forward(request,response);
		
		//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
	}

}

