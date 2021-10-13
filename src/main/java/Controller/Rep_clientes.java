package main.java.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import main.java.Model.ClientesDTO;
import main.java.Model.Reporte_ClientesDAO;


/**
 * Servlet implementation class Rep_clientes
 */
@WebServlet("/Rep_clientes")
public class Rep_clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rep_clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("opcion");
		
		PrintWriter salida = response.getWriter();
		Gson datos= new Gson();
		
		if(op.equals("clientes")) {
			Reporte_ClientesDAO repDao = new Reporte_ClientesDAO();
			ArrayList<ClientesDTO> lista = new ArrayList<>();
			lista = repDao.cargar_select();
			salida.println(datos.toJson(lista)); 
		} 
		
	}

}
