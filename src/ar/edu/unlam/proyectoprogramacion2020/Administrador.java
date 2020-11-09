package ar.edu.unlam.proyectoprogramacion2020;

public class Administrador extends Usuario {

	Integer factorPuntos;

	public Administrador(Integer factorPuntos, String nombre, String apellido, String mail, String contrase�a, Integer id, Integer puntos, Double saldo) {
		super(nombre, apellido, mail, contrase�a, id, puntos, saldo);
		this.factorPuntos = factorPuntos;
	}

	public Integer getFactorPuntos() {
		return factorPuntos;
	}

	public void setFactorPuntos(Integer factorPuntos) {
		this.factorPuntos = factorPuntos;
	}

}
