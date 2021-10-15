package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.EmpleadoDAO;
import Model.EmpleadoDTO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("opcion");
		
		PrintWriter salida = response.getWriter();
		Gson datos = new Gson();
		
		if(op.equals("usuarios")) {
			EmpleadoDAO empDAO = new EmpleadoDAO();
			ArrayList<EmpleadoDTO> lista = new ArrayList<>();
			lista = empDAO.cargar_select();
			salida.println(datos.toJson(lista));	
		}
	}

}
