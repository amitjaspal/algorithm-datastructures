package com.algorithms;

import java.util.Arrays;


public class KthLargest {

  public int findKthLargestNumber(int []input, int k){
    if(input == null || input.length == 0) return -1;

    int index = input.length - k;
    if(k < 0 || index < 0) return -1;

    int t = findKthLargestNumberHelper(input, index, 0, input.length-1);
    return input[t];
  }

  private int findKthLargestNumberHelper(int []input, int k, int l, int u){


    int tmp = quickSelect(input, l, u);
    //System.out.println("resulting index = " + tmp);
    if(tmp == (l + k)) return tmp;
    else if(tmp > (l + k)) return findKthLargestNumberHelper(input, k, l, tmp-1);
    else return findKthLargestNumberHelper(input, k - tmp-1,tmp+1, u);
  }

  private int quickSelect(int []input, int l, int u){
    int i = l, j = u;
    int pivot = input[l];
    while(i<j){
      while(i<u && input[i] <= pivot) i++; // Take care of equality i.e i != u
      while(j>l && input[j] >= pivot) j--;
      if(i<j && input[i] > input[j]){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
      }
    }
    input[l] = input[j];
    input[j] = pivot;
    return j;
  }
}
