package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import static sample.Main.window;

public class ratingcontroller implements Initializable {

    @FXML
    private Label docname;
    @FXML
    private Rating rate;
    String q;

    @FXML
    private void back6 (ActionEvent event) throws IOException
    {
        AnchorPane appointmentcontrol = FXMLLoader.load(getClass().getResource("appointment.fxml"));
        Scene scene = new Scene(appointmentcontrol,691,541);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void finish (ActionEvent event) throws IOException
    {
        double getr = rate.getRating();
        System.out.println(getr);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","cureit","far");
            String update_ratingproc = "{ call update_rating(?, ?) }";
            CallableStatement cs = conn.prepareCall(update_ratingproc);
            cs.setString(1, q);
            cs.setDouble(2, getr);
            cs.execute();
        }
        catch(Exception sqle){
            System.out.println("SQL Exception 1: " +sqle);
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root,750,639);
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
        docname.setText(doctorinfocontroller.doctorchosen);
        q = doctorinfocontroller.doctorchosen;
    }
}
