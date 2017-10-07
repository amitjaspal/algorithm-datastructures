package com.algorithms;

public class BinarySearch {

  public int findFloor(int []input, int key){
    if(input == null || input.length == 0) return -1;
    int l = 0;
    int u = input.length - 1;
    while(u-l>1){
      int mid = l + ((u-l)/2);
      if(input[mid] >= key){
        u = mid;
      }else{
        l = mid;
      }
    }
    if(key >= input[l] && key < input[u]) return input[l];
    if(key >= input[u]) return input[u];
    return -1;
  }
}
