package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.mainscene;
import static sample.Main.window;

public class Controller implements Initializable {

    @FXML
    private void cureitclicked (ActionEvent event) throws IOException
    {
        AnchorPane human = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Scene scene = new Scene(human,690,531);
        window.setScene(scene);
        window.show();

    }
    @FXML
    private void aboutclicked (ActionEvent event) throws IOException
    {
        AnchorPane aboutcontrol = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = new Scene(aboutcontrol,690,531);
        window.setScene(scene);
        window.show();

    }
    @FXML
    private void helpclicked (ActionEvent event) throws IOException
    {
        AnchorPane helpcontrol = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene scene = new Scene(helpcontrol,690,531);
        window.setScene(scene);
        window.show();

    }
    @FXML
    private void exitclicked (ActionEvent event) throws IOException
    {
        Stage closewin = new Stage();
        closewin.initStyle(StageStyle.UNDECORATED);
        closewin.initModality(Modality.APPLICATION_MODAL);
        closewin.setMinWidth(250);
        VBox cc = new VBox(10);
        Button yes,no;
        yes = new JFXButton("Yes");
        no = new JFXButton("No");
        yes.setOnAction(e -> {
            closewin.close();
            window.close();
        });
        no.setOnAction(e ->{
            closewin.close();
            window.setScene(mainscene);
            window.show();
        });
        Label quit = new Label("Are you sure you want to exit?");
        cc.getChildren().addAll(quit,yes,no);
        cc.setAlignment(Pos.CENTER);
        Scene exitscene = new Scene(cc);
        closewin.setScene(exitscene);
       // closewin.show();
        closewin.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}
