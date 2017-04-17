package com.algorithms;

public class MinimumSizeSubarray {

  public int minSubArrayLen(int s, int[] nums) {
    int i = 0, j = 0, k = 0;
    int answer = Integer.MAX_VALUE;
    while(j<nums.length){
      k = k + nums[j];
      if( k >= s){

        while(i<= j && k >= s) {
          answer = Math.min(answer, (j-i + 1));
          k = k - nums[i];
          i++;
        }
      }
      j++;
    }
    return answer == Integer.MAX_VALUE ? 0 : answer;
  }
}
