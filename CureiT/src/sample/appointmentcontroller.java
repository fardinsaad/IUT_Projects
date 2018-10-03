package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import static sample.Main.window;

public class appointmentcontroller implements Initializable {


    @FXML
    private ChoiceBox<String> day_sel;
    @FXML
    static String day;
    @FXML
    private Label warning;
    @FXML
    int param3 = 0;
    int i=1;
    @FXML
    private DatePicker dp;
    @FXML
    private void dppushed (ActionEvent event) throws IOException
    {

    }
    @FXML
    private void nextpushed (ActionEvent event) throws IOException
    {
        String z = doctorinfocontroller.doctorchosen;
        System.out.println(z);
        day = day_sel.getValue();
        String ccc = "",ccc2 = "";


        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","cureit","far");
            String get_dayproc = "{ call get_day(?, ?, ?) }";
            CallableStatement cs = conn.prepareCall(get_dayproc);
            cs.setString(1, z);
            cs.setString(2, day);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.execute();
             param3 = cs.getInt(3);
            System.out.println(param3);
            conn.close();

        }
        catch(Exception sqle){
            System.out.println("SQL Exception 1: " +sqle);
        }
        if(param3 == 1)
        {
            AnchorPane ratingcontrol = FXMLLoader.load(getClass().getResource("rating.fxml"));
            Scene scene = new Scene(ratingcontrol,690,531);
            window.setScene(scene);
            window.show();
        }
        else if(param3 == 2)
        {
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connn= DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","cureit","far");
                String get_textproc = "{ call get_text(?, ?) }";
                CallableStatement cc = connn.prepareCall(get_textproc);
                cc.setInt(1, i);
                cc.registerOutParameter(2, java.sql.Types.VARCHAR);
                cc.execute();
                ccc = cc.getString(2);
                System.out.println(ccc);
                warning.setText(ccc);
                connn.close();

            }
            catch(Exception sqle){
                System.out.println("SQL Exception 1: " +sqle);
            }
        }

        i++;

    }
    @FXML
    private void back5 (ActionEvent event) throws IOException
    {
        AnchorPane doctorinfocontrol = FXMLLoader.load(getClass().getResource("doctorinfo.fxml"));
        Scene scene = new Scene(doctorinfocontrol,690,531);
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
        day_sel.getItems().addAll("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY");
        day_sel.setValue("SUNDAY");
    }
}
