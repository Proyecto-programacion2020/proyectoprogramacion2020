package ar.edu.unlam.proyectoprogramacion2020;

public class Ventas {

	private Integer idVenta;
	private Integer cantidad;
	private Producto producto;
	private Integer totalPuntos;
	private Double precioTotal;
	private Cliente cliente;
	private Integer cantidadPuntos;
	private MedioDePago medioDePago;
	private Boolean estadoDePago;
	
	
	public Ventas(Integer idVenta, Integer cantidad, Cliente cliente, Producto producto, MedioDePago medioDePago, 
			Integer cantidadPuntos){
		this.cliente=cliente;
		this.idVenta=idVenta;
		this.cantidad=cantidad;
		this.producto=producto;
		this.totalPuntos= cantidad * producto.getPrecioPuntos(); //precio total en puntos
		this.precioTotal= cantidad * producto.getPrecioReal(); //precio total en saldo
		this.cliente=cliente;
		this.cantidadPuntos= cantidadPuntos; //puntos que suma el usuario
		this.medioDePago=medioDePago;
		this.estadoDePago=false;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(Integer totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void setCantidadPuntos(Integer cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Boolean getEstadoDePago() {
		return estadoDePago;
	}

	public void setEstadoDePago(Boolean estadoDePago) {
		this.estadoDePago = estadoDePago;
	}
}
