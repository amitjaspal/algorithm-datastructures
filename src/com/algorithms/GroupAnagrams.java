package com.algorithms;

import java.util.*;

/**
 * Created by ajaspal on 1/6/17.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<String, List<String>>();
        List<List<String>> answer = new ArrayList<List<String>>();
        for(String input : strs){
            char [] c = input.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            List<String> tmp = groupedAnagrams.getOrDefault(s, new ArrayList<String>());
            tmp.add(input);
            groupedAnagrams.put(s,tmp);


        }
        for(Map.Entry<String, List<String>> e : groupedAnagrams.entrySet()){
            answer.add(e.getValue());
        }

        return answer;
    }
}
