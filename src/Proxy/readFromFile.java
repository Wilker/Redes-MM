/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * SuperClasse que trata da abertura e leitura do arquivo e carrega os dados do
 * no hashmap se o nome do servidor for default, ele é adicionado como servidor
 * padrão das requisições.
 *
 * @author wilker
 */
abstract class readFromFile {

    Scanner in;
    String filePath;
    String fileName;
    String defaultServer;
    Map<String, String> servers = new HashMap<String, String>();

    void readServersFromFile() {
        try {
            filePath = System.getProperty("user.dir").concat("/" + fileName);
            in = new Scanner(new File(filePath));
            do {
                String s = in.nextLine();
                if (!(s.charAt(0) == '#')) {
                    String[] tmp = s.split(" ");
                    if (tmp[0].equals("default")) {
                        setDefaultServer(tmp[1]);
                    } else {
                        servers.put(tmp[0], tmp[1]);
                    }
                }
            } while (in.hasNextLine());

        } catch (FileNotFoundException ex) {
            System.out.println("Server List file not found");
        }catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Arquivo com linhas branco não são permitidos");
        }
    }

    abstract void setDefaultServer(String defaultServer);
}
