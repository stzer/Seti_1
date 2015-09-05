package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by MikAnt on 05.09.2015.
 */
public class ChatController extends Pane{
    public ChatController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chat_client.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
