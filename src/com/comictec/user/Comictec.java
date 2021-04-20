/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.user;

import com.comictec.data.CCharacter;
import com.comictec.data.CharCollection;
import com.comictec.data.Comicbook;
import com.comictec.data.Gender;
import com.comictec.data.Story;
import com.comictec.data.StoryCollection;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author bortq
 */
public class Comictec {

    /**
     * @param args the command line arguments
     */
    public static void test(){
        Story cebo = new Story("O pior aniversário da minha vida", "Cebolinha vai para uma fazenda comemorar seu aniversário.", 30);
        Story maga = new Story("A Ouvinte", "Magali tenta se mostrar uma boa ouvinte para seus amigos. Mas e quando ela quer falar também?", 30);
        CharCollection.newChar(new CCharacter("Cebolinha", Gender.MALE, "Garoto que fala elado"));
        CharCollection.newChar(new CCharacter("Mônica", Gender.FEMALE, "Forte e dentuça"));
        CharCollection.newChar(new CCharacter("Magali", Gender.FEMALE, "Comilona"));
        cebo.setCharacters(Set.of("Cebolinha", "Mônica"));
        cebo.setCharacters(Set.of("Magali"));
        maga.setCharacters(Set.of("Magali"));
        StoryCollection.newStory(cebo);
        StoryCollection.newStory(maga);
        Comicbook gibi;
        gibi = new Comicbook("Cebolinha", "Panini", 2, BigDecimal.valueOf(2.90), 90, "Quarto");
        gibi.setStories(Set.of(cebo, maga));
        //System.out.println(CharCollection.getCharbyID(1).toString());
        //System.out.println(CharCollection.getCharbyID(2).toString());
        System.out.println(cebo.toString());
        System.out.println(gibi.toString());
    }
    public static void main(String[] args) {
        //test();
        int com=0;
        Scanner prompt = new Scanner(System.in);
        
        while(true){
        System.out.println("Bem vindo ao Comictec! O que deseja fazer?\n"
                + "1 - Adicionar\n"
                + "2 - Exibir\n"
                + "3 - Gerenciar\n"
                + "4 - Sair");
        try{
            com = prompt.nextInt();
            
            
        }catch(Exception ex){
            System.out.println("Digite um número!");
        }
        switch(com){
             case 1:
                 CBManager.addPrompt(prompt);
                 
                 break;
             case 2:
                 System.out.println("Exibindo");
                 break;
             case 3:
                 System.out.println("Gerenciando");
                 break;
             case 4: 
                 System.out.println("Saindo");
                 return;
             default:
                 System.out.println("Escolha de 1 a 4");
            }
        //System.out.println(cebo.toString());
        }
    }
    
}
