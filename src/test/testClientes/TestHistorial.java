package test.testClientes;

import static org.junit.Assert.*;
import mapa.Coordenada;
import mapa.Direccion;

import org.junit.Test;

import pedidos.Fecha;
import pedidos.Pedido;
import pedidos.Pedido.Estado;
import clientes.Cliente;
import clientes.Historial;

public class TestHistorial 
{

	//pruebas de agregar cliente y cantidad de clientes
	@Test
	public void testAgregarCliente() 
	{
		Historial historial = new Historial();
		Coordenada c = new Coordenada(25.565434,20.1546545);
		
		//agrego un cliente
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Cliente nuevo = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio");
		historial.agregarCliente(nuevo);
		
		
		assertEquals(1,historial.cantidadClientes());
		
		//Agrego un cliente con cuit repetido, no deberia agregarlo
		
		Direccion dire2 = new Direccion("Chubut","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Cliente nuevo2 = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio"); 
		historial.agregarCliente(nuevo2);
		
		assertEquals(1,historial.cantidadClientes());
		
		
		//agrego otro cliente nuevo
		Direccion dire3 = new Direccion("Chubut","dffkk" , "peron", 809);
		Cliente nuevo3 = new Cliente("30-675808789-0", dire1,c, "La Blanqueada","46634567", "Claudio"); 
		historial.agregarCliente(nuevo3);
		
		assertEquals(2,historial.cantidadClientes());
		
	
	}
	
	
	@Test
	
	public void TestEliminarCliente()
	{
		Historial historial = new Historial();
		Coordenada c = new Coordenada(25.565434,20.1546545);
		//agrego un cliente
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Cliente nuevo = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio"); 
		historial.agregarCliente(nuevo);
		
		//agrego cliente 2
		Cliente nuevo2 = new Cliente("32-56456789-0", dire1,c, "San Cayetano","46634567", "Claudio"); 
		historial.agregarCliente(nuevo2);
		
		//agrego cliente 3
		Direccion dire3 = new Direccion("Chubut","dffkk" , "peron", 809);
		Cliente nuevo3 = new Cliente("30-675808789-0", dire1,c, "La Blanqueada","46634567", "Claudio"); 
		historial.agregarCliente(nuevo3);
		System.out.println(historial);
		assertEquals(3,historial.cantidadClientes());
		
		//Borro un cliente a partir de la clase cliente
		
		historial.borrarCliente(nuevo3);
		
		assertEquals(2,historial.cantidadClientes());

		
		//agrego un cliente
		Cliente nuevo4 = new Cliente("2345", dire1,c,"Los patos","466", "Pepe"); 
		historial.agregarCliente(nuevo4);
		
		assertEquals(3,historial.cantidadClientes());
		
		
		
		
		//Borro un cliente a partir de su cuit
				
		historial.borrarCliente("2345");
		
		assertEquals(2,historial.cantidadClientes());
		System.out.println(historial);
		
	}
	
	
	//Test no valido solo  - revisar
	
	
	//no hay test implementado- reveer como implementarlos
	@Test
	public void testAgregarPedido()
	{ 
		Coordenada c = new Coordenada(25.565434,20.1546545);
		Direccion dire1 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "San Martin", 663);
		Direccion dire2 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		Direccion dire3 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		Direccion dire4 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		Direccion dire5 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		Direccion dire6 = new Direccion("Buenos Aires","Ciudad Autonoma de Buenos Aires" , "Cordoba", 3452);
		
		Cliente nuevo1 = new Cliente("27-32456789-0", dire1,c, "Cronos","46634567", "Claudio");
		Cliente nuevo2= new Cliente("456789-0", dire2,c, "HSBC", "234555","Juan perez");
		Cliente nuevo3 = new Cliente("3278907378", dire3,c, "Quilmes","46634567", "Claudio");
		Cliente nuevo4= new Cliente("02398080230", dire4,c, "Galicia", "234555","Juan perez");
		Cliente nuevo5 = new Cliente("2309889438", dire5,c, "Color text","46634567", "Claudio");
		Cliente nuevo6= new Cliente("4709823809", dire6,c,"Hospital Sommer", "234555","Juan perez");
		
		
		Pedido p1 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p2 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p3 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p4 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p5 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p6 = new Pedido(nuevo2,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p7 = new Pedido(nuevo4,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		Pedido p8 = new Pedido(nuevo6,"xxx","098''","kjlkldas",dire1, 25.15434,-25.464654);
		
		
		Historial h = new Historial();
		h.agregarCliente(nuevo1);
		h.agregarCliente(nuevo2);
		h.agregarCliente(nuevo3);
		h.agregarCliente(nuevo4);
		h.agregarCliente(nuevo5);
		h.agregarCliente(nuevo6);
		
		
		
		
		System.out.println(h);
		System.out.println("+++++++++++agrego pedido");
		h.agregarPedido(p8);
		
		p1.setEstado(Estado.Cerrado);
		h.agregarPedido(p1);
		
		p2.setEstado(Estado.Anulado);
		h.agregarPedido(p2);
		
		
		h.agregarPedido(p3);
		h.agregarPedido(p4);
		
		
		System.out.println("@@@@" +h);
		
		
		System.out.println("****" + h.getPedidos(nuevo1));
		System.out.println("****Asig" + h.getPedidosAsignados(nuevo1));
		System.out.println("****Anul" + h.getPedidosAnulados(nuevo1));
		System.out.println("****CErr" + h.getPedidosCerrados(nuevo1));
		System.out.println("****Solic" + h.getPedidosSolicitados(nuevo1));
		
	}

}
