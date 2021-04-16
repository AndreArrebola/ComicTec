/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comictec.data;

import static com.comictec.data.CharCollection.charlist;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bortq
 */
public class StoryCollection  {
    static Set<Story> storylist = new HashSet();
    public static void newStory(Story newst){
        storylist.add(newst);
    }
    public static Story getStorybyID(long stid){
        return storylist.stream().filter(e->e.getID()==stid).findFirst().get();
        
    }
    public static Long getIDfromName(String storyname){
        return storylist.stream().filter(e->e.getName().equals(storyname)).map(e->e.getID()).findFirst().get();
    }
}
