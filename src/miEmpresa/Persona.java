package miEmpresa;

import java.io.Serializable;

public class Persona implements Serializable
{
	private String nombre;
	private String dni;
	private String legajo;
	private String licencia;
	private String foto;
	
	
	public Persona(String nombreCompleto, String DNI, String leg, String rutaFoto, String licencia)
	{
		this.nombre = nombreCompleto;
		this.dni = DNI;
		this.legajo = leg;
		this.licencia = licencia;
		this.foto = rutaFoto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getLegajo() {
		return legajo;
	}


	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}


	public String getLicencia() {
		return licencia;
	}


	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

//Dos personas son iguales cuando poseen el mismo dni
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	public String toString()
	{
		String ret ="Nombre: " + this.nombre  + " - DNI:"  +this.dni;
		return ret;
	}
	
	
}

