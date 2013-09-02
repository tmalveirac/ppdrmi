package br.ifce.ppd.rmi.utils;

/**
 * Classe: SortStringIgnoreCase.java
 * Comparador objetos baseado em Strings
 * @author Tiago Malveira
 * 
 */

import java.util.Comparator;

/**
 *
 * @author malveira
 */
public class SortStringIgnoreCase implements Comparator<Object>{
    public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
}
