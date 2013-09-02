package br.ifce.ppd.rmi.control;

/**
 * Classe: Regostrador.java
 * Instancia o servidor da aplicação
 * @author Tiago Malveira
 * 
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Registrador {
    public static void main(String args[]) {
        try{
            LocateRegistry.createRegistry( 1099 ); //iniciar servidor de nomes Executando registry não funcionou
            Servidor obj = new Servidor ();
            Naming.rebind("ServidorRef",obj);
            System.out.println("Servidor Registrado!");
        } 
        catch (Exception e){ 
            System.out.println("Erro");
            e.printStackTrace();
        }
    }
}
