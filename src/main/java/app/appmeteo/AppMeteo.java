package app.appmeteo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AppMeteo extends Application {

    @FXML private Label label;
    @FXML private TextField citytxt;
    @FXML private TextField output;

    @FXML private Button button;



    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/app/appmeteo/view/appmeteo.fxml"));
        stage.setTitle("météo");
        stage.setScene(new Scene(root, 954, 638));
        stage.setResizable(false);


        stage.show();


        //Setting the stage


    }

    public static  void main(String[] args) {
        launch(args);






    }






}
