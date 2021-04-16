/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

/**
 *
 * @author bortq
 */
public class Story {
    private static long stcnt=0;
    private long stid;
    private String name;
    private String description;
    private int pagenumber;
    private static final String printemp="Gibi - {0}\n"
            + "{1} Páginas\n"
            + "Descrição: {2}\n"
            + "Personagens: {3}";
    private Set<Long> characters = new HashSet();

    public Story(String name, String description, int pagenumber) {
        this.stid = ++stcnt;
        this.name = name;
        this.description = description;
        this.pagenumber = pagenumber;
    }
    public Story(String name, int pagenumber) {
        this.stid = ++stcnt;
        this.name = name;
        this.description = "Não Possui";
        this.pagenumber = pagenumber;
    }
    @Override
    public String toString(){
        MessageFormat form = new MessageFormat(printemp);
        return MessageFormat.format(printemp, name, pagenumber, description, getCharacters());
    }
    public void addCharacter(String charname){
        this.characters.add(CharCollection.getIDfromName(charname));
    }
    public void setCharacters(Set<String> newcharlist){
        Set <Long> st = newcharlist.stream().map(e->CharCollection.getIDfromName(e)).collect(Collectors.toSet());
        //Set<Long> st =newcharlist.stream().map(e->e.getID()).collect(Collectors.toSet());
        st.stream().forEachOrdered(e->characters.add(e));
        //characters = st;
//this.characters.add();
    }
    public String getCharacters(){
        StringBuilder charlist = new StringBuilder();
        Set <String> charset = characters.stream().map(e->CharCollection.getCharbyID(e).getName()).collect(Collectors.toSet());
    return charset.toString();
    }
    public long getID(){
        return this.stid;
    }
    public String getName(){
        return this.name;
    }
    
    
    
}
