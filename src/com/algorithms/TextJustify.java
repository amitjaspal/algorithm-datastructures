package com.algorithms;

import java.util.ArrayList;
import java.util.List;


public class TextJustify {

  public List<String> fullJustify(String[] words, int maxWidth) {
    if(words == null || words.length == 0 || maxWidth <= 0) return new ArrayList<String>();

    List<String> result = new ArrayList<>();
    int start = 0;
    int currentSum = 0;
    for(int  i = 0;i<words.length;){
      currentSum = currentSum + words[i].length();
      if(currentSum > maxWidth){
        String s = justify(start, i-1, words, currentSum - words[i].length() , maxWidth);
        System.out.println(s);
        System.out.println(s.length());
        result.add(s);
        start = i;
        currentSum = 0;
      }else{
        i++;
        currentSum = currentSum + 1;
      }
    }
    if(start <=  words.length - 1) {
      String s = justify(start, words.length - 1, words, currentSum, maxWidth);
      System.out.println(s.length());
      System.out.println(s);
      result.add(s);
    }
    return result;
  }

  private String justify(int start, int end, String[] words, int totalChars, int maxWidth){
    if(end >= start) {
      totalChars = Math.max(0,totalChars - 1);
      int spacesLeft = maxWidth - totalChars;
      int slots = end - start;
      int spacesToAppend = slots != 0 ? spacesLeft / slots : spacesLeft;
      int spacesRemaining = slots != 0 ? spacesLeft % slots : 0;
      StringBuffer s = new StringBuffer();
      for(int i = start;i<= end ;i++){
        s.append(words[i]);
        if(i != end) {
          s.append(" ");

          for (int k = 0; k < spacesToAppend; k++) {
            s.append(" ");
          }
          if (spacesRemaining > 0) {
            s.append(" ");
            spacesRemaining--;
          }
        }else if(start == end){
          for (int k = 0; k < spacesToAppend; k++) {
            s.append(" ");
          }
          if (spacesRemaining > 0) {
            s.append(" ");
            spacesRemaining--;
          }
        }
      }
      return s.toString();
    }else{
      return "-1";
    }
  }

}
