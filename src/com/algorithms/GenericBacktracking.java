package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GenericBacktracking {

  public List<List<Integer>> subsets(int[] nums) {
    if(nums == null || nums.length == 0) return new ArrayList<>();
    List<List<Integer>> solution = new ArrayList<>();
    subsetsHelper(nums, 0, solution, new ArrayList<>());
    return solution;
  }

  private void subsetsHelper(int []input, int index, List<List<Integer>> solution, List<Integer> candidate){
    //if(index == input.length) return;

    solution.add(new ArrayList<>(candidate));

    for(int i = index ;i<input.length;i++){
      candidate.add(input[i]);
      subsetsHelper(input, i + 1, solution, candidate);
      candidate.remove(candidate.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithoutDups(int[] nums) {
    if(nums == null || nums.length == 0) return new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> solution = new ArrayList<>();
    subsetsWithoutDupsHelper(nums, 0, solution, new ArrayList<>());
    return solution;
  }

  private void subsetsWithoutDupsHelper(int []input, int index, List<List<Integer>> solution, List<Integer> candidate){
    //if(index == input.length) return;

    solution.add(new ArrayList<>(candidate));

    for(int i = index ;i<input.length;i++){
      if(i>index && input[i] == input[i-1]) continue;
      candidate.add(input[i]);
      subsetsHelper(input, i + 1, solution, candidate);
      candidate.remove(candidate.size() - 1);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> solution = new ArrayList<>();
    permuteHelper(nums, new ArrayList<>(),solution);
    return solution;
  }

  private void permuteHelper(int []input, List<Integer> candidate, List<List<Integer>> solution){
    if(candidate.size() == input.length){
      solution.add(new ArrayList<>(candidate));
      return;
    }

    for(int i = 0;i<input.length;i++){
      if(!candidate.contains(input[i])){
        candidate.add(input[i]);
        permuteHelper(input, candidate, solution);
        candidate.remove(candidate.size() - 1);
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    if(nums == null || nums.length == 0) return new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> solution = new ArrayList<>();
    boolean []isUsed = new boolean[nums.length];
    permuteUniqueHelper(nums, 0, new ArrayList<>(),solution,isUsed);
    return solution;
  }

  private void permuteUniqueHelper(int []input, int index, List<Integer> candidate, List<List<Integer>> solution, boolean []isUsed){
    //System.out.println(candidate);
    if(candidate.size() == input.length){
      solution.add(new ArrayList<>(candidate));
      return;
    }

    for(int i = 0;i<input.length;i++){
      if(i>0 && input[i] == input[i-1] && isUsed[i-1]) continue;
      if(!isUsed[i]){
        candidate.add(input[i]);
        isUsed[i] = true;
        permuteUniqueHelper(input, i+1, candidate, solution, isUsed);
        isUsed[i] = false;
        candidate.remove(candidate.size() - 1);
      }
    }
  }
}
