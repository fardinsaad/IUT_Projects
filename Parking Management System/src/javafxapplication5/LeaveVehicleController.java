/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static javafxapplication5.FXMLDocumentController.window;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LeaveVehicleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    TextField number;
    @FXML
    PasswordField password;
    @FXML
    Label alert;
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        window.close();

        
    }
    
    // Verify Parking Number and Password
    
     @FXML
    private void goSee(ActionEvent event) throws IOException {
        
        Boolean mark=false;
        String ss,ss2;
        ss=number.getText();
        ss2=password.getText();
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        if(ss.isEmpty()==true) mark=true;
        if(ss2.isEmpty()==true) mark=true;
        if(mark==true) alert.setVisible(true);
        else
        {
            int y;
            y=Integer.parseInt(ss);
            Boolean flag=false;



             // DATABASE

                try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn=DriverManager.getConnection(
                                        "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                        Statement st = conn.createStatement();
                        ResultSet rset = st.executeQuery(
                                        "select park_number,vehicle_number from vehicle");
                        while(rset.next()){
                                int X;
                                X=rset.getInt(1);
                                String str,str2 = "";

                                str=rset.getString(2);
                                if(X==y){
                                    for(int i=0;i<str.length();i++)
                                    {
                                        if(str.charAt(i)>='0' && str.charAt(i)<='9')
                                        {
                                            str2+=str.charAt(i);
                                        }
                                    }
                                    int zz,pp;
                                    zz=Integer.parseInt(str2);
                                    pp=Integer.parseInt(password.getText());
                                    if(zz==pp) flag=true;
                                }


                        }
                    }
                    catch(Exception sqle){
                            System.out.println("SQL Exception 1: " +sqle);
                    }

                if(flag==true)
                {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkStatus.fxml"));
                    AnchorPane pane = loader.load();

                    ParkStatusController controller = loader.getController();
                    controller.seeInfo(y);

                    window.close();
                    Scene scene = new Scene(pane);
                    mainstage.setScene(scene);
                    mainstage.show();

                    System.out.println("You clicked me!");
                }
                else{
                    alert.setVisible(true);
                }
            
        }
        
        
    }
    
    @FXML
    private void hideLabel(){
        alert.setVisible(false);
    }
     @FXML
    private void textAction(ActionEvent event) throws IOException{
        
        
        Boolean mark=false;
        String ss,ss2;
        ss=number.getText();
        ss2=password.getText();
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        if(mark==true) alert.setVisible(true);
        else
        {
            int y;
            y=Integer.parseInt(ss);
            Boolean flag=false;



             // DATABASE

                try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn=DriverManager.getConnection(
                                        "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                        Statement st = conn.createStatement();
                        ResultSet rset = st.executeQuery(
                                        "select park_number,vehicle_number from vehicle");
                        while(rset.next()){
                                int X;
                                X=rset.getInt(1);
                                String str,str2 = "";

                                str=rset.getString(2);
                                if(X==y){
                                    for(int i=0;i<str.length();i++)
                                    {
                                        if(str.charAt(i)>='0' && str.charAt(i)<='9')
                                        {
                                            str2+=str.charAt(i);
                                        }
                                    }
                                    int zz,pp;
                                    zz=Integer.parseInt(str2);
                                    pp=Integer.parseInt(password.getText());
                                    if(zz==pp) flag=true;
                                }


                        }
                    }
                    catch(Exception sqle){
                            System.out.println("SQL Exception 1: " +sqle);
                    }

                if(flag==true)
                {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkStatus.fxml"));
                    AnchorPane pane = loader.load();

                    ParkStatusController controller = loader.getController();
                    controller.seeInfo(y);

                    window.close();
                    Scene scene = new Scene(pane);
                    mainstage.setScene(scene);
                    mainstage.show();

                    System.out.println("You clicked me!");
                }
                else{
                    alert.setVisible(true);
                }
            
        }
        
        
    }
    
      @FXML
    private void passAction(ActionEvent event) throws IOException{
        
        
        Boolean mark=false;
        String ss,ss2;
        ss=number.getText();
        ss2=password.getText();
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        for(int i=0;i<ss.length();i++)
        {
            if(!(ss.charAt(i)>='0' && ss.charAt(i)<='9')) mark=true;
        }
        if(mark==true) alert.setVisible(true);
        else
        {
            int y;
            y=Integer.parseInt(ss);
            Boolean flag=false;



             // DATABASE

                try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn=DriverManager.getConnection(
                                        "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                        Statement st = conn.createStatement();
                        ResultSet rset = st.executeQuery(
                                        "select park_number,vehicle_number from vehicle");
                        while(rset.next()){
                                int X;
                                X=rset.getInt(1);
                                String str,str2 = "";

                                str=rset.getString(2);
                                if(X==y){
                                    for(int i=0;i<str.length();i++)
                                    {
                                        if(str.charAt(i)>='0' && str.charAt(i)<='9')
                                        {
                                            str2+=str.charAt(i);
                                        }
                                    }
                                    int zz,pp;
                                    zz=Integer.parseInt(str2);
                                    pp=Integer.parseInt(password.getText());
                                    if(zz==pp) flag=true;
                                }


                        }
                    }
                    catch(Exception sqle){
                            System.out.println("SQL Exception 1: " +sqle);
                    }

                if(flag==true)
                {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkStatus.fxml"));
                    AnchorPane pane = loader.load();

                    ParkStatusController controller = loader.getController();
                    controller.seeInfo(y);

                    window.close();
                    Scene scene = new Scene(pane);
                    mainstage.setScene(scene);
                    mainstage.show();

                    System.out.println("You clicked me!");
                }
                else{
                    alert.setVisible(true);
                }
            
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
