package ModelAct2DOM;

public class Producto {

	private String id;
	private String nombre;
	private double precio;
	private int stock;
	private boolean enVenta; 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public boolean getEnVenta() {
		return enVenta;
	}
	public void setEnVenta(boolean enVenta) {
		this.enVenta = enVenta;
	}
	public Producto() {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.enVenta = enVenta;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", enVenta="
				+ enVenta + "]";
	}
	
}
