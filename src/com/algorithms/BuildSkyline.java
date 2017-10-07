package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class BuildSkyline {

  class Node implements Comparable<Node> {
    int height;
    int x;
    boolean isEnd;

    public int compareTo(Node n){
      if (this.x < n.x) return -1;
      if ((this.x == n.x) && (this.isEnd)) return -1;
      if ((this.x == n.x) && (n.isEnd)) return +1;
      if (this.x == n.x && !this.isEnd && this.height > n.height) return -1;
      return 1;
    }
  }

  public List<int[]> getSkyline(int[][] buildings) {

    if (buildings == null || buildings.length == 0) return new ArrayList<>();

    List<Node> input = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      int x = buildings[i][0];
      int y = buildings[i][1];
      int h = buildings[i][2];
      Node n = new Node();
      n.x = x;
      n.height = h;
      n.isEnd = false;
      input.add(n);
      n = new Node();
      n.x = y;
      n.isEnd = true;
      n.height = h;
      input.add(n);
    }

    Collections.sort(input);
    int prev = 0;
    int prev_x = Integer.MIN_VALUE;
    List<int[]> solution = new ArrayList<>();
    TreeSet<Node> index = new TreeSet<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if(o1.height > o2.height) return -1;
        if(o1.height == o2.height) return 0;
        return 1;
      }


      public boolean equals(Node o1, Node o2){
        return o1.height == o2.height;
      }
    });
    for(Node tmp:input){
      //System.out.println(tmp.x);
      if(!tmp.isEnd){

        if(tmp.height > prev){

        }
        index.add(tmp);
      }else{
        index.remove(tmp);
        prev_x = Math.max(prev_x, tmp.x);
        if(index.size() == 0){
          prev = 0;
          continue;
        }
        Node n = index.first();
        if(n.height < prev){
          int []point = new int[2];
          point[0] = tmp.x;
          point[1] = n.height;
          solution.add(point);
          prev = n.height;
        }
      }
    }
    int []point = new int[2];
    point[0] = prev_x;
    point[1] = 0;
    solution.add(point);
    return solution;
  }
}
