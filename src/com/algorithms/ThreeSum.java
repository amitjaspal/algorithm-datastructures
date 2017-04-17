package com.algorithms;

import java.util.*;

/**
 * Created by ajaspal on 10/9/16.
 */
public class ThreeSum {

    class Triplet extends Object{
        int x,y,z;
        Triplet(int a, int b, int c){
            x = Math.min(a, Math.min(b,c));
            y = Math.max(a, Math.min(b, c));
            z = Math.max(a, Math.max(b,c));
        }

        @Override
        public int hashCode() {
            int result = 0;
            result += 11 * x + 13 * y + 17 * z;
            return result;
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> input = new HashMap<Integer, Integer>();
        Set<Triplet> result = new HashSet<Triplet>();
        for(int i = 0;i<nums.length;i++){
            input.put(nums[i], i);
        }
        for(int i = 0; i< nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int target = -1 * (nums[i] + nums[j]);
                if(input.containsKey(target) && input.get(target) != i && input.get(target) != j){
                    result.add(new Triplet(target, nums[i], nums[j]));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(Triplet t : result){
            List<Integer> l = new ArrayList<Integer>();
            l.add(t.x);
            l.add(t.y);
            l.add(t.z);
            ans.add(l);
        }
        return ans;
    }
}
