package br.ifce.ppd.rmi.control;

/**
 * Classe: ClienteItf.java
 * Define a inteface do Cliente
 * @author Tiago Malveira
 * 
 */

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author malveira
 */
public interface ClienteItf extends Remote{
    //Faz o download de um arquivo
    byte[] downloadArquivo(String nomeArquivo) throws RemoteException; 
    //Lista os arquivos do usuário
    List<File> listarArquivos() throws RemoteException;
}
