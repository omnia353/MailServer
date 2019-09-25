package application;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class App {
	public LinkedList linkedEmail = new LinkedList();
	public LinkedList inbox = new LinkedList();
	public File file = new File("/Server");
	public String emailname = new String();
	public String theUser ;
	public String theUserPath ;
	public String pathServer = file.getAbsolutePath();
	public String path = file.getAbsolutePath();
	public int index = 0;
	public File indexServer = new File(path + file.separator + "indexServer.html");
	private File sPathIndex = new File(path + file.separator + "indexServer.html");
	

	public App() {

		file.mkdir();
	}
//get the body of e-mail text to show it the e-mail content
	public String getBody(File f, String index) {
		LinkedList ls = new LinkedList();
		File f2 = new File(f + "\\index.html");
		ls = convertToLinkedList(f2);
		String body = new String();
		String str = new String();
		body = "";
		FileReader fr = null;
		BufferedReader br = null;
		for (int k = 0; k < ls.size(); k++) {
			MailNode mNode = new MailNode();
			mNode = (MailNode) ls.get(k);
			if (mNode.getIndex().equals(index)) {
				String s = mNode.getDate();
				String[] sss = s.split(" ");
				String pathn = new String();
				// the name of e-mail is named by subject and the date
				pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
				try {
					File bodyTxt = new File(f + "\\" + pathn + "\\" + pathn + ".html");
					fr = new FileReader(bodyTxt);
					br = new BufferedReader(fr);

					try {
						
						while ((str = br.readLine()) != null) {
							String substr = new String();
							substr = str.substring(0, (str.length()) - 5);
							System.out.println("subbb>"+ substr);
							// if (str.substring(str.length()-6, str.length()-1))
							
							
							if (str.contains("</br>") ) {
								
								body = body + substr + "\n";
							}
							else {
								body = body + str;
							}
						}
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			}

		}

		return body;


	}

	public void indexOthers(MailNode tempFolder, String path) {

		try {
			LinkedList ls = new LinkedList();
			File fr = new File(path);
			ls = fromIndexToLinkedOther(fr);
			int sizeLS = ls.size();
			String size = Integer.toString(sizeLS);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			PrintWriter pw = new PrintWriter(bw);
			pw.println(size);
			pw.println("</br>");
			pw.println(tempFolder.getnewFolder() + "</br>");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
// loading in the index file in linkedlist
	public void fromLinkedToIndexOther(LinkedList l, File f) throws FileNotFoundException {
	
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < l.size(); i++) {
				MailNode temp = new MailNode();
				temp = (MailNode) l.get(i);
				pw.println(temp.getIndex());
				pw.println("</br>");
				pw.println(temp.getnewFolder() + "</br>");

			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public LinkedList fromIndexToLinkedOther(File f) {
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
				System.out.println(str);
				if (i == 3) {
					i = 0;
				}
				if (i == 0) {
					temp.setIndex((str));
				} else if (i == 2) {					
					str = str.substring(0, str.length()-5);
					temp.setnewFolder(str);
					toLinked.add(temp);
					temp1 = new MailNode();
				}

				i++;

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return toLinked;
	}

	public boolean compose(Mail email) {
		LinkedList linkedEmail = new LinkedList();
		linkedEmail = indexServerToLinkedList(sPathIndex);
		Enode temp = new Enode();
		int flag = 0;
		
		String recievers = new String();
		String attach = new String();
		recievers = email.getTo();
		//for muiltiple reciever
		String[] toNames = recievers.split(" ");
		//for more than one atttachment
		String[] attachArray = new String[10];
		attach = (String) email.getAttachmenet();
		if (attach != null) {
			attachArray = attach.split("#");
		} else {
			attachArray = null;
		}
		//holding muiltiple reciever in queue
		Queue queue = new Queue();
		Queue queue2 = new Queue();
		Queue pathQueue = new Queue();
		for (int j = 0; j < toNames.length; j++) {
			queue.enqueue(toNames[j]);
		}
		// naming e-mail by by its subject and date 
		String s = email.getDate();
		String[] sss = s.split(" ");
		String pathn = new String();
		pathn = email.getSubject() + sss[0] + "-" + sss[1];
		int i = 0;
		while (!queue.isEmpty()) {
			while (i < linkedEmail.size()) {
				temp = (Enode) linkedEmail.get(i);
				if (temp.getEmailName().equals(queue.front())) {
					pathQueue.enqueue(temp.getPath());
					queue2.enqueue(queue.dequeue());
					flag = 1;
					break;
				} else {
					i++;
				}
			}
			if (flag == 0) {
return false;
//break;
			} else {
				flag = 0;
				i = 0;
			}
		}
		int j = 0;
		Enode temp2 = new Enode();
		String fromPath = new String();
		while (j < linkedEmail.size()) {
			temp2 = (Enode) linkedEmail.get(j);
			if (temp2.getEmailName().equals(email.getFrom())) {
				fromPath = temp2.getPath();
				break;
			} else {
				j++;
			}
		}

		if (queue2.isEmpty()) {
			return false;
		} else if (!pathQueue.isEmpty()) {
			while (!pathQueue.isEmpty() && pathQueue.front() != null) {
				File toInbox = new File(pathQueue.front() + "\\Inbox" + "\\" + pathn);
				toInbox.mkdir();
				String emailPath = new String();
				emailPath = toInbox.getAbsolutePath();
				File emailTxt = new File(emailPath + File.separator + pathn + ".html");
				try {
					emailTxt.createNewFile();
					BufferedWriter bw2 = new BufferedWriter(new FileWriter(emailTxt, true));
					PrintWriter pw2 = new PrintWriter(bw2);
					
					String[] theBody = email.getText().split("line.separator");
					for (int k = 0; k < theBody.length; k++) {
						pw2.println(theBody[k] + "</br>");
					}
					pw2.close();
					int attachNo = 1;
					int k = 0;
					String attachmentstr = new String();
					if (attachArray == null || attachArray.length == 0) {
						attachmentstr = null;
					} else {
						attachmentstr = "";
					}

					while (attachArray != null && k < attachArray.length) {
						if (attachArray[k] != null) {
							InputStream is = null;
							OutputStream os = null;
							String a = new String();
							a = attachArray[k];
							String rev = new String();
							String ss = new String();
							ss = "";
							rev = "";
							int m = a.length();
							while (a.charAt(m - 1) != '.') {
								ss = ss + a.charAt(m - 1);
								m--;
							}
							for (int n = ss.length() - 1; n >= 0; n--) {
								rev = rev + ss.charAt(n);
							}
							try {

								is = new FileInputStream(a);
								os = new FileOutputStream(emailPath + "\\attach" + attachNo + "." + rev);
								attachmentstr = attachmentstr + "attach" + attachNo + "." + rev + ";";
								attachNo++;
								byte[] buffer = new byte[1024];
								int length;
								while ((length = is.read(buffer)) > 0) {
									os.write(buffer, 0, length);
								}
							} finally {
								is.close();
								os.close();
							}

						}
						k++;
					}
					email.setAttachmenet(attachmentstr);
					indexFile(email, pathQueue.dequeue() + "\\Inbox\\index.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			int attachNo2 = 1;
			int f = 0;
			String attachmentstr = new String();
			if (attachArray == null || attachArray.length == 0) {
				attachmentstr = null;
			} else {
				attachmentstr = "";
			}

			File toSent = new File(fromPath + "\\Sent" + "\\" + pathn);
			toSent.mkdir();
			String emailPath2 = new String();
			emailPath2 = toSent.getAbsolutePath();
			File emailTxt2 = new File(emailPath2 + File.separator + pathn + ".html");

			while (attachArray != null && f < attachArray.length) {
				if (attachArray[f] != null) {
					InputStream is = null;
					OutputStream os = null;
					String a = new String();
					a = attachArray[f];
					String rev = new String();
					String ss = new String();
					ss = "";
					rev = "";
					int m = a.length();
					while (a.charAt(m - 1) != '.') {
						ss = ss + a.charAt(m - 1);
						m--;
					}
					for (int n = ss.length() - 1; n >= 0; n--) {
						rev = rev + ss.charAt(n);
					}

					try {
						try {
							is = new FileInputStream(a);
							os = new FileOutputStream(emailPath2 + "\\attach" + attachNo2 + "." + rev);
							String sd = new String();

							sd = emailPath2 + "\\attach" + attachNo2 + "." + rev;
							attachmentstr = attachmentstr + "attach" + attachNo2 + "." + rev + ";";
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//sending attachment
						attachNo2++;
						byte[] buffer = new byte[1024];
						int length;
						try {
							while ((length = is.read(buffer)) > 0) {
								os.write(buffer, 0, length);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} finally {
						try {
							is.close();
							os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					f++;

				}

			}
			email.setAttachmenet(attachmentstr);
			try {

				emailTxt2.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(emailTxt2, true));
				PrintWriter pw = new PrintWriter(bw);
				String[] theBody = email.getText().split("\n");
				for (int k = 0; k < theBody.length; k++) {
					pw.println(theBody[k] + "</br>");
				}
				indexFile(email, fromPath + "\\Sent\\index.html");

				pw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
// save a message in draft
	public boolean draft(Mail email) {
		Mail emailDraft = new Mail();
		emailDraft = email;
		LinkedList linkedEmail = new LinkedList();
		linkedEmail = indexServerToLinkedList(sPathIndex);
		Enode temp = new Enode();
		int flag = 0;
		String recievers = new String();
		String attach = new String();
		recievers = email.getTo();
		String[] attachArray = new String[10];
		attach = (String) email.getAttachmenet();
		String q = email.getDate();
		String[] sss = q.split(" ");
		String pathn = email.getSubject() + sss[0] + "-" + sss[1];

		if (attach != null) {
			attachArray = attach.split("#");
		} else {
			attachArray = null;
		}
		String[] toNames = recievers.split(" ");

		Queue queue = new Queue();
		Queue queue2 = new Queue();
		Queue pathQueue = new Queue();
		for (int j = 0; j < toNames.length; j++) {
			queue.enqueue(toNames[j]);
		}

		int i = 0;
		String attachmentstr = new String();
		if (attachArray == null || attachArray.length == 0) {
			attachmentstr = null;
		} else {
			attachmentstr = "";
		}
		while (!queue.isEmpty()) {
			while (i < linkedEmail.size()) {
				temp = (Enode) linkedEmail.get(i);
				if (temp.getEmailName().equals(queue.front())) {
					pathQueue.enqueue(temp.getPath());
					queue2.enqueue(queue.dequeue());
					flag = 1;
					break;
				} else {
					i++;
				}
			}
			if (flag == 0) {
				break;
			} else {
				flag = 0;
				i = 0;
			}
		}
		int j = 0;
		Enode temp2 = new Enode();
		String fromPath = new String();
		while (j < linkedEmail.size()) {
			temp2 = (Enode) linkedEmail.get(j);
			if (temp2.getEmailName().equals(email.getFrom())) {
				fromPath = temp2.getPath();
				break;
			} else {
				j++;
			}
		}
		File toSent = new File(fromPath + "\\Draft" + "\\" + pathn);
		toSent.mkdir();
		String emailPath2 = new String();
		emailPath2 = toSent.getAbsolutePath();

		int attachNo = 1;
		int k = 0;
		while (attachArray != null && k < attachArray.length) {
			if (attachArray[k] != null) {
				InputStream is = null;
				OutputStream os = null;
				String a = new String();
				a = attachArray[k];
				String rev = new String();
				String ss = new String();
				ss = "";
				rev = "";
				int m = a.length();
				while (a.charAt(m - 1) != '.') {
					ss = ss + a.charAt(m - 1);
					m--;
				}
				for (int n = ss.length() - 1; n >= 0; n--) {
					rev = rev + ss.charAt(n);
				}

				try {
					try {
						is = new FileInputStream(a);
						os = new FileOutputStream(emailPath2 + "\\attach" + attachNo + "." + rev);
						attachmentstr = attachmentstr + "attach" + attachNo + "." + rev + ";";
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					attachNo++;
					byte[] buffer = new byte[1024];
					int length;
					try {
						while ((length = is.read(buffer)) > 0) {
							os.write(buffer, 0, length);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					try {
						is.close();
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				k++;
			}
		}
		try {

			File emailTxt2 = new File(emailPath2 + File.separator + pathn + ".html");
			emailTxt2.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(emailTxt2, true));
			PrintWriter pw = new PrintWriter(bw);
			String[] theBody = email.getText().split("\n");
			for (int b = 0; b < theBody.length; b++) {
				pw.println(theBody[b] + "</br>");
			}		
			email.setAttachmenet(attachmentstr);
			indexFile(email, fromPath + "\\Draft\\index.html");

			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public void indexFilter(MailNode fn, String path) {

		try {
			LinkedList ls = new LinkedList();
			File fr = new File(path);
			ls = indexFilterToLinkedList(fr);
			int sizeLS = ls.size();
			String size = Integer.toString(sizeLS);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			PrintWriter pw = new PrintWriter(bw);
			pw.println(size);
			pw.println("</br>");
			pw.println(fn.getFilterName() + "</br>");
			pw.println(fn.getFilterPath() + "</br>");
			pw.println(fn.getFolderName() + "</br>");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LinkedList indexFilterToLinkedList(File f) {
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
				if (i == 5) {
					i = 0;
				}
				if (i == 0) {
					temp.setIndex(str);

				} else if (i == 2) {
					str = str.substring(0, str.length() - 5);
					temp.setFilterName(str);

				} else if (i == 3) {
					str = str.substring(0, str.length() - 5);
					temp.setFilterPath(str);
				} else if (i == 4) {
					str = str.substring(0, str.length() - 5);
					temp.setFolderName(str);
					toLinked.add(temp);
					temp1 = new MailNode();
				}
				i++;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return toLinked;
	}

	public String[][] fromLinkedtoArray(LinkedList l) {
		String[][] array = new String[l.size()][7];
		for (int i = 0; i < l.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode) l.get(i);
			array[i][0] = temp.getIndex();
			array[i][1] = temp.getSubject();
			array[i][2] = temp.getFrom();
			array[i][3] = temp.getTo();
			array[i][4] = temp.getDate();
			array[i][5] = temp.getAttachment();
			array[i][6] = temp.getPriority();
		}
		return array;
	}

	public LinkedList fromArrayToLinked(String[][] array) {
		LinkedList l = new LinkedList();
		for (int i = 0; i < array.length; i++) {
			MailNode temp = new MailNode();
			temp.setIndex(array[i][0]);
			temp.setSubject(array[i][1]);
			temp.setFrom(array[i][2]);
			temp.setTo(array[i][3]);
			temp.setDate(array[i][4]);
			temp.setAttachment(array[i][5]);
			temp.setPriority(array[i][6]);
			l.add(temp);
		}
		return l;
	}

	public LinkedList convertToLinkedList(File f) {
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
				// System.out.println("d5al =" + i);
				temp = temp1;
				if (i == 8) {
					i = 0;
				}
				if (i == 0) {
					temp.setIndex(str);
				} else if (i == 2) {
					str = str.substring(0, str.length() - 5);
					temp.setSubject(str);
				} else if (i == 3) {
					str = str.substring(0, str.length() - 5);
					temp.setFrom(str);
				} else if (i == 4) {
					str = str.substring(0, str.length() - 5);
					temp.setTo(str);

				} else if (i == 5) {
					str = str.substring(0, str.length() - 5);
					temp.setDate(str);

				} else if (i == 6) {

					str = str.substring(0, str.length() - 5);
					temp.setAttachment(str);

				} else if (i == 7) {
					str = str.substring(0, str.length() - 5);
					temp.setPriority((str));
					toLinked.add(temp);
					temp1 = new MailNode();
				}
				i++;
			}
			fr.close();
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return toLinked;
	}
	public void fromLinkedToIndex(LinkedList l, File f) throws FileNotFoundException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < l.size(); i++) {
				MailNode temp = new MailNode();
				temp = (MailNode) l.get(i);
				pw.println(temp.getIndex());
				pw.println("</br>");
				pw.println(temp.getSubject() + "</br>");
				pw.println(temp.getFrom() + "</br>");
				pw.println(temp.getTo() + "</br>");
				pw.println(temp.getDate() + "</br>");
				pw.println(temp.getAttachment() + "</br>");
				pw.println(temp.getPriority() + "</br>");
				// pw.close();
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void indexFile(Mail email, String path) {

		try {
			LinkedList ls = new LinkedList();
			File fr = new File(path);
			ls = convertToLinkedList(fr);
			int sizeLS = ls.size();
			String size = Integer.toString(sizeLS);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			PrintWriter pw = new PrintWriter(bw);
			pw.println(size);
			pw.println("</br>");
			pw.println(email.getSubject() + "</br>");
			pw.println(email.getFrom() + "</br>");
			pw.println(email.getTo() + "</br>");
			pw.println(email.getDate() + "</br>");
			pw.println(email.getAttachmenet() + "</br>");
			pw.println("4" + "</br>");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LinkedList indexServerToLinkedList(File f) {
		LinkedList toLinked = new LinkedList();
		String str = new String();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			int i = 0;
			Enode temp = new Enode();
			Enode temp1 = new Enode();
			while ((str = br.readLine()) != null) {

				temp = temp1;
				if (i == 5) {
					i = 0;
				}
				if (i == 0) {
					temp.setIndexUser(Integer.parseInt(str));
				} else if (i == 2) {
					str = str.substring(0, str.length() - 5);
					temp.setEmailName(str);
				} else if (i == 3) {
					str = str.substring(0, str.length() - 5);
					temp.setPath(str);
				} else if (i == 4) {
					str = str.substring(0, str.length() - 5);
					temp.setPassword(str);
					toLinked.add(temp);
					temp1 = new Enode();
				}
				i++;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return toLinked;
	}

	public boolean signin(String email, String password) {
		int i = 0;
		int flag = 0;
		Enode s = new Enode();
		s.setEmailName(email);
		s.setPassword(password);
		s.setPath(pathServer + "\\" + email);
		Enode m = new Enode();
		File ff = new File(pathServer + "\\indexServer.html");
		LinkedList newL = indexServerToLinkedList(ff);
		while (i < newL.size()) {
			m = (Enode) newL.get(i);
			if (s.getEmailName().equals(m.getEmailName())) {
				flag = 1;
				break;
			}
			i++;
		}
		if (flag == 1) {
			if (s.getPassword().equals(m.getPassword())) {
				theUser = email;
				theUserPath = s.getPath();
				flag = 0;
				String trashindex = theUserPath + "\\Trash" + "\\index.html";
				File index = new File(trashindex);
				LinkedList linkedindex = convertToLinkedList(index);
				int k = 0;
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH;mm;ss");
				LocalDateTime now = LocalDateTime.now();
				String currenttime = dtf.format(now);
				while (k < linkedindex.size()) {
					MailNode temp = (MailNode) linkedindex.get(k);
					String sDate = temp.getDate();
					String[] sss = sDate.split(" ");
					String pathn = new String();
					pathn = temp.getSubject() + sss[0] + "-" + sss[1];
					daysDiff(temp.getDate(), currenttime, temp.getIndex(), pathn);

					k++;
				}

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean signup(Contact contact) {
		String nameOfEmail = new String();
		String password = new String();
		String birth = new String();
		String name1 = new String();
		String name2 = new String();
		String G = new String();
		String pathimage = new String();
		int flag;
		int i = 0;
		flag = 0;
		nameOfEmail = contact.getEmailName();
		password = contact.getPassword();
		birth = contact.getDateOfBirth();
		name1 = contact.getFirstName();
		name2 = contact.getLastName();
		G = contact.getGender();
		pathimage = contact.getProfilePicture();
		File fq = new File(pathServer + "\\indexServer.html");
		LinkedList newL = indexServerToLinkedList(fq);
		while (i < newL.size()) {
			Enode temp2 = (Enode) newL.get(i);
			System.out.println(temp2.getEmailName() + "*/*/*/" + nameOfEmail);
			if (temp2.getEmailName().equals(nameOfEmail)) {
				flag = 1;
				break;
			} else {
				i++;
				flag = 0;
			}
		}
		int flag2 = 0;
		int flag3 = 0;
		int flag4 = 0;
		int flag5 = 0;
		if (flag == 1) {
			System.out.println("Repeated Email Name");
		}
		if (password.length() < 8 || password.length() > 20) {
			flag2 = 1;
			System.out.println("Try to enter a suitable password");
		}
		if (name1.contains(" ")) {
			flag3 = 1;
			System.out.println("No space");
		}
		if (name2.contains(" ")) {
			flag4 = 1;
			System.out.println("No space");
		}
		if (nameOfEmail.contains(" ")) {
			flag5 = 1;
			System.out.println("No space");
		}
		if (flag != 1 && flag2 != 1 && flag3 != 1 && flag4 != 1 && flag5 != 1) {
			File f1 = new File(path + "\\" + nameOfEmail);
			f1.mkdir();
			String pathF1 = f1.getAbsolutePath();
			theUserPath = pathF1;
			theUser = nameOfEmail;
			File info = new File(pathF1 + file.separator + "info.html");
			try {
				info.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Enode temp = new Enode();
			temp.setEmailName(contact.getEmailName());
			temp.setPassword(contact.getPassword());
			temp.setPath(pathF1);
			write_indexserver(temp);
			File inbox = new File(pathF1 + "\\Inbox");
			File sent = new File(pathF1 + "\\Sent");
			File trash = new File(pathF1 + "\\Trash");
			File draft = new File(pathF1 + "\\Draft");
			File others = new File(pathF1 + "\\Others");
			File filter = new File(pathF1 + "\\Filter");
			File favourite = new File(pathF1 + "\\Favourites");

			inbox.mkdir();
			sent.mkdir();
			trash.mkdir();
			draft.mkdir();
			others.mkdir();
			filter.mkdir();
			favourite.mkdir();

			File indexInbox = new File(pathF1 + "\\Inbox" + file.separator + "index.html");
			File indexSent = new File(pathF1 + "\\Sent" + file.separator + "index.html");
			File indexTrash = new File(pathF1 + "\\Trash" + file.separator + "index.html");
			File indexDraft = new File(pathF1 + "\\Draft" + file.separator + "index.html");
			File indexOthers = new File(pathF1 + "\\Others" + file.separator + "index.html");
			File indexFilter = new File(pathF1 + "\\Filter" + file.separator + "index.html");
			File indexContacts = new File(pathF1 + file.separator + "Contacts.html");
			File indexfavourite = new File(pathF1 + "\\Favourites" + file.separator + "index.html");

			try {
				indexInbox.createNewFile();
				indexDraft.createNewFile();
				indexSent.createNewFile();
				indexTrash.createNewFile();
				indexOthers.createNewFile();
				indexFilter.createNewFile();
				indexContacts.createNewFile();
				indexfavourite.createNewFile();

				if (pathimage != null) {
					FileWriter fw = new FileWriter(info, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					BufferedImage image = null;
					File f = null;
					f = new File(pathimage);
					image = new BufferedImage(20, 30, BufferedImage.TYPE_INT_ARGB);
					image = ImageIO.read(f);

					f = new File(pathF1 + "\\" + "profilePic.jpg");
					ImageIO.write(image, "jpg", f);

					pw.print("<html><head><title>New Page</title></head><body><p>" + "First Name : " + name1 + "</br>"
							+ "Last Name : " + name2 + "</br>" + "Gendre :" + G + "</br>" + "Email : " + nameOfEmail
							+ "</br>" + "Date Of Birth : " + birth + "</br>" + "</p><img src = " + "profilePic.jpg"
							+ "></body></html>");
					pw.close();
				} else {
					FileWriter fw = new FileWriter(info, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					pw.print("<html><head><title>New Page</title></head><body><p>" + "First Name : " + name1 + "</br>"
							+ "Last Name : " + name2 + "</br>" + "Gendre :" + G + "</br>" + "Email : " + nameOfEmail
							+ "</br>" + "Date Of Birth : " + birth + "</body></html>");
					pw.close();
				}
				System.out.println(theUserPath + "+++++++++");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();
			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
				}
			}

		} else {
			// if file, then delete it
			file.delete();
		}
	}

	public void after30Days(long d, String deletePath, String indexmail) {

		if (d >= 30) {
			// File file = new File(deletePath);

			File directory = new File(deletePath);
			directory.mkdirs();
			// make sure directory exists
			if (!directory.exists()) {

			} else {

				try {

					delete(directory);

				} catch (IOException e) {
					e.printStackTrace();

				}
			}

			System.out.println("Done");

			String fromIndex = new String();
			fromIndex = theUserPath + "\\Trash";
			Delete_from_index(fromIndex, indexmail);
			System.out.println("del");
		}
	}

	public long daysDiff(String s1, String s2, String index, String name) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH;mm;ss");
		String inputString1 = s1;
		String inputString2 = s2;

		long dateDiff = 0;

		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			long diff = date2.getTime() - date1.getTime();
			dateDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		after30Days(dateDiff, theUserPath + "\\Trash\\" + name, s1);
		return dateDiff;
	}

	public void write_indexserver(Enode account) {
		File f = new File(pathServer + "\\indexServer.html");
		LinkedList newlinked = new LinkedList();
		newlinked = indexServerToLinkedList(f);
		int size = newlinked.size();
		Enode temp = new Enode();
		temp.setEmailName(account.getEmailName());
		temp.setPassword(account.getPassword());
		temp.setPath(account.getPath());
		temp.setIndexUser(size);
		try {
			BufferedWriter bw3;
			bw3 = new BufferedWriter(new FileWriter(indexServer, true));
			PrintWriter pw3 = new PrintWriter(bw3);
			pw3.println(temp.getIndexUser());
			pw3.println("</br>");
			pw3.println(temp.getEmailName() + "</br>");
			pw3.println(temp.getPath() + "</br>");
			pw3.println(temp.getPassword() + "</br>");
			pw3.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
	}

	public void Rename(String newname, String filepath) {
		File old = new File(filepath);
		int k;
		k = filepath.length();
		String s = "";
		while (filepath.charAt(k - 1) != '\\') {
			k--;
		}
		String newpath = filepath.substring(0, k);
		File fe = new File(newpath + newname);
		old.renameTo(fe);
	}

	
	
	public void renameFolder(String yy, File frename, String oldName, String newName) {
		Rename(newName, frename.getAbsolutePath());
		File newf = new File(yy + "\\Others" + "\\index.html");
		LinkedList newlinked = new LinkedList();
		newlinked = fromIndexToLinkedOther(newf);
		for (int i = 0; i < newlinked.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode) newlinked.get(i);
			System.out.println(temp.getnewFolder() + "nameeeeeeefolder");
			String[] noBreak = temp.getnewFolder().split("</br>");
			String newBr = new String();
			newBr = noBreak[0];
			//noBreak = temp.getnewFolder().substring(0, temp.getnewFolder().length()-5);
			
			if (newBr.equals(oldName)) {
					temp.setnewFolder(newName);
					newlinked.set(i,temp);
				
			}
		}
	
		try {
			fromLinkedToIndexOther(newlinked, newf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEmails(LinkedList mails, String filepath) {
		// hageb el path mn gui path path path 7zwd 73mlo substring b3d kda trash
		
		try {
		Folder des = new Folder();
		des.setPath(theUserPath + "\\Trash");
			moveEmails(mails, des, filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Delete_from_index(String path, String string) {
		File indexfile = new File(path + "\\index.html");
		LinkedList ls = new LinkedList();
		ls = convertToLinkedList(indexfile);
		for (int k = 0; k < ls.size(); k++) {
			MailNode temp = new MailNode();
			temp = (MailNode) ls.get(k);
			if (temp.getDate().equals(string)) {
				if (ls.size() != 1) {
					ls.remove(k);

				} else if (ls.size() == 1) {
					ls.clear();
				}
			}
		}
		Rewrite_index(ls, path);
	}

	public void Rewrite_index(LinkedList linkedindex, String pathindex) {
		File f = new File(pathindex + "\\index.html");
		delete_file(f.getAbsolutePath());
		if (f.delete()) {
			System.out.println(f.getName() + " is deleted!");
		} else {
			System.out.println("Delete operation is failed.");
		}
		LinkedList tonew = new LinkedList();
		int c = 0;
		while (c < linkedindex.size()) {
			MailNode temp = new MailNode();
			MailNode old = new MailNode();
			old = (MailNode) linkedindex.get(c);
			temp.setIndex(Integer.toString(c));
			temp.setTo(old.getTo());
			temp.setFrom(old.getFrom());
			temp.setSubject(old.getSubject());
			temp.setDate(old.getDate());
			temp.setAttachment(old.getAttachment());
			temp.setPriority(old.getPriority());
			tonew.add(temp);
			c++;
		}
		try {
			File newf = new File(pathindex + "\\index.html");
			try {
				newf.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < tonew.size(); i++) {
				MailNode ny = new MailNode();
				ny = (MailNode) tonew.get(i);
				System.out.println("sub####" + ny.getSubject());
				System.out.println("from#################" + ny.getFrom());
				System.out.println("sub####" + ny.getTo());
				System.out.println("sub####" + ny.getIndex());
				System.out.println("***********************");

			}
			fromLinkedToIndex(tonew, newf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void moveEmails(LinkedList mails, Folder des, String filepath) throws IOException {
		for (int i = 0; i < mails.size(); i++) {
			Mail themoved = new Mail();
			MailNode m = (MailNode) mails.get(i);
			String despath = des.getPath();
			String s = m.getDate();
			String[] sss = s.split(" ");
			String pathn = new String();
			pathn = m.getSubject() + sss[0] + "-" + sss[1];
			File desfile = new File(despath + "\\" + pathn);
			File from = new File(filepath + "\\" + pathn);
			Files.move(from.toPath(), desfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Delete_from_index(filepath, m.getDate());
			themoved.setDate(m.getDate());
			themoved.setTo(m.getTo());
			themoved.setFrom(m.getFrom());
			themoved.setSubject(m.getSubject());
			themoved.setAttachmenet(m.getAttachment());
			themoved.setPriority(m.getPriority());
			indexFile(themoved, despath + "\\index.html");
		}
	}

	public void delete_file(String deletePath) {

		File file = new File(deletePath);
		if (file.isDirectory()) {
			if (file.list().length == 0) {
				file.delete();
			} else {
				String files[] = file.list();

				for (String temp : files) {
					File fileDelete = new File(file, temp);
					fileDelete.delete();
				}
				if (file.list().length == 0) {
					file.delete();
				}
			}

		} else {
			file.delete();
		}

	}

	public void setViewingOptions(Sort sort, File file, String sortType) throws FileNotFoundException {
		LinkedList l = convertToLinkedList(file);
		LinkedList returnArray = new LinkedList();
		if (sortType.equals("Priority")) {
			returnArray = sort.prioritySort(l);
		} else {
			
			String[][] array = fromLinkedtoArray(l);
			sort.sort(array, 0, array.length - 1, sortType);
			if(sortType.equals("Default")) {
				for (int i = array.length - 1; i >= 0; i--) {
					MailNode temp = new MailNode();
					temp.setIndex(array[i][0]);
					temp.setSubject(array[i][1]);
					temp.setFrom(array[i][2]);
					temp.setTo(array[i][3]);
					temp.setDate(array[i][4]);
					temp.setAttachment(array[i][5]);
					temp.setPriority(array[i][6]);
					returnArray.add(temp);
				}
			}
			else {
			returnArray = fromArrayToLinked(array);
			}
		}
		fromLinkedToIndex(returnArray, file);
	}

	public LinkedList search(Sort sort, File file, String type, Search binary, String keyWord)
			throws FileNotFoundException {
		LinkedList l = convertToLinkedList(file);
		String[][] array = fromLinkedtoArray(l);
		sort.sort(array, 0, array.length - 1, type);
		l.clear();
		l = fromArrayToLinked(array);
		LinkedList ll = new LinkedList();
		ll = binary.BinarySearch(l, keyWord, type);
		/*
		 * for(int i = 0; i< ll.size(); i++) { MailNode x = new MailNode(); x =
		 * (MailNode) ll.get(i); System.out.println(x.getSubject()); }
		 */
		return ll;
	}
	private static void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
		// Check if sourceFolder is a directory or file
		// If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory()) {
			// Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists()) {
				destinationFolder.mkdir();
			}

			// Get all files from source directory
			String files[] = sourceFolder.list();

			// Iterate over all files and copy them to destinationFolder one by one
			for (String file : files) {
				File srcFile = new File(sourceFolder, file);
				File destFile = new File(destinationFolder, file);

				// Recursive function call
				copyFolder(srcFile, destFile);
			}
		} else {
			// Copy the file content from one place to another
			Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public void copyEmails(LinkedList mails, Folder des, String filepath) throws IOException {
		for (int i = 0; i < mails.size(); i++) {
			Mail themoved = new Mail();
			MailNode m = (MailNode) mails.get(i);
			String mailname = m.getSubject();
			String despath = des.getPath();
			String ss = m.getDate();
			String[] sss = ss.split(" ");
			String pathn = new String();
			pathn = m.getSubject() + sss[0] + "-" + sss[1];
			File desfile = new File(despath + "\\" + pathn);
			File from = new File(filepath + "\\" + pathn);
			try {
				// Files.copy(srcDir.toPath(),destDir.toPath());
				copyFolder(from, desfile);
			} catch (IOException e) {
				e.printStackTrace();
			} // Delete_from_index(filepath, m.getIndex());
			themoved.setDate(m.getDate());
			themoved.setTo(m.getTo());
			themoved.setFrom(m.getFrom());
			themoved.setSubject(m.getSubject());
			indexFile(themoved, despath + "\\index.html");
		}
	}

	public boolean composeFromDraft(LinkedList list) throws IOException {
		for (int k = 0; k < list.size(); k++) {
			LinkedList mail = new LinkedList();
			MailNode temp = new MailNode();
			temp = (MailNode) list.get(k);
			mail.add(temp);
			Folder foldFrom = new Folder();
			foldFrom.setPath("C:\\Server\\" + temp.getFrom() + "\\Sent");
			moveEmails(mail, foldFrom, "C:\\Server\\" + temp.getFrom() + "\\Draft");
			String[] multirec = temp.getTo().split(" ");
			for (int j = 0; j < multirec.length; j++) {
				Folder foldTo = new Folder();
				foldTo.setPath("C:\\Server\\" + multirec[j] + "\\Inbox");

				copyEmails(mail, foldTo, foldFrom.getPath());

			}
			// more reciever split to
		}

		return false;

	}

	public void deleteFolder(File fDelete, String name) throws FileNotFoundException {

		String path = fDelete.getAbsolutePath() + "\\" + name;
		Delete_account(path);
		File newf = new File(fDelete.getAbsolutePath() + "\\index.html");
		LinkedList newlinked = new LinkedList();
		newlinked = fromIndexToLinkedOther(newf);
		for (int i = 0; i < newlinked.size(); i++) {
			MailNode temp = new MailNode();
			temp = (MailNode) newlinked.get(i);
			if (temp.getnewFolder().equals(name)) {
				if (newlinked.size() != 1) {
					newlinked.remove(i);
				} else if (newlinked.size() == 1) {
					newlinked.clear();
				}
			}
		}
		fromLinkedToIndexOther(newlinked, newf);

	}

	public void Delete_account(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			// directory is empty, then delete it
			if (f.list().length == 0) {
				f.delete();
				// System.out.println("Directory is deleted : "+ file.getAbsolutePath());
			} else {
				// list all the directory contents
				String files[] = f.list();
				for (String temp : files) {
					File fileDelete = new File(f, temp);
					if (fileDelete.isDirectory()) {
						Delete_account(fileDelete.getAbsolutePath());
					} else {
						fileDelete.delete();
					}
				}
				// check the directory again, if empty then delete it
				if (f.list().length == 0) {
					f.delete();
				}
			}

		} else {
			// if file, then delete it
			f.delete();
		}
	}

}