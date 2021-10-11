package Model;

public class VentasDTO {
	
	private long codigo_venta;
	private long cedula_cliente_key;
	private long cedula_empleado_key;
	private double ivaventa;
	private double total_venta;
	private double valor_venta;
	
	public VentasDTO(long cedula_cliente_key, long cedula_empleado_key, double ivaventa, double total_venta,
			double valor_venta) {
		this.cedula_cliente_key = cedula_cliente_key;
		this.cedula_empleado_key = cedula_empleado_key;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public long getCedula_cliente_key() {
		return cedula_cliente_key;
	}

	public void setCedula_cliente_key(long cedula_cliente_key) {
		this.cedula_cliente_key = cedula_cliente_key;
	}

	public long getCedula_empleado_key() {
		return cedula_empleado_key;
	}

	public void setCedula_empleado_key(long cedula_empleado_key) {
		this.cedula_empleado_key = cedula_empleado_key;
	}

	public double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	
	
	
	
	
}
