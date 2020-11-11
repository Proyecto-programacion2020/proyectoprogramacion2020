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
	
	
	
	@org.junit.Test
	public void testQueVerificaQueSePagueUnaVentaConPuntos(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente(03); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador(03);
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.PUNTOS, 
				5);
				
		virtual.agregarVenta(nueva, 03); // agrega la venta a la lista
		
		virtual.pagarConPuntos(nueva);
						
		Boolean esperado=true;
		
		assertEquals(esperado, nueva.getEstadoDePago());
		
		System.out.println(nadia.getPuntos());
				
	}
	
	@org.junit.Test
	public void testQueVerificaQueSePagueUnaVentaConTarjeta(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente(03); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador(03);
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.TARJETA, 
				5);
				
		virtual.agregarVenta(nueva, 03); // agrega la venta a la lista
		
		virtual.pagarConPuntos(nueva);
						
		Boolean esperado=true;
		
		assertEquals(esperado, nueva.getEstadoDePago());
		
		System.out.println(nadia.getPuntos());
				
	}
}



