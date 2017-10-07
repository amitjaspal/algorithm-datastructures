package com.algorithms;

import java.util.HashMap;
import java.util.Map;


public class LongestConsecutiveNumbers {

  public int longestConsecutive(int[] nums) {
    if(nums == null || nums.length == 0) return 0;

    Map<Integer, Integer> index = new HashMap<Integer, Integer>();
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    for(Integer i : nums){
      index.put(i, 1);
    }

    int answer = Integer.MIN_VALUE;
    for(int i = 0; i< nums.length;i++){
      if(!index.containsKey(nums[i]+1)){
        int key = nums[i];
        int tmp = 0;
        while(index.containsKey(key)){
          tmp++;
          key--;
        }
        answer = Math.max(answer, tmp);
      }
    }
    return answer;

  }


}
