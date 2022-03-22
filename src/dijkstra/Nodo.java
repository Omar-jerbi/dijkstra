package dijkstra;

public class Nodo {
	public static final int INF = 1234;
	
	public int etichetta;
	public int peso;
	
	public Nodo(int e) {
		etichetta = e;
		peso = INF;
	}
	
	public Nodo(int e, int p) {
		etichetta = e;
		peso = p;
	}
	
}
