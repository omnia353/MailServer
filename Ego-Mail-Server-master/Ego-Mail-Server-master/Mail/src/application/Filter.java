package application;

import java.io.File;
import java.io.IOException;

public class Filter {
	Controller y = new Controller();
	String yy = y.spath;
	Search filterSearch = new Search();
	App app= new App();
	
	Folder folder = new Folder();
	void setFilter (String newFolderName, String filterName) {

		MailNode fn = new MailNode();
		fn.setFilterName(filterName);
		fn.setFolderName(newFolderName);
		fn.setFilterPath(yy+"\\Filter\\"+newFolderName);
		File newFolder = new File(yy+"\\Filter\\"+newFolderName);
		newFolder.mkdir();	
		File indexnew = new File(yy+"\\Filter\\"+newFolderName + File.separator + "index.html");
		try {
			indexnew.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.indexFilter(fn,yy+"\\Filter\\index.html");
	}
	void filter (   ) {
		LinkedList list = new LinkedList();
		LinkedList inboxlist = new LinkedList();
		inboxlist=app.convertToLinkedList(new File(yy+"\\Inbox\\index.html"));
		File indexOthers = new File (yy+"\\Filter\\index.html");
		list = app.indexFilterToLinkedList(indexOthers);
		Search se = new Search();
		String[][] ar = app.fromLinkedtoArray(inboxlist);
		Sort so = new Sort();
		so.sort(ar, 0, ar.length-1,"Sender's Name" );
		LinkedList newlist = new LinkedList();
		newlist=app.fromArrayToLinked(ar);
		for(int i = 0 ; i < newlist.size(); i++) {
			MailNode o = new MailNode();
			o = (MailNode)newlist.get(i);
			System.out.println("pppp" + o.getDate());
		}
		for (int k=0;k<list.size();k++) {
			LinkedList list2 = new LinkedList();
			MailNode temp = new MailNode();
			temp= (MailNode) list.get(k);
			list2=se.BinarySearch(newlist,temp.getFilterName() , "Sender's Name" );
			try {
				Folder folder = new Folder();
				folder.setPath(temp.getFilterPath());
				for(int i = 0 ; i < list2.size(); i++) {
					MailNode o = new MailNode();
					o = (MailNode)list2.get(i);
					System.out.println("pppp" + o.getDate());
				}
				System.out.println("pppp" + list2.size());
				app.moveEmails(list2,folder ,yy+"\\Inbox");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
		
	}
	
	
	void filterSub (   ) {
		LinkedList list = new LinkedList();
		LinkedList inboxlist = new LinkedList();
		inboxlist=app.convertToLinkedList(new File(yy+"\\Inbox\\index.html"));
		File indexOthers = new File (yy+"\\Filter\\index.html");
		list = app.indexFilterToLinkedList(indexOthers);
		Search se = new Search();
		String[][] ar = app.fromLinkedtoArray(inboxlist);
		Sort so = new Sort();
		so.sort(ar, 0, ar.length-1,"Subject" );
		LinkedList newlist = new LinkedList();
		newlist=app.fromArrayToLinked(ar);
		for(int i = 0 ; i < newlist.size(); i++) {
			MailNode o = new MailNode();
			o = (MailNode)newlist.get(i);
			System.out.println("pppp" + o.getDate());
		}
		for (int k=0;k<list.size();k++) {
			LinkedList list2 = new LinkedList();
			MailNode temp = new MailNode();
			temp= (MailNode) list.get(k);
			list2=se.BinarySearch(newlist,temp.getFilterName() ,"Subject" );
			try {
				Folder folder = new Folder();
				folder.setPath(temp.getFilterPath());
				for(int i = 0 ; i < list2.size(); i++) {
					MailNode o = new MailNode();
					o = (MailNode)list2.get(i);
					System.out.println("pppp" + o.getDate());
				}
				System.out.println("pppp" + list2.size());
				app.moveEmails(list2,folder ,yy+"\\Inbox");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
		
	}


}
