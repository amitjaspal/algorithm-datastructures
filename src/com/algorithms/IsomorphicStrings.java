package com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ajaspal on 1/1/17.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        Set<Character> alreadyMapped = new HashSet<Character>();
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        for(int i = 0 ;i < s.length();i++){
            Character x = s.charAt(i);
            Character y = t.charAt(i);
            if(charMap.get(x) == null && alreadyMapped.contains(y) == false){
                charMap.put(x,y);
                alreadyMapped.add(y);
            }
            else if(charMap.get(x) != null){
                if(charMap.get(x) != y ){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
