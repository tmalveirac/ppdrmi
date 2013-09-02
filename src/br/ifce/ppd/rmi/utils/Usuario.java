package br.ifce.ppd.rmi.utils;

/**
 * Classe: Usuario.java
 * Define um usuário da aplicação
 * @author Tiago Malveira
 * 
 */

import java.io.File;
import java.io.Serializable;
import java.util.List;

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
