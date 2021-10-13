package main.java.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.Controller.Conexion;

public class Reporte_ClientesDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public ArrayList<ClientesDTO> cargar_select(){
		
		ClientesDTO cli = null;
		ArrayList<ClientesDTO> lista = new ArrayList<>();
		
		try {
			String sql = "select * from tienda_generica.clientes";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				cli = new ClientesDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				lista.add(cli);
			}
		}catch(SQLException ex) {
			
		}
		
		return lista;
		
	}
	
}
