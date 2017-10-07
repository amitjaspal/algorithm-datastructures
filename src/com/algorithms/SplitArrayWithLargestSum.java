package com.algorithms;

import java.util.Arrays;


public class SplitArrayWithLargestSum {
  public int splitArray(int[] nums, int m) {
    if(nums == null || nums.length == 0) return 0;
    int sum = 0;
    for(int x : nums){
      sum += x;
    }
    int bestDivision = sum / m;
    int i = 0;
    int partialSum = 0;
    int lastDiff = Integer.MAX_VALUE;
    int answer = Integer.MIN_VALUE;
    //System.out.println(bestDivision);
    while(i<nums.length){
      partialSum = partialSum + nums[i];
      int diff = Math.abs(partialSum - bestDivision);
      //System.out.println(lastDiff + "," + diff);
      if(diff > lastDiff){
        partialSum = nums[i];
        lastDiff = Math.abs(partialSum - bestDivision);
        answer = Math.max(answer, partialSum);
      }else{
        lastDiff = diff;
        answer = Math.max(answer, partialSum);
      }
      i++;
    }
    return answer;
  }
}
