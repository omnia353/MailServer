package application;

public class PriorityQueue {

	LinkedList myQ = new LinkedList();
	int sizeQ=0;
	public void insert(Object item, int key) {
		if(key <= 0 || key > Integer.MAX_VALUE) {
			throw new UnsupportedOperationException("ERROR");
		}
		PrNode newNode = new PrNode(item , key);
		int i =0;
		if(sizeQ != 0) {
			PrNode nextcurrent = (PrNode)myQ.get(0);
			while(i < sizeQ && nextcurrent.priority <= key) {
				nextcurrent = (PrNode)myQ.get(i+1);
				i++;
			}
		}
		myQ.add(i, newNode);
		sizeQ++;
		int v = 0;
		while(v<sizeQ) {
			PrNode se = (PrNode) myQ.get(v);
			v++;
		}
	}


	public Object removeMin() {
		if (sizeQ == 0) {
			throw new UnsupportedOperationException("ERROR");
		}
		PrNode s ;
		s = (PrNode) myQ.get(0);
		if(sizeQ == 1) {
			myQ.clear();
		}
		else {
			myQ.remove(0);
		}
		sizeQ --;
		return s.data;
	}


	public Object min() {
		if (sizeQ == 0) {
			throw new UnsupportedOperationException("ERROR");
		}
		PrNode s ;
		s = (PrNode) myQ.get(0);
		return s.data;
	}


	public boolean isEmpty() {
		if(sizeQ==0) {
			return true;
		}
		return false;
	}


	public int size() {
		return sizeQ;
	}

}
