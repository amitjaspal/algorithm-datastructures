package com.algorithms;

import java.util.ArrayList;
import java.util.List;


public class SparseMatrixMultiplication {
  class Node{
    int index;
    int val;
    Node(int i, int v){
      this.index = i;
      this.val = v;
    }
  }
  public int[][] multiply(int[][] A, int[][] B) {
    int n = A.length;
    int k = A[0].length;
    int m = B[0].length;
    List<List<Node>> l1 = new ArrayList<>(n);
    for(int i = 0;i< n;i++){
      List<Node> tmp = new ArrayList<>();
      for(int j = 0;j<k;j++){
        if(A[i][j] != 0){
          tmp.add(new Node(j, A[i][j]));
        }
      }
      l1.add(tmp);
    }
    List<List<Node>> l2 = new ArrayList<>(m);
    for(int i = 0;i< m;i++){
      List<Node> tmp = new ArrayList<>();
      for(int j = 0;j<k;j++){
        if(B[j][i] != 0){
        }
      }
      l2.add(tmp);
    }
    int [][]result = new int[n][m];
    for(int i = 0;i<n;i++){
      for(int j = 0;j<m;j++){
        result[i][j] = multiply(l1.get(i), l2.get(j));
      }
    }
    return result;
  }

  private int multiply(List<Node> l1, List<Node> l2){
    int tmp = 0;
    int i = 0, j = 0;
    while(i < l1.size() && j<l2.size()){
      if(l1.get(i).index > l2.get(j).index){
        j++;
      }
      else if(l1.get(i).index < l2.get(j).index){
        i++;
      }else{
        i++;
        j++;
        tmp += l1.get(i).val * l2.get(j).val;
      }
    }
    return tmp;
  }
}
