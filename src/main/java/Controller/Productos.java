package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Model.ProductosDAO;
import Model.ProductosDTO;
import Model.ProveedoresDTO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		ProductosDAO prodDao = new ProductosDAO();
		
		// Validacion archivo
		
		if(request.getParameter("cargar") != null) {
			Part archivo = request.getPart("archivo");
			String nombre = request.getParameter("nombre");
			String Url="/Users/acruz/Development/Estudio/Prueba/Equipo3Grupo31/src/main/webapp/Doc/	";
			
			try {
				InputStream file = archivo.getInputStream();
				File copia = new File(Url + nombre + ".csv");
				FileOutputStream escribir = new FileOutputStream(copia);
				int num = file.read();
				while (num != -1) {
					escribir.write(num);
					num = file.read();
				}
				escribir.close();
				file.close();
				JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
				if(prodDao.Cargar_productos(Url + nombre + ".csv")) {
					JOptionPane.showMessageDialog(null, "Productos registrados correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Productos no se registrados correctamente");
				}
		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo" + e);
			}
		}
		
		// Validacion consulta
		
		if (request.getParameter("consultar") != null) {

			int codigo_producto;
			double ivacompra, precio_compra, precio_venta;
			String nombre_producto, nitproveedor_key;
			

			codigo_producto = Integer.parseInt(request.getParameter("producto"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
			if (prod != null) {
				codigo_producto = prod.getCodigo_producto();
				ivacompra = prod.getIvacompra();
				nitproveedor_key = prod.getNitproveedor_key();
				nombre_producto = prod.getNombre_producto();
				precio_compra = prod.getPrecio_compra();
				precio_venta = prod.getPrecio_venta();
				response.sendRedirect("Productos.jsp?codigo_producto=" + codigo_producto + "&&ivacompra="
						+ ivacompra + "&&nitproveedor_key=" + nitproveedor_key + "&&nombre_producto=" + nombre_producto
						+ "&&precio_compra=" + precio_compra + "&&precio_venta=" + precio_venta);
			} else {
				response.sendRedirect("Productos.jsp?men= El producto no existe");
			}

		}
		
		// Validacion Actualizar
		
		if (request.getParameter("actualizar") != null) {
			int codigo_producto;
			double ivacompra, precio_compra, precio_venta;
			String nombre_producto, nitproveedor_key;

			codigo_producto = Integer.parseInt(request.getParameter("cod_prod"));
			ivacompra = Double.parseDouble(request.getParameter("ivacompra"));
			nitproveedor_key = request.getParameter("nitproveedor_key");
			nombre_producto = request.getParameter("nombre_producto");
			precio_compra = Double.parseDouble(request.getParameter("precio_compra"));
			precio_venta = Double.parseDouble(request.getParameter("precio_venta"));
			ProductosDTO prodDTO = new ProductosDTO(codigo_producto, ivacompra, nitproveedor_key, 
					nombre_producto, precio_compra, precio_venta);
			if (prodDao.Actualizar_Producto(prodDTO)) {
				JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
				response.sendRedirect("Productos.jsp?men=Producto actualizado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Producto no actualizado correctamente");
				response.sendRedirect("Productos.jsp?men=Producto no actualizado correctamente");
			}
		}
		
		
	}

}