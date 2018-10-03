package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
    public static Stage window;
    public  static Scene mainscene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        Scene scene = new Scene(root,750,639);
        mainscene = scene;
        window.setScene(mainscene);
        window.initStyle(StageStyle.UNDECORATED);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
