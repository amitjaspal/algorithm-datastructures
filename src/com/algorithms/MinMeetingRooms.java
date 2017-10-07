package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MinMeetingRooms {


   public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
   }

   class Node{
     Integer value;
     boolean isEnd;
   }
   public int minMeetingRooms(Interval[] intervals) {
      if(intervals == null || intervals.length == 0) return 0;
      List<Node> l = new ArrayList<Node>();
      for(Interval i : intervals){
        Node n = new Node();
        n.value = i.start;
        n.isEnd = false;
        l.add(n);
        n = new Node();
        n.value = i.end;
        n.isEnd = true;
        l.add(n);
      }
     Collections.sort(l, (a, b) -> a.value.compareTo(b.value));
     int answer = 1;
     int intersecting = 1;
      for(int i = 1;i<l.size();i++){
        if(l.get(i).isEnd){
          intersecting --;
        }else{
          intersecting ++;
        }
        answer = Math.max(answer, intersecting);
     }
     return answer;
   }

  private int compareNode(Node n1, Node n2){

    if(n1.value < n2.value) return -1;
    else if(n1.value > n2.value) return 1;
    else{
      if(n1.isEnd) return -1;
      return +1;
    }

  }
}
