package dijkstra;

import java.util.ArrayList;

public class Main {

	public static void dijkstra(Grafo g, Nodo s, ArrayList<Integer> aDist, ArrayList<Nodo> aParent) {
		for(var i = 0; i < g.numNodes(); i++) {
			aDist.add(Nodo.INF);
			aParent.add(null);
		}
		aDist.add(s.etichetta, 0);
		//aParent.add(s.etichetta, null);
		var H = new Heap(g.numNodes());
		for(var Ls_archi:g._grafo) {
			H.insert(Ls_archi.get(0).from, aDist.get(Ls_archi.get(0).from.etichetta));
		}
		

		while(!H.isEmpty()) {
			Nodo x = H.getMin();
			for(var lista_archi:g._grafo) {
				if(lista_archi.get(0).from.etichetta == x.etichetta) { //per ogni arco di x
					for(var arco:lista_archi) { //per ogni arco di x
						if(arco.to != null) { //per ogni arco di x
//							if(aDist.get(x.etichetta) + arco.peso < aDist.get(arco.to.etichetta)) 
//							{						
//								aParent.add(arco.to.etichetta, lista_archi.get(0).from);
//								H.changePriority(arco.to, aDist.get(arco.to.etichetta));
//							}	
	
						}
						
//						System.out.println(arco.from.etichetta +" "+
//								(arco.to != null ? arco.to.etichetta+ " " + arco.peso : "---------"));
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
		
		
		
		var aDist = new ArrayList<Integer>();		
		var aParent = new ArrayList<Nodo>();
		
		dijkstra(g, n0, aDist, aParent);


	}

}
