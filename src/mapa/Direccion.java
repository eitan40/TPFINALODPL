package mapa;

import java.io.Serializable;


public class Direccion implements Serializable
{
	private String pais;
	private String provincia;
	private String localidad;
	private String calle;
	private int altura;
	
	
	
	//Vamos a trabajar con clientes  de argentina
	public Direccion(String prov, String loca, String calle, int altura)
	{
		this.pais = "Argentina";
		this.provincia = prov;
		this.localidad = loca;
		this.calle = calle;
		this.altura = altura;
	}




	public String getProvincia() 
	{
		return provincia;
	}


	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}


	public String getLocalidad() 
	{
		return localidad;
	}

	
	public void setLocalidad(String localidad) 
	{
		this.localidad = localidad;
	}


	public String getCalle() 
	{
		return calle;
	}


	public void setCalle(String calle) 
	{
		this.calle = calle;
	}

	
	public int getAltura() 
	{
		return altura;
	}


	public void setAltura(int altura) 
	{
		this.altura = altura;
	}
	
	
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + altura;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result
				+ ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}




	//Dos direcciones son iguales cuando todos sus parametros coinciden
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Direccion))
			return false;
		Direccion other = (Direccion) obj;
		if (altura != other.altura)
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}




	public String toString()
	{
		return calle + " " + altura + "," + localidad + "," + provincia;
	}
	
	
}
