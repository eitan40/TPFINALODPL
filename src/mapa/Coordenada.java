package mapa;

import java.io.Serializable;

public class Coordenada implements Serializable
{
	
	private double latitud;
	private double longitud;
	
	//El constructor debe recibir una direccion en formato
	//string y convertirla en coordenadas(Latitud, longitud)
	//a partir de hallar la ubicacion en el mapa

	
	
	//Implementado en forma provisoria - buscar como hacerlo !!!!!!!!!!!!!!!!!!!!!!!1
	
	public Coordenada(double latitud, double longitud) 
	{
		this.longitud = latitud;
		this.latitud = longitud;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	
	//Dos coordenadas son iguales cuando su latitud y longitud son iguales
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordenada))
			return false;
		Coordenada other = (Coordenada) obj;
		if (Double.doubleToLongBits(latitud) != Double
				.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double
				.doubleToLongBits(other.longitud))
			return false;
		return true;
	}

	
	
	
	@Override
	public String toString()
	{
		return "(" + this.latitud + "," + this.longitud + ")";
	}

	
}
