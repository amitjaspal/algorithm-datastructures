package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph1 {

  Map<Integer, List<Integer>> adjList;
  boolean isDirected;

  public Graph1(int [][]input){
    adjList = new HashMap<>();
    for(int i = 0;i<input.length;i++){
      List<Integer> tmp = new ArrayList<>();
      for(int j = 0; j<input[0].length;j++){
        if(input[i][j] != 0){
          tmp.add(j);
        }
      }
      adjList.put(i, tmp);
    }
  }

  public boolean isBiPartite(){
    int sz = adjList.size();
    char []colors = new char[sz];
    for(int i = 0;i<sz;i++){
      colors[i] = 'G';
    }
    return runDFS(0, colors, 'W');
  }

  private boolean runDFS(int N, char []colors, char expColor){
    System.out.println("N = " + N + " expC " + expColor);
    if(colors[N] == 'G'){
      colors[N] = expColor;
      boolean isBiPartitie = true;
      for(Integer n : adjList.get(N)){
        char ch = expColor == 'W' ? 'B' : 'W';
        isBiPartitie = isBiPartitie & runDFS(n, colors, ch);
      }
      return isBiPartitie;
    }else{
      return colors[N] == expColor;
    }
  }

}
