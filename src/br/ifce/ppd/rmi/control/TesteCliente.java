/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author malveira
 */

public class TesteCliente {
    public static void main(String[] args) throws RemoteException, IOException{
        Cliente c = new Cliente("kelly");
        
        for (;;){
            System.out.print("Digite a Frase:");
            BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));
            String line = r.readLine();
            
            switch (line) {
                case "l":
                    List<String> logins = c.listaLogins();
                    for (String s : logins){
                        System.err.println(s + ",");
                    }
                    break;
                    
                case "d":
                    c.desconectar();
                    break;
                    
                default:
                    String retorno = c.inverterMensagem(line);
                    System.out.println("Frase Invertida = " + retorno);
            }       
        }
    }
}
