package test.testClientes;

import static org.junit.Assert.*;
import mapa.Coordenada;
import mapa.Direccion;

import org.junit.Test;

import clientes.Cliente;

public class TestCliente {

	//Pruebo el equals de cliente
	
	//dados 2 clientes con su cuit igual, pero distintos el resto de sus parametros
	//estos deben ser iguales
	@Test
	public void testEquals() 
	{
		Coordenada c = new Coordenada(25.565434,20.1546545);
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Direccion dire2 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		
		Cliente nuevo = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio");
		
		Cliente dos = new Cliente("27-32456789-0", dire2,c, "HSBC", "234555","Juan perez");
		
	
		assertTrue(nuevo.equals(dos));
		
		
	}
	
	
	
	//dados 2 clientes con su cuit distinto, pero el resto de sus parametros iguales
	//estos deben ser distintos
	@Test
	public void testEquals2()
	{
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Coordenada c = new Coordenada(25.565434,20.1546545);
		
		Cliente nuevo1 = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio");
		Cliente nuevo2 = new Cliente("27-42456789-0", dire1,c, "Cronos","46634567", "Claudio");
		
		
		
		assertFalse(nuevo1.equals(nuevo2));
	
	}
	
	
	//Testeo agregarDireccionDireccion
	
	@Test
	public void testAgregarDireccion()
	{
		Coordenada c = new Coordenada(25.565434,20.1546545);
		Direccion dire = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		
		Cliente nuevo = new Cliente("27-32456789-0", dire,c, "Cronos","46634567", "Claudio");
	
		//El tamaño de las direcciones de nuevo debe ser igual a 1.
		//ademas testeamos cantidad de sucursales
		
		assertEquals(1,nuevo.cantidadSucursales());
		
		
		//Agrego una sucursal
		
		Direccion dire2 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires", "Juan B Justo", 23433);
		
		nuevo.agregarDomicilio(dire2,c);
		
		assertEquals(2,nuevo.cantidadSucursales());
		
		
//		Este test no pasa, nose en que esta fallando, si las sucurales don repetidas no debe agregarlas
		//Vuelvo a agregar la misma sucursal, como esta esta repetida, no la debe agregar
		nuevo.agregarDomicilio(dire2,c);
		
		assertEquals(2,nuevo.cantidadSucursales());
		
		
	}
	

}
