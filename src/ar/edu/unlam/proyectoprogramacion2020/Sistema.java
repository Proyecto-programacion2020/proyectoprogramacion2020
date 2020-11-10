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
	
	public void pagar(Ventas nueva){
		if(loginCliente(nueva.getCliente().getId())){
		for(Ventas v: listaVentas){
			
			if(v.getIdVenta().equals(nueva.getIdVenta())&&v.getEstadoDePago()==false){
				
				if(v.getMedioDePago()==MedioDePago.PUNTOS&&v.getCliente().getPuntos()>=v.getTotalPuntos()){
					v.getCliente().setPuntos(v.getCliente().getPuntos()-v.getTotalPuntos());
			
					nueva.setEstadoDePago(true);
					nueva.getCliente().setPuntos(nueva.getCantidadPuntos());
					
				}else if (v.getMedioDePago()==MedioDePago.TARJETA &&v.getCliente().getSaldo()>=v.getPrecioTotal()){
						v.getCliente().setSaldo(v.getCliente().getSaldo()-v.getPrecioTotal());
						
						nueva.setEstadoDePago(true);
						nueva.getCliente().setPuntos(nueva.getCantidadPuntos());

				}
				anularCompra(nueva);

				}
			}
		}
	}
	
	public void agregarVenta(Ventas nueva){
		if(loginAdministrador(nueva.getCliente().getId())){
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
	
	
	
