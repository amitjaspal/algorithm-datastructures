package com.algorithms;

public class FindTargetWays {

  public int findTargetSumWays(int[] nums, int S) {
    if(nums == null || nums.length == 0) return 0;
    return findTargetSumWaysHelper(nums, S, 0, 0);
  }

  private int findTargetSumWaysHelper(int []nums, int S, int idx, int currentSum){
    if(idx ==nums.length){
      if(currentSum == S) return 1;
      return 0;
    }else{
      int currentSum1 = currentSum + nums[idx];
      int currentSum2 = currentSum - nums[idx];
      return findTargetSumWaysHelper(nums, S, idx+1, currentSum1) + findTargetSumWaysHelper(nums, S, idx+1, currentSum2);

    }
  }
}
