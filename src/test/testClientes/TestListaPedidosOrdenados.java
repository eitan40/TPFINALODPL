package test.testClientes;

import static org.junit.Assert.*;
import mapa.Coordenada;
import mapa.Direccion;

import org.junit.Test;

import pedidos.Fecha;
import pedidos.Pedido;
import pedidos.Pedido.Estado;
import clientes.Cliente;
import clientes.listaPedidosOrdenados;

public class TestListaPedidosOrdenados {

	@Test
	public void test() 
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
		Cliente nuevo6= new Cliente("4709823809", dire6,c, "Hospital Sommer", "234555","Juan perez");
		
		Fecha fecha = new Fecha();
		
		Pedido p1 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1,5.565434,20.1546545);
		Pedido p2 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.565434,20.1546545);
		Pedido p3 = new Pedido(nuevo1,"xxx", "098''","kjlkldas",dire1, 25.565434,20.1546545);
		Pedido p4 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1, 25.565434,20.1546545);
		Pedido p5 = new Pedido(nuevo1,"xxx","098''","kjlkldas",dire1,25.565434,20.1546545);
		Pedido p6 = new Pedido(nuevo2,"xxx","098''","kjlkldas",dire1,25.565434,20.1546545);
		Pedido p7 = new Pedido(nuevo4,"xxx","098''","kjlkldas",dire1,25.565434,20.1546545);
		Pedido p8 = new Pedido(nuevo6,"xxx","098''","kjlkldas",dire1,25.565434,20.1546545);
		
		
		p1.setEstado(Estado.Cerrado);
		p6.setEstado(Estado.Anulado);
		p7.setEstado(Estado.Asignado);
		
		listaPedidosOrdenados l = new listaPedidosOrdenados();
		l.agregar(p1);
		l.agregar(p6);
		l.agregar(p7);
		
		System.out.println(l);
	}

}
