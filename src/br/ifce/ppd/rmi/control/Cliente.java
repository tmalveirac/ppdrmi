/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

/**
 *
 * @author malveira
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
        
        this.login=login;
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

    @Override
    public byte[] downloadArquivo(String nomeArquivo) throws RemoteException {
        try{

    	    File file = new File(nomeArquivo);
            InputStream inStream;  
    	    inStream = new FileInputStream(file);
    	     
    	    byte[] buffer;
            buffer = new byte[ (int) file.length() ];

            inStream.read(buffer, 0, buffer.length);          
            inStream.close();
            
            return buffer;
    	}catch(IOException e){
    	    e.printStackTrace();
            return null;
    	}
    }

    @Override
    public List<String> listarArquivos() {
        File file = new File("/home/malveira/teste/destino");
        List<String> listaArquivo = new ArrayList<String>();

        for (File f : file.listFiles()){
            listaArquivo.add(f.getName());
        }
        
        return listaArquivo;
    }
    
}