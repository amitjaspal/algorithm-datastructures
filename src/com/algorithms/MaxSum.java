package com.algorithms;

public class MaxSum {

  // Assumption : sum will be in range of int
  public int findMaxSum(String input){
    if(input == null || input.length() == 0) return 0;
    return findMaxSumHelper(input, 1, (int)input.charAt(0) - 48);

  }

  private int findMaxSumHelper(String input, int idx, int currentValue){
    //System.out.println(currentValue);
    if(idx == input.length()) return currentValue;

    int val = (int)input.charAt(idx) - 48;
    return Math.max(findMaxSumHelper(input, idx + 1, currentValue * val), findMaxSumHelper(input, idx + 1, currentValue + val));
  }
}
