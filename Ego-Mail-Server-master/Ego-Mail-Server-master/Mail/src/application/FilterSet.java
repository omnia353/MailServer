package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FilterSet {
	Filter x = new Filter();
	@FXML
	TextField  nameFilter = new TextField();
	@FXML
	TextField nameFolder = new TextField();
	@FXML
	Label error = new Label();
	@FXML
	public void setFilter(ActionEvent event) throws IOException {
		if(nameFolder.getText().length() == 0 || nameFilter.getText().length() == 0) {
			error.setText("You must fill all fields!");
		}
		else {
		x.setFilter(nameFolder.getText(), nameFilter.getText());
		Stage stage = (Stage) error.getScene().getWindow();
	    stage.close();
		}
	}
	public void cancel (ActionEvent event) {
		Stage stage = (Stage) error.getScene().getWindow();
	    stage.close();
	}
}
