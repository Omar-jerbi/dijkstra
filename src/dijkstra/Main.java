package dijkstra;

public class Main {

	public static void dijkstra(Grafo g, Nodo s, int[] aDist, Nodo[] aParent) {
		for(var u:g._grafo) {
			aDist[u.get(0).from.etichetta] = Nodo.INF;
		}
			
		aDist[s.etichetta] = 0;
				
		aParent[s.etichetta] = null;
		
		var H = new Heap(6);
		
		for(var u:g._grafo) {
			H.insert(u.get(0).from, aDist[u.get(0).from.etichetta]);
		}
		
		
		while(!H.isEmpty()) {
			Nodo x = H.getMin();
			
			for(var lista_archi:g._grafo) {
				if(lista_archi.get(0).from.etichetta == x.etichetta) {
					for(var arco:lista_archi) {
//						if(arco.to != null) {
//							if(aDist[lista_archi.get(0).from.etichetta] + arco.peso 
//									< 
//									aDist[arco.to.etichetta]) {
//								aParent[arco.to.etichetta] = lista_archi.get(0).from;
//								H.changePriority(arco.to, aDist[arco.to.etichetta]);
//							}	
//						}
						System.out.println(arco.from.etichetta +" "+
								(arco.to != null ? arco.to.etichetta : "vuoto") +
										" "+arco.peso);
					}					
				}

			}
		}
	}
	
	
	public static void main(String[] args) {
		var g = new Grafo();
		
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		
		
		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		
		
		g.addArc(n0, n1, 4);
		g.addArc(n0, n3, 2);
		g.addArc(n1, n2, 7);
		g.addArc(n3, n2, 3);
		g.addArc(n3, n4, 8);
		g.addArc(n2, n4, 1);
		g.addArc(n2, n5, 5);
		g.addArc(n4, n5, 4);
		
		
		//System.out.println(g._grafo.get(1).get(1).to.etichetta); //B == 2
		
		var aDist = new int[6];
		Nodo[] aParent = new Nodo[6];
		
		dijkstra(g, n0, aDist, aParent);


	}

}
