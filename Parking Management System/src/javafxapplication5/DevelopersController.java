/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DevelopersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        
        mainstage.setScene(pubScene);
        mainstage.show();
        System.out.println("You clicked me!");
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
