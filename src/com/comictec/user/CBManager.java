/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.user;

import java.util.Scanner;

/**
 *
 * @author bortq
 */
public class CBManager {
    public static void addPrompt(Scanner prompt){
        
        int pnum=0;
        System.out.println("O que deseja adicionar?\n"
                + "1 - Personagem\n"
                + "2 - História\n"
                + "3 - Gibi\n"
                + "4 - Voltar");
        
            pnum = prompt.nextInt();
            switch(pnum){
                case 1:
                    addChar();
                    break;
                case 2:
                    addStory();
                    break;
                case 3:
                    addCB();
                    break;
                    
            }    
        
    
}
    public static void addChar(){
        System.out.println("Adicionando chat");
    }
    public static void addStory(){
        System.out.println("Adicionando história");
    }
    public static void addCB(){
        System.out.println("Adicionando Gibi");
    }


}
