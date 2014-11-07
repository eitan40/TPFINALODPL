package miEmpresa;

import java.io.Serializable;

public class Camiones implements Serializable
{
	private String dominio;
	private String marca;
	private String modelo;
	private int anio;
	private String color;
	
	public Camiones (String patente, String marca, String modelo, String color, int anio)
	{
		this.dominio = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
		return result;
	}

	//Dos camiones son iguales si tienen la misma patente/dominio
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camiones other = (Camiones) obj;
		if (dominio == null) {
			if (other.dominio != null)
				return false;
		} else if (!dominio.equals(other.dominio))
			return false;
		return true;
	}
	
	@Override 
	public String toString()
	{
		String ret = this.dominio + "-" + this.marca + "-" + this.modelo + "-" + this.anio;
		return ret;
	}
	
	
	
}
