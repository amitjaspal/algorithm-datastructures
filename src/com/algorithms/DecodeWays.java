package com.algorithms;

public class DecodeWays {

  int dp[];

  public int numDecodings(String s) {
    if(s == null || s.length() == 0) return 0;
    dp = new int[s.length() + 1];
    return decodeWaysHelper(s, 0);
  }

  private int decodeWaysHelper(String s, int currentIndex){
    if(currentIndex > (s.length())) return 0;

    else if(s.length() == currentIndex) return 1;

    else if(s.charAt(currentIndex) == '0') return 0;

    else if(currentIndex + 1 < s.length() && s.charAt(currentIndex+1) == '0'){
      if(Integer.parseInt(s.substring(currentIndex, currentIndex+2)) <= 26) {
        dp[currentIndex] = decodeWaysHelper(s, currentIndex + 2);
      }else{
        return 0;
      }
    }
    else if(currentIndex + 1 < s.length() && Integer.parseInt(s.substring(currentIndex, currentIndex+2)) <= 26) {
      dp[currentIndex] = decodeWaysHelper(s, currentIndex + 1) + decodeWaysHelper(s, currentIndex + 2);
    }else {
      dp[currentIndex] = decodeWaysHelper(s, currentIndex + 1);
    }
    return dp[currentIndex];
    }

  }
