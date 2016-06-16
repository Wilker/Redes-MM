/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que vai ser responsável para ler o arquivo de servidores e retornar
 * armazenar os IPs dos mesmo. Melhorar o nome dessa classe.
 *
 * @author wilker
 */
class ServerList {

    Scanner in;
    String filePath;
    List<String> servers = new ArrayList<String>();

    public ServerList(String filePath) {
        this.filePath = filePath;
    }

    private void readServersFromFile() {
        try {
            filePath = System.getProperty("user.dir");
            in = new Scanner(new File(filePath));
            do {
                String s = in.nextLine();
                if (!(s.charAt(0) == '#')) {
                    servers.add(s);
                }
            } while (in.hasNextLine());

        } catch (FileNotFoundException ex) {
            System.out.println("Server List file not found\n");

        }
    }
}
