package com.algorithms;

public class SearchInRotatedArray {

  public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    return searchHelper(nums, 0, nums.length-1, target);
  }

  private int searchHelper(int []input, int l, int u, int target){

    if(l>u) return -1;
    int mid = l + ((u-l)/2);
    if(input[mid] == target) return mid;

    else if(input[mid] <= input[u]){
      if(target > input[mid] && target <= input[u]){
        return binarySearch(input, mid+1, u, target);
      }else{
        return searchHelper(input, l, mid-1, target);
      }
    }else{
      if(target < input[mid] && target >= input[l]){
        return binarySearch(input, l, mid-1, target);
      }else{
        return searchHelper(input, mid+1, u, target);
      }

    }


  }

  private int binarySearch(int []input, int l, int u, int target){
    if(l>u) return -1;
    int i = l, j = u;
    while(i<j){
      int mid = i + (j-i)/2;
      if(input[mid] == target) return mid;
      else if(input[mid] > target) j = mid - 1;
      else i = mid + 1;
    }
    if(input[i] == target) return i;
    return -1;
  }
}
