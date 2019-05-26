package interfaceGraphique;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.*;
import java.util.*;

import interfaceGraphique.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Fenetre de connexion
 * 
 * @author Ihcen
 *
 */
public class MainAppController implements Initializable{
		
	
	@FXML
	private Text txtConnect;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private void btnLoginAction() throws IOException {
		txtConnect.setText("Bonjour "+txtUsername.getText());
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}
