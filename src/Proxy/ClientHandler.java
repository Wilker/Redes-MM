/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.net.Socket;


/**
 *
 * @author midiacom
 */
class ClientHandler implements Runnable {

    private String ipIC;
    Socket client;
    String originIP;
    

    //TODO lê de um arquivo de configuração os endereços IP's dos servidores a serem utilizados.
    //Se vier de dentro da rede do IC mandar pra um servidor. Se vier de outra rede mandar pra outro.
    public ClientHandler(Socket clientSocket) {
        client = clientSocket;
    }

    @Override
    public void run() {
        //TODO implementar a classe que vai lidar com a requisição dos clientes
        ServerList serverList = new ServerList();
        ClientRedir clientRedir = new ClientRedir();
        originIP = client.getInetAddress().getHostAddress();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
