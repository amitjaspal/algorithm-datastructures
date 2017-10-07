package com.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
    Set<String> index = new HashSet<>(wordDict);
    int []dp = new int[s.length()];
    for(int i = 0;i<s.length();i++){
      dp[i] = 0;
    }
    return wordBreakHelper(s, index,0,dp);

  }

  private boolean wordBreakHelper(String s, Set<String> wordDict, int start,int []dp){
    if(start == s.length() ){
      return true;
    }

    if(dp[start] != 0) return dp[start] == 1 ? true : false;
    boolean answer = false;
    for(int i = start;i<s.length();i++){
      if(wordDict.contains(s.substring(start,i+1))){
        answer = answer || wordBreakHelper(s, wordDict, i+1,dp);
        if(answer) break;
      }

    }
    dp[start] = answer == true ? 1 : -1;
    return answer;
  }

}
