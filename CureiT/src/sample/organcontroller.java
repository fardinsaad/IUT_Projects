package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.window;


public class organcontroller implements Initializable{


    @FXML
    private void emergencyclicked (ActionEvent event) throws IOException {
        AnchorPane emergencycontrol = FXMLLoader.load(getClass().getResource("emergency.fxml"));
        Scene scene = new Scene(emergencycontrol, 690, 531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void consultclicked (ActionEvent event) throws IOException
    {
        AnchorPane consultcontrol = FXMLLoader.load(getClass().getResource("consult.fxml"));
        Scene scene = new Scene(consultcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void back2 (ActionEvent event) throws IOException
    {
        AnchorPane human = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Scene scene = new Scene(human,690,531);
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
        // TODO
    }


}
