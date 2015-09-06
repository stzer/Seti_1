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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MikAnt on 05.09.2015.
 */
public class LoginController extends Pane{

    public LoginController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    Button goChat;
    @FXML
    TextField ip_enter;
    @FXML
    TextField name_enter;
    @FXML
    RadioButton create_button;
    @FXML
    RadioButton join_button;


    @FXML
    public void createChat(ActionEvent event) {
        if(true) {
            new Thread(new ServerStart()).start();
            ChatController chatController = new ChatController();
            Parent root;
            Stage stage = new Stage();
            stage.setTitle("Chat");
            stage.setScene(new Scene(chatController, 700, 500));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        else {
            ErrorController errorController = new ErrorController();
            Parent root;
            Stage stage = new Stage();
            stage.setTitle("Error!");
            stage.setScene(new Scene(errorController, 374, 123));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }
}
