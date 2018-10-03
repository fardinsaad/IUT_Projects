package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.window;

public class esolutioncontroller implements Initializable {


    @FXML
    private Label sol;

    @FXML
    private void finishpushed (ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void back4 (ActionEvent event) throws IOException
    {
        AnchorPane emergencycontrol = FXMLLoader.load(getClass().getResource("emergency.fxml"));
        Scene scene = new Scene(emergencycontrol, 690, 531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void minimizeclicked(ActionEvent event) throws IOException {
        window.setIconified(true);
    }

    @FXML
    void closeclicked(ActionEvent event) throws IOException {
        window.close();

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sol.setText(emergencycontroller.str);


    }
}
