package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main1 {
	@FXML
	public Button signin = new Button();
	Button signup = new Button();
	static int flagx = 0;

	public void Signup(ActionEvent event) {
		try {
			flagx = 1;
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
			Scene scene = new Scene(root, 659, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void Help(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Help.fxml"));
			Scene scene = new Scene(root, 608, 794);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void Signin(ActionEvent event) {
		try {
			flagx = 0;
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/App.fxml"));
			Scene scene = new Scene(root, 400, 460);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
