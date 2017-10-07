package com.algorithms;

import java.util.Arrays;


public class WildcardPatternMatching {

  public boolean isMatch(String s, String p) {
    if((s == null || s.length() == 0) && (p == null || p.length() == 0)) return true;
    if(s == null || s.length() == 0 || p ==null || p.length() == 0)  return false;

    int n = s.length();
    int m = p.length();
    int [][]dp = new int[m+1][n+1];

    dp[0][0] = 1;

    for(int i = 1;i<n+1;i++){
      dp[0][i] = 0;
    }

    for(int i = 1; i<m+1;i++){
      dp[i][0] = p.charAt(i-1) == '*' ? dp[i-1][0] : 0; // take special care of the indices.
    }

    for(int i = 1;i<m+1;i++){
      for(int j = 1;j<n+1;j++){
        if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
          dp[i][j] = dp[i-1][j-1];
        }
        else if(p.charAt(i-1) == '*'){
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
        //System.out.print(dp[i][j]);
      }
      //System.out.println();
    }


    return dp[m][n] > 0;
  }

}
