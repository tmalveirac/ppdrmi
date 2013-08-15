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
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements InverterItf {
    public Servidor() throws RemoteException{
        super();
        System.out.println("Servidor criado!");
    }   

    @Override
    public String inverter(String msg) throws RemoteException {
        StringBuffer strbuf = new StringBuffer(msg);
        System.out.println("Recebido: "+msg);
        String retorno = (strbuf.reverse()).toString();
        return retorno;
    }
}
