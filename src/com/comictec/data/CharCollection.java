/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author bortq
 */
public class CharCollection {
    static Set<CCharacter> charlist = new HashSet(); 
    
    public static void newChar(CCharacter newc){
        charlist.add(newc);
    }
    public static CCharacter getCharbyID(long chid){
        return charlist.stream().filter(e->e.getID()==chid).findFirst().get();
    }
    
    public static Long getIDfromName(String charname){
        return charlist.stream().filter(e->e.getName().equals(charname)).map(e->e.getID()).findFirst().get();
    }
    
}
