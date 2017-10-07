package com.algorithms;

import java.util.HashSet;
import java.util.Set;


public class MinWindowContainingChars {

  public String minWindow(String s, String t) {
    if(s == null || t == null) return null;
    if(t.length() > s.length()) return "";
    int start = 0;
    int end = 0;
    int []map = new int[256];
    Set<Character> set = new HashSet<Character>();
    for(Character c : t.toCharArray()) {
      map[c]++;
      set.add(c);
    }
    int cnt = 0;
    int answer = s.length();
    int sf = 0, ef = s.length()-1;
    boolean ansFound = false;
    while(end < s.length()){
      map[s.charAt(end)]--;
      if(map[s.charAt(end)] == 0) cnt++;

      if(cnt == set.size()){

        while(start <= end){
          if((end - start + 1) <= answer){
            sf = start;
            ef = end;
            answer = end - start + 1;
            ansFound = true;
          }
          map[s.charAt(start)]++;
          if(map[s.charAt(start)] == 1){
            start++;
            cnt--;
            break;
          }
          start++;
        }
      }
      end++;
    }
    if(!ansFound) return "";
    return s.substring(sf,ef+1);
  }
}
