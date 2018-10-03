package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.window;


public class doctorinfocontroller implements Initializable{
    @FXML
    private Label docinfo;
    @FXML
    private Label docinfo1;
    @FXML
    private ChoiceBox<String> doc_sel;
    static String doctorchosen;




    @FXML
    private void back4 (ActionEvent event) throws IOException
    {
        AnchorPane consultcontrol = FXMLLoader.load(getClass().getResource("consult.fxml"));
        Scene scene = new Scene(consultcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void nextpushed (ActionEvent event) throws IOException
    {
        doctorchosen = doc_sel.getValue();
        AnchorPane appointmentcontrol = FXMLLoader.load(getClass().getResource("appointment.fxml"));
        Scene scene = new Scene(appointmentcontrol,690,531);
        window.setScene(scene);
        window.show();

       // System.out.println(doctorchosen);

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
        docinfo.setText(consultcontroller.x);
        docinfo1.setText(consultcontroller.y);
        doc_sel.getItems().addAll(consultcontroller.x1, consultcontroller.y1);
        doc_sel.setValue(consultcontroller.x1);
    }


}
