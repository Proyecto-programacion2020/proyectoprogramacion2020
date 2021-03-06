package ar.edu.unlam.proyectoprogramacion2020;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {

	@org.junit.Test
	public void testQueVerificaQueElClienteSePuedaLoguear() {
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia);
		
		assertTrue(virtual.loginCliente("nadiasierra@gmail.com","nadius2020"));
	}

	
	@org.junit.Test
	public void testQueVerificaQueElAdministradorSePuedaLoguear(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Administrador nadia= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarAdministrador(nadia);
		
		assertTrue(virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2020"));
	}

	@org.junit.Test
	public void testQueVerificaQueElClienteNoSePuedaLoguear() {

		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia);
		
		assertFalse(virtual.loginCliente("nadiasierra@gmail.com","nadius2018"));
	}

	@org.junit.Test
	public void testQueVerificaQueElAdministradorNoSePuedaLoguear() {

		Sistema virtual= new Sistema ("virtual");
		
		Administrador nadia= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia);
		
		assertFalse(virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2020"));
	}
	
	
	
	@org.junit.Test
	public void testQueVerificaQueSePagueUnaVentaConPuntos(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.PUNTOS, 
				5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
		virtual.pagarConPuntos(nueva);
						
		Boolean esperado=true;
		
		assertEquals(esperado, nueva.getEstadoDePago());
		
				
	}
	
	@org.junit.Test
	public void testQueVerificaQueSePagueUnaVentaConTarjeta(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.TARJETA, 
				5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
		virtual.pagarConTarjeta(nueva);
						
		Boolean esperado=true;
		
		assertEquals(esperado, nueva.getEstadoDePago());
						
	}
	
	@org.junit.Test
	public void testQueVerificaQueNoSeAgreguenDosClientesIguales() {

		Sistema virtual= new Sistema ("virtual");
		
		Cliente marce= new Cliente("marce", "gonzalez", "marcegonza@gmail.com", "marce2020", 03, 20.0);
		
		Cliente marce2= new Cliente("marce", "gonzalez", "marcegonza@gmail.com", "marce2020", 03, 20.0);
		
		virtual.registrarCliente(marce);
				
		Boolean vo= virtual.registrarCliente(marce2);
		
		Boolean ve=false;
		
		assertEquals(ve, vo);
	}

	@org.junit.Test
	public void testQueVerificaQueNoSeAgreguenDosAdministradoresIguales() {

		Sistema virtual= new Sistema ("virtual");
		
		Administrador luz= new Administrador("luz", "juarez", "luzjuarez@gmail.com", "nadius2021", 03, 20.0);

		Administrador luz2= new Administrador("luz", "juarez", "luzjuarez@gmail.com", "nadius2021", 03, 20.0);

		virtual.registrarAdministrador(luz);
				
		Boolean vo= virtual.registrarAdministrador(luz2);
		
		Boolean ve=false;
		
		assertEquals(ve, vo);
	}
	
	@org.junit.Test
	public void testQueSiNoLlegaConLosPuntosSeAnulaLaCompra () {
		Sistema virtual= new Sistema ("virtual");
		
		Cliente elCliente= new Cliente("lucia", "tonietti", "toniettilucia@gmail.com", "contra123", 8, 20.0);
		
		virtual.registrarCliente(elCliente); //se registra cliente
		
		virtual.loginCliente("toniettilucia@gmail.com", "contra123"); //se loguea
						
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 50); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, elCliente, galles, MedioDePago.PUNTOS, 5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
				
		Boolean ve= false;
		Boolean vo= virtual.pagarConPuntos(nueva);
		 
		assertEquals(ve,vo);

	}
	
	@org.junit.Test
	public void testQueSiNoLlegaConElSaldoSeAnulaLaCompra () {
		Sistema virtual= new Sistema ("virtual");
		
		Cliente elCliente= new Cliente("lucia", "tonietti", "toniettilucia@gmail.com", "contra123", 8, 20.0);
		
		virtual.registrarCliente(elCliente); //se registra cliente
		
		virtual.loginCliente("toniettilucia@gmail.com", "contra123"); //se loguea
						
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 25.0, 50); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, elCliente, galles, MedioDePago.TARJETA, 5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
				
		Boolean ve= false;
		Boolean vo= virtual.pagarConTarjeta(nueva);
		 
		assertEquals(ve,vo);

	}
	
	@org.junit.Test
	public void testQueVerificaQueSeAgregueLAVentaConPuntosALaListaDePagados(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.PUNTOS, 
				5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
		virtual.pagarConPuntos(nueva);
		
		Boolean esperado=true;
		Boolean vo=false;
		
		for (Ventas v : virtual.getListadoPagadosPorPuntos()) {
			if(v.getIdVenta()==nueva.getIdVenta())
				vo= true;
		}
		
		assertEquals(esperado, vo);
	}
	
	@org.junit.Test
	public void testQueVerificaQueSeAgregueLAVentaConTarjetaALaListaDePagados(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
						
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		virtual.agregarProducto(galles, nadia2);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.TARJETA, 
				5);
				
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		
		virtual.pagarConTarjeta(nueva);
		
		Boolean esperado=true;
		Boolean vo=false;
		
		for (Ventas v : virtual.getPagadosConTarjeta()) {
			if(v.getIdVenta()==nueva.getIdVenta())
				vo= true;
		}
		
		
		assertEquals(esperado, vo);
	}
	
	@org.junit.Test
	public void testQueVerificaQueObtieneTotalPagadasPorTajeta(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		Cliente cliente2= new Cliente("nombre", "ap", "mail", "contra", 04, 50.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		virtual.registrarCliente(cliente2);
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
		virtual.loginCliente("mail", "contra"); 				
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		Administrador nadia3= new Administrador("nadia", "sierra", "nadiasierra@gmail.com.ar", "nadius2025", 04, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		virtual.registrarAdministrador(nadia3);
		
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		virtual.loginAdministrador("nadiasierra@gmail.com.ar", "nadius2025");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		Producto galles2= new Producto("Pepa", 4045, "Pepas", 15.0, 8); 
		
		virtual.agregarProducto(galles, nadia2);
		
		virtual.agregarProducto(galles2, nadia3);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.TARJETA, 
				5);
		
		Ventas nueva2= new Ventas(02, 01, cliente2, galles2, MedioDePago.TARJETA, 
				5);
		
		
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		virtual.agregarVenta(nueva2, nadia3);
		
		virtual.pagarConTarjeta(nueva);
		virtual.pagarConTarjeta(nueva2);
							
		Integer valorEsperado = 2;
		Integer valorObtenido = 0;
		
		for(Integer i=0;i<virtual.getPagadosConTarjeta().size();i++){
			valorObtenido++;
		}
		
		assertEquals(valorEsperado, valorObtenido);
						
	}
	
	@org.junit.Test
	public void testQueVerificaQueObtieneTotalPagadasPorPuntos(){
		
		Sistema virtual= new Sistema ("virtual");
		
		Cliente nadia= new Cliente("nadia", "sierra", "nadiasierra@gmail.com", "nadius2020", 03, 20.0);
		
		Cliente cliente2= new Cliente("nombre", "ap", "mail", "contra", 04, 50.0);
		
		virtual.registrarCliente(nadia); //se registra cliente
		virtual.registrarCliente(cliente2);
		
		virtual.loginCliente("nadiasierra@gmail.com", "nadius2020"); //se loguea
		virtual.loginCliente("mail", "contra"); 				
	
		Administrador nadia2= new Administrador("nadia", "sierra", "nadiasierra@gmail.com", "nadius2021", 03, 20.0);
		Administrador nadia3= new Administrador("nadia", "sierra", "nadiasierra@gmail.com.ar", "nadius2025", 04, 20.0);
		
		virtual.registrarAdministrador(nadia2);
		virtual.registrarAdministrador(nadia3);
		
		
		virtual.loginAdministrador("nadiasierra@gmail.com", "nadius2021");
		virtual.loginAdministrador("nadiasierra@gmail.com.ar", "nadius2025");
		
		Producto galles= new Producto("Oreo", 4040, "Oreo", 20.0, 10); 
		
		Producto galles2= new Producto("Pepa", 4045, "Pepas", 15.0, 8); 
		
		virtual.agregarProducto(galles, nadia2);
		
		virtual.agregarProducto(galles2, nadia3);
		
		Ventas nueva= new Ventas(01, 01, nadia, galles, MedioDePago.PUNTOS, 
				5);
		
		Ventas nueva2= new Ventas(02, 01, cliente2, galles2, MedioDePago.PUNTOS, 
				5);
		
		
		virtual.agregarVenta(nueva, nadia2); // agrega la venta a la lista
		virtual.agregarVenta(nueva2, nadia3);
		
		virtual.pagarConPuntos(nueva);
		virtual.pagarConPuntos(nueva2);
							
		Integer valorEsperado = 2;
		Integer valorObtenido = 0;
		
		for(Integer i=0;i<virtual.getListadoPagadosPorPuntos().size();i++){
			valorObtenido++;
		}
		
		assertEquals(valorEsperado, valorObtenido);
						
	}
	
	
}



