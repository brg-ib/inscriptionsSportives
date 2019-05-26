package interfaceGraphique;
	
import java.io.IOException;

import interfaceGraphique.MenuController;
import interfaceGraphique.MainAppController;

import inscriptions.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	
	private Stage stage;
	private BorderPane rootLayout;
	
	
    /**
     * Constructeur
     */
    public MainApp() {
      // Connexion
    	
    } 
    
    
	@Override
	public void start(Stage stage) {
		
		 	this.stage = stage;
			stage.setTitle("Application M2L Inscriptions Sportive");
	        
	        // Set the application icon.
	        this.stage.getIcons().add(new Image("file:ressources/logom2l.png"));

	        initRootLayout();

	        //initMenu();
		
	}
	
	
	  /**
     * Initializes the root layout
     */
    public void initRootLayout() {
        
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/interfaceGraphique/MainApp.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

//            // Give the controller access to the main app.
////            RootLayoutController controller = loader.getController();
////            controller.setMainApp(this);

    }
    
    /**
     * Initializes the menu layout
     */
    public void initMenu() {
        System.out.println("hello");
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaceGraphique/Menu.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

//            // Give the controller access to the main app.
////            RootLayoutController controller = loader.getController();
////            controller.setMainApp(this);

    }
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonne() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Personne.fxml"));
            AnchorPane personne = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personne);

            // Give the controller access to the main app.
           // MenuController controller = loader.getController();
       //     controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getStage() {
        return stage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
