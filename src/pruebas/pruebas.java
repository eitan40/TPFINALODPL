package pruebas;

import odpgl.Implementacion;
import pedidos.Fecha;
import pedidos.Pedido;
import mapa.Coordenada;
import mapa.Direccion;
import mapa.Domicilio;
import miEmpresa.Camiones;
import miEmpresa.Persona;
import clientes.Cliente;


public class pruebas {

	public static void main(String[] args) 
	{
		Implementacion n = new Implementacion();
		Coordenada c = new Coordenada(-25.34651321,22.164434);
		Direccion dire = new Direccion("Buenos aires", "CABA","SAN MARTIN", 1000);
		
		Cliente cliente = new Cliente("12-465453-4", dire,c, "SANTANDER RIO", "897232322","Sofia");
		Cliente cliente2 = new Cliente("20-46461321-0", dire,c, "TYS", "111","Claudia");
		System.out.println(cliente);
		n.agregarCliente(cliente);
		n.agregarCliente(cliente2);
		
		System.out.println("HOlaaaaaaaaaaaaa");
		System.out.println(n);
		System.out.println("Lista Clientes"+n.getListaClientes());

		Direccion dire1 = new Direccion("Buenos aires", "CABA","CORDOBA", 3323);
		System.out.println(dire1);
		
		
		Cliente cliente1 = new Cliente("45-32423423-4", dire1,c, "Galicia", "897232322","Sofia");
		System.out.println(cliente1);
		
		
		
		Persona p = new Persona("Lucas", "3344444","wdwd", "dwf", "df3321");
		System.out.println(p);
		
		n.agregarPersona(p);
		System.out.println(n);
		
		
		//agrego un pedido
		Pedido nuevo = new Pedido(cliente1, "sofia","4569-4654","xxx", dire1,-25.34651321,22.164434);
		n.crearPedido(nuevo);
		
		Camiones cam =new Camiones("da545","Ford", "xxx", "rojo",4567);
		
		System.out.println(cam);
		
		n.agregarCamion(cam);
		System.out.println(n);
	}

}
