package test.testPedidos;

import static org.junit.Assert.*;

import java.util.Calendar;

import mapa.Coordenada;
import mapa.Direccion;

import org.junit.Test;

import pedidos.Fecha;
import pedidos.Pedido;
import clientes.Cliente;

public class TestPedido {

	
	//Como lo testeo?????
	@Test
	public void testNuevoPedido() 
	{
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Direccion dire2 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		Coordenada c = new Coordenada(25.565434,20.1546545);
		Cliente uno = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio");
		
		Cliente dos = new Cliente("27-32456789-0", dire2,c, "HSBC", "234555","Juan perez");
		
		
		Pedido nuevo1 = new Pedido(uno, "Carlos","6345-4535","ir de 08a15",dire1,25.45687,-25.1546465);
		
		Pedido nuevo2 = new Pedido(dos, "Carlos","4535","",dire2,25.45687,-25.1546465);
		
		System.out.println(nuevo1);
		System.out.println(nuevo2);
	}

}
