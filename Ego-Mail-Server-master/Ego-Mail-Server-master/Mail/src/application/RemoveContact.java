package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class RemoveContact implements Initializable {
	//App x = new App();
	SortContacts a = new SortContacts();
	Controller y = new Controller();
	String path = y.spath;
	@FXML
	public ComboBox<String> combo;
	ObservableList<String> numberList = FXCollections.observableArrayList();
	@FXML
	public void removeContact(ActionEvent event) throws NumberFormatException, FileNotFoundException {	
		File ff = new File(path + "\\contacts.html");
		a.Delete_from_contacts(ff, Integer.parseInt(combo.getValue()));
		Stage stage = (Stage) combo.getScene().getWindow();
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
	public void cancel (ActionEvent event) {
		Stage stage = (Stage)combo.getScene().getWindow();
	    stage.close();
	}
		
}

