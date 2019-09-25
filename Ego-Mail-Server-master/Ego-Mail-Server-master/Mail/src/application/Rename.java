package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Rename {
	Controller y = new Controller();
	ControllerMain x = new ControllerMain();
	App z = new App();
	String path = y.spath;
	String s;
	@FXML
	TextField renameF = new TextField();
	@FXML
	Label error = new Label();

	@FXML
	public void renameOther(ActionEvent event) {
		s = x.sM;
		int flag = 0;
		File fd = new File(path + "\\Others\\index.html");
		LinkedList otherFolders = z.fromIndexToLinkedOther(new File(fd.getAbsolutePath()));
		for (int i = 0; i < otherFolders.size(); i++) {
			MailNode temp = (MailNode) otherFolders.get(i);
			String theF = temp.getnewFolder();
			String[] arr = theF.split("</br>");
			if (arr[0].equals(renameF.getText())) {
				flag = 1;
				error.setText("The Folder Name Already Exists!");
				break;
			}
		}
		if (flag == 0) {
			String rev = new String();
			String ss = new String();
			ss = "";
			rev = "";
			int m = s.length();
			while (s.charAt(m - 1) != '\\') {
				ss = ss + s.charAt(m - 1);
				m--;
			}
			for (int n = ss.length() - 1; n >= 0; n--) {
				rev = rev + ss.charAt(n);
			}
			String oldName = new String();
			oldName = rev;
			File ff = new File(s);
			z.renameFolder(path, ff, oldName, renameF.getText());
			Stage stage = (Stage) error.getScene().getWindow();
		    stage.close();
		}
		
	}
	@FXML
	public void cancel (ActionEvent event) {
		Stage stage = (Stage) error.getScene().getWindow();
	    stage.close();
	}
}
