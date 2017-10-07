package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class PaintHouses {

  public int minCostII(int[][] costs) {
    if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

    int rows = costs.length;
    int columns = costs[0].length;

    int dp[][] = new int[rows][columns];
    int dp2[][] = new int[rows][columns];
    int min = Integer.MAX_VALUE;
    int secMin = Integer.MAX_VALUE;
    int index = -1;
    for(int j = 0;j<costs[0].length;j++){
      dp[0][j] = costs[0][j];
      if(min >= dp[0][j]){
        secMin = min;
        min = dp[0][j];
        index = j;

      }
      else if(secMin >= dp[0][j]){
        secMin = dp[0][j];
      }
    }
    //System.out.println(min);
    //System.out.println(secMin);
    if(rows == 1) return min;
    for(int j = 0;j<costs[0].length;j++){
      if(j != index){
        dp2[0][j] = min;
      }else{
        dp2[0][j] = secMin;
      }
    }
    //System.out.println(Arrays.toString(dp2[0]));
    int answer = Integer.MAX_VALUE;
    for(int i = 1;i<rows;i++){
      min = Integer.MAX_VALUE;
      secMin = Integer.MAX_VALUE;
      index = -1;
      //System.out.println(Arrays.toString(dp2[i-1]));
      for(int j = 0;j<columns;j++){
        dp[i][j] = costs[i][j] + dp2[i-1][j];
        if(min >= dp[i][j]){
          secMin = min;
          min = dp[i][j];
          index = j;

        }
        else if(secMin >= dp[i][j]){
          secMin = dp[i][j];
        }
        if(i == rows - 1){
          answer = Math.min(answer, dp[i][j]);
        }
      }
      System.out.println("min -> " + min);
      System.out.println("secMin -> " + secMin);
      for(int j = 0;j<columns;j++){
        if(j != index){
          dp2[i][j] = min;
        }else{
          dp2[i][j] = secMin;
        }
      }
      System.out.println("Coloring -> " + Arrays.toString(dp[i]));
      System.out.println("Not Coloring -> " + Arrays.toString(dp2[i]));

    }
    return answer;
  }
}
