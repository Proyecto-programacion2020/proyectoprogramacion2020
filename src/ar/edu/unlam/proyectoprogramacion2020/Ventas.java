package ar.edu.unlam.proyectoprogramacion2020;

public class Ventas {

	private Integer idVenta;
	private Integer cantidad;
	private Producto producto;
	private Integer totalPuntos;
	private Double precioTotal;
	private Usuario comprador;
	private Integer cantidadPuntos;
	private String medioDePago;
	private String estadoDePago;
	
	public Ventas(Integer idVenta, Integer cantidad, Usuario comprador, Producto producto, String medioDePago, 
			Integer cantidadPuntos){
		this.comprador=comprador;
		this.idVenta=idVenta;
		this.cantidad=cantidad;
		this.producto=producto;
		this.totalPuntos=cantidad*producto.getPrecioPuntos(); //pecio total en puntos
		this.precioTotal=cantidad*producto.getPrecioReal(); //precio total en saldo
		this.setComprador(comprador);
		this.cantidadPuntos= cantidadPuntos; //puntos que suma el usuario
		this.medioDePago=medioDePago;
		this.estadoDePago="pagar";
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
	 * @return the comprador
	 */
	public Usuario getComprador() {
		return comprador;
	}

	/**
	 * @param comprador the comprador to set
	 */
	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
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
	public String getMedioDePago() {
		return medioDePago;
	}

	/**
	 * @param medioDePago the medioDePago to set
	 */
	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}

	/**
	 * @return the estadoDePago
	 */
	public String getEstadoDePago() {
		return estadoDePago;
	}

	/**
	 * @param estadoDePago the estadoDePago to set
	 */
	public void setEstadoDePago(String estadoDePago) {
		this.estadoDePago = estadoDePago;
	}
	
	
}
