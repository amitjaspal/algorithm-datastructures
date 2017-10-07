package com.algorithms;

public class LongestSubstringWithAtmostTwoDistinctChar {

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if(s == null) return 0;
    if(s.length() < 3) return s.length();

    int start = 0, end = 0;
    int []map = new int [256];
    int cnt = 0;
    int answer = 2;
    while(end < s.length()){
      int tmp = map[s.charAt(end)];
      if(tmp == 0) cnt++;
      map[s.charAt(end)]++;
      if(cnt == 3){
        while(start <= end){
          map[s.charAt(start)]--;
          if(map[s.charAt(start)] == 0){
            cnt--;
            start++;
            break;
          }
          start++;
        }
      }
      answer = Math.max(answer, end - start + 1);
      end++;
    }
    return answer;
  }

}
