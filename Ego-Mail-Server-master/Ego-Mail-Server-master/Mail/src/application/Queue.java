package application;
import application.LinkedList;
public class Queue {
	LinkedList myQ = new LinkedList();//s
	int Qsize = 0;
	//*dd

	
	public void enqueue(Object item) {
		myQ.add(item);
		Qsize++;
	}

	
	public Object dequeue() {
		Object s = myQ.get(0);
		if (Qsize == 0) {
			throw new UnsupportedOperationException("ERROR");
		}
		if (Qsize == 1) {
			myQ.clear();
		} else {
			myQ.remove(0);
		}
		Qsize--;
		return s;
	}
	
	public boolean isEmpty() {
		if (Qsize == 0) {
			return true;
		}
		return false;
	}//*/

	
	public int size() {
		return Qsize;
	}
	
	public Object front() {
		
		if (Qsize == 0) {
			throw new UnsupportedOperationException("ERROR");
		}
		Object s = myQ.get(0);
		return s;
	}
}