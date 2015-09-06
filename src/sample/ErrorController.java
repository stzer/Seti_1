package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

/**
 * Created by MikAnt on 06.09.2015.
 */
public class ErrorController extends Pane {
    public ErrorController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    Button ok_error_button;

    @FXML
    public void closeErrorMessage(ActionEvent event){
        LoginController loginController=new LoginController();
        Stage stage = new Stage();
        stage.setScene(new Scene(loginController));
        stage.setTitle("Sign in");
        stage.setWidth(359);
        stage.setHeight(290);
        stage.setResizable(false);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}