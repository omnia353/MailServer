package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControllerMain implements Initializable {
	@FXML
	private AnchorPane mainRoot;

	@FXML

	private AnchorPane mainRoot2;

	@FXML
	private AnchorPane mainRoot3;

	@FXML
	private AnchorPane mainRoot4;

	@FXML
	private AnchorPane newFolderRoot;
	@FXML
	Button renameB = new Button();
	@FXML
	Button view1;

	@FXML
	Button view2;

	@FXML
	Button view3;

	@FXML
	Button view4;

	@FXML
	Button go1;

	@FXML
	Button go2;

	@FXML
	Button go3;

	@FXML
	Button go4;

	@FXML
	Button go5;

	@FXML
	Button go6;

	@FXML
	Button go7;

	@FXML
	Button go8;

	@FXML
	Button go9;

	@FXML
	Button go10;

	@FXML
	Button exite1;

	@FXML
	public ListView theViewList;

	@FXML
	Button Previous;

	@FXML
	Button bodyBtn;

	@FXML
	TextArea emailBody;

	@FXML
	Button img;

	@FXML
	Button att1;

	@FXML
	Button att2;

	@FXML
	Button att3;

	@FXML
	Button att4;

	@FXML
	Button att5;

	@FXML
	Button att6;

	@FXML
	Button att7;

	@FXML
	Button att8;

	@FXML
	Button att9;

	@FXML
	Button att10;

	@FXML
	public AnchorPane root1;

	@FXML
	public AnchorPane root2;

	@FXML
	public ListView attList;

	@FXML
	Label attlabel;

	@FXML
	Label bodylabel;

	@FXML
	Label fromLabel;

	@FXML
	Label dateLabel;

	@FXML
	Label subjectLabel;

	@FXML
	TextField t1;

	@FXML
	TextField t2;

	@FXML
	TextField t3;

	@FXML
	TextField t4;

	@FXML
	Label h500;

	@FXML
	CheckBox chk1;

	@FXML
	CheckBox chk2;

	@FXML
	CheckBox chk3;

	@FXML
	CheckBox chk4;

	@FXML
	CheckBox chk5;

	@FXML
	CheckBox chk6;

	@FXML
	CheckBox chk7;

	@FXML
	CheckBox chk8;

	@FXML
	CheckBox chk9;

	@FXML
	CheckBox chk10;

	@FXML
	Button seemore;
	@FXML
	public ComboBox<String> combo;
	ObservableList<String> viewList = FXCollections.observableArrayList();

	@FXML
	public ComboBox<String> combo1;
	ObservableList<String> searchList = FXCollections.observableArrayList();

	@FXML
	public TextField search = new TextField();

	@FXML
	Button GoSrearch;
	@FXML
	Button close = new Button();
	@FXML
	Button GoView;

	@FXML
	public ComboBox<String> combo3;
	ObservableList<String> multiList = FXCollections.observableArrayList();

	@FXML
	public ComboBox<String> combo4;
	ObservableList<String> toList = FXCollections.observableArrayList();

	@FXML
	public ComboBox<String> combo5;
	ObservableList<String> otherVV = FXCollections.observableArrayList();
	@FXML
	public ComboBox<String> comboFilter;
	ObservableList<String> filterList = FXCollections.observableArrayList("---");
	@FXML
	public ComboBox<String> comboDeleteFolder;
	@FXML
	Button addNewFolder;

	@FXML
	TextField folderName;
	@FXML
	static String sM = new String();
	@FXML
	Button chkLikedFolder;

	@FXML
	Label warning1;

	@FXML
	Button vOther;
	@FXML
	Button fav = new Button();
	@FXML
	ComboBox<String> prio1;
	ObservableList<String> prioritySelect = FXCollections.observableArrayList();
	@FXML
	ComboBox<String> indexs;
	ObservableList<String> indexSelect = FXCollections.observableArrayList();

	@FXML
	Button SendDraft = new Button();
	@FXML
	AnchorPane pane = new AnchorPane();

	LinkedList multi = new LinkedList();
	App x = new App();
	int pageCount1 = 1;
	int pageCount2 = 0;
	int pageCount3 = 0;
	int pageCount4 = 0;
	int pageCount5 = 0;
	int pageCount6 = 0;
	int pageCount7 = 0;
	int pageCount8 = 0;
	int pageCount9 = 0;
	int flagBackNext = 0;
	String sMain;
	String s = "0";
	String sSearch = "1";
	String others = "1";
	String filter = "1";
	File f = null;
	String m;
	String tempNode = new String();
	MailNode mNode = new MailNode();
	Controller y = new Controller();
	String yy = y.spath;
	public String refresh2 = new String();

	public void deleteFile(String deletePath) {
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

	@FXML
	public void chkMulti1(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(0);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti2(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(1);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti3(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(2);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti4(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(3);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti5(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(4);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti6(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(5);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti7(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(6);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti8(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(7);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti9(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(8);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	@FXML
	public void chkMulti10(ActionEvent event) {
		int flagchk = 0;
		int index1 = 0;
		Button k1 = (Button) theViewList.getItems().get(9);
		String temp = k1.getText();
		String[] split = temp.split(" ");
		MailNode m = new MailNode();
		m.setIndex((split[0]));
		System.out.println(" index chk1 ---->    " + split[0]);

		if (!(multi.isEmpty())) {
			for (int i = 0; i < multi.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) multi.get(i);
				if (temp2.getIndex().equals(m.getIndex())) {
					flagchk = 1;
					index1 = i;
					break;
				}
			}
			if (flagchk == 1) {
				if (multi.size() == 1) {
					multi.clear();
					combo3.setVisible(false);
					combo4.setVisible(false);
				} else {
					multi.remove(index1);
				}
			} else {
				multi.add(m);
				combo3.setVisible(true);
			}
		} else {
			multi.add(m);
			combo3.setVisible(true);
		}
	}

	public void ifDelete() {
		String smain = new String();
		smain = sMain + "\\index.html";
		LinkedList tempLink = new LinkedList();
		File tempFile = new File(smain);
		System.out.println("smainnnnnnnnnnnnnnnnnn"+smain);
		tempLink = x.convertToLinkedList(tempFile);
		System.out.println("sizeeeeeeeeee"+tempLink.size());

		LinkedList toReturn = new LinkedList();
		for (int i = 0; i < multi.size(); i++) {
			MailNode n1 = new MailNode();
			n1 = (MailNode) multi.get(i);
			for (int j = 0; j < tempLink.size(); j++) {
				MailNode n2 = new MailNode();
				n2 = (MailNode) tempLink.get(j);
				if (n1.getIndex().equals(n2.getIndex())) {
					toReturn.add(n2);
				}
			}
		}
		chk1.setSelected(false);
		chk2.setSelected(false);
		chk3.setSelected(false);
		chk4.setSelected(false);
		chk5.setSelected(false);
		chk6.setSelected(false);
		chk7.setSelected(false);
		chk8.setSelected(false);
		chk9.setSelected(false);
		chk10.setSelected(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		if(!multi.isEmpty()) {
			multi.clear();
			}
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		System.out.println("SMAIMMMM" + sMain);
		deleteEmails(toReturn, sMain);
	
	}

	public void ifMove(File d) {
		String smain = new String();
		smain = sMain + "\\index.html";
		System.out.println("MOVEE");
		LinkedList tempLink = new LinkedList();
		File tempFile = new File(smain);
		tempLink = x.convertToLinkedList(tempFile);
		LinkedList toReturn = new LinkedList();
		for (int i = 0; i < multi.size(); i++) {
			MailNode n1 = new MailNode();
			n1 = (MailNode) multi.get(i);
			for (int j = 0; j < tempLink.size(); j++) {
				MailNode n2 = new MailNode();
				n2 = (MailNode) tempLink.get(j);
				if (n1.getIndex().equalsIgnoreCase(n2.getIndex())) {
					toReturn.add(n2);
				}
			}
		}
		Folder des = new Folder();
		des.setPath(d.getAbsolutePath());
		try {
			x.moveEmails(toReturn, des, sMain);
			// moveEmails(toReturn, des, sMain);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!multi.isEmpty()) {
		multi.clear();
		}
		chk1.setSelected(false);
		chk2.setSelected(false);
		chk3.setSelected(false);
		chk4.setSelected(false);
		chk5.setSelected(false);
		chk6.setSelected(false);
		chk7.setSelected(false);
		chk8.setSelected(false);
		chk9.setSelected(false);
		chk10.setSelected(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;

	}

	@FXML
	public void moveAction(ActionEvent event) {
		String j = combo4.getValue();
		String thePath = yy + "\\Others\\" + j;
		File g = new File(thePath);
		ifMove(g);
	}

	@FXML
	public void multiAction(ActionEvent event) {
		String d = combo3.getValue();
		if (d.equals("Delete")) {
			ifDelete();
		}
		if (d.equals("Move")) {
			combo4.setVisible(true);
		}
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
	}

	@FXML
	public void viewEmailsInbox(ActionEvent event) throws IOException {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		pageCount2++;
		if (pageCount2 == 1) {
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			refresh2 = "Inbox";
			viewList.clear();
			viewList.add("Subject");
			viewList.add("Default");
			viewList.add("Sender's Name");
			viewList.add("Priority");
			searchList.clear();
			multiList.clear();
			attList.getItems().clear();
			multiList.add("Delete");
			multiList.add("Move");
			searchList.add("Subject");
			searchList.add("Sender's Name");
			searchList.add("---");
			theViewList.getItems().clear();
			LinkedList i = new LinkedList();
			sMain = yy + "\\Inbox";
			String smain = sMain + "\\index.html";
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount5 == 0
					&& pageCount6 == 0 && pageCount7 == 0) {
				File ff = new File(s);
				i = x.convertToLinkedList(ff);
			} else {
				s = sMain + "\\index.html";
				File ff = new File(smain);
				i = x.convertToLinkedList(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			int count1 = 0;
			for (int j = 0; j < 10 && j < i.size(); j++) {
				count1++;
				// combo3.setVisible(false);
				if (j == 0) {
					chk1.setVisible(true);
				}
				if (j == 1) {
					chk2.setVisible(true);
				}
				if (j == 2) {
					chk3.setVisible(true);
				}
				if (j == 3) {
					chk4.setVisible(true);
				}
				if (j == 4) {
					chk5.setVisible(true);
				}
				if (j == 5) {
					chk6.setVisible(true);
				}
				if (j == 6) {
					chk7.setVisible(true);
				}
				if (j == 7) {
					chk8.setVisible(true);
				}
				if (j == 8) {
					chk9.setVisible(true);
				}
				if (j == 9) {
					chk10.setVisible(true);
				}
				MailNode m = new MailNode();
				m = (MailNode) i.get(j);
				String s1 = m.getFrom();
				String s2 = m.getSubject();
				String s3 = m.getIndex();
				while (s1.length() != 20) {
					s1 = s1 + " ";
				}
				while (s2.length() != 30) {
					s2 = s2 + " ";
				}
				String s = s3 + "  " + s1 + s2 + m.getDate();
				Button k = new Button();
				k.setText(s);
				k.setPrefHeight(40);
				k.setPrefWidth(606);
				k.setFont(new Font("Courier New", 13));
				k.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						attList.getItems().clear();
						String tempp = new String();
						tempp = k.getText();
						String[] p = tempp.split(" ");
						String toAttach = new String();
						toAttach = p[0];
						int aTT = (Integer.parseInt(toAttach));
						LinkedList t11 = x.convertToLinkedList(new File(smain));
						MailNode myNode = new MailNode();
						for (int k2 = 0; k2 < t11.size(); k2++) {
							MailNode d = new MailNode();
							d = (MailNode) t11.get(k2);
							if (aTT == Integer.parseInt(d.getIndex())) {
								myNode = d;
								mNode = d;
							}
						}
						String s3 = new String();
						s3 = x.getBody(new File(yy + "\\Inbox"), myNode.getIndex());
						System.out.println("<<<<<" + s3);
						emailBody.setText(s3);
						bodylabel.setVisible(true);
						attlabel.setVisible(true);
						emailBody.setVisible(true);
						attList.setVisible(true);
						fromLabel.setVisible(true);
						subjectLabel.setVisible(true);
						dateLabel.setVisible(true);
						t1.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						t4.setVisible(true);
						t1.setText(myNode.getFrom());
						t2.setText(myNode.getSubject());
						t3.setText(myNode.getDate());
						t4.setText(myNode.getTo());
						prio1.setPromptText("Priority");
						prio1.setVisible(true);
						close.setVisible(true);
						;
						fav.setVisible(true);
						pane.setVisible(true);
						if (!(myNode.getAttachment()).equals("null")) {
							String[] att1 = (myNode.getAttachment()).split(";");
							for (int i = 0; i < att1.length; i++) {
								Button k = new Button();
								System.out.println(att1[i]);
								String temp1 = att1[i];
								k.setText(temp1);
								k.setOnAction(new EventHandler() {
									@Override
									public void handle(Event event) {
										String ss = mNode.getDate();
										String[] sss = ss.split(" ");
										String pathn = new String();
										pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
										String myFile = yy + "\\Inbox\\" + pathn + "\\" + k.getText();
										File fll = new File(myFile);
										try {
											Desktop.getDesktop().open(fll);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});
								attList.getItems().add(k);
							}
						}
					}
				});
				theViewList.getItems().add(k);
			}
			while (count1 < 10) {
				if (count1 == 0) {
					chk1.setVisible(false);
				}
				if (count1 == 1) {
					chk2.setVisible(false);
				}
				if (count1 == 2) {
					chk3.setVisible(false);
				}
				if (count1 == 3) {
					chk4.setVisible(false);
				}
				if (count1 == 4) {
					chk5.setVisible(false);
				}
				if (count1 == 5) {
					chk6.setVisible(false);
				}
				if (count1 == 6) {
					chk7.setVisible(false);
				}
				if (count1 == 7) {
					chk8.setVisible(false);
				}
				if (count1 == 8) {
					chk9.setVisible(false);
				}
				if (count1 == 9) {
					chk10.setVisible(false);
				}
				count1++;
			}
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			combo5.setPromptText("Other Folders");
			search.setPromptText("Search");
		}
	}

	@FXML
	public void deleteOther(ActionEvent event) throws IOException {
		String j = comboDeleteFolder.getValue();
		File op = new File(yy + "\\Others");
		try {
			x.deleteFolder(op, j);
			/*combo4.getItems().clear();
			combo5.getItems().clear();*/
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goRenam(ActionEvent event) throws IOException {
		sM = sMain;
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/RenameF.fxml"));
		Scene scene = new Scene(root, 329, 326);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		renameB.setVisible(false);

	}

	@FXML
	public void openOtherFolder(ActionEvent event) {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		filterList.clear();
		File fi = new File(yy + "\\Filter\\index.html");
		LinkedList lx = x.indexFilterToLinkedList(fi);
		if (lx.size() != 0) {
			filterList.clear();
			for (int i = 0; i < lx.size(); i++) {
				MailNode temp = new MailNode();
				temp = (MailNode) lx.get(i);
				filterList.add(temp.getFolderName());
			}

		}
		refresh2 = "Others";
		viewList.clear();
		viewList.add("Subject");
		viewList.add("Default");
		viewList.add("Sender's Name");
		viewList.add("Receiver's Name");
		viewList.add("Priority");
		searchList.clear();
		attList.getItems().clear();
		multiList.clear();
		multiList.add("Delete");
		multiList.add("Move");
		searchList.add("Subject");
		searchList.add("Sender's Name");
		searchList.add("Receiver's Name");
		searchList.add("---");
		theViewList.getItems().clear();
		renameB.setVisible(true);
		LinkedList i = new LinkedList();
		String temp = new String();
		sMain = yy + "\\Others\\" + combo5.getValue();
		others = combo5.getValue();
		String smain = sMain + "\\index.html";
		if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount5 == 0
				&& pageCount2 == 0 && pageCount7 == 0) {
			File ff = new File(s);
			i = x.convertToLinkedList(ff);
		} else {
			s = sMain + "\\index.html";
			File ff = new File(smain);
			i = x.convertToLinkedList(ff);
			System.out.println(ff.getAbsolutePath() + "file in otherssss222");
			if (sSearch != null) {
				deleteFile(sSearch);
			}
		}
		int count1 = 0;
		for (int j = 0; j < 10 && j < i.size(); j++) {

			count1++;
			if (j == 0) {
				chk1.setVisible(true);
			}
			if (j == 1) {
				chk2.setVisible(true);
			}
			if (j == 2) {
				chk3.setVisible(true);
			}
			if (j == 3) {
				chk4.setVisible(true);
			}
			if (j == 4) {
				chk5.setVisible(true);
			}
			if (j == 5) {
				chk6.setVisible(true);
			}
			if (j == 6) {
				chk7.setVisible(true);
			}
			if (j == 7) {
				chk8.setVisible(true);
			}
			if (j == 8) {
				chk9.setVisible(true);
			}
			if (j == 9) {
				chk10.setVisible(true);
			}
			MailNode m = new MailNode();
			m = (MailNode) i.get(j);
			String s1 = m.getFrom();
			String s4 = m.getTo();
			String s2 = m.getSubject();
			while (s1.length() != 20) {
				s1 = s1 + " ";
			}
			while (s4.length() != 20) {
				s4 = s4 + " ";
			}
			while (s2.length() != 30) {
				s2 = s2 + " ";
			}
			String s3 = m.getIndex();
			String s = s3 + " " + s1 + s4 + s2 + m.getDate();
			Button k = new Button();
			k.setText(s);
			k.setPrefHeight(40);
			k.setPrefWidth(606);
			k.setFont(new Font("Courier New", 13));
			k.setOnAction(new EventHandler() {
				@Override
				public void handle(Event event) {
					attList.getItems().clear();
					String tempp = new String();
					tempp = k.getText();
					String[] p = tempp.split(" ");
					String toAttach = new String();
					toAttach = p[0];
					int aTT = Integer.parseInt(toAttach);
					LinkedList t11 = x.convertToLinkedList(new File(smain));
					MailNode myNode = new MailNode();
					for (int k2 = 0; k2 < t11.size(); k2++) {
						MailNode d = new MailNode();
						d = (MailNode) t11.get(k2);
						if (aTT == Integer.parseInt(d.getIndex())) {
							myNode = d;
							mNode = d;

						}
					}
					String s3 = new String();
					// Sent 3'alat huh
					s3 = x.getBody(new File(yy + "\\Others\\" + combo5.getValue()), myNode.getIndex());
					System.out.println("<<<<<" + s3);
					emailBody.setText(s3);
					bodylabel.setVisible(true);
					attlabel.setVisible(true);
					emailBody.setVisible(true);
					attList.setVisible(true);
					fromLabel.setVisible(true);
					subjectLabel.setVisible(true);
					dateLabel.setVisible(true);
					t1.setVisible(true);
					t2.setVisible(true);
					t3.setVisible(true);
					t4.setVisible(true);
					t1.setText(myNode.getFrom());
					t2.setText(myNode.getSubject());
					t3.setText(myNode.getDate());
					t4.setText(myNode.getTo());
					prio1.setPromptText("Priority");
					prio1.setVisible(true);
					close.setVisible(true);
					fav.setVisible(true);
					pane.setVisible(true);
					if (!(myNode.getAttachment()).equals("null")) {
						System.out.println("------------------");
						String[] att1 = (myNode.getAttachment()).split(";");
						for (int i = 0; i < att1.length; i++) {
							Button k = new Button();
							System.out.println(att1[i]);
							String temp1 = att1[i];
							k.setText(temp1);
							k.setOnAction(new EventHandler() {
								@Override
								public void handle(Event event) {
									String ss = mNode.getDate();
									String[] sss = ss.split(" ");
									String pathn = new String();
									pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
									// hena lazm n7dd el folder elly hwa feh
									String myFile = yy + "\\Others\\" + combo5.getValue() + "\\" + pathn + "\\"
											+ k.getText();
									File fll = new File(myFile);
									try {
										Desktop.getDesktop().open(fll);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							});
							attList.getItems().add(k);
						}
					}
				}
			});
			theViewList.getItems().add(k);
		}
		while (count1 < 10) {
			if (count1 == 0) {
				chk1.setVisible(false);
			}
			if (count1 == 1) {
				chk2.setVisible(false);
			}
			if (count1 == 2) {
				chk3.setVisible(false);
			}
			if (count1 == 3) {
				chk4.setVisible(false);
			}
			if (count1 == 4) {
				chk5.setVisible(false);
			}
			if (count1 == 5) {
				chk6.setVisible(false);
			}
			if (count1 == 6) {
				chk7.setVisible(false);
			}
			if (count1 == 7) {
				chk8.setVisible(false);
			}
			if (count1 == 8) {
				chk9.setVisible(false);
			}
			if (count1 == 9) {
				chk10.setVisible(false);
			}
			count1++;
		}
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount2 = 0;
		pageCount7 = 0;
		pageCount6 = 1;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		combo1.setPromptText("Search by:");
		search.setPromptText("Search");
	}

	@FXML
	public void theSort(ActionEvent event) throws IOException {
		File ff = new File(s);
		String h = new String();
		h = combo.getValue();
		Sort y = new Sort();
		if (h.equals("First Name") || h.equals("Last Name")) {
			SortContacts z = new SortContacts();
			z.setViewingOptionsContacts(y, ff, h);
		} else {
			x.setViewingOptions(y, ff, h);
		}
		if (pageCount2 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			viewEmailsInbox(event);
		} else if (pageCount3 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount1 = 1;
			pageCount9 = 0;
			viewEmailsSent(event);
		} else if (pageCount4 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			viewEmailsDraft(event);
		} else if (pageCount5 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			viewEmailsTrash(event);
		} else if (pageCount6 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			openOtherFolder(event);
		} else if (pageCount7 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			contacts(event);
		} else if (pageCount8 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			filteredFolders(event);
		} else if (pageCount9 != 0) {
			pageCount2 = 0;
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			viewFavourites(event);
		}
	}

	@FXML
	public void newFolderAction(ActionEvent event) throws IOException {
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/NewFolderScreen.fxml"));
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void goEmail(ActionEvent event) throws IOException {
		AnchorPane nextRoot = FXMLLoader.load(getClass().getResource("/application/emailDetails.fxml"));
		root1.getChildren().setAll(nextRoot);
	}

	@FXML
	public void viewEmailsSent(ActionEvent event) throws IOException {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo4.setVisible(false);
		pageCount3++;
		if (pageCount3 == 1) {
			refresh2 = "Sent";
			combo3.setVisible(false);
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			viewList.clear();
			viewList.add("Subject");
			viewList.add("Default");
			viewList.add("Receiver's Name");
			viewList.add("Priority");
			multiList.clear();
			attList.getItems().clear();
			multiList.add("Delete");
			multiList.add("Move");
			searchList.clear();
			searchList.add("Subject");
			searchList.add("Receiver's Name");
			searchList.add("---");
			theViewList.getItems().clear();

			LinkedList i = new LinkedList();
			sMain = yy + "\\Sent";
			String smain = sMain + "\\index.html";
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount2 == 0 && pageCount4 == 0 && pageCount5 == 0
					&& pageCount6 == 0 && pageCount7 == 0) {
				File ff = new File(s);
				i = x.convertToLinkedList(ff);
			} else {
				s = sMain + "\\index.html";
				File ff = new File(smain);
				i = x.convertToLinkedList(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			int count1 = 0;
			for (int j = 0; j < 10 && j < i.size(); j++) {
				// combo3.setVisible(false);
				count1++;
				if (j == 0) {
					chk1.setVisible(true);
				}
				if (j == 1) {
					chk2.setVisible(true);
				}
				if (j == 2) {
					chk3.setVisible(true);
				}
				if (j == 3) {
					chk4.setVisible(true);
				}
				if (j == 4) {
					chk5.setVisible(true);
				}
				if (j == 5) {
					chk6.setVisible(true);
				}
				if (j == 6) {
					chk7.setVisible(true);
				}
				if (j == 7) {
					chk8.setVisible(true);
				}
				if (j == 8) {
					chk9.setVisible(true);
				}
				if (j == 9) {
					chk10.setVisible(true);
				}
				MailNode m = new MailNode();
				m = (MailNode) i.get(j);
				String s1 = m.getTo();
				String s2 = m.getSubject();
				while (s1.length() != 20) {
					s1 = s1 + " ";
				}
				while (s2.length() != 30) {
					s2 = s2 + " ";
				}
				String s3 = m.getIndex();
				String s = s3 + "  " + s1 + s2 + m.getDate();
				Button k = new Button();
				k.setText(s);
				k.setPrefHeight(40);
				k.setPrefWidth(606);
				k.setFont(new Font("Courier New", 13));
				k.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						attList.getItems().clear();
						String tempp = new String();
						tempp = k.getText();
						String[] p = tempp.split(" ");
						String toAttach = new String();
						toAttach = p[0];
						int aTT = (Integer.parseInt(toAttach));
						LinkedList t11 = x.convertToLinkedList(new File(smain));
						MailNode myNode = new MailNode();
						for (int k2 = 0; k2 < t11.size(); k2++) {
							MailNode d = new MailNode();
							d = (MailNode) t11.get(k2);
							if (aTT == Integer.parseInt(d.getIndex())) {
								myNode = d;
								mNode = d;
							}
						}
						String s3 = new String();
						s3 = x.getBody(new File(yy + "\\Sent"), myNode.getIndex());
						// Attach path
						emailBody.setText(s3);
						bodylabel.setVisible(true);
						attlabel.setVisible(true);
						emailBody.setVisible(true);
						attList.setVisible(true);
						fromLabel.setVisible(true);
						subjectLabel.setVisible(true);
						dateLabel.setVisible(true);
						t1.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						h500.setVisible(true);
						t4.setVisible(true);
						t1.setText(myNode.getFrom());
						t2.setText(myNode.getSubject());
						t3.setText(myNode.getDate());
						t4.setText(myNode.getTo());
						prio1.setPromptText("Priority");
						prio1.setVisible(true);
						fav.setVisible(true);
						close.setVisible(true);
						pane.setVisible(true);
						System.out.println("____________" + myNode.getAttachment());
						if (!(myNode.getAttachment()).equals("null")) {
							System.out.println("------------------");
							String[] att1 = (myNode.getAttachment()).split(";");
							for (int i = 0; i < att1.length; i++) {
								Button k = new Button();
								System.out.println(att1[i]);
								String temp1 = att1[i];
								k.setText(temp1);
								k.setOnAction(new EventHandler() {
									@Override
									public void handle(Event event) {
										String ss = mNode.getDate();
										String[] sss = ss.split(" ");
										String pathn = new String();
										pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
										String myFile = yy + "\\Sent\\" + pathn + "\\" + k.getText();
										File fll = new File(myFile);
										try {
											Desktop.getDesktop().open(fll);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});
								attList.getItems().add(k);
							}
						}
					}
				});
				theViewList.getItems().add(k);
			}
			while (count1 < 10) {
				if (count1 == 0) {
					chk1.setVisible(false);
				}
				if (count1 == 1) {
					chk2.setVisible(false);
				}
				if (count1 == 2) {
					chk3.setVisible(false);
				}
				if (count1 == 3) {
					chk4.setVisible(false);
				}
				if (count1 == 4) {
					chk5.setVisible(false);
				}
				if (count1 == 5) {
					chk6.setVisible(false);
				}
				if (count1 == 6) {
					chk7.setVisible(false);
				}
				if (count1 == 7) {
					chk8.setVisible(false);
				}
				if (count1 == 8) {
					chk9.setVisible(false);
				}
				if (count1 == 9) {
					chk10.setVisible(false);
				}
				count1++;
			}
			pageCount2 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			search.setPromptText("Search");
		}
	}

	@FXML
	public void theCheck(ActionEvent event) {
		String s = "";
		String[] theInf = s.split(" ");
		MailNode current = null;
		current.setFrom(theInf[0]);
		current.setDate(theInf[2]);
		multi.add(current);
	}

	/*public void attach(String s) throws IOException {
		String myFile = "C:\\Server\\nadarashad\\Inbox\\fileee\\" + s;
		Desktop.getDesktop().open(f);
	}*/

	@FXML
	public void viewAdd(ActionEvent event) throws IOException {
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Folder.fxml"));
		Scene scene = new Scene(root, 351, 315);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void viewEmailsTrash(ActionEvent event) throws IOException {

		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		pageCount5++;
		if (pageCount5 == 1) {
			refresh2 = "Trash";
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			viewList.clear();
			viewList.add("Subject");
			viewList.add("Default");
			viewList.add("Receiver's Name");
			viewList.add("Sender's Name");
			viewList.add("Priority");
			searchList.clear();
			multiList.clear();
			multiList.add("Move");
			searchList.add("Subject");
			searchList.add("Sender's Name");
			searchList.add("Receiver's Name");
			searchList.add("---");
			theViewList.getItems().clear();
			attList.getItems().clear();
			LinkedList i = new LinkedList();
			sMain = yy + "\\Trash";
			String smain = sMain + "\\index.html";
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount2 == 0
					&& pageCount6 == 0 && pageCount7 == 0) {
				File ff = new File(s);
				i = x.convertToLinkedList(ff);
			} else {
				s = sMain + "\\index.html";
				File ff = new File(smain);
				i = x.convertToLinkedList(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			int count1 = 0;
			for (int j = 0; j < 10 && j < i.size(); j++) {
				//// combo3.setVisible(false);
				count1++;
				if (j == 0) {
					chk1.setVisible(true);
				}
				if (j == 1) {
					chk2.setVisible(true);
				}
				if (j == 2) {
					chk3.setVisible(true);
				}
				if (j == 3) {
					chk4.setVisible(true);
				}
				if (j == 4) {
					chk5.setVisible(true);
				}
				if (j == 5) {
					chk6.setVisible(true);
				}
				if (j == 6) {
					chk7.setVisible(true);
				}
				if (j == 7) {
					chk8.setVisible(true);
				}
				if (j == 8) {
					chk9.setVisible(true);
				}
				if (j == 9) {
					chk10.setVisible(true);
				}
				MailNode m = new MailNode();
				m = (MailNode) i.get(j);
				String s1 = m.getFrom();
				String s2 = m.getSubject();
				String s4 = m.getTo();
				while (s1.length() != 20) {
					s1 = s1 + " ";
				}
				while (s4.length() != 20) {
					s4 = s4 + " ";
				}
				while (s2.length() != 30) {
					s2 = s2 + " ";
				}
				String s3 = m.getIndex();
				String s = s3 + " " + s1 + s4 + s2 + m.getDate();
				Button k = new Button();
				k.setText(s);
				k.setPrefHeight(40);
				k.setPrefWidth(606);
				k.setFont(new Font("Courier New", 13));
				k.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						attList.getItems().clear();
						String tempp = new String();
						tempp = k.getText();
						String[] p = tempp.split(" ");
						String toAttach = new String();
						toAttach = p[0];
						int aTT = Integer.parseInt(toAttach);
						LinkedList t11 = x.convertToLinkedList(new File(smain));
						MailNode myNode = new MailNode();
						for (int k2 = 0; k2 < t11.size(); k2++) {
							MailNode d = new MailNode();
							d = (MailNode) t11.get(k2);
							if (aTT == Integer.parseInt(d.getIndex())) {
								myNode = d;
								mNode = d;
							}
						}
						String s3 = new String();
						s3 = x.getBody(new File(yy + "\\Trash"), myNode.getIndex());
						System.out.println("<<<<<" + s3);
						emailBody.setText(s3);
						bodylabel.setVisible(true);
						attlabel.setVisible(true);
						emailBody.setVisible(true);
						attList.setVisible(true);
						fromLabel.setVisible(true);
						subjectLabel.setVisible(true);
						dateLabel.setVisible(true);
						t1.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						t4.setVisible(true);
						t1.setText(myNode.getFrom());
						t2.setText(myNode.getSubject());
						t3.setText(myNode.getDate());
						t4.setText(myNode.getTo());
						prio1.setPromptText("Priority");
						prio1.setVisible(true);
						close.setVisible(true);
						fav.setVisible(true);
						pane.setVisible(true);
						if (!(myNode.getAttachment()).equals("null")) {
							System.out.println("------------------");
							String[] att1 = (myNode.getAttachment()).split(";");
							for (int i = 0; i < att1.length; i++) {
								Button k = new Button();
								System.out.println(att1[i]);
								String temp1 = att1[i];
								k.setText(temp1);
								k.setOnAction(new EventHandler() {
									@Override
									public void handle(Event event) {
										String ss = mNode.getDate();
										String[] sss = ss.split(" ");
										String pathn = new String();
										pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
										String myFile = yy + "\\Trash\\" + pathn + "\\" + k.getText();
										File fll = new File(myFile);
										try {
											Desktop.getDesktop().open(fll);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});
								attList.getItems().add(k);
							}
						}
					}
				});
				theViewList.getItems().add(k);
			}
			while (count1 < 10) {
				if (count1 == 0) {
					chk1.setVisible(false);
				}
				if (count1 == 1) {
					chk2.setVisible(false);
				}
				if (count1 == 2) {
					chk3.setVisible(false);
				}
				if (count1 == 3) {
					chk4.setVisible(false);
				}
				if (count1 == 4) {
					chk5.setVisible(false);
				}
				if (count1 == 5) {
					chk6.setVisible(false);
				}
				if (count1 == 6) {
					chk7.setVisible(false);
				}
				if (count1 == 7) {
					chk8.setVisible(false);
				}
				if (count1 == 8) {
					chk9.setVisible(false);
				}
				if (count1 == 9) {
					chk10.setVisible(false);
				}
				count1++;
			}
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount2 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			search.setPromptText("Search");
		}
	}

	@FXML
	public void viewEmailsDraft(ActionEvent event) throws IOException {

		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		pageCount4++;
		if (pageCount4 == 1) {
			refresh2 = "Draft";
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			viewList.clear();
			viewList.add("Subject");
			viewList.add("Default");
			viewList.add("Receiver's Name");
			viewList.add("Priority");
			searchList.clear();
			multiList.clear();
			multiList.add("Delete");
			multiList.add("Move");
			searchList.add("Subject");
			searchList.add("Receiver's Name");
			searchList.add("---");
			theViewList.getItems().clear();
			attList.getItems().clear();
			LinkedList i = new LinkedList();
			sMain = yy + "\\Draft";
			String smain = sMain + "\\index.html";
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount2 == 0 && pageCount5 == 0
					&& pageCount6 == 0 && pageCount7 == 0) {
				File ff = new File(s);
				i = x.convertToLinkedList(ff);
			} else {
				s = sMain + "\\index.html";
				File ff = new File(smain);
				i = x.convertToLinkedList(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			int count1 = 0;
			for (int j = 0; j < 10 && j < i.size(); j++) {
				count1++;
				//// combo3.setVisible(false);
				if (j == 0) {
					chk1.setVisible(true);
				}
				if (j == 1) {
					chk2.setVisible(true);
				}
				if (j == 2) {
					chk3.setVisible(true);
				}
				if (j == 3) {
					chk4.setVisible(true);
				}
				if (j == 4) {
					chk5.setVisible(true);
				}
				if (j == 5) {
					chk6.setVisible(true);
				}
				if (j == 6) {
					chk7.setVisible(true);
				}
				if (j == 7) {
					chk8.setVisible(true);
				}
				if (j == 8) {
					chk9.setVisible(true);
				}
				if (j == 9) {
					chk10.setVisible(true);
				}
				MailNode m = new MailNode();
				m = (MailNode) i.get(j);
				String s1 = m.getTo();
				String s2 = m.getSubject();
				while (s1.length() != 20) {
					s1 = s1 + " ";
				}
				while (s2.length() != 30) {
					s2 = s2 + " ";
				}
				String s3 = m.getIndex();
				String s = s3 + "  " + s1 + s2 + m.getDate();
				Button k = new Button();
				k.setText(s);
				k.setPrefHeight(40);
				k.setPrefWidth(606);
				k.setFont(new Font("Courier New", 13));
				k.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						attList.getItems().clear();
						String tempp = new String();
						tempp = k.getText();
						String[] p = tempp.split(" ");
						String toAttach = new String();
						toAttach = p[0];
						int aTT = Integer.parseInt(toAttach);
						LinkedList t11 = x.convertToLinkedList(new File(smain));
						MailNode myNode = new MailNode();
						for (int k2 = 0; k2 < t11.size(); k2++) {
							MailNode d = new MailNode();
							d = (MailNode) t11.get(k2);
							if (aTT == Integer.parseInt(d.getIndex())) {
								myNode = d;
								mNode = d;
							}
						}
						String s3 = new String();
						s3 = x.getBody(new File(yy + "\\Draft"), myNode.getIndex());
						emailBody.setText(s3);
						bodylabel.setVisible(true);
						attlabel.setVisible(true);
						emailBody.setVisible(true);
						attList.setVisible(true);
						fromLabel.setVisible(true);
						subjectLabel.setVisible(true);
						dateLabel.setVisible(true);
						t1.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						t4.setVisible(true);
						t1.setText(myNode.getFrom());
						t2.setText(myNode.getSubject());
						t3.setText(myNode.getDate());
						t4.setText(myNode.getTo());
						prio1.setPromptText("Priority");
						prio1.setVisible(true);
						close.setVisible(true);
						SendDraft.setVisible(true);
						fav.setVisible(true);
						pane.setVisible(true);
						if (!(myNode.getAttachment()).equals("null")) {
							System.out.println("------------------");
							String[] att1 = (myNode.getAttachment()).split(";");
							for (int i = 0; i < att1.length; i++) {
								Button k = new Button();
								System.out.println(att1[i]);
								String temp1 = att1[i];
								k.setText(temp1);
								k.setOnAction(new EventHandler() {
									@Override
									public void handle(Event event) {
										String ss = mNode.getDate();
										String[] sss = ss.split(" ");
										String pathn = new String();
										pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
										String myFile = yy + "\\Draft\\" + pathn + "\\" + k.getText();
										File fll = new File(myFile);
										try {
											Desktop.getDesktop().open(fll);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});
								attList.getItems().add(k);
							}
						}
					}
				});
				theViewList.getItems().add(k);
			}
			while (count1 < 10) {
				if (count1 == 0) {
					chk1.setVisible(false);
				}
				if (count1 == 1) {
					chk2.setVisible(false);
				}
				if (count1 == 2) {
					chk3.setVisible(false);
				}
				if (count1 == 3) {
					chk4.setVisible(false);
				}
				if (count1 == 4) {
					chk5.setVisible(false);
				}
				if (count1 == 5) {
					chk6.setVisible(false);
				}
				if (count1 == 6) {
					chk7.setVisible(false);
				}
				if (count1 == 7) {
					chk8.setVisible(false);
				}
				if (count1 == 8) {
					chk9.setVisible(false);
				}
				if (count1 == 9) {
					chk10.setVisible(false);
				}
				count1++;
			}
			pageCount3 = 0;
			pageCount2 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			search.setPromptText("Search");
		}

	}

	@FXML
	public void seeMore(ActionEvent event) {
		String smain = sMain + "\\index.html";
		LinkedList i = new LinkedList();
		if (s.equals(sSearch)) {
			File ff = new File(s);
			i = x.convertToLinkedList(ff);
		} else {
			s = sMain + "\\index.html";
			File ff = new File(smain);
			i = x.convertToLinkedList(ff);
			if (sSearch != null) {
				deleteFile(sSearch);
			}
		}
		if (pageCount1 >= 1 && (pageCount1 * 10) < i.size()) {
			theViewList.getItems().clear();
			bodylabel.setVisible(false);
			attlabel.setVisible(false);
			emailBody.setVisible(false);
			attList.setVisible(false);
			fromLabel.setVisible(false);
			subjectLabel.setVisible(false);
			dateLabel.setVisible(false);
			t1.setVisible(false);
			t2.setVisible(false);
			t3.setVisible(false);
			h500.setVisible(false);
			t4.setVisible(false);
			prio1.setVisible(false);
			close.setVisible(false);
			SendDraft.setVisible(false);
			fav.setVisible(false);
			pane.setVisible(false);
			combo3.setVisible(false);
			combo4.setVisible(false);
			if (pageCount2 != 0 || pageCount8 != 0) {
				int count1 = 0;
				for (int j = (pageCount1 * 10); j < ((pageCount1 * 10) + 10) && j < i.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getFrom();
					String s2 = m.getSubject();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							fav.setVisible(true);
							pane.setVisible(true);
							System.out.println("Ataaaaaaa>>" + myNode.getAttachment());
							if (!(myNode.getAttachment()).equals("null")) {
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount3 != 0 || pageCount4 != 0) {
				int count1 = 0;
				for (int j = (pageCount1 * 10); j < ((pageCount1 * 10) + 10) && j < i.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getTo();
					String s2 = m.getSubject();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {

						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							pane.setVisible(true);
							if (pageCount4 != 0) {
								SendDraft.setVisible(true);
							}
							fav.setVisible(true);
							System.out.println(myNode.getFrom());
							System.out.println(myNode.getTo());
							System.out.println(myNode.getDate());
							System.out.println(myNode.getSubject());

							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									System.out.println("k.get>>>>>>>>>>>>" + k.getText());
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount5 != 0 || pageCount6 != 0 || pageCount9 != 0) {

				int count1 = 0;
				for (int j = (pageCount1 * 10); j < ((pageCount1 * 10) + 10) && j < i.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getFrom();
					String s2 = m.getSubject();
					String s4 = m.getTo();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					while (s4.length() != 20) {
						s4 = s4 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s4 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			pageCount1++;

		}
	}

	@FXML
	public void back(ActionEvent event) {
		String smain = sMain + "\\index.html";
		LinkedList i = new LinkedList();
		if (s.equals(sSearch)) {
			File ff = new File(s);
			i = x.convertToLinkedList(ff);
		} else {
			s = sMain + "\\index.html";
			File ff = new File(smain);
			i = x.convertToLinkedList(ff);
			if (sSearch != null) {
				deleteFile(sSearch);
			}
		}
		if (pageCount1 >= 2 && (pageCount1 * 10) - 20 >= 0) {
			bodylabel.setVisible(false);
			attlabel.setVisible(false);
			emailBody.setVisible(false);
			attList.setVisible(false);
			fromLabel.setVisible(false);
			subjectLabel.setVisible(false);
			dateLabel.setVisible(false);
			t1.setVisible(false);
			t2.setVisible(false);
			t3.setVisible(false);
			h500.setVisible(false);
			t4.setVisible(false);
			prio1.setVisible(false);
			close.setVisible(false);
			SendDraft.setVisible(false);
			fav.setVisible(false);
			pane.setVisible(false);
			combo3.setVisible(false);
			combo4.setVisible(false);
			theViewList.getItems().clear();
			if (pageCount2 != 0 || pageCount8 != 0) {
				int count1 = 0;
				for (int j = (pageCount1 * 10) - 20; j < ((pageCount1 - 1) * 10) && j < i.size(); j++) {
					count1++;
					if (j == (pageCount1 * 10) - 20 + 0) {
						chk1.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 1) {
						chk2.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 2) {
						chk3.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 3) {
						chk4.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 4) {
						chk5.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 5) {
						chk6.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 6) {
						chk7.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 7) {
						chk8.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 8) {
						chk9.setVisible(true);
					}
					if (j == (pageCount1 * 10) - 20 + 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getFrom();
					String s2 = m.getSubject();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount3 != 0 || pageCount4 != 0) {
				int count1 = 0;
				for (int j = (pageCount1 * 10) - 20; j < ((pageCount1 - 1) * 10) && j < i.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getTo();
					String s2 = m.getSubject();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {

						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							if (pageCount4 != 0) {
								SendDraft.setVisible(true);
							}
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount5 != 0 || pageCount6 != 0 || pageCount9 != 0) {
				int count1 = 0;
				for (int j = (pageCount1 * 10) - 20; j < ((pageCount1 - 1) * 10) && j < i.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) i.get(j);
					String s1 = m.getFrom();
					String s2 = m.getSubject();
					String s4 = m.getTo();
					while (s1.length() != 20) {
						s1 = s1 + " ";
					}
					while (s2.length() != 30) {
						s2 = s2 + " ";
					}
					while (s4.length() != 20) {
						s4 = s4 + " ";
					}
					String s3 = m.getIndex();
					String s = s3 + " " + s1 + s4 + s2 + m.getDate();
					Button k = new Button();
					k.setText(s);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {

						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(smain));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(sMain), myNode.getIndex());
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = sMain + "\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}

					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			pageCount1--;

		}
	}

	@FXML

	public void search(ActionEvent event) throws IOException {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		String s2 = combo1.getValue();
		String smain = new String();
		String sb = search.getText();
		Sort p = new Sort();
		Search binary = new Search();
		LinkedList ll = new LinkedList();
		if (s2.equals("First Name") || s2.equals("Last Name") || (s2.equals("---") && pageCount7 != 0)) {
			smain = sMain;
			File ff = new File(smain);
			File fff = new File(yy + File.separator + "temp.html");
			fff.createNewFile();
			if (s2.equals("---")) {
				ll = a.convertToLinkedListContact(ff);
				s = sMain;
				search.setText("Search");
			} else {
				sSearch = fff.getAbsolutePath();
				ll = a.searchContacts(p, ff, s2, binary, sb);
				a.fromLinkedToIndexContact(ll, fff);
				s = sSearch;
			}
			theViewList.getItems().clear();
			for (int j = 0; j < 10 && j < ll.size(); j++) {
				MailNode c = new MailNode();
				c = (MailNode) ll.get(j);
				String s = new String();
				String s22 = new String();
				LinkedList link = new LinkedList();
				link = c.getEmails();
				for (int i = 0; i < link.size(); i++) {
					if (i == link.size() - 1) {
						s22 = s22 + c.getEmails().get(i);
					} else {
						s22 = s22 + c.getEmails().get(i) + "/";
					}
				}
				TextArea t = new TextArea();
				t.setFont(new Font("Courier New", 13));
				t.setPrefSize(30, 100);
				t.setStyle("-fx-font-alignment: center");
				String s6 = c.getRelation();
				if (s6.length() == 0) {
					s = "Contact :" + c.getIndex() + "\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name :"
							+ c.getLastName() + " \n" + "Emails: " + s22;
				} else {
					s = "Contact :" + c.getIndex() + "\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name :"
							+ c.getLastName() + "\n" + "Relation: " + c.getRelation() + " \n" + "Emails: " + s22;

				}
				t.setText(s);
				theViewList.getItems().add(t);
			}
			Button addContact = new Button();
			addContact.setPrefSize(640, 31);
			addContact.setAlignment(Pos.TOP_CENTER);
			addContact.setText("Add New Contact");
			theViewList.getItems().add(addContact);
			addContact.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					Stage primaryStage = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("/application/NewCont.fxml"));
						Scene scene1 = new Scene(root, 454, 413);
						scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene1);
						primaryStage.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			Button editContact = new Button();
			editContact.setPrefSize(640, 31);
			editContact.setAlignment(Pos.TOP_CENTER);
			editContact.setText("Edit Contact");
			theViewList.getItems().add(editContact);
			editContact.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					Stage primaryStage = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("/application/EditContact.fxml"));
						Scene scene1 = new Scene(root, 454, 413);
						scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene1);
						primaryStage.show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});
			Button deleteContact = new Button();
			deleteContact.setPrefSize(640, 31);
			deleteContact.setAlignment(Pos.TOP_CENTER);
			deleteContact.setText("Remove Contact");
			theViewList.getItems().add(deleteContact);
			deleteContact.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					Stage primaryStage = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("/application/DeleteContact.fxml"));
						Scene scene1 = new Scene(root, 276, 289);
						scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene1);
						primaryStage.show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});
		} else {
			smain = sMain + "\\index.html";
			File ff = new File(smain);
			if (s2.equals("---")) {
				File fff = new File(sMain + File.separator + "temp.html");
				fff.createNewFile();
				sSearch = fff.getAbsolutePath();
				ll = x.convertToLinkedList(ff);
				s = sMain;
				search.setPromptText("Search");
			} else {
				File fff = new File(sMain + File.separator + "temp.html");
				System.out.println(fff.getAbsolutePath() + "++++++++++++");
				fff.createNewFile();
				sSearch = fff.getAbsolutePath();
				s = sSearch;
				ll = x.search(p, ff, s2, binary, sb);
				x.fromLinkedToIndex(ll, fff);
			}
			if (pageCount2 != 0 || pageCount8 != 0) {
				theViewList.getItems().clear();
				int count1 = 0;
				for (int j = 0; j < 10 && j < ll.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) ll.get(j);
					String l1 = m.getFrom();
					String l2 = m.getSubject();
					String l3 = m.getIndex();
					while (l1.length() != 20) {
						l1 = l1 + " ";
					}
					while (l2.length() != 30) {
						l2 = l2 + " ";
					}
					String l = l3 + " " + l1 + l2 + m.getDate();
					Button k = new Button();
					k.setText(l);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = (Integer.parseInt(toAttach));
							LinkedList t11 = x.convertToLinkedList(new File(sMain + "\\index.html"));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(yy + "\\Inbox"), myNode.getIndex());
							System.out.println("<<<<<" + s3);
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							;
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = yy + "\\Inbox\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount3 != 0 || pageCount4 != 0) {
				theViewList.getItems().clear();
				int count1 = 0;
				for (int j = 0; j < 10 && j < ll.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) ll.get(j);
					String l1 = m.getTo();
					String l2 = m.getSubject();
					while (l1.length() != 20) {
						l1 = l1 + " ";
					}
					while (l2.length() != 30) {
						l2 = l2 + " ";
					}
					String l3 = m.getIndex();
					String l = l3 + " " + l1 + l2 + m.getDate();
					Button k = new Button();
					k.setText(l);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = (Integer.parseInt(toAttach));
							LinkedList t11 = x.convertToLinkedList(new File(sMain + "\\index.html"));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(yy + "\\Sent"), myNode.getIndex());
							// Attach path
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							h500.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							fav.setVisible(true);
							close.setVisible(true);
							pane.setVisible(true);
							System.out.println("____________" + myNode.getAttachment());
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = yy + "\\Sent\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
			if (pageCount5 != 0 || pageCount6 != 0 || pageCount9 != 0) {
				theViewList.getItems().clear();
				int count1 = 0;
				for (int j = 0; j < 10 && j < ll.size(); j++) {
					count1++;
					if (j == 0) {
						chk1.setVisible(true);
					}
					if (j == 1) {
						chk2.setVisible(true);
					}
					if (j == 2) {
						chk3.setVisible(true);
					}
					if (j == 3) {
						chk4.setVisible(true);
					}
					if (j == 4) {
						chk5.setVisible(true);
					}
					if (j == 5) {
						chk6.setVisible(true);
					}
					if (j == 6) {
						chk7.setVisible(true);
					}
					if (j == 7) {
						chk8.setVisible(true);
					}
					if (j == 8) {
						chk9.setVisible(true);
					}
					if (j == 9) {
						chk10.setVisible(true);
					}
					MailNode m = new MailNode();
					m = (MailNode) ll.get(j);
					String l1 = m.getFrom();
					String l2 = m.getSubject();
					String l4 = m.getTo();
					while (l1.length() != 20) {
						l1 = l1 + " ";
					}
					while (l4.length() != 20) {
						l4 = l4 + " ";
					}
					while (l2.length() != 30) {
						l2 = l2 + " ";
					}
					String l3 = m.getIndex();
					String l = l3 + " " + l1 + l4 + l2 + m.getDate();
					Button k = new Button();
					k.setText(l);
					k.setPrefHeight(40);
					k.setPrefWidth(606);
					k.setFont(new Font("Courier New", 13));
					k.setOnAction(new EventHandler() {
						@Override
						public void handle(Event event) {
							attList.getItems().clear();
							String tempp = new String();
							tempp = k.getText();
							String[] p = tempp.split(" ");
							String toAttach = new String();
							toAttach = p[0];
							int aTT = Integer.parseInt(toAttach);
							LinkedList t11 = x.convertToLinkedList(new File(sMain + "\\index.html"));
							MailNode myNode = new MailNode();
							for (int k2 = 0; k2 < t11.size(); k2++) {
								MailNode d = new MailNode();
								d = (MailNode) t11.get(k2);
								if (aTT == Integer.parseInt(d.getIndex())) {
									myNode = d;
									mNode = d;
								}
							}
							String s3 = new String();
							s3 = x.getBody(new File(yy + "\\Trash"), myNode.getIndex());
							System.out.println("<<<<<" + s3);
							emailBody.setText(s3);
							bodylabel.setVisible(true);
							attlabel.setVisible(true);
							emailBody.setVisible(true);
							attList.setVisible(true);
							fromLabel.setVisible(true);
							subjectLabel.setVisible(true);
							dateLabel.setVisible(true);
							t1.setVisible(true);
							t2.setVisible(true);
							t3.setVisible(true);
							t4.setVisible(true);
							t1.setText(myNode.getFrom());
							t2.setText(myNode.getSubject());
							t3.setText(myNode.getDate());
							t4.setText(myNode.getTo());
							prio1.setPromptText("Priority");
							prio1.setVisible(true);
							close.setVisible(true);
							fav.setVisible(true);
							pane.setVisible(true);
							if (!(myNode.getAttachment()).equals("null")) {
								System.out.println("------------------");
								String[] att1 = (myNode.getAttachment()).split(";");
								for (int i = 0; i < att1.length; i++) {
									Button k = new Button();
									System.out.println(att1[i]);
									String temp1 = att1[i];
									k.setText(temp1);
									k.setOnAction(new EventHandler() {
										@Override
										public void handle(Event event) {
											String ss = mNode.getDate();
											String[] sss = ss.split(" ");
											String pathn = new String();
											pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
											String myFile = yy + "\\Trash\\" + pathn + "\\" + k.getText();
											File fll = new File(myFile);
											try {
												Desktop.getDesktop().open(fll);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});
									attList.getItems().add(k);
								}
							}
						}
					});
					theViewList.getItems().add(k);
				}
				while (count1 < 10) {
					if (count1 == 0) {
						chk1.setVisible(false);
					}
					if (count1 == 1) {
						chk2.setVisible(false);
					}
					if (count1 == 2) {
						chk3.setVisible(false);
					}
					if (count1 == 3) {
						chk4.setVisible(false);
					}
					if (count1 == 4) {
						chk5.setVisible(false);
					}
					if (count1 == 5) {
						chk6.setVisible(false);
					}
					if (count1 == 6) {
						chk7.setVisible(false);
					}
					if (count1 == 7) {
						chk8.setVisible(false);
					}
					if (count1 == 8) {
						chk9.setVisible(false);
					}
					if (count1 == 9) {
						chk10.setVisible(false);
					}
					count1++;
				}
			}
		}
	}

	SortContacts a = new SortContacts();

	@FXML
	public void contacts(ActionEvent event) throws IOException {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		chk1.setVisible(false);
		chk2.setVisible(false);
		chk3.setVisible(false);
		chk4.setVisible(false);
		chk5.setVisible(false);
		chk6.setVisible(false);
		chk7.setVisible(false);
		chk8.setVisible(false);
		chk9.setVisible(false);
		chk10.setVisible(false);
		renameB.setVisible(false);
		pageCount7++;
		if (pageCount7 == 1) {
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			viewList.clear();
			refresh2 = "Contacts";
			viewList.add("First Name");
			viewList.add("Last Name");
			searchList.clear();
			searchList.add("First Name");
			searchList.add("Last Name");
			searchList.add("---");
			theViewList.getItems().clear();
			sMain = yy + "\\Contacts.html";
			LinkedList l = new LinkedList();
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount5 == 0
					&& pageCount6 == 0 && pageCount2 == 0) {
				File ff = new File(s);
				l = a.convertToLinkedListContact(ff);
			} else {
				s = sMain;
				File ff = new File(sMain);
				l = a.convertToLinkedListContact(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			for (int j = 0; j < 10 && j < l.size(); j++) {
				MailNode c = new MailNode();
				c = (MailNode) l.get(j);
				Button k = new Button();
				String s = new String();
				String s2 = new String();
				LinkedList ll = new LinkedList();
				ll = c.getEmails();
				for (int i = 0; i < ll.size(); i++) {
					if (i == ll.size() - 1) {
						s2 = s2 + c.getEmails().get(i);
					} else {
						s2 = s2 + c.getEmails().get(i) + "/";
					}
				}
				TextArea t = new TextArea();
				t.setFont(new Font("Courier New", 13));
				t.setPrefWidth(606);
				t.setPrefHeight(100);
				// t.setPrefSize(10, 100);
				t.setStyle("-fx-font-alignment: center");
				String s6 = c.getRelation();
				if (s6.length() == 0) {
					s = "Contact :" + c.getIndex() + "\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name :"
							+ c.getLastName() + " \n" + "Emails: " + s2;
				} else {
					s = "Contact :" + c.getIndex() + "\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name :"
							+ c.getLastName() + "\n" + "Relation: " + c.getRelation() + " \n" + "Emails: " + s2;

				}
				t.setText(s);
				t.setEditable(false);
				theViewList.getItems().add(t);
			}
			Button addContact = new Button();
			addContact.setPrefSize(606, 30);
			addContact.setAlignment(Pos.TOP_CENTER);
			addContact.setText("Add New Contact");
			theViewList.getItems().add(addContact);
			addContact.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					Stage primaryStage = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("/application/NewCont.fxml"));
						Scene scene1 = new Scene(root, 454, 413);
						scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene1);
						primaryStage.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			if (l.size() != 0) {
				Button editContact = new Button();
				editContact.setPrefSize(606, 30);
				editContact.setAlignment(Pos.TOP_CENTER);
				editContact.setText("Edit Contact");
				theViewList.getItems().add(editContact);
				editContact.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						Stage primaryStage = new Stage();
						Parent root;
						try {
							root = FXMLLoader.load(getClass().getResource("/application/EditContact.fxml"));
							Scene scene1 = new Scene(root, 454, 413);
							scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene1);
							primaryStage.show();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				});
				Button deleteContact = new Button();
				deleteContact.setPrefSize(606, 30);
				deleteContact.setAlignment(Pos.TOP_CENTER);
				deleteContact.setText("Remove Contact");
				theViewList.getItems().add(deleteContact);
				deleteContact.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						Stage primaryStage = new Stage();
						Parent root;
						try {
							root = FXMLLoader.load(getClass().getResource("/application/DeleteContact.fxml"));
							Scene scene1 = new Scene(root, 276, 289);
							scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene1);
							primaryStage.show();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				});
			}

			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount6 = 0;
			pageCount2 = 0;
			pageCount8 = 0;
			pageCount9 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			search.setPromptText("Search");
		}

	}

	@FXML
	public void setFilter(ActionEvent event) throws IOException {
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/application/SetFilter.fxml"));
			Scene scene1 = new Scene(root, 400, 400);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void compose(ActionEvent event) throws IOException {
		System.out.println(yy+"pathhhhhhhhh");
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/application/Compose.fxml"));
			Scene scene1 = new Scene(root, 547, 679);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void filteredFolders(ActionEvent event) throws IOException {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		// pageCount8++;
		// if (pageCount8 == 1 || !filter.equals(comboFilter.getValue()) ) {
		otherVV.clear();
		File tempFolders = new File(yy + "\\Others\\index.html");
		LinkedList r = x.fromIndexToLinkedOther(tempFolders);
		for (int i = 0; i < r.size(); i++) {
			MailNode temp = (MailNode) r.get(i);
			String folders = temp.getnewFolder();
			// String[] folder = folders.split("</br>");
			otherVV.add(folders);
		}
		viewList.clear();
		viewList.add("Subject");
		viewList.add("Sender's Name");
		viewList.add("Default");
		viewList.add("Priority");
		searchList.clear();
		searchList.add("Subject");
		searchList.add("Sender's Name");
		searchList.add("---");

		String smain = new String();
		/*
		 * s = smain; if (sSearch != null) { deleteFile(sSearch); } File fff = new
		 * File(smain); LinkedList i = x.convertToLinkedList(fff);
		 */
		LinkedList i = new LinkedList();
		String temp = new String();
		if (comboFilter.getValue().equals(null) && refresh2.equals("Filter")) {
			comboFilter.setValue(filter);
		}
		temp = comboFilter.getValue();
		if ((filter.equals(temp)) && refresh2.equals("Filter")) {
			sMain = yy + "\\Filter\\" + filter;
		} else {
			sMain = yy + "\\Filter\\" + comboFilter.getValue();
			filter = comboFilter.getValue();
		}
		refresh2 = "Filter";
		smain = sMain + "\\index.html";
		if (s.equals(sSearch) && pageCount2 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount5 == 0
				&& pageCount6 == 0 && pageCount7 == 0) {
			File ff = new File(s);
			i = x.convertToLinkedList(ff);
		} else {
			s = sMain + "\\index.html";
			File ff = new File(smain);
			i = x.convertToLinkedList(ff);
			if (sSearch != null) {
				deleteFile(sSearch);
			}
		}
		int count1 = 0;
		theViewList.getItems().clear();
		for (int j = 0; j < 10 && j < i.size(); j++) {
			count1++;
			if (j == 0) {
				chk1.setVisible(true);
			}
			if (j == 1) {
				chk2.setVisible(true);
			}
			if (j == 2) {
				chk3.setVisible(true);
			}
			if (j == 3) {
				chk4.setVisible(true);
			}
			if (j == 4) {
				chk5.setVisible(true);
			}
			if (j == 5) {
				chk6.setVisible(true);
			}
			if (j == 6) {
				chk7.setVisible(true);
			}
			if (j == 7) {
				chk8.setVisible(true);
			}
			if (j == 8) {
				chk9.setVisible(true);
			}
			if (j == 9) {
				chk10.setVisible(true);
			}
			MailNode m = new MailNode();
			m = (MailNode) i.get(j);
			String s3 = m.getIndex();
			String s1 = m.getFrom();
			String s2 = m.getSubject();
			while (s1.length() != 20) {
				s1 = s1 + " ";
			}
			while (s2.length() != 30) {
				s2 = s2 + " ";
			}
			String s = s3 + " " + s1 + s2 + m.getDate();
			Button k = new Button();
			k.setText(s);
			k.setPrefHeight(40);
			k.setPrefWidth(606);
			k.setFont(new Font("Courier New", 13));
			k.setOnAction(new EventHandler() {
				@Override
				public void handle(Event event) {
					attList.getItems().clear();
					String tempp = new String();
					tempp = k.getText();
					String[] p = tempp.split(" ");
					String toAttach = new String();
					toAttach = p[0];
					System.out.println("ataaaaaaaaaaaaaaaaaaaah>" + toAttach);
					System.out.println(sMain + "\\index.html" + "++++++++++++++++++++===");

					int aTT = Integer.parseInt(toAttach);
					LinkedList t11 = x.convertToLinkedList(new File(sMain + "\\index.html"));
					MailNode myNode = new MailNode();
					for (int k2 = 0; k2 < t11.size(); k2++) {
						MailNode d = new MailNode();
						d = (MailNode) t11.get(k2);
						if (aTT == Integer.parseInt(d.getIndex())) {
							myNode = d;
							mNode = d;

						}
					}
					String s3 = new String();
					s3 = x.getBody(new File(sMain), myNode.getIndex());
					emailBody.setText(s3);
					bodylabel.setVisible(true);
					attlabel.setVisible(true);
					emailBody.setVisible(true);
					attList.setVisible(true);
					fromLabel.setVisible(true);
					subjectLabel.setVisible(true);
					dateLabel.setVisible(true);
					t1.setVisible(true);
					t2.setVisible(true);
					t3.setVisible(true);
					t4.setVisible(true);
					t1.setText(myNode.getFrom());
					t2.setText(myNode.getSubject());
					t3.setText(myNode.getDate());
					t4.setText(myNode.getTo());
					prio1.setPromptText("Priority");
					prio1.setVisible(true);
					close.setVisible(true);
					fav.setVisible(true);
					pane.setVisible(true);
					System.out.println("Ataaaaaaa>>" + myNode.getAttachment());
					if (!(myNode.getAttachment()).equals("null")) {
						String[] att1 = (myNode.getAttachment()).split(";");
						for (int i = 0; i < att1.length; i++) {
							Button k = new Button();
							System.out.println(att1[i]);
							String temp1 = att1[i];
							k.setText(temp1);
							k.setOnAction(new EventHandler() {
								@Override
								public void handle(Event event) {
									String ss = mNode.getDate();
									String[] sss = ss.split(" ");
									String pathn = new String();
									pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
									String myFile = sMain + "\\" + pathn + "\\" + k.getText();
									File fll = new File(myFile);
									try {
										Desktop.getDesktop().open(fll);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							});
							attList.getItems().add(k);
						}
					}
				}
			});
			theViewList.getItems().add(k);
		}
		while (count1 < 10) {
			if (count1 == 0) {
				chk1.setVisible(false);
			}
			if (count1 == 1) {
				chk2.setVisible(false);
			}
			if (count1 == 2) {
				chk3.setVisible(false);
			}
			if (count1 == 3) {
				chk4.setVisible(false);
			}
			if (count1 == 4) {
				chk5.setVisible(false);
			}
			if (count1 == 5) {
				chk6.setVisible(false);
			}
			if (count1 == 6) {
				chk7.setVisible(false);
			}
			if (count1 == 7) {
				chk8.setVisible(false);
			}
			if (count1 == 8) {
				chk9.setVisible(false);
			}
			if (count1 == 9) {
				chk10.setVisible(false);
			}
			count1++;
		}
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount2 = 0;
		pageCount1 = 1;
		pageCount8 = 1;
		pageCount9 = 0;
		combo1.setPromptText("Search by:");
		search.setPromptText("Search");
	}

	// }
	@FXML
	public void viewFavourites(ActionEvent event) {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		close.setVisible(false);
		SendDraft.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		pageCount9++;
		if (pageCount9 == 1) {
			refresh2 = "Favourites";
			otherVV.clear();
			File tempFolders = new File(yy + "\\Others\\index.html");
			LinkedList r = x.fromIndexToLinkedOther(tempFolders);
			for (int i = 0; i < r.size(); i++) {
				MailNode temp = (MailNode) r.get(i);
				String folders = temp.getnewFolder();
				// String[] folder = folders.split("</br>");
				otherVV.add(folders);
			}
			filterList.clear();
			File fi = new File(yy + "\\Filter\\index.html");
			LinkedList lx = x.indexFilterToLinkedList(fi);
			if (lx.size() != 0) {
				filterList.clear();
				for (int i = 0; i < lx.size(); i++) {
					MailNode temp = new MailNode();
					temp = (MailNode) lx.get(i);
					filterList.add(temp.getFolderName());
				}

			}
			viewList.clear();
			viewList.add("Subject");
			viewList.add("Default");
			viewList.add("Receiver's Name");
			viewList.add("Sender's Name");
			viewList.add("Priority");
			searchList.clear();
			multiList.clear();
			multiList.add("Delete");
			multiList.add("Move");
			searchList.add("Subject");
			searchList.add("Sender's Name");
			searchList.add("Receiver's Name");
			searchList.add("---");
			theViewList.getItems().clear();
			attList.getItems().clear();
			LinkedList i = new LinkedList();
			sMain = yy + "\\Favourites";
			String smain = sMain + "\\index.html";
			if (s.equals(sSearch) && pageCount8 == 0 && pageCount3 == 0 && pageCount4 == 0 && pageCount2 == 0
					&& pageCount6 == 0 && pageCount7 == 0) {
				File ff = new File(s);
				i = x.convertToLinkedList(ff);
			} else {
				s = sMain + "\\index.html";
				File ff = new File(smain);
				i = x.convertToLinkedList(ff);
				if (sSearch != null) {
					deleteFile(sSearch);
				}
			}
			int count1 = 0;
			for (int j = 0; j < 10 && j < i.size(); j++) {
				// combo3.setVisible(false);
				count1++;
				if (j == 0) {
					chk1.setVisible(true);
				}
				if (j == 1) {
					chk2.setVisible(true);
				}
				if (j == 2) {
					chk3.setVisible(true);
				}
				if (j == 3) {
					chk4.setVisible(true);
				}
				if (j == 4) {
					chk5.setVisible(true);
				}
				if (j == 5) {
					chk6.setVisible(true);
				}
				if (j == 6) {
					chk7.setVisible(true);
				}
				if (j == 7) {
					chk8.setVisible(true);
				}
				if (j == 8) {
					chk9.setVisible(true);
				}
				if (j == 9) {
					chk10.setVisible(true);
				}
				MailNode m = new MailNode();
				m = (MailNode) i.get(j);
				String s1 = m.getFrom();
				String s2 = m.getSubject();
				String s4 = m.getTo();
				while (s1.length() != 20) {
					s1 = s1 + " ";
				}
				while (s4.length() != 20) {
					s4 = s4 + " ";
				}
				while (s2.length() != 30) {
					s2 = s2 + " ";
				}
				String s3 = m.getIndex();
				String s = s3 + " " + s1 + s4 + s2 + m.getDate();
				Button k = new Button();
				k.setText(s);
				k.setPrefHeight(40);
				k.setPrefWidth(606);
				k.setFont(new Font("Courier New", 13));
				k.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						attList.getItems().clear();
						String tempp = new String();
						tempp = k.getText();
						String[] p = tempp.split(" ");
						String toAttach = new String();
						toAttach = p[0];
						int aTT = Integer.parseInt(toAttach);
						LinkedList t11 = x.convertToLinkedList(new File(smain));
						MailNode myNode = new MailNode();
						for (int k2 = 0; k2 < t11.size(); k2++) {
							MailNode d = new MailNode();
							d = (MailNode) t11.get(k2);
							if (aTT == Integer.parseInt(d.getIndex())) {
								myNode = d;
								mNode = d;
							}
						}
						String s3 = new String();
						s3 = x.getBody(new File(yy + "\\Trash"), myNode.getIndex());
						System.out.println("<<<<<" + s3);
						emailBody.setText(s3);
						bodylabel.setVisible(true);
						attlabel.setVisible(true);
						emailBody.setVisible(true);
						attList.setVisible(true);
						fromLabel.setVisible(true);
						subjectLabel.setVisible(true);
						dateLabel.setVisible(true);
						t1.setVisible(true);
						t2.setVisible(true);
						t3.setVisible(true);
						t4.setVisible(true);
						t1.setText(myNode.getFrom());
						t2.setText(myNode.getSubject());
						t3.setText(myNode.getDate());
						t4.setText(myNode.getTo());
						prio1.setPromptText("Priority");
						prio1.setVisible(true);
						close.setVisible(true);
						fav.setVisible(true);
						pane.setVisible(true);
						if (!(myNode.getAttachment()).equals("null")) {
							System.out.println("------------------");
							String[] att1 = (myNode.getAttachment()).split(";");
							for (int i = 0; i < att1.length; i++) {
								Button k = new Button();
								System.out.println(att1[i]);
								String temp1 = att1[i];
								k.setText(temp1);
								k.setOnAction(new EventHandler() {
									@Override
									public void handle(Event event) {
										String ss = mNode.getDate();
										String[] sss = ss.split(" ");
										String pathn = new String();
										pathn = mNode.getSubject() + sss[0] + "-" + sss[1];
										String myFile = yy + "\\Trash\\" + pathn + "\\" + k.getText();
										File fll = new File(myFile);
										try {
											Desktop.getDesktop().open(fll);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});
								attList.getItems().add(k);
							}
						}
					}
				});
				theViewList.getItems().add(k);
			}
			while (count1 < 10) {
				if (count1 == 0) {
					chk1.setVisible(false);
				}
				if (count1 == 1) {
					chk2.setVisible(false);
				}
				if (count1 == 2) {
					chk3.setVisible(false);
				}
				if (count1 == 3) {
					chk4.setVisible(false);
				}
				if (count1 == 4) {
					chk5.setVisible(false);
				}
				if (count1 == 5) {
					chk6.setVisible(false);
				}
				if (count1 == 6) {
					chk7.setVisible(false);
				}
				if (count1 == 7) {
					chk8.setVisible(false);
				}
				if (count1 == 8) {
					chk9.setVisible(false);
				}
				if (count1 == 9) {
					chk10.setVisible(false);
				}
				count1++;
			}
			pageCount3 = 0;
			pageCount4 = 0;
			pageCount5 = 0;
			pageCount2 = 0;
			pageCount6 = 0;
			pageCount7 = 0;
			pageCount8 = 0;
			pageCount1 = 1;
			combo1.setPromptText("Search by:");
			search.setText("Search");
		}

	}

	@FXML
	public void closeEmail(ActionEvent event) {
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		fav.setVisible(false);
		pane.setVisible(false);
	}

	@FXML
	public void setPriority(ActionEvent event) {
		String priorityDegree;
		priorityDegree = prio1.getValue();
		prioritySelect.clear();
		prioritySelect.add("1");
		prioritySelect.add("2");
		prioritySelect.add("3");
		prioritySelect.add("4");
		Priority kk = new Priority();
		File kill = new File(sMain + "\\index.html");
		LinkedList temp = new LinkedList();
		temp = x.convertToLinkedList(kill);
		String index = new String();
		// index = indexs.getValue();
		for (int i = 0; i < temp.size(); i++) {
			MailNode myN = new MailNode();
			myN = (MailNode) temp.get(i);
			if (myN.getDate().equals(t3.getText()) && myN.getSubject().equals(t2.getText())
					&& myN.getFrom().equals(t1.getText()) && myN.getTo().equals(t4.getText())) {
				index = myN.getIndex();
			}
		}
		kk.setPriority(priorityDegree, index, sMain);
		prioritySelect.clear();
		prioritySelect.add("1");
		prioritySelect.add("2");
		prioritySelect.add("3");
		prioritySelect.add("4");
		
	}

	@FXML
	public void refresh(ActionEvent event) throws IOException {
		pageCount2 = 0;
		pageCount3 = 0;
		pageCount4 = 0;
		pageCount5 = 0;
		pageCount6 = 0;
		pageCount7 = 0;
		pageCount8 = 0;
		pageCount9 = 0;
		pageCount1 = 1;
		if(!multi.isEmpty()) {
			multi.clear();
			}
		chk1.setSelected(false);
		chk2.setSelected(false);
		chk3.setSelected(false);
		chk4.setSelected(false);
		chk5.setSelected(false);
		chk6.setSelected(false);
		chk7.setSelected(false);
		chk8.setSelected(false);
		chk9.setSelected(false);
		chk10.setSelected(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		renameB.setVisible(false);
		File ff = new File(yy + "\\Filter\\index.html");
		LinkedList l = x.indexFilterToLinkedList(ff);
		if (l.size() != 0) {
			filterList.clear();
			for (int i = 0; i < l.size(); i++) {
				MailNode temp = new MailNode();
				temp = (MailNode) l.get(i);
				filterList.add(temp.getFolderName());
			}

		}
		combo4.getItems().clear();
		combo5.getItems().clear();
		Filter fi = new Filter();
		fi.filter();
		fi.filterSub();
		File tempFolders = new File(yy + "\\Others\\index.html");
		LinkedList r = x.fromIndexToLinkedOther(tempFolders);
		for (int i = 0; i < r.size(); i++) {
			MailNode temp = (MailNode) r.get(i);
			String folders = temp.getnewFolder();
			// String[] folder = folders.split("</br>");
			otherVV.add(folders);
		}
		if (refresh2.equals("Inbox")) {
			pageCount2 = 0;
			viewEmailsInbox(event);
		} else if (refresh2.equals("Sent")) {
			pageCount3 = 0;
			viewEmailsSent(event);
		} else if (refresh2.equals("Draft")) {
			pageCount4 = 0;
			viewEmailsDraft(event);
		} else if (refresh2.equals("Trash")) {
			pageCount5 = 0;
			viewEmailsTrash(event);
		} else if (refresh2.equals("Contacts")) {
			pageCount7 = 0;
			contacts(event);
		} else if (refresh2.equalsIgnoreCase("Filter")) {
			pageCount8 = 0;
			comboFilter.setValue(filter);
			filteredFolders(event);
		} else if (refresh2.equals("Favourites")) {
			pageCount9 = 0;
			viewFavourites(event);
		}
		else {
			renameB.setVisible(false);
		}
	}

	@FXML
	Button p = new Button();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		p.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				String myFile = yy + "\\info.html";
				File fll = new File(myFile);
				try {
					Desktop.getDesktop().open(fll);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		bodylabel.setVisible(false);
		attlabel.setVisible(false);
		emailBody.setVisible(false);
		attList.setVisible(false);
		fromLabel.setVisible(false);
		subjectLabel.setVisible(false);
		dateLabel.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		h500.setVisible(false);
		t4.setVisible(false);
		prio1.setVisible(false);
		pane.setVisible(false);
		combo3.setVisible(false);
		combo4.setVisible(false);
		viewList.add("---");
		combo.setItems(viewList);
		combo1.setItems(searchList);
		combo3.setItems(multiList);
		File tempFolders = new File(yy + "\\Others\\index.html");
		LinkedList r = x.fromIndexToLinkedOther(tempFolders);
		for (int i = 0; i < r.size(); i++) {
			MailNode temp = (MailNode) r.get(i);
			String folders = temp.getnewFolder();
			// String[] folder = folders.split("</br>");
			otherVV.add(folders);
		}
		combo5.setItems(otherVV);
		combo4.setItems(otherVV);
		comboDeleteFolder.setItems(otherVV);
		File ff = new File(yy + "\\Filter\\index.html");
		LinkedList l = x.indexFilterToLinkedList(ff);
		if (l.size() != 0) {
			filterList.clear();
			for (int i = 0; i < l.size(); i++) {
				MailNode temp = new MailNode();
				temp = (MailNode) l.get(i);
				filterList.add(temp.getFolderName());
			}

		}
		comboFilter.setItems(filterList);
		Filter fi = new Filter();
		fi.filter();
		fi.filterSub();
		prioritySelect.add("1");
		prioritySelect.add("2");
		prioritySelect.add("3");
		prioritySelect.add("4");
		prio1.setItems(prioritySelect);
	}

	public void deleteEmails(LinkedList mails, String filepath) {
		Folder des = new Folder();
		des.setPath(yy + "\\Trash");
		try {
			System.out.println("fpathdel>>>" + filepath);
			x.moveEmails(mails, des, filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Delete_from_index(String path, String string) {
		File indexfile = new File(path + "\\index.html");
		LinkedList ls = new LinkedList();
		ls = x.convertToLinkedList(indexfile);
		if (!ls.isEmpty()) {
			if (ls.size() != 1) {
				ls.remove(Integer.parseInt(string));
			} else if (ls.size() == 1) {
				ls.clear();

			}
		}
		Rewrite_index(ls, path);
		System.out.println(path + "path rewrite");
	}

	public void Rewrite_index(LinkedList linkedindex, String pathindex) {
		File f = new File(pathindex + "\\index.html");
		f.delete();
		LinkedList tonew = new LinkedList();
		MailNode old = new MailNode();
		int c = 0;
		while (c < linkedindex.size()) {
			MailNode temp = new MailNode();
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
			x.fromLinkedToIndex(tonew, newf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void moveEmails(LinkedList mails, Folder des, String filepath) throws IOException {
		System.out.println("da5all");
		for (int i = 0; i < mails.size(); i++) {
			System.out.println("da5alll");
			Mail themoved = new Mail();
			MailNode m = (MailNode) mails.get(i);
			String mailname = m.getSubject();
			String despath = des.getPath();
			String s = m.getDate();
			String[] sss = s.split(" ");
			String pathn = new String();
			pathn = m.getSubject() + sss[0] + "-" + sss[1];
			System.out.println("pathnnnnnnn>>" + pathn);
			File desfile = new File(despath + "\\" + pathn);
			File from = new File(filepath + "\\" + pathn);
			System.out.println("despath>>" + despath);
			System.out.println("pathn>>" + pathn);
			System.out.println(
					"destination in controller   " + despath + "\\" + pathn + "     from  " + filepath + "\\" + pathn);
			Files.move(from.toPath(), desfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("fiulepath to delete index >." + filepath);
			Delete_from_index(filepath, m.getIndex());
			themoved.setDate(m.getDate());
			themoved.setTo(m.getTo());
			themoved.setFrom(m.getFrom());
			themoved.setSubject(m.getSubject());
			x.indexFile(themoved, despath + "\\index.html");
		}
	}

	public void starAction(ActionEvent event) {
		System.out.println(sMain + "     ---   smmmmmm");
		File kill = new File(sMain + "\\index.html");
		LinkedList temp = new LinkedList();
		temp = x.convertToLinkedList(kill);
		int flag = 0;
		MailNode theNode = new MailNode();
		LinkedList n = new LinkedList();
		for (int i = 0; i < temp.size(); i++) {
			MailNode myN = new MailNode();
			myN = (MailNode) temp.get(i);
			if (myN.getDate().equals(t3.getText()) && myN.getSubject().equals(t2.getText())
					&& myN.getFrom().equals(t1.getText()) && myN.getTo().equals(t4.getText())) {
				theNode = myN;
				n.add(myN);
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			LinkedList test = new LinkedList();
			test = x.convertToLinkedList(new File(yy + "\\Favourites\\index.html"));
			int flag2 = 0;
			for (int i = 0; i < test.size(); i++) {
				MailNode temp2 = new MailNode();
				temp2 = (MailNode) test.get(i);
				if (theNode.getDate().equals(temp2.getDate()) && theNode.getSubject().equals(temp2.getSubject())
						&& theNode.getTo().equals(temp2.getTo()) && theNode.getFrom().equals(temp2.getFrom())) {
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 0) {
				Folder k = new Folder();
				k.setPath(yy + "\\Favourites");
				try {
					x.copyEmails(n, k, (sMain));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@FXML
	public void composeFromDraft(ActionEvent event) throws IOException {
		File kill = new File(sMain + "\\index.html");
		LinkedList temp = new LinkedList();
		temp = x.convertToLinkedList(kill);
		MailNode theNode = new MailNode();
		LinkedList ll = new LinkedList();
		for (int i = 0; i < temp.size(); i++) {
			MailNode myN = new MailNode();
			myN = (MailNode) temp.get(i);
			if (myN.getDate().equals(t3.getText()) && myN.getSubject().equals(t2.getText())
					&& myN.getFrom().equals(t1.getText()) && myN.getTo().equals(t4.getText())) {
				theNode = myN;
				ll.add(myN);
				break;
			}
		}
		x.composeFromDraft(ll);
	}

	@FXML
	public void goBack(ActionEvent event) {
		/*
		 * Stage primaryStage = new Stage(); Parent root; try { root =
		 * FXMLLoader.load(getClass().getResource("/application/MainP.fxml")); Scene
		 * scene1 = new Scene(root, 1366, 720);
		 * scene1.getStylesheets().add(getClass().getResource("application.css").
		 * toExternalForm()); primaryStage.setScene(scene1); primaryStage.show();
		 */
		Stage stage = (Stage) combo.getScene().getWindow();
		stage.close();
		/*
		 * } catch (IOException e1) { e1.printStackTrace(); }
		 */

	}

	@FXML
	public void addAccount(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/MainP.fxml"));
		Scene scene1 = new Scene(root, 1366, 720);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	@FXML
	public void signout(ActionEvent event) {
		/*
		 * Stage primaryStage = new Stage(); Parent root; try { root =
		 * FXMLLoader.load(getClass().getResource("/application/MainP.fxml")); Scene
		 * scene1 = new Scene(root, 1366, 720);
		 * scene1.getStylesheets().add(getClass().getResource("application.css").
		 * toExternalForm()); primaryStage.setScene(scene1); primaryStage.show();
		 */
		Stage stage = (Stage) combo.getScene().getWindow();
		stage.close();
		/*
		 * } catch (IOException e1) { e1.printStackTrace(); }
		 */
	}

}