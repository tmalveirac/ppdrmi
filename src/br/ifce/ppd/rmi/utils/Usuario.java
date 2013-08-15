/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.utils;

import java.io.Serializable;

/**
 *
 * @author malveira
 */
public class Usuario implements Serializable{
    private int id;
    private String login;

    public Usuario(String login) {
        this.login = login;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
}
