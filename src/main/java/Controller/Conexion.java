package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	
	private String bd = "tienda_generica";
	private String url = "jdbc:mysql://localhost:3306/"+bd;
	private String user = "root";
	private String pass = "";
	Connection conec = null;
	
	public Connection Conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conec = DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error en la Conexion ...." + e);
		}
		
		return conec;
		
	}

}