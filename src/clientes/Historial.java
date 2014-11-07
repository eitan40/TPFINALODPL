package clientes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import almacenamiento.Persistencia;
import pedidos.Fecha;
import pedidos.Pedido;
import pedidos.Pedido.Estado;
import miEmpresa.Camiones;
import miEmpresa.Persona;

public class Historial implements Serializable
{
	private Map pedidosPorCliente;
	
	public Historial()
	{
		this.pedidosPorCliente = new HashMap<Cliente, listaPedidosOrdenados>();
	}
	
	
	
//METODOS SOBRE LOS CLIENTES
	
	
	//agregar un nuevo cliente
	public void agregarCliente(Cliente nuevo)
	{
		listaPedidosOrdenados p = new listaPedidosOrdenados();
		this.pedidosPorCliente.put(nuevo,p);
	}
	
	
	//borrar un cliente
	public void borrarCliente(Cliente eliminar)
	{
		this.pedidosPorCliente.remove(eliminar);
	}
	
	
	//borrar un cliente a partir de su cuit
	public void borrarCliente(String cuit)
	{
		Iterator it = pedidosPorCliente.keySet().iterator();
				
			while(it.hasNext())
			{	
				Cliente eliminar = (Cliente) it.next();
				if(eliminar.getCuit().equals(cuit))
					borrarCliente(eliminar);
			}

		
	}
	
	
	//editar cliente - no se permite ediatr cuit
	public void editarCliente(Cliente AEditar, String nombre, String telefono, String nombre_Contacto) 
	{
		AEditar.setNombre(nombre);
		AEditar.setTelefono(telefono);
		AEditar.setNombre_Contacto(nombre_Contacto);
	}
	
	//devuelve la cantidad de clientes
	public int cantidadClientes()
	{
		return this.pedidosPorCliente.size();
	}
	
	
	//Devuelve todos los pedidos del cliente
	public listaPedidosOrdenados getPedidos(Cliente cliente)
	{
		Iterator it = pedidosPorCliente.entrySet().iterator();
		
		Entry <Cliente,listaPedidosOrdenados> siguiente = null;
		
		Cliente c = null;
		Set<Pedido> p = null;
		
		while(it.hasNext())
		{	
			siguiente = (Entry<Cliente,listaPedidosOrdenados>) it.next();
			
			//si estoy parada en la clave cliente correspondiente
			if(siguiente.getKey().equals(cliente))
			
				return siguiente.getValue(); //valor
		}
		
		return null;
	}
	
	
	//Devuelve un set de pedidos solicitados
	public Set<Pedido> getPedidosSolicitados(Cliente cliente) 
	{
		return getPedidos(cliente).listaPedidosSolicitados;
	}

	
	//Devuelve un set de pedidos asignados
	public Set<Pedido> getPedidosAsignados(Cliente cliente) 
	{
		return getPedidos(cliente).listaPedidosAsignados;
	}

	
	//Devuelve un set de pedidos cerrados
	public Set<Pedido> getPedidosCerrados(Cliente cliente) 
	{
		return getPedidos(cliente).listaPedidosCerrados;
	}

	
	//Devuelve un set de pedidos anulados
	public Set<Pedido> getPedidosAnulados(Cliente cliente) 
	{
		return getPedidos(cliente).listaPedidosAnulados;
	}
	
//METODOS SOBRE LOS PEDIDOS
	
	@SuppressWarnings("unchecked")
	public void agregarPedido(Pedido nuevo)
	{
		
		Iterator it = pedidosPorCliente.entrySet().iterator();
		
		Entry <Cliente,listaPedidosOrdenados> siguiente = null;
		
		Cliente c = null;
		Set<Pedido> p = null;
		
		while(it.hasNext())
		{	
			siguiente = (Entry<Cliente,listaPedidosOrdenados>) it.next();
				System.out.println("zzzzzzz" + siguiente.getKey());
			if(siguiente.getKey().equals(nuevo.getCliente()))
				siguiente.getValue().agregar(nuevo);
				
		}
		
	}
	
	
	
	
	@Override
	public String toString()
	{
	Iterator it = pedidosPorCliente.entrySet().iterator();
		
	String ret ="";
	
		while(it.hasNext())
		{
			Map.Entry e = (Map.Entry)it.next();
			ret=ret + e.getKey().toString()+"\n" + e.getValue().toString() + "\n";
		}
		
		return ret;
	}

	
	
	public void editarPedido(Pedido Aeditar, Camiones camion, Persona chofer, String contacto, Estado estado, String observaciones, String telefono_contacto) 
	{
		Iterator it = pedidosPorCliente.entrySet().iterator();
		
		Entry <Cliente,listaPedidosOrdenados> siguiente = null;
		
		Cliente c = null;
		Set<Pedido> p = null;
		
		//Recorro los clientes
		while(it.hasNext())
		{	
			siguiente = (Entry<Cliente,listaPedidosOrdenados>) it.next();
			
			//Encuentro el cliente al que corresponde el pedido
			if(siguiente.getKey().equals(Aeditar.getCliente()))
	
				siguiente.getValue().editarPedidoEnSetCorrespondiente(Aeditar, camion, chofer, contacto, estado, observaciones, telefono_contacto);
				
		}
	
	}

	public Set<Cliente> getClientes() 
	{
		Iterator it = pedidosPorCliente.entrySet().iterator();
		
		Set<Cliente> ret = new HashSet<Cliente>();
		
			while(it.hasNext())
			{
				Map.Entry e = (Map.Entry)it.next();
				ret.add((Cliente) e.getKey());
			}
			
		return ret;
	}

	


	
}
