package com.algorithms;

import java.util.Arrays;


public class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    if(nums == null) return 0;
    if(nums.length < 3) return nums.length;

    int i = 0, j = 1, numCopied = 1;
    while(j<nums.length){
      if(nums[i] == nums[j] && numCopied >= 2) j++;
      else if(nums[i] == nums[j]){
        i++;
        nums[i] = nums[j];
        numCopied++;
        j++;
      }else{
        i++;
        nums[i] = nums[j];
        numCopied = 1;
        j++;
      }
    }
    System.out.println(Arrays.toString(nums));
    return i+1;
  }
}
