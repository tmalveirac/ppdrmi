/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

/**
 *
 * @author malveira
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

public class Servidor extends UnicastRemoteObject implements InverterItf {
    
    // Vetor que armazena os usuários ativos em uma sessão
    private static List<ClienteItf> listaClienteItf = new ArrayList<ClienteItf>();
    private static List<String> listaLogin =  new ArrayList<String>(); //temp
    private static List<Usuario> listUsuario = new ArrayList<Usuario>();
    
    
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
            //listaLogin.add(login);
            
            Usuario u = new Usuario();
            u.setLogin(login);
            List<File> listaArquivo = new ArrayList<File>();
            
            for (File s : c.listarArquivos()){
                System.err.println(s.getName()+",");
                listaArquivo.add(s);
            }
            
            u.setListaArquivo(listaArquivo);
            
            listUsuario.add(u);
            
            //TODO: Enviar a lista de arquivos pra todo mundo
            
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
            //listaLogin.remove(indiceByLogin(login));
            
            listUsuario.remove(indiceByLogin(login));
            Naming.unbind("//localhost/" + login);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        System.err.println("Cliente: " + login + "Desconectado");
       
    }

    @Override
    public List<Usuario> listarUsuarios() throws RemoteException {   
       return listUsuario;
    }
    
    
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
    public void atualizarPasta(String login) throws RemoteException {
        try {
            ClienteItf c = (ClienteItf) Naming.lookup("//localhost/" + login);
            listUsuario.get(indiceByLogin(login)).setListaArquivo(c.listarArquivos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
