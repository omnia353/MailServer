package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortContacts {
	Controller y = new Controller();
	String path = y.spath;
	public String[][] fromLinkedtoArray(LinkedList l) {
		String[][] array = new String[l.size()][7];
		for (int i = 0; i < l.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode) l.get(i);
			array[i][0] = temp.getIndex();
			array[i][1] = temp.getFirstName();
			array[i][2] = temp.getLastName();
			LinkedList k = new LinkedList();
			k = temp.getEmails();
			String str = new String();
			for(int j = 0; j < k.size(); j++) {
				if(j == 0) {
					str = (String) k.get(0);
					}
					else{
					str = str + '+' + k.get(j);	
					}
			}
			array[i][3] = str;
			array[i][4] = temp.getRelation();
		}
		return array;
	}
	public LinkedList fromArrayToLinked(String[][] array) {
		LinkedList l = new LinkedList();
		for(int i = 0; i < array.length; i++) {
			MailNode temp = new MailNode();
			temp.setIndex(array[i][0]);
			temp.setFirstName(array[i][1]);
			temp.setLastName(array[i][2]);
			LinkedList k = new LinkedList();
			String str3 = new String();
			str3 = array[i][3];
			int j = 0;
			while(j < str3.length()) {
				String str2 = new String();
				while(j < str3.length() && str3.charAt(j) != '+' ) {
					str2 = str2 + str3.charAt(j);
					j++;
				}
				k.add(str2);
				j++;
			}
			temp.setEmails(k);
			temp.setRelation(array[i][4]);
			l.add(temp);
		}
		return l;
	}

	public int l;
	public void sortContacts(String[][] array, int low, int high, String sortType) {
		
		if(sortType.equals("First Name")) {
			l = 1;
		}else if(sortType.equals("Last Name")) {
			l = 2;
		}
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
	            for(int k = 0; k < 5; k++) {
	            String temp = array[i][k];
	            array[i][k] = array[j][k];
	            array[j][k] = temp;
	            }
	        }
	    }
	    for(int k = 0; k < 5; k++) {
	        String temp = array[i + 1][k];
	        array[i + 1][k] = array[high][k];
	        array[high][k] = temp;
	        }
	    return i+1;
	}
	
	public void setViewingOptionsContacts(Sort sort , File file ,String sortType) throws FileNotFoundException {
		LinkedList l = convertToLinkedListContact(file);
		String[][] array = fromLinkedtoArray(l);
		sort.sort(array, 0, array.length-1,sortType);
		LinkedList fromarray = new LinkedList();
		fromarray= fromArrayToLinked(array);
		fromLinkedToIndexContact(fromarray,file);
	}
	public LinkedList searchContacts(Sort sort, File file, String type, Search binary,String keyWord) throws FileNotFoundException {
		LinkedList l = convertToLinkedListContact(file);
		String[][] array = fromLinkedtoArray(l);
		sort.sort(array, 0, array.length-1,type);
		l.clear();
		l = fromArrayToLinked(array);
		LinkedList ll = new LinkedList();
		ll = binary.BinarySearch(l, keyWord, type);
		return ll;
	}
	public LinkedList convertToLinkedListContact (File f) {
		LinkedList toLinked = new LinkedList();
		String str = new String();
		FileReader fr = null;
		BufferedReader br = null;
			try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
				
				int i = 0;
				MailNode temp = new MailNode();
				MailNode temp1 = new MailNode();
			while ((str = br.readLine()) != null) {
				temp = temp1;
				if(i == 6) {
					i = 0;					
				}
				 if(i == 0 ) {
					temp.setIndex(str);
				
				}
				else if(i == 2) {
					str=str.substring(0, str.length()-5);
					temp.setFirstName(str);
					
				}else if(i == 3) {
					str=str.substring(0, str.length()-5);
					temp.setLastName(str);
					
				}else if(i == 4) {
					LinkedList k = new LinkedList();
					str=str.substring(0, str.length()-5);
					String str2 = new String();
					int j = 0;
					while(j < str.length()) {
						str2 = new String();
						while(j < str.length() && str.charAt(j) != '+' ) {
							str2 = str2 + str.charAt(j);
							j++;
						}
						k.add(str2);
						j++;
					}
					temp.setEmails(k);
			
				}else if(i == 5) {
					str=str.substring(0, str.length()-5);
					temp.setRelation(str);
					toLinked.add(temp);
					temp1 = new MailNode();
					
				}
				i++;
			}
		//	toLinked.add(temp);
			} catch (IOException e) {

				e.printStackTrace();
			}
			return toLinked;
	}public void fromLinkedToIndexContact(LinkedList l,File fff) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fff);
		writer.print("");
		writer.close();
		try {
			PrintWriter pw = new PrintWriter(fff);
			for(int i = 0; i < l.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode)l.get(i);
			pw.println(Integer.toString(i));
			pw.println("</br>");
			pw.println(temp.getFirstName()+"</br>");
			pw.println(temp.getLastName()+"</br>");
			String s = new String();
			LinkedList emails = temp.getEmails();
			for(int j = 0; j < emails.size(); j++) {
				if(j == 0) {
				s = (String) emails.get(0);
				}
				else{
				s = s + '+' + emails.get(j);	
				}
			}
			pw.println(s+"</br>");
			pw.println(temp.getRelation()+"</br>");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	public void indexFileContacts (MailNode co ,String path ) {
		try {
			LinkedList ls = new LinkedList();
			File fr = new File(path);
			ls=convertToLinkedListContact(fr);
			int sizeLS = ls.size();
			String size = Integer.toString(sizeLS);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
			PrintWriter pw = new PrintWriter(bw);
			pw.println(size); //index
			pw.println("</br>");
			pw.println(co.getFirstName()+"</br>");
			pw.println(co.getLastName()+"</br>");
			String s = new String();
			LinkedList emails = co.getEmails();
			for(int i = 0; i < emails.size(); i++) {
				if(i == 0) {
				s = (String) emails.get(0);
				}
				else{
				s = s + '+' + emails.get(i);	
				}
			}
			pw.println(s+"</br>");
			pw.println(co.getRelation() + "</br>");
			//pw.println("<html><head><title>New Page</title></head><body><p>"+size+"</br>"+email.getSubject()+"</br>"+email.getFrom()+"</br>"+email.getTo()+"</br>"+email.getDate()+"</br>"+"                 "+"</br>"+"</p></body></html>");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public void creatContact(String namef, String namel, String r, LinkedList e) {
		MailNode newContact = new MailNode();
		newContact.setFirstName(namef);
		newContact.setLastName(namel);
		newContact.setEmails(e);
		newContact.setRelation(r);
		//System.out.println(pathServer+"\\"+theUser + "\\Contacts.html"+"++++++");
		indexFileContacts(newContact,path+ "\\Contacts.html" );
	}
	public MailNode getContact(String index) {
		File ff = new File(path+ "\\Contacts.html");
		System.out.println(ff.getAbsolutePath() + "hygtgg");
		LinkedList l = convertToLinkedListContact(ff);
		for(int i = 0; i < l.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode) l.get(i);
			if(temp.getIndex().equals(index)) {
				return temp;
			}
		}
		return null;
	}
	public void editContact(String namef, String namel, String r, LinkedList e,String index) throws NumberFormatException, FileNotFoundException {
		File ff = new File(path+ "\\Contacts.html");
		Delete_from_contacts(ff, Integer.parseInt(index));
		creatContact(namef, namel, r, e);
	}
	public void Delete_from_contacts(File ff, int index) throws FileNotFoundException {
		LinkedList ls = new LinkedList();
		ls = convertToLinkedListContact(ff);
		if (!ls.isEmpty()) {
			if (ls.size() != 1) {
				ls.remove(index);
			} else if (ls.size() == 1) {
				ls.clear();
			}
		}
		fromLinkedToIndexContact(ls, ff);
	}

	/*public void Rewrite_contacts(LinkedList linkedindex, File ff) {
		String s = ff.getAbsolutePath();
		ff.delete();
		LinkedList tonew = new LinkedList();
		MailNode old = new MailNode();
		int c = 0;
		while (c < linkedindex.size()) {
			MailNode temp = new MailNode();
			old = (MailNode) linkedindex.get(c);
			temp.setIndex(Integer.toString(c));
			temp.setFirstName(old.getFirstName());
			temp.setLastName(old.getLastName());
			temp.setRelation(old.getRelation());
			temp.setEmails(old.getEmails());
			tonew.add(temp);
			c++;
		}
		try {
			File newf = new File(s);
			fromLinkedToIndex(tonew, newf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}*/

}
