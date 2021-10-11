package Model;

public class ClientesDTO {

	private int Cedula;
	private String Direccion;
	private String Email;
	private String Nombre;
	private String Telefono;

	
	

	public ClientesDTO(int cedula, String direccion, String email, String nombre, String telefono) {
		Cedula = cedula;
		Direccion = direccion;
		Email = email;
		Nombre = nombre;
		Telefono = telefono;
	}


	public int getCedula() {
		return Cedula;
	}




	public void setCedula(int cedula) {
		Cedula = cedula;
	}




	public String getDireccion() {
		return Direccion;
	}




	public void setDireccion(String direccion) {
		Direccion = direccion;
	}




	public String getEmail() {
		return Email;
	}




	public void setEmail(String email) {
		Email = email;
	}




	public String getNombre() {
		return Nombre;
	}




	public void setNombre(String nombre) {
		Nombre = nombre;
	}




	public String getTelefono() {
		return Telefono;
	}




	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	
}

