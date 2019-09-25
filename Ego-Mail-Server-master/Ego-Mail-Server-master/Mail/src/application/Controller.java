package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class Controller implements Initializable {

App x = new App();
Main1 y = new Main1();
@FXML
private TextField email;
@FXML
private PasswordField password;
@FXML
private Label status;
@FXML
private AnchorPane rootPane;
static String spath;
static String user;
static File serverpath;
public void log(ActionEvent event) throws IOException {
	if(!x.signin(email.getText(), password.getText())) {
		status.setText("Failed to login!\nIncorrect email or password");
	}
	
	else {
		spath = x.theUserPath;
		serverpath = x.indexServer;
		user = x.theUser;
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomeP.fxml"));
			Scene scene1 = new Scene(root,2000,800);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
			Stage stage = (Stage) email.getScene().getWindow();
		    stage.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public void back(ActionEvent event) throws IOException {
	Stage stage = (Stage) status.getScene().getWindow();
	stage.close();
}


	Contact co = new Contact();
	Mail mail = new Mail();
	boolean flag = false;	
	@FXML
	private TextField kk;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t4;
	@FXML
	private Button btnn;
	@FXML
	private Button btn;
	@FXML
	private Button btndraft;
	@FXML
	private TextField to;
	@FXML
	private TextField from;
	@FXML
	private TextField sub;
	@FXML
	private TextArea body;
	@FXML
	private Label lblerror;
	@FXML
	public ComboBox <String> combo1 ;
	@FXML
	public ComboBox <String> combo2 ;
	@FXML
	public ComboBox <String> combo3 ;
	@FXML
	public ComboBox <String> combo4 ;
	//bktb method bt5od action event
	public void generate (ActionEvent event) {
		lblerror.setVisible(false);
		String s1 = combo1.getValue();
		String s2 = combo2.getValue();
		String s3 = combo3.getValue();
		String s4 = combo4.getValue();
		int flag3 = 0;
		String date = s2 +"/" + s3 + "/" + s4;
		String firstn = kk.getText();
		if(firstn.contains(" ") || firstn.length() == 0) {
			lblerror.setVisible(true);
			lblerror.setText("Check your Email name and Password");
			flag3 = 1;
		}
		String lastn = t2.getText();
		if(lastn.contains(" ") || lastn.length() == 0) {
			lblerror.setVisible(true);
			lblerror.setText("Check your Email name and Password");
			flag3 = 1;
		}
		String emailname = t3.getText();
		if(emailname.contains(" ") || emailname.length() == 0) {
			lblerror.setVisible(true);
			lblerror.setText("Check your Email name and Password");
			flag3 = 1;
		}
		String pass = t4.getText();
		if(pass.contains(" ") || pass.length() == 0) {
			lblerror.setVisible(true);
			lblerror.setText("Check your Email name and Password");
			flag3 = 1;
		}
		if(pass.length()<8 || pass.length()>20 ) {
			lblerror.setVisible(true);
			lblerror.setText("Check your Email name and Password");
			flag3 = 1;
		}
		if(flag3 != 1) {
		co.setDateOfBirth(date);
		co.setFirstName(firstn);
		co.setLastName(lastn);
		co.setEmailName(emailname);
		System.out.println(emailname + "ooooooooooooo" + t3.getText());
		co.setPassword(pass);
		co.setGender(s1);
		x.signup(co);
		spath = x.theUserPath;
		serverpath = x.indexServer;
		user = x.theUser;
		System.out.println("user path +++++" + user  );
			try {
				Stage primaryStage  = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/HomeP.fxml"));
				Scene scene = new Scene(root,1325,800);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				Stage stage = (Stage) t3.getScene().getWindow();
			    stage.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}		
	String profile = null;
	public void profilepic (ActionEvent event) {
		FileChooser fc = new FileChooser();
		File selected = fc.showOpenDialog(null);
		String profile = selected.getAbsolutePath();
		co.setProfilePicture(profile);
		flag = true;
	}
	String s = new String();
	boolean flag2 = false;
	/*public void compose(ActionEvent event) {
		//lsa na2es el attachemnent
		if (flag2) {
			mail.setAttachmenet(s);
			}
		mail.setTo(to.getText());
		mail.setFrom(from.getText());
		mail.setText(body.getText());
		mail.setSubject(sub.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH;mm;ss");
	    LocalDateTime now = LocalDateTime.now();
		mail.setDate(dtf.format(now));
		a.compose(mail);
		flag=false;
	}*/
	/*public void draft(ActionEvent event) {
		if (flag2) {
		mail.setAttachmenet(s);
		}
		mail.setTo(to.getText());
		mail.setFrom(from.getText());
		mail.setText(body.getText());
		mail.setSubject(sub.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH;mm;ss");
	    LocalDateTime now = LocalDateTime.now();
		mail.setDate(dtf.format(now));
		a.draft(mail);	
		flag=false;
	}
	
	*/
	public void backSignup(ActionEvent event) throws IOException {
		Stage stage = (Stage) combo1.getScene().getWindow();
		stage.close();
	}
	public void attach (ActionEvent event) {
		flag2 = true;
		FileChooser fc = new FileChooser();
		File selected = fc.showOpenDialog(null);
		String q = selected.getAbsolutePath();
		s=s+q+"#";
	}	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(y.flagx);
		if(y.flagx ==1) {
		ObservableList<String> List4 = FXCollections.observableArrayList("1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012"); 
		ObservableList<String> List3 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12"); 
		ObservableList<String> List2 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"); 
		ObservableList<String> List = FXCollections.observableArrayList("Male","Female"); 
		combo1.setItems(List);	
		combo2.setItems(List2);
		combo3.setItems(List3);
		combo4.setItems(List4);
		}
	}
}

