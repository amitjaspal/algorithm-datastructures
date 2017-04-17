package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class CloneGraph {
  class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  };
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) return null;
    Map<UndirectedGraphNode, UndirectedGraphNode> mNoC = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    Stack<UndirectedGraphNode> st = new Stack<UndirectedGraphNode>();

    st.push(node);
    while(st.size() != 0){
      UndirectedGraphNode tmp = st.peek();
      st.pop();

      // copy this node;
      UndirectedGraphNode tmpCopy = mNoC.get(tmp);
      if(tmpCopy == null) {tmpCopy = new UndirectedGraphNode(tmp.label);
        mNoC.put(tmp, tmpCopy);
      }

      for(UndirectedGraphNode neighbour : tmp.neighbors){
        if(mNoC.containsKey(neighbour)){
          tmpCopy.neighbors.add(mNoC.get(neighbour));
        }else{
          UndirectedGraphNode tmpCopy1 = new UndirectedGraphNode(neighbour.label);
          tmpCopy.neighbors.add(tmpCopy1);
          mNoC.put(neighbour, tmpCopy1);
          st.push(neighbour);
        }

      }
    }
    return mNoC.get(node);
  }
}
