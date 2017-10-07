package com.algorithms;

import java.util.Arrays;


public class RegexMatternMatching {

  public boolean isMatch(String s, String p) {
    if((s == null ) && (p == null)) return true;
    if(s == null || p == null) return false;

    int n = s.length();
    int m = p.length();

    int dp[][] = new int[n+1][m+1];
    dp[0][0] = 1;
    for(int i = 1;i<n+1;i++){
      dp[i][0] = 0;
    }
    for(int j = 1;j<m+1;j++){
      dp[0][j] = (p.charAt(j-1) == '*' && j > 1) ? dp[0][j-2] : 0;
    }
    //System.out.println(Arrays.toString(dp[0]));
    for(int i = 1;i<n+1;i++){
      for(int j = 1;j<m+1;j++){
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
          dp[i][j] = dp[i-1][j-1];
        }
        else if(p.charAt(j-1) == '*'){
          if(j > 1) {
            dp[i][j] = Math.max(dp[i][j], dp[i][j - 2]);
            if ((s.charAt(i - 1) == p.charAt(j - 2)) || (p.charAt(j-2) == '.')) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
          }
        }
      }
      //System.out.println(Arrays.toString(dp[i]));
    }
    return dp[n][m] > 0;
  }
}
