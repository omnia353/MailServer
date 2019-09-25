package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HelpControl implements Initializable{
	@FXML
	ListView<ImageView> view = new ListView();
	@FXML
	Button button200 = new Button();
	@FXML
	Button one = new Button();
	@FXML
	Button one2= new Button();
	@FXML
	Button one3 = new Button();
	@FXML
	Button one4 = new Button();
	@FXML
	Button one5 = new Button();
	@FXML
	Button one6 = new Button();
	@FXML
	AnchorPane roott = new AnchorPane();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/application/1.PNG")));
		  ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/application/2.PNG")));
		  ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/application/3.PNG")));
		  ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/application/4.PNG")));
		  ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/application/5.PNG")));
		  ImageView image6 = new ImageView(new Image(getClass().getResourceAsStream("/application/6.PNG")));

		  view.getItems().add(image);
		  view.getItems().add(image2);
		  view.getItems().add(image3);
		  view.getItems().add(image4);
		  view.getItems().add(image5);
		  view.getItems().add(image6);
	}

}
