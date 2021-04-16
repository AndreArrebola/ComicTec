/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

import java.text.MessageFormat;

/**
 *
 * @author bortq
 */
public class CCharacter {
    private static long chcnt=0;
    private long chid;
    private String name;
    private Gender gender;
    private String description;
    private static final String printemp="Personagem - {0}\n"
            + "Gênero: {1}\n"
            + "Descrição: {2}";

    public CCharacter(String name, Gender gender, String description) {
        this.chid = ++chcnt;
        this.name = name;
        this.gender = gender;
        this.description = description;
    }

    @Override
    public String toString() {
        MessageFormat form = new MessageFormat(printemp);
        return MessageFormat.format(printemp, name, gender, description);
    }
    protected long getID(){
        return this.chid;
    }
    protected String getName(){
        return this.name;
    }
    
    
}
