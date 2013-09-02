package br.ifce.ppd.rmi.control;

/**
 * Classe: Servidor.java
 * Implementa o lado servidor da aplicação
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.rmi.utils.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends UnicastRemoteObject implements ServidorItf {
    
    // Vetor que armazena os usuários ativos em uma sessão
    private static List<ClienteItf> listaClienteItf = new ArrayList<ClienteItf>();
    private static List<Usuario> listUsuario = new ArrayList<Usuario>();
    
    public Servidor() throws RemoteException{
        super();
        System.out.println("Servidor criado!");
    }   


    /**
    * Conecta um usuário
    *             
    * @param    login   login do cliente
    * @return   void   
    */
    @Override
    public void conectar(String login) throws RemoteException {
        try {
            //Consulta o usuário no servidor de nomes
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            listaClienteItf.add(c);
            
            Usuario u = new Usuario();
            u.setLogin(login);
            List<File> listaArquivo = new ArrayList<File>();
            
            //Obtém a lista de arquivos do usuário
            for (File s : c.listarArquivos()){
                System.err.println(s.getName()+",");
                listaArquivo.add(s);
            }
            
            u.setListaArquivo(listaArquivo);
            listUsuario.add(u);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Desconecta um cliente
    *             
    * @param    login   login do cliente
    * @return   void   
    */
    @Override
    public void desconectar(String login) throws RemoteException {
        try {
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            if (listaClienteItf.remove(c)) {
                System.err.println("Removeu objeto Cliente da lista");
            }
            
            listUsuario.remove(indiceByLogin(login));
            Naming.unbind("//localhost/" + login);
        
        } catch (Exception e) {
            e.printStackTrace();
        }   
        System.err.println("Cliente: " + login + "Desconectado");
    }

    /**
    * Lista todos os usuário da aplicação
    *             
    * @return   void   
    */
    @Override
    public List<Usuario> listarUsuarios() throws RemoteException {   
       return listUsuario;
    }
    
    /**
    * Determina o índice do usuário na lista
    *             
    * @param    login   login do cliente
    * @return   void   
    */
    public static int indiceByLogin (String login){		
	int indice = -1;	
        for (Usuario u : listUsuario){
            indice++;
            if (u.getLogin().equals(login)){
                    return indice;
            }
        }		
        return indice;		
    }

    /**
    * Atualiza a pasta de um usuário
    *             
    * @param    login   login do cliente
    * @return   void   
    */
    @Override
    public void atualizarPasta(String login) throws RemoteException {
        try {
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            listUsuario.get(indiceByLogin(login)).setListaArquivo(c.listarArquivos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Verifica se um login já existe na lista de usuários
    *             
    * @param    login       loging do cliente
    * @return   boolean     true, se existe. False, caso contrário
    */
    @Override
    public boolean existeLogin(String login) throws RemoteException {
        for (Usuario u : listUsuario){
            if(u.getLogin().equals(login)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
