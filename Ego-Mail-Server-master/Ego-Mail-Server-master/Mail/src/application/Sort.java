package application;


public class Sort {
public int l;
public void sort(String[][] array, int low, int high, String sortType) {

	if (sortType.equals("Default")) {
		l = 4;
	} else if (sortType.equals("Subject")) {
		l = 1;
	} else if (sortType.equals("Sender's Name")) {
		l = 2;
	} else if (sortType.equals("Receiver's Name")) {
		l = 3;
	}else if (sortType.equals("Index")) {
		l = 0;
	}
	/*else if(sortType.equals("Priority")) {
		l = 6;
	}*/
	Stack stack = new Stack();
	stack.push(low);
	stack.push(high);
	while (!stack.isEmpty()) {
		while (low <= high) {
		int index = partition(array, low, high, array[high][l]);
		stack.push(index+1);
		stack.push(high);
		high = index-1;
		}
		high = (int) stack.pop();
		low = (int) stack.pop();
	}
		}
public int partition(String[][]array, int low, int high, String pivot) {
   int i = (low-1);
    for (int j = low; j <= high-1; j++)
    {
        if (array[j][l].compareTo(pivot) <= 0)
        {
            i++;
            for(int k = 0; k < 7; k++) {
            String temp = array[i][k];
            array[i][k] = array[j][k];
            array[j][k] = temp;
            }
        }
    }
    for(int k = 0; k < 7; k++) {
        String temp = array[i + 1][k];
        array[i + 1][k] = array[high][k];
        array[high][k] = temp;
        }
    return i+1;
}
public LinkedList prioritySort(LinkedList l) {
	PriorityQueue pQ = new PriorityQueue();
	for(int i = 0; i < l.size(); i++){
		MailNode temp = new MailNode();
		temp = (MailNode) l.get(i);
		int p = Integer.parseInt(temp.getPriority());
		pQ.insert(temp, p);

	}
	LinkedList newList = new LinkedList();
	while(pQ.size() != 0) {
		MailNode temp2 = new MailNode();
		temp2 = (MailNode) pQ.removeMin();
		newList.add(temp2);
	}
	return newList;
}

/*
public String[][] toStringArray(LinkedList l) {
	String[][] array = new String[l.size()][5];
	for (int i = 0; i < l.size(); i++) {
		MailNode temp = new MailNode();
		temp = (MailNode) l.get(i);
		array[i][0] = temp.getIndex();
		array[i][1] = temp.getSubject();
		array[i][2] = temp.getFrom();
		array[i][3] = temp.getTo();
		array[i][4] = temp.getDate();
	}
	return array;
}
public LinkedList fromArrayToLinked(String[][] array) {
	LinkedList l = new LinkedList();
	for(int i = 0; i < array.length; i++) {
		MailNode temp = new MailNode();
		temp.setIndex(array[i][0]);
		temp.setSubject(array[i][1]);
		temp.setFrom(array[i][2]);
		temp.setTo(array[i][3]);
		temp.setDate(array[i][4]);
		l.add(temp);
	}
	return l;
}*/
/*public static void main(String[] args) {
	System.out.println("starttt");
	LinkedList l = new LinkedList();
	MailNode temp = new MailNode();
	temp.setIndex("5");
	temp.setDate("2018/11/2");
	temp.setFrom("nada");
	temp.setTo("omnia");
	temp.setSubject("h.w");
	temp.setPriority("4");
	l.add(temp);
	MailNode temp2 = new MailNode();
	temp2.setIndex("0");
	temp2.setDate("2018/10/2");
	temp2.setFrom("omnia");
	temp2.setTo("nada");
	temp2.setSubject("c.w");
	temp2.setPriority("1");
	l.add(temp2);
	MailNode temp3 = new MailNode();
	temp3.setIndex("9");
	temp3.setDate("2019/11/2");
	temp3.setFrom("khaled");
	temp3.setTo("omnia");
	temp3.setSubject("l.w");
	temp3.setPriority("2");
	l.add(temp3);
	Sort q = new Sort();
	LinkedList ll = new LinkedList();
	ll = q.prioritySort(l);
	for ( int i=0;i<ll.size();i++) {
		MailNode en= new MailNode();
		en= (MailNode) ll.get(i);
		System.out.println("b"+en.getPriority());
	}
}
/*String[][] array = {
		{"5",
		"yes",
		"omnia",
		"nadarashad",
		"2018/04/28 22:56:57"
		},
		{"7",
		"hello",
		"saragamal",
		"omnia",
		"2018/04/28 22:58:22"
		},
		{
		"2",
		"bye",
		"khaled",
		"sara",
		"2018/04/28 22:58:38",
		},
		{
		"0",
		"h.w",
		"sally",
		"ahmed",
		"2018/04/28 22:58:49"
		}
};
Sort q = new Sort();
q.sort(array, 0, array.length-1,"Index");
for(int i = 0; i< array.length; i++) {
	System.out.print(array[i][0] + " ");
	System.out.print(array[i][1]+" ");
	System.out.print(array[i][2]+" ");
	System.out.print(array[i][3]+" ");
	System.out.println(array[i][4]);
}
}*/
}