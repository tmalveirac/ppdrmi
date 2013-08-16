/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author malveira
 */
public interface ClienteItf extends Remote{
    
    byte[] downloadArquivo(String nomeArquivo) throws RemoteException; 
    List<String> listarArquivos() throws RemoteException;
    
}
