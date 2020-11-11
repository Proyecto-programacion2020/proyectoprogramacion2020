package ar.edu.unlam.proyectoprogramacion2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Sistema {

	private ArrayList<Producto>listaProductos;
	private HashSet<Cliente>listaClientes;
	private HashSet<Administrador>listaAdministradores;
	private ArrayList<Ventas>listaVentas;
	private String nombre;
	
	
	public Sistema(String nombre) {
		this.nombre=nombre;
		this.listaProductos = new ArrayList<Producto>();
		this.listaClientes = new HashSet<Cliente>();
		this.listaAdministradores=new HashSet<Administrador>();
		this.listaVentas = new ArrayList<Ventas>();
	}

	public Boolean loginAdministrador (Integer Id){
		
		for(Administrador u:listaAdministradores){
			if(u.getId().equals(Id)){
				
				return true;
			}
		}
		
		return false;	
	}
	
	public Boolean loginCliente (Integer Id){
		
		for(Cliente a:listaClientes){
			if(a.getId().equals(Id)){
				
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
		
			if(loginAdministrador(admin.getId())){
				listaProductos.add(nuevo);
			}
		}
	
	public void pagarConPuntos(Ventas nueva){
		
		for(Ventas v: listaVentas){
			
				if(v.getIdVenta().equals(nueva.getIdVenta())){//chequea que la venta existe
					
					if(loginCliente(nueva.getCliente().getId())){//chequea que el cliente esta logueado
						
						if(v.getMedioDePago().equals(MedioDePago.PUNTOS)){//chequea medio de pago
							
							if(v.getCliente().getPuntos()>=v.getTotalPuntos()){// chequea que el cliente tenga puntos para pagar
								
								v.setEstadoDePago(true);
								
								Integer puntosVigentesDelCliente= v.getCliente().getPuntos();
								puntosVigentesDelCliente-=v.getTotalPuntos();
								puntosVigentesDelCliente+=v.getCantidadPuntos();
								v.getCliente().setPuntos(puntosVigentesDelCliente);
							}
						}
					}
			}
		}
		
	}

	public void pagarConTarjeta(Ventas nueva){
		
		for(Ventas v: listaVentas){
			
				if(v.getIdVenta().equals(nueva.getIdVenta())){//chequea que la venta existe
					
					if(loginCliente(nueva.getCliente().getId())){//chequea que el cliente esta logueado
						
						if(v.getMedioDePago().equals(MedioDePago.TARJETA)){//chequea medio de pago
							
							if(v.getCliente().getSaldo()>=v.getPrecioTotal()){// chequea que el cliente tenga puntos para pagar
								
								v.setEstadoDePago(true);
								
								Double saldoVigenteDelCliente= v.getCliente().getSaldo();
								saldoVigenteDelCliente-=v.getPrecioTotal();
								v.getCliente().setSaldo(saldoVigenteDelCliente);
								
								Integer puntosVigentesDelCliente=v.getCliente().getPuntos();
								puntosVigentesDelCliente+=v.getCantidadPuntos();
								v.getCliente().setPuntos(puntosVigentesDelCliente);
							}
						}
					}
			}
		}
		
	}


	
	public void agregarVenta(Ventas nueva, Integer Id){
		if(loginAdministrador(Id)){
		listaVentas.add(nueva);
	}
	}
	
	public void anularCompra(Ventas nueva){
		for(Ventas v:listaVentas){
			if(v.getIdVenta().equals(nueva.getIdVenta())){
				listaVentas.remove(nueva);
			}
		}
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

	
	
	}
	
	
	
