package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MikAnt on 06.09.2015.
 */
public class ServerStart implements Runnable {
    @Override
    public void run() {
        ServerSocket serverSock = null;
        try {
            serverSock = new ServerSocket(8700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true)
        {
            Socket clientSock = null;
            try {
                clientSock = serverSock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread listener = new Thread(new ServerThread(clientSock));
            listener.start();
        }
    }
}
