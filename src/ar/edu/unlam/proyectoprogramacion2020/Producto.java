package ar.edu.unlam.proyectoprogramacion2020;

public class Producto extends Categoria {

	private Integer CODIGO;
	private String nombre;
	private Double precioReal;
	private Integer precioPuntos;

	public Producto(String descripcion, Integer CODIGO, String nombre, Double precioReal, Integer precioPuntos) {
		super(descripcion);
		this.CODIGO = CODIGO;
		this.nombre = nombre;
		this.precioReal = precioReal;
		this.precioPuntos = precioPuntos;
	}
	
	

	public Integer getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(Integer cODIGO) {
		CODIGO = cODIGO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioReal() {
		return precioReal;
	}

	public void setPrecioReal(Double precioReal) {
		this.precioReal = precioReal;
	}

	public Integer getPrecioPuntos() {
		return precioPuntos;
	}

	public void setPrecioPuntos(Integer precioPuntos) {
		this.precioPuntos = precioPuntos;
	}
	
	

}
