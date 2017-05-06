package com.algorithms;

public class CombinationSum {

  public int combinationSum4(int[] nums, int target) {
    int[] DP = new int[target + 1];
    //init
    DP[0] = 1;
    for(int i = 1;i<=target;i++){
      for(int j = 0;j<nums.length;j++){
        if(i - nums[j] >= 0){
          DP[i] = DP[i] + DP[i-nums[j]];
        }
      }
    }
    return DP[target];
  }
}
