package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import javax.xml.soap.Text;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by MikAnt on 05.09.2015.
 */

public class ChatController extends Pane {
    boolean isWork = false;
    final ObservableList<String> listItems = FXCollections.observableArrayList();

    BufferedReader reader;
    PrintWriter client;
    Socket sock;
    int port;

    public ChatController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chat_client.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {

            fxmlLoader.load();
            connectToServer(new Socket("localhost", 8701));

            chatDisplay.setItems(listItems);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    ListView<String> chatDisplay;

    private void connectToServer(Socket clientSock) {
        try {
            sock = clientSock;
            port = sock.getPort();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadItems(final ObservableList<String> listItems) {
        isWork = !isWork;
        Task listLoader = new Task() {
            {
                setOnSucceeded(workerStateEvent -> {
                });

                setOnFailed(workerStateEvent -> getException().printStackTrace());
            }

            @Override
            protected Void call() {
                while (isWork) {
                    InputStreamReader IR = null;
                    try {
                        IR = new InputStreamReader(sock.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader BR = new BufferedReader(IR);
                    String MESSAGE = null;
                    try {
                        MESSAGE = BR.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    listItems.add(MESSAGE);
                    if (MESSAGE != null) {
                        PrintStream PS = null;
                        try {
                            PS = new PrintStream(sock.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        PS.println("CONNECTION SET");
                    }

                }
                return null;
            }
        };

    }
}
