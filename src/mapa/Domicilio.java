package mapa;

import java.io.Serializable;

public class Domicilio implements Serializable
{
	private Direccion direccion;
	private Coordenada coordenada;
	
	public Domicilio(Direccion dire, Coordenada coordenada)
	{
		this.direccion=dire;
		this.coordenada = coordenada;
	}




	public Direccion getDireccion() 
	{
		return direccion;
	}

	
	public void setDireccion(Direccion direccion) 
	{
		this.direccion = direccion;
	}


	public Coordenada getCoordenada() 
	{
		return coordenada;
	}


	public void setCoordenada(Coordenada coordenada) 
	{
		this.coordenada = coordenada;
	}

	
	
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		return result;
	}

	
	//Dos domicilios son iguales si su direccion y su coordenada son iguales
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Domicilio))
			return false;
		Domicilio other = (Domicilio) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}

	
	
	
	@ Override
	
	public String toString()
	{
		return "dire:" + this.direccion + "coord" + this.coordenada;
	}


	
		
	
}
