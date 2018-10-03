package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.window;

public class humanbodycontroller implements Initializable{

    static String orgname;


    @FXML
    private void liverclicked() throws IOException
    {
        orgname = "liver";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void stomachclicked() throws IOException
    {
        orgname = "stomach";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void brainclicked() throws IOException
    {
        orgname = "brain";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void lungsclicked() throws IOException
    {
        orgname = "lungs";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void heartclicked() throws IOException
    {
        orgname = "heart";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void kidneyclicked() throws IOException
    {
        orgname = "kidney";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void skinclicked() throws IOException
    {
        orgname = "skin";
        AnchorPane organcontrol = FXMLLoader.load(getClass().getResource("organ.fxml"));
        Scene scene = new Scene(organcontrol,690,531);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void back() throws IOException
    {
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
    }


}

