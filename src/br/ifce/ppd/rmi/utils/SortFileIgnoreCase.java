package br.ifce.ppd.rmi.utils;

/**
 * Classe: SortFileIgnoreCase.java
 * Comparador de arquivos baseado em Strings
 * @author Tiago Malveira
 * 
 */

import java.io.File;
import java.util.Comparator;

public class SortFileIgnoreCase implements Comparator<Object>{

    @Override
    public int compare(Object t, Object t1) {
        File s1 = (File) t;
        File s2 = (File) t1;
        return s1.getName().toLowerCase().compareTo(s2.getName().toLowerCase());
    }   
}
