package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MikAnt on 06.09.2015.
 */
public class ServerThread implements Runnable {
    BufferedReader reader;
    PrintWriter client;
    Socket sock;
    int port;
    public ServerThread(Socket clientSock) {
            try
            {
                sock = clientSock;
                port=sock.getPort();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

    }

    @Override
    public void run() {

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
            //System.out.println(MESSAGE);
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
}
