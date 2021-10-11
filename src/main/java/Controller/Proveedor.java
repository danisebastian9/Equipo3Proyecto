package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Model.ProveedoresDAO;
import Model.ProveedoresDTO;

/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedoresDAO provDAO = new ProveedoresDAO();

		// Validación al pulsar el botón crear en la intefáz, lo cual inserta un valor a
		// la tabla
		if (request.getParameter("crear") != null) {
			long nitproveedor;
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;

			nitproveedor = Long.parseLong(request.getParameter("nitproveedor"));
			nombre_proveedor = request.getParameter("nombre_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			ProveedoresDTO provDto = new ProveedoresDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, 
					nombre_proveedor, telefono_proveedor);
			if (provDAO.Insertar_Proveedor(provDto)) {
				JOptionPane.showMessageDialog(null, "Proveedor registrado exitosamente");
				response.sendRedirect("Proveedores.jsp?men=Proveedor registrado exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "El Proveedor NO se registro");
				response.sendRedirect("Proveedores.jsp?men=El Proveedor NO se registro");
			}
		}
		
		// Validación al pulsar el botón consultar, nos trae información de la base de
				// datos
				if (request.getParameter("consultar") != null) {

					long nitproveedor;
					String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;

					nitproveedor = Long.parseLong(request.getParameter("nit"));
					ProveedoresDTO prov = provDAO.Buscar_Proveedor(nitproveedor);
					if (prov != null) {
						nitproveedor = prov.getNitproveedor();
						nombre_proveedor = prov.getNombre_proveedor();
						direccion_proveedor = prov.getDireccion_proveedor();
						telefono_proveedor = prov.getTelefono_proveedor();
						ciudad_proveedor = prov.getCiudad_proveedor();
						response.sendRedirect("Proveedores.jsp?nitproveedor=" + nitproveedor + "&&nombre_proveedor="
								+ nombre_proveedor + "&&direccion_proveedor=" + direccion_proveedor + "&&telefono_proveedor=" + telefono_proveedor
								+ "&&ciudad_proveedor=" + ciudad_proveedor);
					} else {
						response.sendRedirect("Proveedores.jsp?men= El empleado no Existe");
					}

				}
				
				// Validación al pulsar el botón Actualizar
				if (request.getParameter("actualizar") != null) {
					long nitproveedor;
					String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;

					nitproveedor = Long.parseLong(request.getParameter("nit_prov"));
					nombre_proveedor = request.getParameter("nombre_proveedor");
					direccion_proveedor = request.getParameter("direccion_proveedor");
					telefono_proveedor = request.getParameter("telefono_proveedor");
					ciudad_proveedor = request.getParameter("ciudad_proveedor");
					ProveedoresDTO provDTO = new ProveedoresDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, 
							nombre_proveedor, telefono_proveedor);
					if (provDAO.Actualizar_Proveedor(provDTO)) {
						JOptionPane.showMessageDialog(null, "Proveedor Actualizado exitosamente");
						response.sendRedirect("Proveedores.jsp?men=Proveedor actualizado exitosamente");
					} else {
						JOptionPane.showMessageDialog(null, "El Proveedor NO se actualizo");
						response.sendRedirect("Proveedores.jsp?men=El Proveedor NO se actualizo");
					}
				}
				
				// Validación al pulsar el botón borrar
				if (request.getParameter("borrar") != null) {
					long nitproveedor;

					nitproveedor = Long.parseLong(request.getParameter("nit_prov"));
					int op = JOptionPane.showConfirmDialog(null, "Desea eliminar el Proveedor nit_prov: " + nitproveedor);
					if (op == 0) {
						if (provDAO.Eliminar_Proveedor(nitproveedor)) {
							response.sendRedirect("Proveedores.jsp?men=Proveedor eliminado exitosamente");
						} else {
							response.sendRedirect("Proveedores.jsp?men=El proveedor NO se elimino");
						}
					} else {
						response.sendRedirect("Proveedores.jsp");
					}
				}
		
	}

}
