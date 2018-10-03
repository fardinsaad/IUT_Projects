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

public class consultcontroller implements Initializable {
    @FXML
    ChoiceBox<String>location = new ChoiceBox<>();
    static String x,y,x1,y1,oo;


    @FXML
    private void back3 (ActionEvent event) throws IOException
    {
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void nextpushed (ActionEvent event) throws IOException
    {
       String loc = location.getValue();
       x="";
       y="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","cureit","far");
            Statement st = conn.createStatement();

            ResultSet rset = st.executeQuery(
                    "select doc,location,cost,rating,phone from consult where location = '"+loc+"' and organ = '"+oo+"'");


            int i=1;
            while(rset.next())
            {
                if(i==1)
                {
                    x="Name:         "+rset.getString(1)+"\n"+"Location:     "+rset.getString(2)+"\n"+"Visiting fee: "+rset.getString(3)+"\n"+"Rating:        "+rset.getString(4)+"\n"+"Phone:        "+rset.getString(5);
                    x1=rset.getString(1);
                }
                else if(i==2)
                {
                    y="Name:         "+rset.getString(1)+"\n"+"Location:     "+rset.getString(2)+"\n"+"Visiting fee: "+rset.getString(3)+"\n"+"Rating:        "+rset.getString(4)+"\n"+"Phone:        "+rset.getString(5);
                    y1=rset.getString(1);
                }
                i++;

            }
        }
        catch(Exception sqle){
            System.out.println("SQL Exception 1: " +sqle);
        }
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
        // TODO
        oo = humanbodycontroller.orgname;
        location.getItems().addAll("Mirpur", "Gulshan", "Dhanmondi", "Uttara");
        location.setValue("Mirpur");
    }
}
