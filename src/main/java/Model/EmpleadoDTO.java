package Model;

public class EmpleadoDTO {

	private long cedula_empleado;
	private String email_empleado;
	private String nombre_empleado;
	private String contrasena;
	private String empleado;
	
	public EmpleadoDTO(long cedula_empleado, String email_empleado, String nombre_empleado, String contrasena,
			String empleado) {
		this.cedula_empleado = cedula_empleado;
		this.email_empleado = email_empleado;
		this.nombre_empleado = nombre_empleado;
		this.contrasena = contrasena;
		this.empleado = empleado;
	}

	public long getCedula_empleado() {
		return cedula_empleado;
	}

	public void setCedula_empleado(long cedula_empleado) {
		this.cedula_empleado = cedula_empleado;
	}

	public String getEmail_empleado() {
		return email_empleado;
	}

	public void setEmail_empleado(String email_empleado) {
		this.email_empleado = email_empleado;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	
}
