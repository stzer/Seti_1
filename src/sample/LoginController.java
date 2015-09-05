package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void createChat(ActionEvent event) {
        ChatController chatController=new ChatController();
        Parent root;
        Stage stage = new Stage();
        stage.setTitle("Чачт");
        stage.setScene(new Scene(chatController, 700, 500));
        stage.setResizable(false);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
