package br.ifce.ppd.rmi.control;

/**
 * Classe: Servidor.java
 * Implementa o lado servidor da aplicação
 * @author Tiago Malveira
 * 
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
    
    private ServidorItf servidor;
    private String login;
    private String nomeServidor;
    private File pasta;
        
    public Cliente (String login, String nomeServidor, File pasta) throws Exception{
        servidor = (ServidorItf)Naming.lookup("//"+nomeServidor);
        System.out.println("Objeto Localizado!");

        if (!servidor.existeLogin(login)){
            Naming.rebind(login,this); 
        }
        else{
            JOptionPane.showMessageDialog(null,	"Já existe um usuário com este login conectado! Reinicie o programa!",
                                    "Atenção", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
                             
        this.pasta=pasta;
        this.nomeServidor=nomeServidor;
        this.login=login;
        servidor.conectar(login);       
    }

    public ServidorItf getServidor() {
        return servidor;
    }

    public void setServidor(ServidorItf servidor) {
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
   
    /**
    * Faz um download de um arquivo
    *             
    * @param    nomeArquivo     nome do arquivo
    * @return   byte[]          array de bytes do arquivo   
    */
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
            return null;
    	}
    }

    /**
    * Lista os arquivos do cliente
    *             
    * @return   List<File>  lista de arquivos do cliente   
    */
    @Override
    public List<File> listarArquivos() throws RemoteException {
        List<File> listaArquivo = new ArrayList<File>();

        //Percorre a lista de arquivos do cliente
        for (File f : pasta.listFiles()){
            if (!f.isDirectory()){
                listaArquivo.add(f);
            }
        }
        
        return listaArquivo;
    }
    
    /**
    * Faz o download de um arquivo de outro usuário
    *             
    * @param    login           login do cliente
    *           nomeArquivo     nome do arquivo
    * @return   byte[]          array de bytes do arquivo   
    */
    public byte[] downloadArquivoOutroUsuario(String login, String nomeArquivo) throws RemoteException{
        try{
            String campos[] = this.nomeServidor.split("/"); //Extrair endereço do servidor
            
    	    ClienteItf clienteItf = (ClienteItf) Naming.lookup("//"+campos[0]+"/"+login); 
            return clienteItf.downloadArquivo(nomeArquivo);
            
    	}catch(Exception e){
            return null;
    	}
    }
    
}