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
	
	// Calcula la distancia entre dos coordenadas
	public static double calcularDistancia(Coordenada c1,Coordenada c2) {

		double a,b;
		if(c1.latitud > c2.latitud)
			a = c1.latitud - c2.latitud;
		else
			a = c2.latitud - c1.latitud;
		
		if(c1.longitud > c2.longitud)
			b = c1.longitud - c2.longitud;
		else
			b = c2.longitud - c1.longitud;

		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
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
