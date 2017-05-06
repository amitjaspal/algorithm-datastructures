package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetsWithNoDuplicates {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    Arrays.sort(nums);
    List<List<Integer>> answer = new ArrayList<>();
    answer.add(new ArrayList<Integer>());
    int prev = 0;
    for(int i = 0;i<nums.length;i++){
      int start = i > 0 && nums[i] == nums[i-1] ? prev : 0;
      int sz = answer.size();
      prev = answer.size();
      for(int j = start;j<sz;j++){
        List<Integer> tmp = answer.get(j);
        List<Integer> sol = new ArrayList<Integer>(tmp.size());
        for(Integer x : tmp){
          sol.add(x);
        }
        sol.add(nums[i]);
        answer.add(sol);
      }

    }
    for(int i = 0;i<answer.size();i++){
      for(int j = 0; j< answer.get(i).size();j++){
        System.out.print(answer.get(i).get(j) + ",");
      }
      System.out.println();
    }
    return answer;
  }


}
