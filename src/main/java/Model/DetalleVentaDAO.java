package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Controller.Conexion;

public class DetalleVentaDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;

	public long Detalle_venta(int cantidad_producto, long codigo_producto_key, long codigo_venta_key,
			double valor_total, double valor_venta, double valoriva) {

		boolean resul = false;
		long codigo_detalle_venta = 0;

		try {
			String sql = "insert into detalle_ventas(cantidad_producto, codigo_producto_key, codigo_venta_key, valor_total, valor_venta, valoriva) values (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cantidad_producto);
			ps.setLong(2, codigo_producto_key);
			ps.setLong(3, codigo_venta_key);
			ps.setDouble(4, valor_total);
			ps.setDouble(5, valor_venta);
			ps.setDouble(6, valoriva);
			resul = ps.executeUpdate() > 0;
			if (resul) {
				sql = "select codigo_venta_key from tienda_generica.detalle_ventas order by codigo_detalle_venta desc limit 1";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();
				while (res.next()) {
					codigo_detalle_venta = res.getLong(1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se Insertaron datos a la tabla ventas");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}

		return codigo_detalle_venta;

	}
}
