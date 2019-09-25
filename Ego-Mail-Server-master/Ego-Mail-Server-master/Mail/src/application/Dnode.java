package application;

public class Dnode {
	public Object data;
	public Dnode next;
	public Dnode previous;

	public Dnode(Object d) {
		data = d;
		next = null;
		previous = null;
	}
}