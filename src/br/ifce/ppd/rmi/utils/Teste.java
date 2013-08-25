/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.utils;

/**
 *
 * @author malveira
 */
public class Teste {
    public static void main(String[] args){
        String s = "teste";
        
        if (s.contains("est")){
            System.err.println("possui");
        }
        
        for (int i=0; i<10; i++){
            System.err.println("i-" + i);
            for (int j=0; j<10; j++){
                System.err.println("j-" + j);
                if (j==2){
                    break;
                }
            }
        }
        
    }
}
