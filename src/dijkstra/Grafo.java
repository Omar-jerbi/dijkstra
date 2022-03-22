package dijkstra;

import java.util.LinkedList;
import java.util.ArrayList;



class Edge{
	Nodo from;
	Nodo to;
	int peso;
	
	public Edge(Nodo f, Nodo t, int p) {
		from = f;
		to = t;
		peso = p;
	}
}


//orientato
public class Grafo {
	private int _n;
	public ArrayList<LinkedList<Edge>> _grafo;
	
	public Grafo(){
		_n = 0;
		_grafo = new ArrayList<LinkedList<Edge>>();
	}
	
	public boolean isEmpty() {
		return _n == 0;
	}
	
	public void addNode(Nodo n){
		var ll = new LinkedList<Edge>();
		ll.add(new Edge(n, null, -1));
		_grafo.add(ll);
		_n++;
	}
	
	public void addArc(Nodo from, Nodo to, int p) {
		_grafo.get(from.etichetta).add(new Edge(from, to, p));
	}
	
	
}
