package ar.edu.unlam.proyectoprogramacion2020;

public class Usuario extends Persona{
	
	private String mail;
	private String contraseña;
	private Integer Id;
	private Integer puntos;
	private Double saldo;
	
	public Usuario(String nombre, String apellido, String mail, String contraseña, Integer id, Integer puntos, Double saldo) {
		super(nombre, apellido);
		this.mail = mail;
		this.contraseña = contraseña;
		this.Id = id;
		this.puntos = puntos;
		this.saldo = saldo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
