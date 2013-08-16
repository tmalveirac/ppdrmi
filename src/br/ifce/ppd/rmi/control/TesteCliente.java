/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author malveira
 */

public class TesteCliente {
    public static void main(String[] args) throws RemoteException, IOException{
        Cliente c = new Cliente("kelly");
        String arquivo = "/home/malveira/teste/a.txt";
        
        //Movendo um arquivo de uma pasta para outra
        InputStream inStream = null;
	OutputStream outStream = null;
        
        try{
 
    	    File file = new File("/home/malveira/teste/destino/a.txt");

    	    outStream = new FileOutputStream(file);
 
            outStream.write(c.getServidor().downloadArquivo(arquivo), 0, 
                    c.getServidor().downloadArquivo(arquivo).length);
    	   
    	    outStream.close();
 
    	    System.out.println("Arquivo copiado com sucesso!");
 
    	}catch(IOException e){
    	    e.printStackTrace();
    	}
        
        for (;;){
            System.out.print("Digite a Frase:");
            BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));
            String line = r.readLine();
            
            switch (line) {
                case "l":
                    List<String> logins = c.listaLogins();
                    for (String s : logins){
                        System.err.println(s + ",");
                    }
                    break;
                    
                case "d":
                    c.desconectar();
                    System.exit(0);
                    break;
                    
                default:
                    String retorno = c.inverterMensagem(line);
                    System.out.println("Frase Invertida = " + retorno);
            }       
        }
    }
}
