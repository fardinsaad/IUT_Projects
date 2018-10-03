

// FRONT PAGE


package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

import javafx.stage.Stage;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;


public class FXMLDocumentController implements Initializable {
    
    int cnt=0;
    @FXML
    private Label label;
  
    @FXML
    Button button2 = new Button();

    public static Stage window = new Stage();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_2.fxml"));
        Scene scene= new Scene(pane);
        mainstage.setScene(scene);
        mainstage.show();
        System.out.println("You clicked me!");
    }
    @FXML
    private void handleButton2(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("LeaveVehicle.fxml"));
        Scene scene= new Scene(pane);
     
        window.setScene(scene);
        window.show();
       
    }
    
    @FXML
    private void handleButton3(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Developers.fxml"));
        Scene scene= new Scene(pane);
     
        mainstage.setScene(scene);
        mainstage.show();
       
    }
    
     @FXML
    private void showCars(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkArea.fxml"));
        AnchorPane pane = loader.load();
        
        ParkAreaController controller = loader.getController();
        controller.changeColour();
        
        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void handleCloseButton(ActionEvent event) throws IOException {
        mainstage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
