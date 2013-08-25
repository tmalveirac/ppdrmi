/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

import br.ifce.ppd.rmi.utils.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author malveira
 */
public interface InverterItf extends Remote {
    String inverter(String msg) throws RemoteException;
    
    void conectar(String login) throws RemoteException;
    void desconectar(String login) throws RemoteException;
    
    boolean existeLogin(String login) throws RemoteException;
            
    void atualizarPasta(String login) throws RemoteException;
    
    byte[] downloadArquivo(String nomeArquivo) throws RemoteException;
               
    
    List<Usuario> listarUsuarios() throws RemoteException;
}
