package application;

public class PrNode {
	public Object data;
	public int priority;
	public Snode next;

	public PrNode(Object d , final int b) {
		data = d;
		next = null;
		priority = b;
	}
}