/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.control;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author malveira
 */
public interface InverterItf extends Remote {
    String inverter(String msg) throws RemoteException;
}
