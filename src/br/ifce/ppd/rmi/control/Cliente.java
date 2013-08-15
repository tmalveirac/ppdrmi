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
import java.util.List;

public class Cliente extends UnicastRemoteObject implements ClienteItf {
    
    private InverterItf servidor;
    private String login;
    
    
    public Cliente (String login) throws RemoteException{
        
        try {
            servidor = (InverterItf)Naming.lookup("//localhost/InverterRef");
            System.out.println("Objeto Localizado!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        try {
            Naming.rebind(login,this);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        servidor.conectar(login);
        
    }

    public InverterItf getServidor() {
        return servidor;
    }

    public void setServidor(InverterItf servidor) {
        this.servidor = servidor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    public String inverterMensagem(String s) throws RemoteException{
        return servidor.inverter(s);
    }
    
    public List<String> listaLogins() throws RemoteException{
        return servidor.listarLogins();
    }
    
    public void desconectar() throws RemoteException{
        servidor.desconectar(this.login);
    }
}