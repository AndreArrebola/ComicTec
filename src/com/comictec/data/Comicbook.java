/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author bortq
 */
public class Comicbook {
    private static long cbcnt=0;
    private long cbid;
    private String name;
    private String publisher;
    private int issue;
    private BigDecimal price;
    private int pagenumber;
    private String location;
    private String observation;
    private Set<Long> stories = new HashSet();
    private static final String printemp="Gibi - {0}\n"
            + "Editora {1}\n"
            + "Edição {2}\n"
            + "Preço: {3}\n"
            + "{4} páginas\n"
            + "Local: {5}\n"
            + "Observação: {6}\n\n"
            + "Histórias:\n\n{7}";

    public Comicbook(String name, String publisher, int issue, BigDecimal price, int pagenumber, String location, String observation) {
        this.cbid = ++cbcnt;
        this.name = name;
        this.publisher = publisher;
        this.issue = issue;
        this.price = price;
        this.pagenumber = pagenumber;
        this.location = location;
        this.observation = observation;
    }
    public Comicbook(String name, String publisher, int issue, BigDecimal price, int pagenumber, String location) {
        this.cbid = ++cbcnt;
        this.name = name;
        this.publisher = publisher;
        this.issue = issue;
        this.price = price;
        this.pagenumber = pagenumber;
        this.location = location;
        this.observation = "Não há";
    }
    @Override
    public String toString(){
        MessageFormat form = new MessageFormat(printemp);
        return MessageFormat.format(printemp, name,publisher,issue,price,pagenumber,location,observation,getStories());
    }
    public void setStoriesbyName(Set <String> newstorylist){
        Set <Long> st = newstorylist.stream().map(e->StoryCollection.getIDfromName(e)).collect(Collectors.toSet());
        st.stream().forEachOrdered(e->stories.add(e));
    }
    public void setStoriesbyID(Set <Long> newstorylist){
        //Possible breach
        newstorylist.stream().forEachOrdered(e->stories.add(e));
    }
    public void setStories(Set <Story> newstorylist){
        Set <Long> st = newstorylist.stream().map(e->e.getID()).collect(Collectors.toSet());
        st.stream().forEachOrdered(e->stories.add(e));
    }
    public void addStory(String storyname){
        this.stories.add(CharCollection.getIDfromName(storyname));
    }
    public void addStory(long storyid){
        this.stories.add(storyid);
    }
    public String getStories(){
        StringBuilder storylist = new StringBuilder();
        Set <String> storyset = stories.stream().map(e->StoryCollection.getStorybyID(e).getName()).collect(Collectors.toSet());
    return storyset.toString();
    }
    
    
}
