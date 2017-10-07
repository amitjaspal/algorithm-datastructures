package com.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RemoveInvalidParanthesis2 {

  int maxLength;
  public List<String> removeInvalidParentheses(String s) {
    Set<String> solutions = new HashSet<>();
    traverseString(s, new StringBuffer(), solutions, 0, 0, 0 );
    return  new ArrayList<>(solutions);
  }

  private void traverseString(String s, StringBuffer candidate, Set<String> solutions, int index, int open, int close){
    if(open < close) return;
    if(index == s.length() && open != close) return;
    if(index == s.length() && open == close){
      if(maxLength < candidate.length()){
        solutions.clear();
        solutions.add(candidate.toString());
        maxLength = candidate.length();
      }
      else if(maxLength == candidate.length()){
        solutions.add(candidate.toString());
      }
      return;
    }

    if(s.charAt(index) == '('){
      candidate.append('(');
      traverseString(s,candidate,solutions, index + 1, open+1, close);
      candidate.deleteCharAt(candidate.length() - 1);
      traverseString(s,candidate,solutions, index + 1, open, close);
    }else if(s.charAt(index) == ')'){
      candidate.append(')');
      traverseString(s,candidate,solutions, index + 1, open, close+1);
      candidate.deleteCharAt(candidate.length() - 1);
      traverseString(s,candidate,solutions, index + 1, open, close);
    }else{
      candidate.append(s.charAt(index));
      traverseString(s,candidate,solutions, index + 1, open, close);
    }

  }
}
