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
import java.util.ArrayList;
import java.util.List;

public class Servidor extends UnicastRemoteObject implements InverterItf {
    
    // Vetor que armazena os usuários ativos em uma sessão
    private static List<ClienteItf> listaClienteItf = new ArrayList<ClienteItf>();
    private static List<String> listaLogin =  new ArrayList<String>();
    
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

    @Override
    public void conectar(String login) throws RemoteException {
        try {
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            listaClienteItf.add(c);
            listaLogin.add(login);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void desconectar(String login) throws RemoteException {
        try {
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            if (listaClienteItf.remove(c)) {
                System.err.println("Removeu objeto Cliente da lista");
            }
            listaLogin.remove(indiceByLogin(login));
            Naming.unbind("//localhost/" + login);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        System.err.println("Cliente: " + login + "Desconectado");
       
    }

    @Override
    public List<String> listarLogins() throws RemoteException {   
       return listaLogin;
    }
    
    
    public static int indiceByLogin (String login){		
	int indice = -1;	
        for (String s : listaLogin){
            indice++;
            if (s.equals(login)){
                    return indice;
            }
        }		
        return indice;		
    }
    
}
