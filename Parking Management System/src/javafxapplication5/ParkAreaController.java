

// PARKING AREA PAGE


package javafxapplication5;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;
import static javafx.beans.binding.Bindings.or;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static javafxapplication5.FXMLDocumentController.window;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;



public class ParkAreaController implements Initializable {

  
    
    @FXML
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35;
    
   
    Button[] araButton = new Button[40];
    
    
    
    public void changeColour(){

        // Vehicle Slot Allocation
        
        araButton[1]=b1;
        araButton[2]=b2;
        araButton[3]=b3;
        araButton[4]=b4;
        araButton[5]=b5;
        araButton[6]=b6;
        araButton[7]=b7;
        araButton[8]=b8;
        araButton[9]=b9;
        araButton[10]=b10;
        araButton[11]=b11;
        araButton[12]=b12;
        araButton[13]=b13;
        araButton[14]=b14;
        araButton[15]=b15;
        araButton[16]=b16;
        araButton[17]=b17;
        araButton[18]=b18;
        araButton[19]=b19;
        araButton[20]=b20;
        araButton[21]=b21;
        araButton[22]=b22;
        araButton[23]=b23;
        araButton[24]=b24;
        araButton[25]=b25;
        araButton[26]=b26;
        araButton[27]=b27;
        araButton[28]=b28;
        araButton[29]=b29;
        araButton[30]=b30;
        araButton[31]=b31;
        araButton[32]=b32;
        araButton[33]=b33;
        araButton[34]=b34;
        araButton[35]=b35;
        
        
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
                       araButton[X].setStyle("-fx-background-color: #FF0000");
                               
                                 
                }
            }
            catch(Exception sqle){
			System.out.println("SQL Exception 1: " +sqle);
            }
    }
    
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        
        window.close();
//        mainstage.setScene(pubScene);
//        mainstage.show();
//        System.out.println("You clicked me!");
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
}
