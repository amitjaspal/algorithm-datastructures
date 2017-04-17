package com.algorithms;

import java.util.Arrays;


public class DutchNationalFlag {

  public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while(mid <= high){
      if(nums[mid] == 2){
        int tmp = nums[high];
        nums[high] = nums[mid];
        nums[mid] = tmp;
        high--;
      }else if(nums[mid] == 0){
        int tmp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = tmp;
        low++;
        mid++;
      }else{
        mid++;
      }
    }
    System.out.println(Arrays.toString(nums));
  }
}
