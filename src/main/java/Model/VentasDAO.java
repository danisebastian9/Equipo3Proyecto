package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.Conexion;

public class VentasDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public long Iniciar_venta(int cedula_cliente, long cedula_empleado) {
		
		long cedula = Long.valueOf(cedula_cliente);
		boolean resul = false;
		long codigo_venta=0;
		
		try {
			String sql = "insert into ventas(cedula_cliente_key, cedula_empleado_key, ivaventa, total_venta, valor_venta) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, cedula);
			ps.setLong(2, cedula_empleado);
			ps.setDouble(3, 0);
			ps.setDouble(4, 0);
			ps.setDouble(5, 0);
			resul = ps.executeUpdate()>0;
			if(resul) {
				sql = "select codigo_venta from tienda_generica.ventas order by codigo_venta desc limit 1";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();
				while(res.next()) {
					codigo_venta = res.getLong(1);
				}
			}else {
				JOptionPane.showMessageDialog(null, "No se Insertaron datos a la tabla ventas");
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
		}

		return codigo_venta;
		
	}
	
	public long Actualizar_Venta(long codigo_venta, double ivaventa, double total_venta, double valor_total) {
		boolean resul = false;
		String sql = "update ventas set ivaventa = ?, valor_venta = ?, total_venta = ? where codigo_venta = ?";
		try {
		ps = con.prepareStatement(sql);
		ps.setDouble(1, ivaventa);
		ps.setDouble(2, total_venta);
		ps.setDouble(3, valor_total);
		ps.setLong(4, codigo_venta);
		
		resul = ps.executeUpdate()>0;
		
		if(!resul) {
			JOptionPane.showMessageDialog(null, "No se encontro venta");
		}
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al actualizar la venta: " + e);
		}
		
		return codigo_venta;
	}
	
}
