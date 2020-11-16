package ar.edu.unlam.proyectoprogramacion2020;

public class Usuario extends Persona{
	
	private String mail;
	private String contraseña;
	private Integer Id;
	private Integer puntos;
	private Double saldo;
	private Boolean estadoLogin;
	
	public Usuario(String nombre, String apellido, String mail, String contraseña, Integer id, Double saldo) {
		super(nombre, apellido);
		this.mail = mail;
		this.contraseña = contraseña;
		this.Id = id;
		this.setPuntos(puntos);
		this.saldo = saldo;
		this.estadoLogin=false;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	public Boolean getEstadoLogin() {
		return estadoLogin;
	}

	public void setEstadoLogin(Boolean estadoLogin) {
		this.estadoLogin = estadoLogin;
	}
	
	
}
