package pedidos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public abstract class Generador implements Iterator
{
	// Instancia
	private Instancia instancia;

	// Cantidad de ciudades
	private int n;

	// Pila de pedidos
	private Stack<Pedido> p;

	// El constructor toma la cantidad de pedidos
	public Generador(Instancia inst) {
		instancia = inst;
		n = instancia.cantidadPedidos();
	}

	// Genera todos los recorridos
	public LinkedList<Recorrido> generar() {
		LinkedList<Recorrido> ret = new LinkedList<Recorrido>();

		Recorrido recorrido = new Recorrido(instancia);
		recorrido.agregar(null);

		completar(recorrido, ret);
		return ret;
	}

	// Proceso recursivo
	private void completar(Recorrido recorrido, LinkedList<Recorrido> ret) {
		// Caso base: El recorrido contiene todos los pedidos
		if (recorrido.size() == n) {
			ret.add(recorrido.clonar());
			return;
		}

		// Caso recursivo: Agrego todas los posibles pedidos al recorrido
		for (int i = 0; i < n; ++i) {
			if (recorrido.contiene(i) == false) {
				recorrido.agregar(p.get(i));
				completar(recorrido, ret);
				recorrido.eliminarUltima(); // La ultima es la i
			}
		}
	}

}
