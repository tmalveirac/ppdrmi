/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.rmi.utils;

import java.util.Comparator;

/**
 *
 * @author malveira
 */
public class SortIgnoreCase implements Comparator<Object>{
    public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
}
