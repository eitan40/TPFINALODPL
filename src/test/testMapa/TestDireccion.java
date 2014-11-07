package test.testMapa;

import static org.junit.Assert.*;
import mapa.Direccion;

import org.junit.Test;

public class TestDireccion {

	@Test
	//prueba de equals
	public void test() 
	{
		Direccion dire1= new Direccion ("Cordoba","Villa carlos paz","Peron", 3112);
		Direccion dire2= new Direccion ("Cordoba","Villa carlos paz","Peron", 3112);
		Direccion dire3= new Direccion ("San luis","Villa carlos paz","Peron", 3112);
		Direccion dire4= new Direccion ("Cordoba","plaza","Peron", 3112);
		Direccion dire5= new Direccion ("Cordoba","Villa carlos paz","San martin", 3112);
		Direccion dire6= new Direccion ("Cordoba","Villa carlos paz","Peron", 9232);
		
		//Pruebas de equals direccion
		
		assertTrue(dire1.equals(dire2));
		assertFalse(dire1.equals(dire3));
		assertFalse(dire1.equals(dire6));
		assertFalse(dire2.equals(dire5));
		assertFalse(dire5.equals(dire4));
		assertFalse(dire3.equals(dire4));
		assertTrue(dire1.equals(dire1));
	}

}
