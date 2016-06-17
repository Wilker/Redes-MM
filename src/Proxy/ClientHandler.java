/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author midiacom
 */
class ClientHandler implements Runnable {

    private String ipIC;
    Socket client;
    String originIP;
    String destName;
    String destIP;

    //TODO lê de um arquivo de configuração os endereços IP's dos servidores a serem utilizados.
    //Se vier de dentro da rede do IC mandar pra um servidor. Se vier de outra rede mandar pra outro.
    public ClientHandler(Socket clientSocket) {
        client = clientSocket;
    }

    @Override
    public void run() {
        /*
        Fluxo a seguir -> Cliente Conecta, são carregadas as listas dos endereços 
        dos servidores, será extraído o ip do cliente, feita uma verificação para onde 
        deverá se redirecionado, retornar o ip para onde irá ser feita a conexão.
         */
        //TODO implementar a classe que vai lidar com a requisição dos clientes

        ClientRedir clientRedir = new ClientRedir();
        ServerList serverList = new ServerList();
        originIP = client.getInetAddress().getHostAddress();

        /*
        Primeiro, verificar que tipo de redirecionamento devo fazer.
        Se para o servidor padrão ou para algum específico.
         */
        destName = clientRedir.getIpRedir(originIP);

        /*
        De posse do nome do servidor de destino
        Buscar seu endereço IP
         */
        destIP = serverList.getIpServer(destName);

        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeBytes(destIP + "\n");
        } catch (IOException ex) {
            System.out.println("Erro na conexão ao servidor");
        }

    }

}
