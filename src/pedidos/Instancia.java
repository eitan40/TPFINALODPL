package pedidos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import mapa.Coordenada;
//import pedido.Pedido;

public class Instancia {

	private Map<Pedido, Coordenada> pedidos;

	// Crea una instancia a partir de un conjunto de Pedidos.
	public Instancia(Set<Pedido> pedidos) {

		this.pedidos = new HashMap<Pedido, Coordenada>();
		for (Pedido pedido : pedidos) {
			this.pedidos.put(pedido, this.pedidos.get(pedido.getCoordenada()));
		}
	}

	public double getDistancia(Pedido p1, Pedido p2) {
		Coordenada c1 = pedidos.get(p1);
		Coordenada c2 = pedidos.get(p2);
		return Coordenada.calcularDistancia(c1, c2);
	}

	public int cantidadPedidos() {
		return pedidos.size();
	}
}
