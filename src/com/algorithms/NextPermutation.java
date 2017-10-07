package com.algorithms;

import java.util.Arrays;


public class NextPermutation {

  public void nextPermutation(int[] nums) {
    if(nums == null || nums.length < 2) return ;
    int i = nums.length - 1;
    Integer pivot = null;
    while(i >= 0){
      if(i-1 >= 0 && nums[i-1] < nums[i]){
        pivot = nums[i-1];
        break;
      }
      i--;
    }
    if(pivot == null){
      reverse(nums, 0, nums.length - 1);
      return;
    }

    // pivot exists at index i - 1
    int min = Integer.MAX_VALUE;
    int swapIndex = -1;
    for(int j = i;j<nums.length;j++){
      if(nums[j] > pivot && nums[j] <= min){ // Take care of the equality
        min = nums[j];
        swapIndex = j;
      }
    }

    nums[i-1] = min;
    nums[swapIndex] = pivot;
    reverse(nums, i, nums.length - 1);

  }

  private void reverse(int []input, int i, int j){
    while(i<j){
      int tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
      i++;
      j--;
    }
  }
}
