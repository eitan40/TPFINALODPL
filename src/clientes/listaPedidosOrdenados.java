package clientes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import pedidos.Fecha;
import pedidos.Pedido;
import pedidos.Pedido.Estado;
import miEmpresa.Camiones;
import miEmpresa.Persona;

public class listaPedidosOrdenados implements Serializable 
{
	
	public Set listaPedidosSolicitados;
	public Set listaPedidosAsignados;
	public Set listaPedidosCerrados;
	public Set listaPedidosAnulados;
	
	//son 4 set segun el estado del pedido
	
	public listaPedidosOrdenados()
	{
		this.listaPedidosSolicitados = new HashSet<Pedido>();
		this.listaPedidosAsignados = new HashSet<Pedido>();
		this.listaPedidosCerrados = new HashSet<Pedido>();
		this.listaPedidosAnulados = new HashSet<Pedido>();
			
	}

	//agregar un nuevo pedido
	public void agregar(Pedido nuevo) 
	{	
		//segun su estado, lo agrega al set que corresponde
		
		if(nuevo.getEstado().equals(Estado.Solicitado))
			this.listaPedidosSolicitados.add(nuevo);
		
		else if(nuevo.getEstado().equals(Estado.Asignado))
			this.listaPedidosAsignados.add(nuevo);
		
		else if(nuevo.getEstado().equals(Estado.Cerrado))
			this.listaPedidosCerrados.add(nuevo);
		else if(nuevo.getEstado().equals(Estado.Anulado))
			this.listaPedidosAnulados.add(nuevo);
	}
	
	
	public void editarPedidoEnSetCorrespondiente(Pedido Aeditar, Camiones camion, Persona chofer, String contacto_pedido, Estado estado, String observaciones, String telefono_contacto) 
	{
		//segun su estado, edita en el set que corresponde
		
		if(Aeditar.getEstado().equals(Estado.Solicitado))
			editarSet(this.listaPedidosSolicitados,Aeditar,camion,chofer,contacto_pedido,estado,observaciones,telefono_contacto);
		
		else if(Aeditar.getEstado().equals(Estado.Asignado))
			editarSet(this.listaPedidosAsignados,Aeditar,camion,chofer,contacto_pedido,estado,observaciones,telefono_contacto);
		
		else if(Aeditar.getEstado().equals(Estado.Cerrado))
			editarSet(this.listaPedidosCerrados,Aeditar,camion,chofer,contacto_pedido,estado,observaciones,telefono_contacto);
		else if(Aeditar.getEstado().equals(Estado.Anulado))
			editarSet(this.listaPedidosAnulados,Aeditar,camion,chofer,contacto_pedido,estado,observaciones,telefono_contacto);
	}

	//Recorre un set y edita el pedido
	public void editarSet(Set<Pedido> set, Pedido Aeditar, Camiones camion, Persona chofer, String contacto_pedido, Estado estado, String observaciones, String telefono_contacto)
	{
		Iterator iterador = set.iterator();
		
		while(iterador.hasNext())
		{
			Pedido siguiente = (Pedido) iterador.next();
			if(siguiente.equals(Aeditar))
			{
				siguiente.setCamion(camion);
				siguiente.setChofer(chofer);
				siguiente.setContacto_pedido(contacto_pedido);
				siguiente.setEstado(estado);
				siguiente.setObservaciones(observaciones);
				siguiente.setTelefono_contacto(telefono_contacto);
			}
		}
	}
	
	
	
	@Override
	
	public String toString()
	{
		String ret="lista pedidos solicitados:" + this.listaPedidosSolicitados;
		ret=ret + "lista pedidos asignados:" + this.listaPedidosAsignados;
		ret=ret + "lista pedidos cerrados:" + this.listaPedidosCerrados;
		ret=ret + "lista pedidos anulados:" + this.listaPedidosAnulados;
		
		return ret;
		 
	}


}
