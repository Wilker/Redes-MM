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
public class ServerProxy implements Runnable {

	private ServerSocket servidorSocket;
	private int SERVER_PORT = 9999;
	

	

	@Override
	public void run() {
		try {
			servidorSocket = new ServerSocket(SERVER_PORT);
                        System.out.println("Proxy server listening on "+" port:\n");
			while (true) {
				Socket clientSocket = servidorSocket.accept();
                                System.out.println("Client connected from " +clientSocket.getInetAddress()+"\n");
				//new Thread(new ClienteProcessamento(clientSocket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
