package pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pendientes 
{
	Iterable<Pedido> pendientes;
	
	
	public ArrayList<Pedido> enEspera()
	{
		ArrayList<Pedido> ret = null;
		for(Pedido pedido : pendientes)
		{
			if (pedido.getEstado() == pedido.getEstado().Asignado)
				ret.add(pedido);
		}
		
		return ret;
	}
	
	
}