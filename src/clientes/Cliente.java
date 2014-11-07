package clientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import mapa.Coordenada;
import mapa.Direccion;
import mapa.Domicilio;


public class Cliente implements Serializable
{

//variables de negocio
	
	//cuit del cliente
	private String Cuit;
		
	//Domicilios de la empresa - aqui se tiene en cuenta 
	// cuando una empresa tiene sucursales
	public Set<Domicilio> domicilios;
	
	//variables de instancia secundarias		
	//Nombre fiscal del cliente
	private String Nombre;
	
	//telefono para contactarse
	private String telefono;

	//contacto en la empresa
	private String nombre_Contacto;
	
	
	public Cliente(String cuit, Direccion direccion, Coordenada coord,  String nombre, String tel, String contacto)
	{
		this.Nombre = nombre;
		this.Cuit= cuit;
		this.telefono = tel;
		
		if(this.domicilios ==null)
		this.domicilios = new HashSet<Domicilio>();
		
		domicilios.add(new Domicilio(direccion,coord));

		this.nombre_Contacto = contacto;
		
	}
	
	
	//devuelve el nombre del cliente
	public String getNombre() 
	{
		return Nombre;
	}


	
	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}

	
	
	public String getCuit() 
	{
		return this.Cuit;
	}


	
	public void setCuit(String cuit) 
	{
		Cuit = cuit;
	}

	// devuelve los domicilios del cliente
	public Set<Domicilio> getDomicilios() 
	{
		return this.domicilios;
	}
	


	public String getTelefono() 
	{
		return telefono;
	}


	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}


	public String getNombre_Contacto() 
	{
		return nombre_Contacto;
	}


	public void setNombre_Contacto(String nombre_Contacto) 
	{
		this.nombre_Contacto = nombre_Contacto;
	}


	public void setDomicilios(Set<Domicilio> domicilios) 
	{
		this.domicilios = domicilios;
	}

	public void agregarDomicilio(Direccion dire, Coordenada coordenada) 
	{
		Domicilio dom = new Domicilio(dire, coordenada);
		
		//agrego la sucursal si es que esta ya no pertenece al cliente
		//YA lo implementa el Set
		this.domicilios.add(dom);
	}



	
	//Borrar un domicilio
	public void borrarDomicilio(Direccion dire)
	{
		this.domicilios.remove(dire);
	}
	
	//cantidad de sucursales
	public int cantidadSucursales()
	{
		return this.domicilios.size();
	}
	
	

	//Dos empresas son iguales cuando tienen el mismo cuit
	//Puede haber dos empresas distintas con las mismas coordenas, pues estan en el mismo edificio
	
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cuit == null) ? 0 : Cuit.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		if (Cuit == null) {
			if (other.Cuit != null)
				return false;
		} else if (!Cuit.equals(other.Cuit))
			return false;
		return true;
	}


	@Override
	public String toString()
	{
		return Nombre;
		
	}


	
}
