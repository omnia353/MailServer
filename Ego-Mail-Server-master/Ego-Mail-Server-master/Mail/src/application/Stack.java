package application;

import java.util.EmptyStackException;

public class Stack  {

    public Node2 top = new Node2(null, null);
    public int size;

   
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node2 temp = top;
            Object element = top.getElement();
            top = top.getNext();
            temp = null;
            size--;
            return element;
        }
    }


    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.getElement();
        }
    }


    public void push(Object element) {
        Node2 newNode = new Node2(element, top);
        top = newNode;
        size++;

    }

 
    public boolean isEmpty() {
        if (top.getElement() == null) {
            return true;
        } else {
            return false;
        }
    }


    public int size() {
        return size;
    }

}