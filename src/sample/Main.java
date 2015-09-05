package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {





    @Override
    public void start(Stage stage) throws Exception{
        LoginController loginController=new LoginController();
        stage.setScene(new Scene(loginController));
        stage.setTitle("Авторизация");
        stage.setWidth(359);
        stage.setHeight(290);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
