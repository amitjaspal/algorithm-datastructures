package com.algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class BrickWall {

  class Node implements Comparable<Node>{
    int brickRow;
    int brickColumn;
    Integer brickSize;

    public int compareTo(Node o){
      return brickSize.compareTo(o.brickSize);
    }

  }

  public int leastBricks(List<List<Integer>> wall) {
    if(wall == null || wall.size() == 0) return 0;

    Queue<Node> q = new PriorityQueue<>();
    Map<Integer,Integer> index = new HashMap<Integer, Integer>();
    int answer = wall.size();
    // initialize the priority queue;
    for(int i = 0;i<wall.size();i++){
      if(wall.get(i) != null && wall.get(i).get(0) != null){
        Node n = new Node();
        n.brickRow = i;
        n.brickColumn = 0;
        n.brickSize = wall.get(i).get(0);
        int cnt = index.getOrDefault(n.brickSize, 0);
        cnt++;
        index.put(n.brickSize, cnt);
        q.add(n);
      }
    }
    while(q.size() != 0){
      Node tmp = q.poll();

      int x = index.get(tmp.brickSize);
      if(x > 0){
        index.put(tmp.brickSize, x - 1);
      }
      if(tmp.brickColumn == wall.get(tmp.brickRow).size() - 1) continue;
      //System.out.println(tmp.brickSize + "->" + x);
      answer = Math.min(answer, wall.size() - x);

      if(wall.get(tmp.brickRow).size() > (tmp.brickColumn + 1)){
        Node n = new Node();
        n.brickRow = tmp.brickRow;
        n.brickColumn = tmp.brickColumn + 1;
        n.brickSize = tmp.brickSize + wall.get(tmp.brickRow).get(tmp.brickColumn + 1);
        q.add(n);
        int cnt = index.getOrDefault(n.brickSize, 0);
        cnt++;
        index.put(n.brickSize, cnt);
      }


    }
    return answer;
  }
}
