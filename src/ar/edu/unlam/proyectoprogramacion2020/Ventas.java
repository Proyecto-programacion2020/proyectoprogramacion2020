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

	/**
	 * @return the idVenta
	 */
	public Integer getIdVenta() {
		return idVenta;
	}

	/**
	 * @param idVenta the idVenta to set
	 */
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the totalPuntos
	 */
	public Integer getTotalPuntos() {
		return totalPuntos;
	}

	/**
	 * @param totalPuntos the totalPuntos to set
	 */
	public void setTotalPuntos(Integer totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	/**
	 * @return the precioTotal
	 */
	public Double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the cantidadPuntos
	 */
	public Integer getCantidadPuntos() {
		return cantidadPuntos;
	}

	/**
	 * @param cantidadPuntos the cantidadPuntos to set
	 */
	public void setCantidadPuntos(Integer cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	/**
	 * @return the medioDePago
	 */
	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	/**
	 * @param medioDePago the medioDePago to set
	 */
	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	/**
	 * @return the estadoDePago
	 */
	public Boolean getEstadoDePago() {
		return estadoDePago;
	}

	/**
	 * @param estadoDePago the estadoDePago to set
	 */
	public void setEstadoDePago(Boolean estadoDePago) {
		this.estadoDePago = estadoDePago;
	}
}
