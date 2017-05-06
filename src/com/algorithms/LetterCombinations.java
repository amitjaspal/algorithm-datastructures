package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinations {

  Map<Character, String> mapping;
  public List<String> letterCombinations(String digits) {
    Map<Character, String> mapping = new HashMap<>();
    mapping.put('2',"a,b,c");
    mapping.put('3',"d,e,f");
    mapping.put('4',"g,h,i");
    mapping.put('5',"j,k,l");
    mapping.put('6',"m,n,o");
    mapping.put('7',"p,q,r,s");
    mapping.put('8',"t,u,v");
    mapping.put('9',"w,x,y,z");
    List<String> result = new ArrayList<String>();
    letterCombinationsHelper(digits, 0, mapping, result, new StringBuffer());
    return result;
  }

  private void letterCombinationsHelper(String digits, int index, Map<Character, String> mapping, List<String> result, StringBuffer candidate){
    if(index == digits.length()){
      String solution = new String(candidate);
      System.out.println(solution);
      result.add(solution);
      return;
    }

    String []tokens = mapping.get(digits.charAt(index)).split(",");
    for(String token : tokens){
      candidate.append(token);
      letterCombinationsHelper(digits, index+1, mapping, result, candidate);
      candidate.deleteCharAt(candidate.length()-1);
    }
  }
}
