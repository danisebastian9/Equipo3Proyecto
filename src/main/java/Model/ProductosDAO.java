package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controller.Conexion;

public class ProductosDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean Cargar_productos(String Url) {
		boolean resul = false;

		try {
			String sql = "load data infile '" + Url
					+ "' into table productos fields terminated by ';' lines terminated by '\n' ";
			ps = con.prepareStatement(sql);
			// ps.setString(0, Url);
			resul = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar productos" + ex);
		}
		return resul;
	}

	// Consultar productos
	public ProductosDTO Buscar_Producto(int codigo_producto) {

		ProductosDTO prod = null;
		try {
			String sql = "select * from tienda_generica.productos where codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo_producto);
			res = ps.executeQuery();
			while (res.next()) {
				prod = new ProductosDTO(res.getInt(1), res.getDouble(2), res.getString(3), res.getString(4),
						res.getDouble(5), res.getDouble(6));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar el producto" + e);
		}

		return prod;

	}

	//Actualizar productos
	public boolean Actualizar_Producto(ProductosDTO prod) {
		boolean resul = false;
		try {
			String sql = "update productos set ivacompra=?, nitproveedor_key=?, nombre_producto=?, precio_compra=?, precio_venta=? where codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, prod.getIvacompra());
			ps.setString(2, prod.getNitproveedor_key());
			ps.setString(3, prod.getNombre_producto());
			ps.setDouble(4, prod.getPrecio_compra());
			ps.setDouble(5, prod.getPrecio_venta());
			ps.setInt(6, prod.getCodigo_producto());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el producto" + ex);
		}
		return resul;
	}
}
