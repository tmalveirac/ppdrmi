/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

/**
 *
 * @author malveira
 */
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

public class Registrador {
    public static void main(String args[]) {

        try{
            LocateRegistry.createRegistry( 1099 ); //iniciar servidor de nomes Executando registry não funcionou
            Servidor obj = new Servidor ();
            Naming.rebind("InverterRef",obj);
            System.out.println("Servidor Registrado!");
        } 
        catch (Exception e){ 
            System.out.println("Erro");
        }
    }
}
