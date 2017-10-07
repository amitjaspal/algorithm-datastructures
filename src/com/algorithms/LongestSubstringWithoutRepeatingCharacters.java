package com.algorithms;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {

    if(s == null) return 0;
    if(s.length() < 2) return s.length();

    int start = 0, end = 0;
    int answer = 1;
    boolean []map = new boolean[256];
    while(end < s.length()){
      if(map[s.charAt(end)]){
        while(start <= end){
          if(s.charAt(start) == s.charAt(end)){
            start++;
            break;
          }
          map[s.charAt(start)] = false;
          start++;
        }
      }

      map[s.charAt(end)] = true;
      answer = Math.max(answer, end - start + 1);
      end++;
    }
    return answer;
  }
}
