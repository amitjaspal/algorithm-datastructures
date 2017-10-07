package com.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


public class RearrangeTasks {

  class Node{
    Integer count;
    char ch;
  }
  public String rearrangeTasks(String input, int k){
    Map<Character, Integer> countMap = new HashMap<>();
    for(Character c : input.toCharArray()){
      int oldCount = countMap.getOrDefault(c, 0);
      countMap.put(c, oldCount + 1);
    }

    Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o2.count.compareTo(o1.count);
      }
    });

    for(Map.Entry<Character, Integer> e : countMap.entrySet()){
      Node n = new Node();
      n.count = e.getValue();
      n.ch = e.getKey();
      q.add(n);
    }

    char []result = new char[input.length()];
    int start = 0;
    while(q.size() != 0){
      Node n = q.poll();
      int freq = n.count;
      Character ch = n.ch;
      start = 0;
      while(result[start] != '\0') start++;
      int idx = start;
      while(freq != 0 && idx < input.length()){
        result[idx] = ch;
        idx = idx + k + 1;
        freq--;
      }

      System.out.println(Arrays.toString(result));
    }
    return new String(result);
  }
}
