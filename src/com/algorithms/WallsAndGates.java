package com.algorithms;

import java.util.*;
import java.util.LinkedList;


public class WallsAndGates {

  class Node{
    int x; int y;

    Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  public void wallsAndGates(int[][] rooms) {
    if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

    Queue<Node> q = new LinkedList<Node>();
    // initialize the queue
    for(int i = 0;i<rooms.length;i++){
      for(int j = 0;j<rooms[0].length;j++){
        if(rooms[i][j] == 0){
          q.add(new Node(i,j));
        }
      }
    }
    while(q.size() != 0){
      Node tmp = q.poll();
      int idx = tmp.x;
      int idy = tmp.y;
      if(idx + 1 < rooms.length && rooms[idx + 1][idy] == Integer.MAX_VALUE){
        rooms[idx + 1][idy] = rooms[idx][idy] + 1;
        q.add(new Node(idx+1, idy));
      }

      if(idx - 1 >= 0 && rooms[idx - 1][idy] == Integer.MAX_VALUE){
        rooms[idx - 1][idy] = rooms[idx][idy] + 1;
        q.add(new Node(idx-1, idy));
      }

      if(idy + 1 < rooms[0].length && rooms[idx][idy+1] == Integer.MAX_VALUE){
        rooms[idx][idy + 1] = rooms[idx][idy] + 1;
        q.add(new Node(idx, idy + 1));
      }

      if(idy-1 >= 0 && rooms[idx][idy-1] == Integer.MAX_VALUE){
        rooms[idx][idy - 1] = rooms[idx][idy] + 1;
        q.add(new Node(idx, idy - 1));
      }
    }

    return;
  }
}
