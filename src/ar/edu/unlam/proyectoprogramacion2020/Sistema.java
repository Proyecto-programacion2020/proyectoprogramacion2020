package ar.edu.unlam.proyectoprogramacion2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Sistema {

	private ArrayList<Producto>listaProductos;
	private HashSet<Usuario>listaUsuarios;
	private ArrayList<Ventas>listaVentas;
	private String nombre;
	
	public Sistema(String nombre) {
		this.nombre=nombre;
		this.listaProductos = new ArrayList<Producto>();
		this.listaUsuarios = new HashSet<Usuario>();
		this.listaVentas = new ArrayList<Ventas>();
	}

	public Boolean login (Integer Id){
		
		for(Usuario u:listaUsuarios){
			if(u.getId().equals(Id)){
				
				return true;
			}
		}
		
		return false;	
	}
	
	public Boolean registrarUsuario(Usuario nuevo){
		for(Usuario u: listaUsuarios){
			if(u.getId().equals(nuevo.getId())){
				return false;
			}else{
				listaUsuarios.add(nuevo);
				nuevo.setPuntos(20);
			}
		}
		return true; 
	}
	
	public void agregarProducto(Producto nuevo){
		
		listaProductos.add(nuevo);

	}
	
	public void pagar(Ventas nueva){
		if(login(nueva.getComprador().getId())){
		for(Ventas v: listaVentas){
			
			if(v.getIdVenta().equals(nueva.getIdVenta())&&v.getEstadoDePago()==false){
				
				if(v.getMedioDePago()==MedioDePago.PUNTOS&&v.getComprador().getPuntos()>=v.getTotalPuntos()){
					v.getComprador().setPuntos(v.getComprador().getPuntos()-v.getTotalPuntos());
			
					nueva.setEstadoDePago(true);
					nueva.getComprador().setPuntos(nueva.getCantidadPuntos());
					
				}else if (v.getMedioDePago()==MedioDePago.TARJETA &&v.getComprador().getSaldo()>=v.getPrecioTotal()){
						v.getComprador().setSaldo(v.getComprador().getSaldo()-v.getPrecioTotal());
						
						nueva.setEstadoDePago(true);
						nueva.getComprador().setPuntos(nueva.getCantidadPuntos());

				}
				anularCompra(nueva);

				}
			}
		}
	}
	
	public void agregarVenta(Ventas nueva){
		if(login(nueva.getComprador().getId())){
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
	 * @return the listaUsuarios
	 */
	public HashSet<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(HashSet<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
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
	
	
	
