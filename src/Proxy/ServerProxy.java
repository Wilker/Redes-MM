/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author midiacom
 */
public class ServerProxy {

    private ServerSocket servidorSocket;
    private final int SERVER_PORT = 9875;

    public void startServer() {
        try {
            servidorSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Proxy server listening on port:" + SERVER_PORT + " \n");
            while (true) {
                Socket clientSocket = servidorSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress() + "\n");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
