package com.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak2 {


  public List<String> wordBreak(String s, List<String> wordDict) {
    if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return null;
    List<String>candidate = new ArrayList<>();
    Set<String> index = new HashSet<>(wordDict);
    TempHolder t = wordBreakHelper(s, index, 0, candidate);
    if(t.isEndReached){
      return t.solution;
    }else{
      return null;
    }
  }

  class TempHolder{
    List<String> solution;
    boolean isEndReached;
  }

  private TempHolder wordBreakHelper(String s, Set<String> wordDict, int start, List<String> candidate){

    if(start == s.length()){
      List<String> x = new ArrayList<>(candidate);
      TempHolder tmp = new TempHolder();
      tmp.isEndReached = true;
      tmp.solution = x;
      return tmp;
    }
    List<String> solution = new ArrayList<>();
    for(int i = start;i<s.length();i++){
      if(wordDict.contains(s.substring(start, i + 1))){
        candidate.add(s.substring(start,i+1));
        TempHolder tmp = wordBreakHelper(s,wordDict, i + 1,candidate);
        if(tmp.isEndReached) return tmp;
        else{
          candidate.remove(candidate.size() - 1);
        }
      }

    }
    TempHolder tmp = new TempHolder();
    tmp.isEndReached = false;
    return tmp;
  }
}
