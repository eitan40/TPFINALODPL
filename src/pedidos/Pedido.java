package pedidos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import mapa.Coordenada;
import mapa.Direccion;
import mapa.Domicilio;
import miEmpresa.Camiones;
import miEmpresa.Persona;
import clientes.Cliente;


 

public class Pedido implements Serializable
{
	
	public static enum Estado
	{
		Solicitado, Asignado, Cerrado, Anulado;
		
		public static int cantOpciones(){
			return 4;
		}
	}

	
	//estado del pedido: Solicitado, Asignado, Cerrado, Anulado;
	private Estado estado;
	
	//Direccion de la empresa
	private Direccion direccion;
	
	//Coordenadas de la empresa, segun la direccion
	private Coordenada coordenada;
	
	//Domicilio de las sucursales
	private Set<Domicilio> domicilio;
	
	//empresa a la que pertenece el pedido
	private Cliente empresa;
	
	//fecha que se realizo el pedido
	private Fecha fecha_de_pedido;
	
	//contacto que solicito o recibira el pedido
	private String contacto_pedido;
	
	//telefono del contacto
	private String telefono_contacto;

	
	//observaciones del pedido, por ej explicacion de como llegar 
	private String observaciones;
	
	//Camion que se le asigna
	private Camiones camion;
	
	//Chofer asignado
	private Persona chofer;

	
	
	
	
	public Pedido(Cliente emp, String contacto, String telefono, String obs, Direccion dire, double latitud, double longitud)
	{	
		this.estado = Estado.Solicitado;
		this.empresa = emp;
		this.fecha_de_pedido = new Fecha();
		this.contacto_pedido = contacto;
		this.telefono_contacto = telefono;
		this.observaciones = obs;
		this.camion = null;
		this.chofer = null;	
		this.direccion = dire;
		this.coordenada = new Coordenada(latitud, longitud);
		this.domicilio = new HashSet<Domicilio>();
		this.domicilio.add(new Domicilio(direccion, coordenada));
	}



	public Estado getEstado() 
	{
		return estado;
	}


	public void setEstado(Estado estado) 
	{
		this.estado = estado;
	}



	public Cliente getCliente() 
	{
		return empresa;
	}



	public void setCliente(Cliente empresa) {
		this.empresa = empresa;
	}


	public Set<Domicilio> getDomicilio() 
	{
		return domicilio;
	}



//	public void setDomicilio(Domicilio domicilio) 
//	{
//		this.domicilio = domicilio;
//	}

	public Fecha getFecha() 
	{
		return fecha_de_pedido;
	}



	public void setFecha(Fecha fecha_de_pedido) 
	{
		this.fecha_de_pedido = fecha_de_pedido;
	}



	public String getContacto_pedido() 
	{
		return contacto_pedido;
	}



	public void setContacto_pedido(String contacto_pedido) 
	{
		this.contacto_pedido = contacto_pedido;
	}



	public String getTelefono_contacto() 
	{
		return telefono_contacto;
	}



	public void setTelefono_contacto(String telefono_contacto) 
	{
		this.telefono_contacto = telefono_contacto;
	}



	public String getObservaciones() 
	{
		return observaciones;
	}



	public void setObservaciones(String observaciones) 
	{
		this.observaciones = observaciones;
	}



	public Camiones getCamion() 
	{
		return camion;
	}



	public void setCamion(Camiones camion) 
	{
		this.camion = camion;
	}



	public Persona getChofer() 
	{
		return chofer;
	}



	public void setChofer(Persona chofer) 
	{
		this.chofer = chofer;
	}

	
	
	

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((fecha_de_pedido == null) ? 0 : fecha_de_pedido.hashCode());
		return result;
	}

	//Dos pedidos son iguales cuando pertenecen a la misma empresa, tienen igual fecha
	//tienen igual domicilio, igual estado

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (estado != other.estado)
			return false;
		if (fecha_de_pedido == null) {
			if (other.fecha_de_pedido != null)
				return false;
		} else if (!fecha_de_pedido.equals(other.fecha_de_pedido))
			return false;
		return true;
	}


	@Override
	public String toString()
	{
		return this.empresa.getNombre().toString() + "fecha:" + fecha_de_pedido ;
		
	}




	
}
