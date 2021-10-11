package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.Conexion;

public class ClientesDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public boolean Agregar_Cliente(ClientesDTO cliente) {
		
		boolean result = false;
		try {
			String sql="INSERT INTO clientes VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getCedula());
			ps.setString(2, cliente.getDireccion());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getNombre());
			ps.setString(5, cliente.getTelefono());
			result = ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al Agregar: " + ex);
		}
		return result;
	}
	
	
	public ClientesDTO Buscar_Cliente(int Cedula) {
		
		ClientesDTO cliente = null;
		try {
			String sql= "SELECT * FROM clientes WHERE cedula_cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Cedula);
			res = ps.executeQuery();
			while(res.next()) {
				cliente = new ClientesDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		
		return cliente;
	}
	
	public boolean Eliminar_Cliente(int Cedula) {
		boolean result = false;
		try {
			String sql = "DELETE FROM clientes WHERE cedula_cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Cedula);
			result = ps.executeUpdate()>0;
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al eliminar Clente"+ e);
		}
		return result;
	}
	
	public boolean Actualizar_Clientes(ClientesDTO Cliente) {
		boolean result = false;
		try {
			String sql = "UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? WHERE cedula_cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Cliente.getDireccion());
			ps.setString(2, Cliente.getEmail());
			ps.setString(3, Cliente.getNombre());
			ps.setString(4, Cliente.getTelefono());
			ps.setInt(5, Cliente.getCedula());
			result = ps.executeUpdate()>0;
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e);
		}
		return result;
	}
	
}
