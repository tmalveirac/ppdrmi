package br.ifce.ppd.rmi.control;

/**
 * Classe: ServidorItf.java
 * Define a interface do Servidor
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.rmi.utils.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServidorItf extends Remote {
    //Conecta um cliente
    void conectar(String login) throws RemoteException;
    //Desconecta um cliente
    void desconectar(String login) throws RemoteException;
    //Verifica se já existe um login
    boolean existeLogin(String login) throws RemoteException;
    //Atualiza pasta do usuário
    void atualizarPasta(String login) throws RemoteException;
    //Lista usuários conectados
    List<Usuario> listarUsuarios() throws RemoteException;
}
