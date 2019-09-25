package application;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ComposeClass implements Initializable {
	App x = new App();
	boolean flag2 = false;
	Controller z = new Controller();
	String u = z.user;
	@FXML
	private TextField to;
	@FXML
	private TextField from;
	@FXML
	private TextField sub;
	@FXML
	private TextArea body;
	@FXML
	private Button btnn;
	@FXML
	private Button btn;
	@FXML
	private Button btndraft;
	Mail mail = new Mail();
	String ss = new String();
	boolean flag = false;	
	@FXML
	Label error  = new Label();
	public void compose(ActionEvent event) {
		error.setText(" ");
		if (flag2) {
			mail.setAttachmenet(ss);
			}
		if(to.getText().length() == 0 || from.getText().length() == 0 || body.getText().length() == 0 || sub.getText().length() == 0) {
			error.setText("You Must Fill In All Fields!");
		}
		else {
		mail.setTo(to.getText());
		mail.setFrom(from.getText());
		mail.setText(body.getText().replaceAll("\n", System.getProperty("line.separator")));
		mail.setSubject(sub.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH;mm;ss");
	    LocalDateTime now = LocalDateTime.now();
		mail.setDate(dtf.format(now));
		if(!x.compose(mail)){
			error.setText("Invalid Email Address!");
		}else {
		flag=false;
			Stage stage = (Stage) to.getScene().getWindow();
		    stage.close();
		}
	}
	}
	public void draft(ActionEvent event) {
		if (flag2) {
		mail.setAttachmenet(ss);
		}
		mail.setTo(to.getText());
		mail.setFrom(from.getText());
		mail.setText(body.getText());
		mail.setSubject(sub.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH;mm;ss");
	    LocalDateTime now = LocalDateTime.now();
		mail.setDate(dtf.format(now));
		x.draft(mail);	
		Stage stage = (Stage) to.getScene().getWindow();
	    stage.close();
		flag=false;
	}
	public void attach (ActionEvent event) {
		flag2 = true;
		FileChooser fc = new FileChooser();
		File selected = fc.showOpenDialog(null);
		String q = selected.getAbsolutePath();
		ss =ss+q+"#";
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		from.setText(u);
		from.setDisable(true);
	}	
}
