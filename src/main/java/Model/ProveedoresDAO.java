package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.Conexion;

public class ProveedoresDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//Método para insertar valores a la tabla
		public boolean Insertar_Proveedor(ProveedoresDTO prov) {
			boolean resul = false;
			try {
				String sql = "insert into proveedores values(?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setLong(1, prov.getNitproveedor());
				ps.setString(2, prov.getCiudad_proveedor());
				ps.setString(3, prov.getDireccion_proveedor());
				ps.setString(4, prov.getNombre_proveedor());
				ps.setString(5, prov.getTelefono_proveedor());
				resul = ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
			}
			return resul;
		}
		
		//Método para Consultar los valores de la tabla
		public ProveedoresDTO Buscar_Proveedor(long nitproveedor) {
			
			ProveedoresDTO prov = null;
			try {
				String sql = "select * from tienda_generica.proveedores where nitproveedor=?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, nitproveedor);
				res = ps.executeQuery();
				while(res.next()) {
					prov = new ProveedoresDTO(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				}
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al Consultar " + e);
			}
			
			return prov;
			
		}
		
		//Método para Actualizar valores de la tabla
		public boolean Actualizar_Proveedor(ProveedoresDTO prov) {
			boolean resul = false;
			try {
				String sql = "update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nitproveedor=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, prov.getCiudad_proveedor());
				ps.setString(2, prov.getDireccion_proveedor());
				ps.setString(3, prov.getNombre_proveedor());
				ps.setString(4, prov.getTelefono_proveedor());
				ps.setLong(5, prov.getNitproveedor());
				resul = ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "error al insertar: " + ex);
			}
			return resul;
		}
		
		//Método para Eliminar valores de la tabla
				public boolean Eliminar_Proveedor(long nitproveedor) {
					boolean resul = false;
					try {
						String sql = "delete from proveedores where nitproveedor=?";
						ps = con.prepareStatement(sql);
						ps.setLong(1, nitproveedor);
						resul = ps.executeUpdate()>0;
					}catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, "error al eliminar: " + ex);
					}
					return resul;
				}
		
		
	
}
