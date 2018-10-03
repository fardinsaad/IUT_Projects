/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// PARK VEHICLE PAGE


package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javafxapplication5.FXMLDocumentController.window;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;
import jdk.nashorn.internal.parser.TokenType;


/**
 * FXML Controller class
 *
 * @author User
 */
public class FXML_2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
     TextField t1,t2,t3;
     @FXML
     Label alert,infoLabel,alert1;
     @FXML
     CheckBox cBox1,cBox2;
     @FXML
     Button carMap;
     
    public ChoiceBox<String> choice = new ChoiceBox<>();
    public ChoiceBox<String> choice1 = new ChoiceBox<>();
     public String ss1 = new String();
     public String ss2 = new String();
     Button parkButton = new Button();
     
     @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
       
        mainstage.setScene(pubScene);
        mainstage.show();
        System.out.println("You clicked me!");

    }
    @FXML
    private void hideLabel(){
        alert.setVisible(false);
        alert1.setVisible(false);
    }
    
    @FXML
    private void noBox(ActionEvent event) throws IOException{
       
        t3.setVisible(false);
        t3.clear();
        infoLabel.setVisible(false);
        carMap.setVisible(false);
        cBox1.setSelected(false);
        cBox2.setSelected(true);
    }
     @FXML
    private void yesBox(ActionEvent event) throws IOException{
       
        t3.setVisible(true);
        infoLabel.setVisible(true);
        carMap.setVisible(true);
        cBox2.setSelected(false);
        cBox1.setSelected(true);
    }
    
    // Show parking area
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
   
    // Going to show parking status
    
    @FXML
    private void goPark(ActionEvent event) throws IOException, InterruptedException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkStatus.fxml"));
        AnchorPane pane = loader.load();
        String state,letter,name,num,park_num;
        state=choice.getValue();
        letter=choice1.getValue();
        System.out.println(state + " " + letter);
        name = t1.getText();
        num = t2.getText();
        park_num=t3.getText();
        boolean flag = false;
        if(name.isEmpty()==true) flag=true;
        if(num.isEmpty()==true) flag=true;
        if(park_num.isEmpty()==false){
            for(int i=0;i<park_num.length();i++ )
            {
                if((park_num.charAt(i)<='0' && park_num.charAt(i)>='9')) flag=true;
            }
            if(flag==false)
            {
                int slot;
                slot=Integer.parseInt(park_num);
                if(letter=="Gha" && (slot<16 || slot>25)){
                    flag=true;
                }
                if(letter=="La" && (slot<26 || slot>35)){
                    flag=true;
                }
                if(letter=="Ha" && (slot<26 || slot>35)){
                    flag=true;
                }
                if(letter=="Ka")
                {
                    if(slot<1 || slot>15) flag=true;
                }
                if(letter=="Kha")
                {
                    if(slot<1 || slot>15) flag=true;
                }
                if(letter=="Ga")
                {
                    if(slot<1 || slot>15) flag=true;
                }
            }
            
        }
        for(int i=0;i<name.length();i++)
        {
            if(name.charAt(i)>='0' && name.charAt(i)<='9') flag=true;
        }
        for(int i=0;i<num.length();i++ )
        {
            if(!(num.charAt(i)>='0' && num.charAt(i)<='9')) flag=true;
        }
        if(flag==true){
            alert.setVisible(true);
            
        }
        else{
            boolean[] cars = new boolean[40];
            boolean mark=false;
            // DATABASE
        
         try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                Statement st = conn.createStatement();

                ResultSet rset = st.executeQuery(
                                "select park_number from vehicle");
                while(rset.next()){
                        int X;
                        X=rset.getInt(1);
                       cars[X]=true;
                               
                                 
                }
            }
            catch(Exception sqle){
			System.out.println("SQL Exception 1: " +sqle);
            }
         
            if(letter=="Gha")
            {
                for(int i=16;i<=25;i++)
                {
                    if(cars[i]==false)
                    {
                        mark=true;
                        break;
                    }
                }
            }
            else if(letter=="La" || letter=="Ha")
            {
                for(int i=26;i<=35;i++)
                {
                    if(cars[i]==false)
                    {
                        mark=true;
                        break;
                    }
                }
            }
            else
            {
                for(int i=1;i<=15;i++)
                {
                    if(cars[i]==false)
                    {
                        System.out.println("mark "+i);
                        mark=true;
                        break;
                    }
                }
            }
            if(mark==true)
            {
                ParkStatusController controller = loader.getController();
                controller.writeit(t1.getText(),state, letter,t2.getText(),t3.getText());

                Scene scene=new Scene(pane);
                mainstage.setScene(scene);
                mainstage.show();
            }
            else
            {
                alert1.setVisible(true);
            }
            
        }
        
        
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choice.getItems().addAll("Dhaka Metro","Chottro Metro","Sylhet Metro");
        choice1.getItems().addAll("Ka","Kha","Ga","Gha","La","Ha");
        cBox2.setSelected(true);
    }   

}
