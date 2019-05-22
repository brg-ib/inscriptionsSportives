package interfaceGraphique;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.*;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


/**
 * @author Ihcen
 *
 */
public class MainConnexionController implements Initializable{
	

	@FXML
	private Text txtConnect;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private void btnOkAction(ActionEvent event) {
		if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/interfaceGraphique/Menu.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Application M2L Inscriptions Sportive");
				stage.show();
				txtPassword.setText("Hello");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			txtUsername.setText("OH NOOOO !");
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}
