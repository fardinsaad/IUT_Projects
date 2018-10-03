
// PARK STATUS PAGE


package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javafxapplication5.FXMLDocumentController.window;
import static javafxapplication5.JavaFXApplication5.mainstage;
import static javafxapplication5.JavaFXApplication5.pubScene;


public class ParkStatusController implements Initializable {

    
    @FXML
      TextField t3,t4,t5,t6,t7,t8;
    boolean[] parkAra = new boolean[40];
    private void callDatabase(){
        
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
                       parkAra[X]=true;
                               
                                 
                }
            }
            catch(Exception sqle){
			System.out.println("SQL Exception 1: " +sqle);
            }
         
        
    }
     public void writeit(String ss1,String ss2,String ss3,String ss4,String ss5){
        System.out.println(ss2+" hello "+ss3);
        t3.setText(ss1);
        t4.setText(ss2+" "+ss3+" "+ss4);
        
        if(ss3=="La" || ss3=="Ha") t5.setText("MotorBike");
      
        else if(ss3=="Gha") t5.setText("SUV");
  
        else t5.setText("Sedan");
        
        // Park Number Allocation
        int x = 0;
        callDatabase();
        if(ss5.isEmpty()==true)
        {
           
            if(ss3=="La" || ss3=="Ha") 
            {
               for(int i=26;i<=35;i++){
                    if(parkAra[i]==false){
                        x=i;
                        break;
                    }
                }
            }
     
            else if(ss3=="Gha")
            {
                for(int i=16;i<=25;i++){
                    if(parkAra[i]==false){
                        x=i;
                        break;
                    }
                }
            }
        

            else 
            {
               for(int i=1;i<=15;i++){
                    if(parkAra[i]==false){
                        x=i;
                        break;
                    }
                }
            }
            
        }
        else
        {
           int val;
           int aa = 1000,bb = 1000;
           val=Integer.parseInt(ss5);
           
           if(ss3=="La" || ss3=="Ha")
           {
               for(int i=val;i<=35;i++){
                    if(parkAra[i]==false){
                        aa=i;
                        break;
                    }
                }
                for(int i=val;i>=26;i--){
                    if(parkAra[i]==false){
                        bb=i;
                        break;
                    }
                }
           }
      
            else if(ss3=="Gha")
            {
                for(int i=val;i<=25;i++){
                    if(parkAra[i]==false){
                        aa=i;
                        break;
                    }
                }
                for(int i=val;i>=16;i--){
                    if(parkAra[i]==false){
                        bb=i;
                        break;
                    }
                }
            }

            else
            {
                for(int i=val;i<=15;i++){
                    if(parkAra[i]==false){
                        aa=i;
                        break;
                    }
                }
                for(int i=val;i>=1;i--){
                    if(parkAra[i]==false){
                        bb=i;
                        break;
                    }
                }
            }
          
           int ans1,ans2;
           ans1=Math.abs(val-aa);
           ans2=Math.abs(val-bb);
           if(ans1<=ans2){
               x=aa;
           }
           else x=bb;
        }
        
        String park_numb,park_timeString,park_billString;
        park_numb = Integer.toString(x);
        t6.setText(park_numb);
        
        // Time
        Random rn2 = new Random();
        int y = rn2.nextInt()%500;
        y=(y+500)%500;
        
        // Bills
        double z;
        if(ss3=="La" || ss3=="Ha") z=y*0.2;
        else if(ss3=="Gha") z=y*0.4;
        else z=y*0.3;
        t7.setText(Integer.toString(y));
        t8.setText(Double.toString(z));
      
        // DATABASE
        
        try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                Statement st = conn.createStatement();

                    String query = new String();
                    String query2 = new String();
                    query = "insert into vehicle values("+String.valueOf(x)+",'"+ss1+"','"
                            +ss2+" "+ss3+" "+ss4+"','"+t5.getText()+"',"+String.valueOf(y)
                            +","+String.valueOf(z)+")";
                    System.out.println(query);
                    
                     query2= "insert into vehicle_archive values("+String.valueOf(x)+",'"+ss1+"','"
                            +ss2+" "+ss3+" "+ss4+"','"+t5.getText()+"',"+String.valueOf(y)
                            +","+String.valueOf(z)+")";
                    st.executeUpdate(query);
                    st.executeUpdate(query2);

            }

            catch(Exception sqle){
                    System.out.println("SQL Exception 1: " +sqle);
            }
        
    } 
     
     int x,y;
     public void seeInfo(int pNum){
         
         // DATABASE
        
            try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn=DriverManager.getConnection(
                                    "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                    Statement st = conn.createStatement();
                    ResultSet rset = st.executeQuery(
                                    "select * from vehicle where park_number="+String.valueOf(pNum));
                    while(rset.next()){
                            
                            Double z;
                            x=rset.getInt(1);
                            y=rset.getInt(5);
                            z=rset.getDouble(6);
                            t6.setText(String.valueOf(x));
                            t7.setText(String.valueOf(y));
                            t8.setText(String.valueOf(z));
                            t3.setText(rset.getString(2));
                            t4.setText(rset.getString(3));
                            t5.setText(rset.getString(4));
                            


                    }
		}
		catch(Exception sqle){
			System.out.println("SQL Exception 1: " +sqle);
		}
            
     }
     
     @FXML
    private void leaveParking(ActionEvent event) throws IOException {
        
         // DATABASE
        
        try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe","saadmanmalik","guitar22");
                Statement st = conn.createStatement();
                try{
                        String query = new String();
                        query = "delete from vehicle where park_number="+String.valueOf(x);
                        System.out.println(query);
                        st.executeUpdate(query);

                }
                catch(Exception sqle){
                        System.out.println("Could not insert tuple" +sqle);

                }

            }
        catch(Exception sqle){
                System.out.println("SQL Exception 1: " +sqle);
        }
        mainstage.setScene(pubScene);
        mainstage.show();
        System.out.println("You clicked me!");
        
        
    }
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        
        mainstage.setScene(pubScene);
        mainstage.show();
        System.out.println("You clicked me!");
        
    }
    
    @FXML
    private void showParking(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ParkArea.fxml"));
        AnchorPane pane = loader.load();
        
        ParkAreaController controller = loader.getController();
        controller.changeColour();
        
        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
