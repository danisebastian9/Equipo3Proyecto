package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.Conexion;

public class ReporteVentaDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public ArrayList<ReporteVentaDTO> cargar() {

		ReporteVentaDTO vent = null;
		ArrayList<ReporteVentaDTO> lista = new ArrayList<>();
		
		try {
			String sql = "select nombre_cliente, cedula_cliente_key, sum(total_venta) as total_venta from ventas inner join clientes on cedula_cliente = cedula_cliente_key group by cedula_cliente_key";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				vent = new ReporteVentaDTO(res.getString(1), res.getLong(2), res.getDouble(3));
				lista.add(vent);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar los datos" + e);
		}

		return lista;

	} 
	
}
