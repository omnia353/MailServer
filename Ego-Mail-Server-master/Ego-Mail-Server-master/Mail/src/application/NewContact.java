package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewContact {
	App x = new App();
	Controller y = new Controller();
	SortContacts z = new SortContacts();
	@FXML
	TextField namef = new TextField();
	@FXML
	TextField namel = new TextField();
	@FXML
	TextField email = new TextField();
	@FXML
	TextField relation = new TextField();
	@FXML
	Label error =  new Label();
	int flag;
	File serverP = y.serverpath;
	String path = y.spath;
	public LinkedList l = new LinkedList();
	public void addEmail(ActionEvent event) {
		LinkedList ll = x.indexServerToLinkedList(serverP);
		flag = 0;
		for(int i = 0; i < ll.size(); i++) {
			Enode temp = new Enode();
			temp = (Enode) ll.get(i);
			if(temp.getEmailName().equals(email.getText())) {
				flag = 1;
				break;
			}
		}
		for(int i = 0; i < l.size(); i++) {
			if(l.get(i).equals(email.getText())) {
				flag = 0;
			}
		}
		if(flag == 1) {
		l.add(email.getText());
		error.setText(" ");
		email.clear();
		}
		else {
			error.setText("Invalid Email!");
		}
	}

	@FXML
	public void addNewContact(ActionEvent event) throws IOException {
		if(namef.getText().length() < 2 || namel.getText().length() < 2 || l.size() == 0) {
			error.setText("You must fill in the First Name,\n Last Name and Email address!");
		}
		else {
		z.creatContact(namef.getText(), namel.getText(), relation.getText(), l);
		l.clear();
	    Stage stage = (Stage) email.getScene().getWindow();
	    stage.close();
		}
	}
	public void cancelButton(ActionEvent event) {
		Stage stage = (Stage) email.getScene().getWindow();
	    stage.close();
	}
}
