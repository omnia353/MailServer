package application;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainFolder {
	@FXML
	public ComboBox<String> combo5;
	ObservableList<String> otherVV = FXCollections.observableArrayList();

	@FXML
	TextField folderName;

	@FXML
	Button chkLikedFolder;

	@FXML
	Label warning1;
	App x = new App();
	Controller y = new Controller();
	String path = y.spath;
	@FXML
	public void chkListOfNewFolders(ActionEvent event) throws IOException {

		warning1.setText("");
		if (!folderName.getText().equals("")) {
			System.out.println("El7amdulellah");
			int flag = 0;
			File fd = new File(path + "\\Others\\index.html");
			LinkedList otherFolders = x.fromIndexToLinkedOther(new File(fd.getAbsolutePath()));
			for (int i = 0; i < otherFolders.size(); i++) {
				MailNode temp = (MailNode) otherFolders.get(i);
				String theF = temp.getnewFolder();
				String[] arr = theF.split("</br>");
				if (arr[0].equals(folderName.getText())) {
					flag = 1;
					warning1.setText("The File Is Already Exist");
					break;
				}
			}
			if (flag == 0) {
				MailNode de = new MailNode();
				de.setnewFolder(folderName.getText());
				otherFolders.add(folderName.getText());
				String pathOther = new String();
				pathOther = path + "\\Others\\index.html";
				x.indexOthers(de, pathOther);
				File newFile = new File(path+ "\\Others\\" + folderName.getText());
				newFile.mkdir();
				String newStr = new String();
				newStr = newFile.getAbsolutePath();
				File newIndex = new File (newStr+"\\index.html");
				newIndex.createNewFile();
				Stage stage = (Stage) folderName.getScene().getWindow();
			    stage.close();
			
			}
		}
	}
	public void cancel (ActionEvent event) {
		Stage stage = (Stage) folderName.getScene().getWindow();
	    stage.close();
	}

}
