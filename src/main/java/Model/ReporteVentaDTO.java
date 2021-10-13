package Model;

public class ReporteVentaDTO {

	private String nombre_cliente;
	private Long cedula_cliente_key;
	private double total_venta;
	
	public ReporteVentaDTO(String nombre_cliente, long cedula_cliente_key, double total_venta) {
		super ();
		this.nombre_cliente = nombre_cliente;
		this.cedula_cliente_key = cedula_cliente_key;
		this.total_venta = total_venta;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public Long getCedula_cliente_key() {
		return cedula_cliente_key;
	}

	public void setCedula_cliente_key(Long cedula_cliente_key) {
		this.cedula_cliente_key = cedula_cliente_key;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	
	
}
