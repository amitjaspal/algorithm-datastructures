package com.algorithms;

import java.util.ArrayList;
import java.util.List;


public class GenerateSubSets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    if(nums == null) return null;
    int sz = nums.length;
    int limit = (int)Math.pow(2, sz) - 1;
    for(int i = 0; i<= limit; i++){
      List<Integer> solution = new ArrayList<>();
      for(int j = 0; j<nums.length; j++){
        if((i & (1<<j)) != 0){
          solution.add(nums[j]);
        }
      }
      answer.add(solution);
    }
    return answer;
  }
}
