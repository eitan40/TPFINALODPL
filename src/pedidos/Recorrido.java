package pedidos;

import java.util.ArrayList;

//Representa un recorrido por algunas o todos los lugares
public class Recorrido
{
	// Instancia asociada
	private Instancia instancia;
	
	// Los lugares del recorrido
	private ArrayList<Pedido> lugares;
	
	// Cada recorrido est� asociado a una instancia
	public Recorrido(Instancia inst)
	{
		instancia = inst;
		lugares = new ArrayList<Pedido>();
	}
	
	// Agrega un lugar al final del recorrido
	public void agregar(Pedido i)
	{
		lugares.add(i);
	}

	// Elimina el ultimo lugar del recorrido
	public void eliminarUltima()
	{
		lugares.remove( lugares.size()-1 );
	}

	// Determina si el lugar esta en el recorrido
	public boolean contiene(int i)
	{
		return lugares.contains(i);
	}

	// Cantidad de lugares en el recorrido
	public int size()
	{
		return lugares.size();
	}
	
	// toString
	@Override public String toString()
	{
		String ret = "";
		for(Pedido x: lugares)
			ret += x + " ";
		
		return ret + "- Dist: " + this.distancia();
	}

	// Clonacion
	@SuppressWarnings("unchecked")
	public Recorrido clonar()
	{
		Recorrido clon = new Recorrido(instancia);
		clon.lugares = (ArrayList<Pedido>) lugares.clone();
		
		return clon;
	}

	// Distancia total
	public double distancia()
	{
		double ret = 0;
		for(int i=0; i<lugares.size()-1; ++i)
		{
			Pedido origen = lugares.get(i);
			Pedido destino = lugares.get(i+1);
			
			ret += instancia.getDistancia(origen, destino);
		}
		
		Pedido ultima = lugares.get( lugares.size()-1 );
		Pedido primera = lugares.get(0);
		
		ret += instancia.getDistancia(ultima, primera);

		return ret;
	}
}