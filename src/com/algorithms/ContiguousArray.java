package com.algorithms;

public class ContiguousArray {

  public int findMaxLength(int[] nums) {
    if(nums == null || nums.length < 2) return 0;

    int sum[] = new int[nums.length];
    sum[0] = nums[0];
    int answer = 0;
    for(int i = 1;i<nums.length;i++){
      sum[i] = sum[i-1] + nums[i];
      if(i%2 == 1 && sum[i] == (i/2 + 1)) {
        answer = Math.max(answer, i + 1);
      }
    }

    for(int i = 0;i<nums.length;i++){
      for(int j = i+1;j<nums.length;j++){
        if((j-i) % 2 == 1 && ((nums[i] + sum[j] - sum[i]) == (j-i+1)/2)){
          answer = Math.max(answer, j - i + 1);
        }
      }
    }
    return answer;
  }
}

