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
import javax.swing.JOptionPane;

public class Cliente extends UnicastRemoteObject implements ClienteItf {
    
    private InverterItf servidor;
    private String login;
    private String nomeServidor;
    private File pasta;
    
    
    public Cliente (String login, String nomeServidor, File pasta) throws RemoteException{
        
        try {
            //servidor = (InverterItf)Naming.lookup("//localhost/InverterRef");
            servidor = (InverterItf)Naming.lookup("//"+nomeServidor);
            System.out.println("Objeto Localizado!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        try {
            if (!servidor.existeLogin(login)){
                Naming.rebind(login,this); 
            }
            else{
                JOptionPane.showMessageDialog(null,	"Já existe um usuário com este login conectado! Reinicie o programa!",
					"Atenção", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
                             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.pasta=pasta;
        this.nomeServidor=nomeServidor;
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

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public File getPasta() {
        return pasta;
    }

    public void setPasta(File pasta) {
        this.pasta = pasta;
    }
    
    
    public void desconectar() throws RemoteException{
        servidor.desconectar(this.login);
    }

    @Override
    public byte[] downloadArquivo(String nomeArquivo) throws RemoteException {
        try{

    	    File file = new File(this.pasta.getPath()+"/"+nomeArquivo);
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
    public List<File> listarArquivos() throws RemoteException {
        //File file = new File("/home/malveira/teste/destino");
        List<File> listaArquivo = new ArrayList<File>();

        for (File f : pasta.listFiles()){
            if (!f.isDirectory()){
                listaArquivo.add(f);
            }
        }
        
        return listaArquivo;
    }
    
    
    public byte[] downloadArquivoOutroUsuario(String login, String nomeArquivo) throws RemoteException{
        try{
            String campos[] = this.nomeServidor.split("/"); //Extrair endereço do servidor
            
    	    ClienteItf clienteItf = (ClienteItf) Naming.lookup("//"+campos[0]+"/"+login); 
            return clienteItf.downloadArquivo(nomeArquivo);
            
    	}catch(Exception e){
    	    e.printStackTrace();
            return null;
    	}
    }
    
}