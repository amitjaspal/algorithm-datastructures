package com.algorithms;

public class ThreeSequence {

  public boolean increasingTriplet(int[] nums) {
    if(nums == null || nums.length < 3) return false;
    int min[] = new int[nums.length];
    int max[] = new int[nums.length];
    min[0] = nums[0];
    max[nums.length - 1] = nums[nums.length - 1];
    for(int i = 1,j= nums.length-2;i<=(nums.length-2);i++,j--){
      min[i] = Math.min(min[i-1], nums[i]);
      max[j] = Math.max(max[j+1], nums[j]);
    }
    for(int i = 1;i<=(nums.length-2);i++){
      if(nums[i] != min[i] && nums[i] != max[i]) return true;
    }
    return false;
  }
}
