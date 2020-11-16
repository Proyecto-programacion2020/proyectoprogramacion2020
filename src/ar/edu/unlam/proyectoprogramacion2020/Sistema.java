package ar.edu.unlam.proyectoprogramacion2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Sistema {

	private ArrayList<Producto>listaProductos;
	private HashSet<Cliente>listaClientes;
	private HashSet<Administrador>listaAdministradores;
	private ArrayList<Ventas>listaVentas;
	private ArrayList<Ventas> ListadoPagadosPorPuntos;
	private ArrayList<Ventas>pagadosConTarjeta;
	private String nombre;
	
	
	public Sistema(String nombre) {
		this.nombre=nombre;
		this.listaProductos = new ArrayList<Producto>();
		this.listaClientes = new HashSet<Cliente>();
		this.listaAdministradores=new HashSet<Administrador>();
		this.listaVentas = new ArrayList<Ventas>();
		this.ListadoPagadosPorPuntos= new ArrayList<Ventas>();
		this.pagadosConTarjeta=new ArrayList<Ventas>();
	}

	public Boolean loginAdministrador (String mail, String contraseña){
		
		for(Administrador u:listaAdministradores){
			if((u.getMail().equals(mail))&&(u.getContraseña().equals(contraseña))){
				u.setEstadoLogin(true);
				return true;
			}
		}
		
		return false;	
	}
	
	public Boolean loginCliente (String mail, String contraseña){
		
		for(Cliente a:listaClientes){
			if((a.getMail().equals(mail))&&(a.getContraseña().equals(contraseña))){
				a.setEstadoLogin(true);
				return true;
			}
		}
		return false;	
	}
	
	public Boolean registrarCliente(Cliente nuevo){
		for(Cliente u: listaClientes){
			if(u.getId().equals(nuevo.getId())){
				return false;
			}
		}
		listaClientes.add(nuevo);
		nuevo.setPuntos(20);
		return true;
	}
	
	public Boolean registrarAdministrador(Administrador nuevo){
		for(Administrador u: listaAdministradores){
			if(u.getId().equals(nuevo.getId())){
				return false;
			}
			}
			listaAdministradores.add(nuevo);
			nuevo.setPuntos(20);
			return true; 
	}
	
	public void agregarProducto(Producto nuevo, Administrador admin){
		
			if(admin.getEstadoLogin()){
				listaProductos.add(nuevo);
			}
		}
	
	public Boolean pagarConPuntos(Ventas nueva){
		
		for(Ventas v: listaVentas){
			
				if(v.getIdVenta().equals(nueva.getIdVenta())){//chequea que la venta existe
					
					if(nueva.getCliente().getEstadoLogin()){//chequea que el cliente esta logueado
						
						if(v.getMedioDePago().equals(MedioDePago.PUNTOS)){//chequea medio de pago
							
							if(v.getCliente().getPuntos()>=v.getTotalPuntos()){// chequea que el cliente tenga puntos para pagar
								
								v.setEstadoDePago(true);
								ListadoPagadosPorPuntos.add(nueva);
								
								Integer puntosVigentesDelCliente= v.getCliente().getPuntos();
								puntosVigentesDelCliente-=v.getTotalPuntos();
								puntosVigentesDelCliente+=v.getCantidadPuntos();
								v.getCliente().setPuntos(puntosVigentesDelCliente);
								return true;
							} 
						}
					}
			}
		} 
		anularCompra(nueva);
		return false;
		
	}

	public Boolean pagarConTarjeta(Ventas nueva){
		
		for(Ventas v: listaVentas){
			
				if(v.getIdVenta().equals(nueva.getIdVenta())){//chequea que la venta existe
					
					if(nueva.getCliente().getEstadoLogin()){//chequea que el cliente esta logueado
						
						if(v.getMedioDePago().equals(MedioDePago.TARJETA)){//chequea medio de pago
							
							if(v.getCliente().getSaldo()>=v.getPrecioTotal()){// chequea que el cliente tenga puntos para pagar
								
								v.setEstadoDePago(true);
								pagadosConTarjeta.add(nueva);
								
								Double saldoVigenteDelCliente= v.getCliente().getSaldo();
								saldoVigenteDelCliente-=v.getPrecioTotal();
								v.getCliente().setSaldo(saldoVigenteDelCliente);
								
								Integer puntosVigentesDelCliente=v.getCliente().getPuntos();
								puntosVigentesDelCliente+=v.getCantidadPuntos();
								v.getCliente().setPuntos(puntosVigentesDelCliente);
								return true;
							}
						}
					}
			}
		}
		anularCompra(nueva);
		return false;
		
	}
	
	
	
	
	public void agregarVenta(Ventas nueva, Administrador nuevo){
		if(nuevo.getEstadoLogin()){
		listaVentas.add(nueva);
	}
	}
	
	public void anularCompra(Ventas nueva){
		for(int i=0;i<listaVentas.size();i++){
			if(listaVentas.get(i).getIdVenta().equals(nueva.getIdVenta())){
				listaVentas.remove(nueva);
			}
		}
	}
	
	public String toStringDeTarjeta() {
		String variable ="";
		for(Integer i=0;i<pagadosConTarjeta.size();i++){
			variable+="Nombre y Apellido: " + pagadosConTarjeta.get(i).getCliente().getNombre() + " " + pagadosConTarjeta.get(i).getCliente().getApellido() + " Total Compra: $" + pagadosConTarjeta.get(i).getPrecioTotal() 
			+ " ID: " + pagadosConTarjeta.get(i).getIdVenta() + "\n";
		}
		return variable;
	}
	
	public String toStringDePuntos() {
		String variable ="";
		for(Integer i=0;i<ListadoPagadosPorPuntos.size();i++){
			variable+="Nombre y Apellido: " + ListadoPagadosPorPuntos.get(i).getCliente().getNombre() + " " + ListadoPagadosPorPuntos.get(i).getCliente().getApellido() + " Total Compra: $" + ListadoPagadosPorPuntos.get(i).getPrecioTotal() 
			+ " ID: " + ListadoPagadosPorPuntos.get(i).getIdVenta() + "\n";
		}
		return variable;
	}


	
	/**
	 * @return the listaProductos
	 */
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	/**
	 * @param listaProductos the listaProductos to set
	 */
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	/**
	 * @return the listaClientes
	 */
	public HashSet<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(HashSet<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * @return the listaAdministrador
	 */
	public HashSet<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	/**
	 * @param listaAdministrador the listaAdministrador to set
	 */
	public void setListaAdministradores(HashSet<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	/**
	 * @return the listaVentas
	 */
	public ArrayList<Ventas> getListaVentas() {
		return listaVentas;
	}

	/**
	 * @param listaVentas the listaVentas to set
	 */
	public void setListaVentas(ArrayList<Ventas> listaVentas) {
		this.listaVentas = listaVentas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Ventas> getListadoPagadosPorPuntos() {
		return ListadoPagadosPorPuntos;
	}

	public void setListadoPagadosPorPuntos(ArrayList<Ventas> listadoPagadosPorPuntos) {
		ListadoPagadosPorPuntos = listadoPagadosPorPuntos;
	}

	/**
	 * @return the pagadosConTarjeta
	 */
	public ArrayList<Ventas> getPagadosConTarjeta() {
		return pagadosConTarjeta;
	}

	/**
	 * @param pagadosConTarjeta the pagadosConTarjeta to set
	 */
	public void setPagadosConTarjeta(ArrayList<Ventas> pagadosConTarjeta) {
		this.pagadosConTarjeta = pagadosConTarjeta;
	}
	
	
	}
	
	
	
