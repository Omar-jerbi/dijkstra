package dijkstra;


public class Heap {
	private Nodo[] Heap;
	private int index;
	private int size;

	
	// swaps two nodes of the heap
	private void swap(int x, int y) {
		Nodo tmp;
		tmp = Heap[x];
		Heap[x] = Heap[y];
		Heap[y] = tmp;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	
	public Heap(int size) {
		this.size = size;
		this.index = 0;
		Heap = new Nodo[size];
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return (i * 2) + 1;
	}

	private int rightChild(int i) {
		return (i * 2) + 2;
	}

	private boolean isLeaf(int i) {
		if (rightChild(i) >= size || leftChild(i) >= size) {
			return true;
		}
		return false;
	}

	
	public void changePriority(Nodo x, int newPeso) {//devo riordinare
		int i = 0;
		for(var e : Heap) {
			if(e.etichetta == x.etichetta) {
				e.peso = newPeso;
				minHeapify(i);
			}
		}
	}
	
	
	public void insert(Nodo element, int newPeso) {
		element.peso = newPeso;
		if (index >= size) {
			return;
		}
		
		Heap[index] = element;
		int current = index;

		while (Heap[current].peso < Heap[parent(current)].peso) {
			swap(current, parent(current));
			current = parent(current);
		}
		index++;
	}

	// removes and returns the minimum element from the heap
	public Nodo getMin() {
     // since its a min heap, so root = minimum
		Nodo popped = Heap[0];
		Heap[0] = Heap[--index];
		minHeapify(0);
		return popped;
	}

	// heapify the node at i
	private void minHeapify(int i) {
	// If the node is a non-leaf node and any of its child is smaller
		if (!isLeaf(i)) {
			if (Heap[i].peso > Heap[leftChild(i)].peso ||
                  Heap[i].peso > Heap[rightChild(i)].peso) {
				if (Heap[leftChild(i)].peso < Heap[rightChild(i)].peso) {
					swap(i, leftChild(i));
					minHeapify(leftChild(i));
				} else {
					swap(i, rightChild(i));
					minHeapify(rightChild(i));
				}
			}
		}
	}

	// builds the min-heap using the minHeapify
	public void minHeap() {
		for (int i = (index - 1 / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}
	
	public void printHeap() {
		for (int i = 0; i < (index / 2); i++) {
			System.out.print("Parent : " + Heap[i].etichetta);
			if (leftChild(i) < index)
				System.out.print(" Left : " + Heap[leftChild(i)].etichetta);
			if (rightChild(i) < index)
				System.out.print(" Right :" + Heap[rightChild(i)].etichetta);
			System.out.println();
		}
	}
	
	///
}
