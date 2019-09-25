package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ProfileMain implements Initializable{
	 @FXML
	    WebView webView;
	Controller x = new Controller();
	String path = "‪C:\\Server\\kiro\\info.html";
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		        System.out.println("onLoadHelpFile clicked" + webView);
		        WebEngine webEngine = webView.getEngine();
		        webEngine.load(getClass().getResource("/application/info.html").toExternalForm());
		    }
	   
}
