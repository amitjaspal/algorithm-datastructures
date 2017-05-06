package com.algorithms;

import java.util.Stack;


public class NumberOfIslands {

  public int numIslands(char[][] grid) {

    if(grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
    boolean [][]isVisited = new boolean[grid.length][grid[0].length];
    int connectedComponents = 0;
    for(int i = 0; i< grid.length;i++){
      for(int j = 0;j<grid[0].length;j++){
        if(grid[i][j] == '1' && !isVisited[i][j]) {
          dfs(grid, isVisited, i, j);
          connectedComponents++;
        }
      }
    }
    return connectedComponents;
  }

  class Node{
    int x; int y;
    Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  private void dfs(char[][] grid, boolean [][]isVisited, int i, int j){
    Node n = new Node(i, j);
    Stack<Node> st = new Stack();
    st.push(n);
    while(st.size() != 0){
      Node tmp = st.pop();
      if(isVisited[tmp.x][tmp.y]) continue;
      isVisited[tmp.x][tmp.y] = true;
      int idx = tmp.x;
      int idy = tmp.y;
      if(idx + 1 < grid.length && !isVisited[idx + 1][idy] && grid[idx+1][idy] == '1'){
        n = new Node(idx+1, idy);
        st.push(n);
      }
      if(idx - 1 >= 0 && !isVisited[idx - 1][idy] && grid[idx-1][idy] == '1'){
        n = new Node(idx-1, idy);
        st.push(n);
      }
      if(idy - 1 >= 0 && !isVisited[idx][idy-1] && grid[idx][idy - 1] == '1'){
        n = new Node(idx, idy-1);
        st.push(n);
      }
      if(idy + 1 < grid[0].length && !isVisited[idx][idy + 1] && grid[idx][idy + 1] == '1'){
        n = new Node(idx, idy + 1);
        st.push(n);
      }
    }
  }
}
