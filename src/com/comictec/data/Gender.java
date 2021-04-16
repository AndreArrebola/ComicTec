/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

/**
 *
 * @author bortq
 */
public enum Gender {
    MALE("Masculino"), FEMALE("Feminino"),OTHER("Outro"),UNDEFINED("Indefinido");
    private String literalGender;
    Gender(String litg){
        this.literalGender = litg;
    }
    @Override
    public String toString(){
        return literalGender;
    }
}
