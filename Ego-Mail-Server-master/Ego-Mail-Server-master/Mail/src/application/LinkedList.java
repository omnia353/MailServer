package application;


public class LinkedList {

	Snode head = null;
	Snode tail = null;
	int mySize = 0;

	public void add(int index, Object element) {
		Snode newnode = new Snode(element);
		Snode test = head;
		int counter = 0;
		counter = mySize;
		if (index > counter || index < 0) {
			throw new UnsupportedOperationException("ERROR");
		} else {
			mySize++;
			if (index == 0 || head == null) {
				newnode.next = head;
				head = newnode;
			} else {
				Snode i = head;
				for (int count = 0; count < index - 1; count++) {
					i = i.next;
				}
				newnode.next = i.next;
				i.next = newnode;
			}
		}
	}

	public void add(Object element) {
		Snode temp = head;
		mySize++;
		if (head == null) {
			Snode current = new Snode(element);
			temp = current;
			temp.next = null;
			head = temp;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			Snode newone = new Snode(element);
			temp.next = newone;
			newone.next = null;
			newone.data = element;
		}

	}

	public Object get(int index) {
		Snode test = head;
		int counter = 0;
		counter = mySize;
		if (index > counter || index < 0 || size() == 0) {
			throw new UnsupportedOperationException("ERROR");
		} else {
			Snode temp;
			temp = head;
			int i = 0;
			while (temp.next != null && i < index) {
				temp = temp.next;
				i++;
			}
			if (temp.next == null) {
			}
			return temp.data;
		}
	}

	public void set(int index, Object element) {
		Snode test = head;
		int counter = 0;
		counter = mySize;
		if (index > counter || index < 0) {
			System.out.println("*");
			throw new UnsupportedOperationException("ERROR");
		} else {
			Snode newone = new Snode(element);
			newone.data = element;
			Snode temp;
			temp = head;
			int i = 0;
			while (temp.next != null && i < index) {
				temp = temp.next;
				i++;
			}
			temp.data = newone.data;

		}
	}

	public void clear() {
		mySize = 0;
		if (isEmpty()) {
			throw new UnsupportedOperationException("null");
		}
		head = null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public void remove(int index) {
		Snode test = head;
		int counter = 0;
		counter = mySize;
		if (index > counter || index < 0) {
			throw new UnsupportedOperationException("ERROR");
		} else {
			mySize--;
			Snode temp = head;
			int i = 0;
			Snode slow = null;
			while (temp.next != null && i < index) {
				slow = temp;
				temp = temp.next;
				i++;
			}
			if (temp.next != null) {
				temp.data = temp.next.data;
				temp.next = temp.next.next;
			} else {
				slow.next = null;
			}

		}
	}

	public int size() {
		return mySize;
	}

	public boolean contains(Object o) {
		Snode temp = head;
		if (size() == 0) {
			return false;
		}
		if (head == null) {
			return false;
		}
		while (temp.next != null && temp.data != o) {
			temp = temp.next;
		}
		if (temp.data.equals(o)) {
			return true;
		} else {
			return false;

		}
	}
}
