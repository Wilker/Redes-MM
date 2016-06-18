/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.util.Map;
import java.util.Set;

/**
 * Classe que vai tratar o redirecionamento dos clientes com base em arquivo.
 * Ela vai ler do arquivo e armazenar uma lista de onde e para qual servidor
 * será redirecionado.
 *
 * @author wilker
 */
public class ClientRedir extends readFromFile {

    public ClientRedir() {
        this.fileName = "clientToServer";
    }

    /**
     * Lê o ip de origem recebido, busca na lista de redirecionamento aquele ip
     * caso esteja na lista, retorna o nome do servidor para qual será
     * redirecionado caso não esteja, retorna o servidor padrão.
     *
     * @param nameServer
     * @return
     */
    String getIpRedir(String nameServer) {
        this.readServersFromFile();
        //Posso retirar esse default daqui pois já está logo após a intanciação da classe
        //setDefaultServer(defaultServer);
        for (String string : servers.keySet()) {
            if (string.equals(nameServer)) {
                return servers.get(string);
            }
        }
        return defaultServer;
    }

    @Override
    void setDefaultServer(String defaultServer) {
        this.defaultServer = "default";
    }
}
