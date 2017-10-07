package com.algorithms;

import java.util.*;
import java.util.LinkedList;


public class SlidingWindowMaximum {

  class Node{
    int val;
    int index;
  }

  public int[] computeSlidingWindowMax(int []input, int k){
    if(input == null || input.length == 0) return null;
    if(k == 0) return null;
    if(k == 1) return input;

    // bootstrap;
    int []result = new int[input.length - k + 1];
    int max = input[0];
    int maxIndex = 0;
    for(int i = 1; i < k;i++){
      if(input[i] >= max){
        max = input[i];
        maxIndex = i;
      }
    }
    int t = 0;
    result[t++] = max;
    Deque<Node> dq = new LinkedList<>();
    Node n = new Node();
    n.index = maxIndex;
    n.val = max;
    dq.addLast(n);
    for(int i = k;i<input.length;i++){
      while(dq.size() > 0 && dq.getLast().val <= input[i]){
        dq.removeLast();
      }
      n = new Node();
      n.val = input[i];
      n.index = i;
      dq.addLast(n);

      if(i - dq.getFirst().index + 1 > k){
        dq.removeFirst();
      }
      result[t++] = dq.getFirst().val;
    }
    return result;
  }
}
