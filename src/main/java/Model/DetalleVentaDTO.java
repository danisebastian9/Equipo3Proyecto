package Model;

public class DetalleVentaDTO {

	private long codigo_detalle_venta;
	private int cantidad_producto;
	private long codigo_producto_key;
	private long codigo_venta_key;
	private double valor_total;
	private double valor_venta;
	private double valoriva;

	public DetalleVentaDTO(long codigo_detalle_venta, int cantidad_producto, long codigo_producto_key, long codigo_venta_key,
			double valor_total, double valor_venta, double valoriva) {
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto_key = codigo_producto_key;
		this.codigo_venta_key = codigo_venta_key;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}

	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public long getCodigo_producto_key() {
		return codigo_producto_key;
	}

	public void setCodigo_producto_key(long codigo_producto_key) {
		this.codigo_producto_key = codigo_producto_key;
	}

	public long getCodigo_venta_key() {
		return codigo_venta_key;
	}

	public void setCodigo_venta_key(long codigo_venta_key) {
		this.codigo_venta_key = codigo_venta_key;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValoriva() {
		return valoriva;
	}

	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	
	
}
