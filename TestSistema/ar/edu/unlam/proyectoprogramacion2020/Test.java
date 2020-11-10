package ar.edu.unlam.proyectoprogramacion2020;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void testQueVerificaQueElClienteSePuedaLoguear() {
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia);
		
		assertTrue(virtual.loginCliente(03));
	}

	
	@org.junit.Test
	public void testQueVerificaQueElAdministradorSePuedaLoguear(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Administrador nadia= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarAdministrador(nadia);
		
		assertTrue(virtual.loginAdministrador(03));
	}

	@org.junit.Test
	public void testQueVerificaQueElClienteNoSePuedaLoguear() {

		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia);
		
		assertFalse(virtual.loginCliente(04));
	}

	@org.junit.Test
	public void testQueVerificaQueElAdministradorNoSePuedaLoguear() {

		Sistema virtual= new Sistema ("virtual");
		
		Administrador nadia= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia);
		
		assertFalse(virtual.loginAdministrador(04));
	}
}



