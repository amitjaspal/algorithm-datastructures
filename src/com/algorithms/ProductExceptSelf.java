package com.algorithms;

import java.util.Arrays;


public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    if(nums == null) return null;
    if(nums.length == 1) return nums;

    int []left = new int[nums.length];
    int []right = new int[nums.length];
    left[0] = nums[0];
    right[nums.length - 1] = nums[nums.length - 1];
    for(int i = 1, j = nums.length - 2; i < nums.length && j >= 0;i++,j--){
      left[i] = left[i-1] * nums[i];
      right[j] = right[j+1]*nums[j];
    }
    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));
    int []answer = new int[nums.length];
    answer[0] = right[1];
    answer[nums.length - 1] = left[nums.length - 2];
    for(int i = 1; i < nums.length-1;i++){
      answer[i] = left[i-1] * right[i+1];
    }
    return answer;
  }
}
