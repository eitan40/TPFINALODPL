package test.testMapa;

import static org.junit.Assert.*;
import mapa.Coordenada;
import mapa.Direccion;

import org.junit.Test;

public class TestCoordenada {

	//Prueba de equals coordenada
	
	@Test
	public void test()
	{
		double latitud = 0;;
		double longitud = 0;
		Direccion dire = new Direccion("Cordoba","Villa carlos paz","Peron", 3112);
		Coordenada coord1 = new Coordenada(latitud, longitud);
		Coordenada coord2 = new Coordenada(latitud,longitud);
		
		assertTrue(coord1.equals(coord2));
	}

}
