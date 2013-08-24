/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.utils;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author malveira
 */
public class Usuario implements Serializable{
    private String login;
    private List<File> listaArquivo;

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario() {
        
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<File> getListaArquivo() {
        return listaArquivo;
    }

    public void setListaArquivo(List<File> listaArquivo) {
        this.listaArquivo = listaArquivo;
    }

}
