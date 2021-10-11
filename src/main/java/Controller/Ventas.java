package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ClientesDAO;
import Model.ClientesDTO;
import Model.DetalleVentaDAO;
import Model.EmpleadoDAO;
import Model.EmpleadoDTO;
import Model.ProductosDAO;
import Model.ProductosDTO;
import Model.VentasDAO;

/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("consultar1") != null) {

			long cedula_empleado;
			int cedula_cliente;
			long codigo_venta;
			String nombre_empleado;
			String nombre_cliente;

			EmpleadoDAO empDao = new EmpleadoDAO();
			ClientesDAO cliDao = new ClientesDAO();
			VentasDAO venDao = new VentasDAO();

			cedula_empleado = Long.parseLong(request.getParameter("ced_empleado"));
			EmpleadoDTO emp = empDao.Buscar_Empleado(cedula_empleado);
			cedula_cliente = Integer.parseInt(request.getParameter("ced_cliente"));
			ClientesDTO cliDto = cliDao.Buscar_Cliente(cedula_cliente);
			if (emp != null && cliDto != null) {
				codigo_venta = venDao.Iniciar_venta(cedula_cliente, cedula_empleado);
				nombre_empleado = emp.getNombre_empleado();
				nombre_cliente = cliDto.getNombre();
				response.sendRedirect("Ventas.jsp?codigo_venta=" + codigo_venta + "&&nombre_empleado=" + nombre_empleado
						+ "&&nombre_cliente=" + nombre_cliente + "&&cedula_empleado=" + cedula_empleado
						+ "&&cedula_cliente=" + cedula_cliente);
			} else {
				response.sendRedirect("Ventas.jsp?men= El cliente o el empleado no Existen");
			}

		}

		ProductosDAO prodDao = new ProductosDAO();

		try {

			if (request.getParameter("consulta2") != null) {

				int codigo_producto = 0;
				double ivacompra, precio_venta;
				String nombre_producto;

				codigo_producto = Integer.parseInt(request.getParameter("codProd1"));
				ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
				if (prod != null) {
					codigo_producto = prod.getCodigo_producto();
					ivacompra = prod.getIvacompra();
					nombre_producto = prod.getNombre_producto();
					precio_venta = prod.getPrecio_venta();
					response.sendRedirect("Ventas.jsp?codProd1=" + codigo_producto + "&&ivacompra=" + ivacompra
							+ "&&nombre_producto=" + nombre_producto + "&&precio_venta=" + precio_venta);
				} else {
					response.sendRedirect("Ventas.jsp?men= El producto no existe");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("Ventas.jsp?error=true");
		}

		try {

			if (request.getParameter("consulta3") != null) {

				int codigo_producto = 0;
				double ivacompra, precio_venta;
				String nombre_producto;

				codigo_producto = Integer.parseInt(request.getParameter("codProd2"));
				ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
				if (prod != null) {
					codigo_producto = prod.getCodigo_producto();
					ivacompra = prod.getIvacompra();
					nombre_producto = prod.getNombre_producto();
					precio_venta = prod.getPrecio_venta();
					response.sendRedirect("Ventas.jsp?codProd2=" + codigo_producto + "&&ivacompra2=" + ivacompra
							+ "&&nombre_producto2=" + nombre_producto + "&&precio_venta2=" + precio_venta);
				} else {
					response.sendRedirect("Ventas.jsp?men= El producto no existe");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("Ventas.jsp?error=true");
		}

		try {

			if (request.getParameter("consulta4") != null) {

				int codigo_producto = 0;
				double ivacompra, precio_venta;
				String nombre_producto;

				codigo_producto = Integer.parseInt(request.getParameter("codProd3"));
				ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
				if (prod != null) {
					codigo_producto = prod.getCodigo_producto();
					ivacompra = prod.getIvacompra();
					nombre_producto = prod.getNombre_producto();
					precio_venta = prod.getPrecio_venta();
					response.sendRedirect("Ventas.jsp?codProd3=" + codigo_producto + "&&ivacompra3=" + ivacompra
							+ "&&nombre_producto3=" + nombre_producto + "&&precio_venta3=" + precio_venta);
				} else {
					response.sendRedirect("Ventas.jsp?men= El producto no existe");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("Ventas.jsp?error=true");
		}

		try {
			if (request.getParameter("registrarVenta") != null) {

				if (!request.getParameter("codigoVenta").isEmpty()) {

					VentasDAO venDao = new VentasDAO();
					DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();

					if (!request.getParameter("codProd1").isEmpty()) {
						detalleVentaDAO.Detalle_venta(Integer.parseInt(request.getParameter("cantProd1")),
								Long.valueOf(request.getParameter("codProd1")),
								Long.valueOf(request.getParameter("codigoVenta")),
								Double.parseDouble(request.getParameter("totalProd1")),
								Double.parseDouble(request.getParameter("valorventa1")),
								Double.parseDouble(request.getParameter("valoriva1")));
					}

					if (!request.getParameter("codProd2").isEmpty()) {
						detalleVentaDAO.Detalle_venta(Integer.parseInt(request.getParameter("cantProd2")),
								Long.valueOf(request.getParameter("codProd2")),
								Long.valueOf(request.getParameter("codigoVenta")),
								Double.parseDouble(request.getParameter("totalProd2")),
								Double.parseDouble(request.getParameter("valorventa2")),
								Double.parseDouble(request.getParameter("valoriva2")));
					}

					if (!request.getParameter("codProd3").isEmpty()) {
						detalleVentaDAO.Detalle_venta(Integer.parseInt(request.getParameter("cantProd3")),
								Long.valueOf(request.getParameter("codProd3")),
								Long.valueOf(request.getParameter("codigoVenta")),
								Double.parseDouble(request.getParameter("totalProd3")),
								Double.parseDouble(request.getParameter("valorventa3")),
								Double.parseDouble(request.getParameter("valoriva3")));
					}

					venDao.Actualizar_Venta(Long.valueOf(request.getParameter("codigoVenta")),
							Double.parseDouble(request.getParameter("totalIva")),
							Double.parseDouble(request.getParameter("totalVenta")),
							Double.parseDouble(request.getParameter("totalConIva")));
					response.sendRedirect("Ventas.jsp");

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
