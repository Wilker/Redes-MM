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
	private JTextPane console = null;

	ServerProxy(JTextPane console) {
		this.console = console;
	}


	@Override
	public void run() {
		try {
			servidorSocket = new ServerSocket(SERVER_PORT);
			console.setText(console.getText() + "Servidor iniciado.\r\nEsperando por clientes...");
			while (true) {
				Socket clienteSocket = servidorSocket.accept();
				console.setText(console.getText() + "\r\n" + "Conexão aceita do endereço "
						+ clienteSocket.getLocalAddress().getHostAddress());
				//new Thread(new ClienteProcessamento(clienteSocket, console)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
