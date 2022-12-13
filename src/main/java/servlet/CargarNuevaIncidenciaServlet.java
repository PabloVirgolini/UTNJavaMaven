package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPersona;
import entities.Incidencia;
import entities.Maquina;
import entities.Persona;
import logic.GestionarIncidencia;


/**
 * Servlet implementation class CargarNuevaIncidenciaServlet
 */
@WebServlet("/CargarNuevaIncidenciaServlet")
public class CargarNuevaIncidenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarNuevaIncidenciaServlet() {
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
		// TODO Auto-generated method stub		
		
		System.out.println("Entramos al CargarNuevaIncidenciaServlet");
		
		GestionarIncidencia ctrl = new GestionarIncidencia();
		
		int idMaquina = Integer.parseInt(request.getParameter("idMaquina").trim());
		Persona pApertura = (Persona) request.getSession().getAttribute("usuario");
		
		String fechaAperturaStr = request.getParameter("txtFechaApertura");
		LocalDate fechaApertura = null;
		fechaApertura = LocalDate.parse(fechaAperturaStr);
		
		//int idEncargadoAsignado = Integer.parseInt(request.getParameter("cbbPersonaReparacion").trim());
				
		String txtDescripcion = request.getParameter("txtDescripcion");
		
		// FALTA RECUPERAR LAS FOTOS
		
		Incidencia inc= new Incidencia();
		
		Maquina m =new Maquina();
		m.setId(idMaquina);
		m=ctrl.validarMaquina(m);
		inc.setMaquina(m);
		
		inc.setPersonaApertura(pApertura);
				
//		DataPersona pDAO = new DataPersona();
//		Persona pEncargado = new Persona();
//		pEncargado.setId(idEncargadoAsignado);
//		pEncargado=pDAO.getById(pEncargado);
//		inc.setPersonaAsignada(pEncargado);

		inc.setFechaApertura(fechaApertura);
		
		inc.setDescripcionProblema(txtDescripcion);
		
		Boolean respuesta;
		String mensaje = "";
		if(request.getParameter("btnGuardar")!=null) {
			respuesta=ctrl.add(inc);
			if(respuesta !=false) {
				mensaje ="Registro agregado"; }
			
		}
		
		request.setAttribute("message", mensaje);
		request.getRequestDispatcher("/vistas/maquinas.jsp").forward(request,response);
	}

}
