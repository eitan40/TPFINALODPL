package test.testMapa;

import static org.junit.Assert.*;
import mapa.Coordenada;
import mapa.Direccion;
import mapa.Domicilio;

import org.junit.Test;

public class TestDomicilio {

	@Test
	public void test() 
	{
		//test equals del domicilio
		
		Direccion dire= new Direccion ("Cordoba","Villa carlos paz","Peron", 3112);
		Coordenada coordenada = new Coordenada(-25.34651321,22.164434);
		Domicilio dom1 = new Domicilio(dire, coordenada);
		Domicilio dom2 = new Domicilio(dire, coordenada);
		
		assertTrue(dom1.equals(dom2));
		
	}

}
