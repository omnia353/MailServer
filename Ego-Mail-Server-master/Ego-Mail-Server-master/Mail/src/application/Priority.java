package application;

import java.io.File;

public class Priority {
	App x = new App();
	void setPriority (String priorityDegree,String index, String path) {
		
		LinkedList old = new LinkedList ();
		File f = new File(path+"\\index.html");
		System.out.println(f.getAbsolutePath()+ "priorityyyyyyyyyyy");
		old = x.convertToLinkedList(f);
		int k = 0;
		System.out.println(priorityDegree + "+++");
		while(k < old.size()) {
			MailNode pNode = new MailNode();
			pNode = (MailNode)old.get(k);
			System.out.println(pNode.getIndex() + "   " + index);
			if(pNode.getIndex().equals(index)) {
				//old.remove(k);
				System.out.println("da5alllllll+++");
				pNode.setPriority(priorityDegree);
				old.set(k,pNode);
				//old.remove(k);
				//old.add(pNode);
			}
			k++;
		}
		x.Rewrite_index(old, path);
		
		
	
	}
	
	

}