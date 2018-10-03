

//  START


package javafxapplication5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class JavaFXApplication5 extends Application {
    public static Stage mainstage;
    public static Scene pubScene;
   
    // Goes to Front Page
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
  
        Scene scene = new Scene(root);
        pubScene = scene;
        mainstage = stage;
        mainstage.setScene(pubScene);
        mainstage.show();
    }

    
    public static void main(String[] args) {
         
        launch(args);
      
    }
    
}
