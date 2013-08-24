/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.utils;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author malveira
 */
public class SortFileIgnoreCase implements Comparator<Object>{

    @Override
    public int compare(Object t, Object t1) {
        File s1 = (File) t;
        File s2 = (File) t1;
        return s1.getName().toLowerCase().compareTo(s2.getName().toLowerCase());
    }   
}
