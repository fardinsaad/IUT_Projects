package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static sample.Main.window;

public class emergencycontroller implements Initializable {

    @FXML
    ChoiceBox<String>echoice = new ChoiceBox<>();
    String p1,p2,p3,p4,zz;
    static String oz,str;

    @FXML
    private void nextpushed (ActionEvent event) throws IOException
    {
        oz = echoice.getValue();
        System.out.println(oz);
        str="";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cureit", "far");
            Statement st = conn.createStatement();

            ResultSet rset = st.executeQuery(
                    "select solution from emergency where choice = '" + oz + "'");

            while (rset.next()) {
                str = str + rset.getString(1) + "\n";
            }
            System.out.println(str);


        }
        catch(Exception sqle){
            System.out.println("SQL Exception 1: " +sqle);
        }

        AnchorPane esolutioncontrol = FXMLLoader.load(getClass().getResource("esolution.fxml"));
        Scene scene = new Scene(esolutioncontrol,690,531);
        window.setScene(scene);
        window.show();


    }


    @FXML
    private void back3 (ActionEvent event) throws IOException
    {
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
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
        zz = humanbodycontroller.orgname;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cureit", "far");
            Statement st = conn.createStatement();
            System.out.println("Connection Established");

            ResultSet rset = st.executeQuery(
                    "select choicee from emergency1 where orgg = '" + zz + "'");


            int i = 1;
            while (rset.next()) {
                if (i == 1) p1 = rset.getString(1);
                else if (i == 2) p2 = rset.getString(1);
                else if (i == 3) p3 = rset.getString(1);
                else if (i == 4) p4 = rset.getString(1);
                i++;
            }

        }
        catch(Exception sqle){
            System.out.println("SQL Exception 1: " +sqle);
        }
        echoice.getItems().addAll(p1,p2,p3,p4);
        echoice.setValue(p1);
    }
}

