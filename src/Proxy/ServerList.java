/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe que vai ser responsável para ler o arquivo de servidores e retornar O
 * arquivo consiste de duas colunas o a primeira é o nome do servidor e a
 * segunda seu endereço IP. armazenar os IPs dos mesmo.
 *
 * @author wilker
 */
class ServerList extends readFromFile {

    public ServerList() {
        fileName = "servers";
    }

    /**
     * Retorna o endereço IP do servidor de nome recebido como parâmetro
     *
     * @param nameServer
     * @return
     */
    String getIpServer(String nameServer) {
        this.readServersFromFile();
        for (String string : servers.keySet()) {
            if (string.equals(nameServer)) {
                return servers.get(string);
            }
        }
        return defaultServer;
    }

    @Override
    void setDefaultServer(String defaultServer) {
        this.defaultServer = defaultServer;
    }

}
