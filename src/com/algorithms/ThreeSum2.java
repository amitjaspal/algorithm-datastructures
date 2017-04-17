package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ThreeSum2 {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) return null;

    Arrays.sort(nums);
    List<List<Integer>> answer = new ArrayList<>();
    for(int i = 0;i<nums.length;i++){
      if(i > 0 && nums[i] == nums[i-1]) continue;
      int target = -1 * nums[i];
      int j = i+1, k = nums.length - 1;
      List<Integer> solution = new ArrayList<Integer>(3);
      while(k > j){
        if(nums[k] + nums[j] > target){
          k--;
        }
        else if(nums[k] + nums[j] < target){
          j++;
        }else{
          solution.add(nums[i]);
          solution.add(nums[j]);
          solution.add(nums[k]);
          answer.add(solution);
          solution = new ArrayList<Integer>(3);
          j++;
          k--;
          while(k > j && nums[j] == nums[j-1]) j++;
          while(k > j && nums[k] == nums[k+1]) k--;
        }
      }

    }
    return answer;
  }
}
