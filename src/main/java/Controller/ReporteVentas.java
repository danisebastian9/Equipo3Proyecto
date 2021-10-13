package Controller;

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

import Model.ClientesDTO;
import Model.ReporteVentaDAO;
import Model.ReporteVentaDTO;
import Model.Reporte_ClientesDAO;

@WebServlet("/ReporteVentas")
public class ReporteVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReporteVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("opcion");

		PrintWriter salida = response.getWriter();
		Gson datos = new Gson();

		if (op.equals("ventas")) {
			ReporteVentaDAO ventDao = new ReporteVentaDAO();
			ArrayList<ReporteVentaDTO> lista = new ArrayList<>();
			lista = ventDao.cargar();
			salida.println(datos.toJson(lista));
		}

	}
}
