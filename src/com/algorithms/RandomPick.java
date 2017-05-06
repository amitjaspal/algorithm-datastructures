package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RandomPick {



    Map<Integer, List<Integer>> index;
    public RandomPick(int[] nums) {
      index = new HashMap<>();
      for(int i = 0;i<nums.length;i++){
        List<Integer> l = index.getOrDefault(nums[i], new ArrayList<>());
        l.add(i);
        index.put(nums[i],l);
      }
    }

    public int pick(int target) {
      List<Integer> l = index.get(target);
      int idx = 0 + (int)(Math.random() * ((l.size() - 0)));
      return l.get(idx);
    }

}
