package application;

public class Node2 {
private Object element;
private Node2 next;
	  public Node2(Object obj,Node2 n) {
		  element=obj;
		  next=n;
	  }
	  public Node2() {
		  
	  }
	public Object getElement() {
		return element;
	}
	public void setElement(Object value) {
		this.element = value;
	}
	public Node2 getNext() {
		return next;
	}
	public void setNext(Node2 next) {
		this.next = next;
	}
	  
	 
	}

