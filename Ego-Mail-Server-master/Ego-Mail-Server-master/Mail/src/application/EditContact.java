package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditContact implements Initializable {

App x = new App();
SortContacts a = new SortContacts();
Controller y = new Controller();
String path = y.spath;
@FXML
public ComboBox<String> combo;
ObservableList<String> numberList = FXCollections.observableArrayList();
@FXML
TextField namefEdit = new TextField();
@FXML
TextField namelEdit = new TextField();
@FXML
TextField emailEdit = new TextField();
@FXML
TextField relationEdit = new TextField();
@FXML
Label error =  new Label();
int flag = 0;
public LinkedList l = new LinkedList();
String index;

@FXML
public void chooseContact(ActionEvent event) {	
index = combo.getValue();
MailNode temp = new MailNode();
temp = a.getContact(index);
namefEdit.setText(temp.getFirstName());
namelEdit.setText(temp.getLastName());
relationEdit.setText(temp.getRelation());
l = temp.getEmails();
String s = new String();
for(int i = 0; i < l.size(); i++) {
	if(i == l.size() - 1 ) {
	s = s + temp.getEmails().get(i);
	}
	else {
		s = s +temp.getEmails().get(i)+ "/";
	}
}
emailEdit.setText(s);

}

public void insertEmail(ActionEvent event) {
	LinkedList ll = x.indexServerToLinkedList(x.indexServer);
	flag = 0;
	for(int i = 0; i < ll.size(); i++) {
		Enode temp = new Enode();
		temp = (Enode) ll.get(i);
		if(temp.getEmailName().equals(emailEdit.getText())) {
			flag = 1;
			break;
		}
	}
	for(int i = 0; i < l.size(); i++) {
		if(l.get(i).equals(emailEdit.getText())) {
			flag = 0;
		}
	}
	if(flag == 1) {
	l.add(emailEdit.getText());
	error.setText(" ");
	emailEdit.clear();
	}
	else {
		error.setText("Invalid Email!");
	}
}
@FXML
public void removeEmail(ActionEvent event) {
	flag = 0;
	for(int i = 0; i < l.size(); i++) {
		if(emailEdit.getText().equals(l.get(i))) {
			flag = 1;
			l.remove(i);
			break;
		}
	}
	if(flag != 1) {
		error.setText("Invalid Email!");
	}
	else {
		error.setText(" ");
		emailEdit.setText(" ");

	}
}
@FXML
public void editContact(ActionEvent event) throws IOException {
	if(namefEdit.getText().length() < 2 || namelEdit.getText().length() < 2 || l.size() == 0) {
		error.setText("You must fill in the First Name,\n Last Name and Email address!");
	}
	else {
	a.editContact(namefEdit.getText(), namelEdit.getText(), relationEdit.getText(), l,combo.getValue());
    Stage stage = (Stage) emailEdit.getScene().getWindow();
    stage.close();
	}
}
public void cancelButton(ActionEvent event) {
	Stage stage = (Stage) emailEdit.getScene().getWindow();
    stage.close();
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File ff = new File(path + "\\contacts.html");
		LinkedList l = a.convertToLinkedListContact(ff);
		for(int i = 0; i < l.size() ; i++) {
			numberList.add(Integer.toString(i));
		}
		combo.setItems(numberList);
	}
}
