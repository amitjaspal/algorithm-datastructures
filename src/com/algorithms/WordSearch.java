package com.algorithms;

import java.util.Arrays;


public class WordSearch {

  public boolean exist(char[][] board, String word) {
    if(board == null || board.length == 0 || board[0].length == 0) return false;
    int r = board.length;
    int c = board[0].length;
    boolean [][]isVisited = new boolean[r][c];
    for(int i = 0; i< r;i++){
      for(int j = 0;j<c;j++){
        if(board[i][j] == word.charAt(0)){
          isVisited = new boolean[r][c];
          if(applyDFS(word, i, j, r, c, 0, isVisited, board)) return true;
        }
      }
    }
    return false;
  }

  private boolean applyDFS(String word, int i, int j, int r, int c, int cnt, boolean [][]isVisited, char[][]board){
    System.out.println("i = " + i + " j = " + j + "  cnt " + cnt);
    //if(i == 1 && j == 2){
    //  System.out.println("cnt = " + cnt + " " + word.charAt(cnt) + " " + isVisited[i][j] + " " + board[i][j]);
    //}


    if(i < 0 || i >=r || j < 0 || j>=c || board[i][j] != word.charAt(cnt)) return false;

    if(isVisited[i][j] == true) return false;
    if(cnt == word.length()-1) return true;
      isVisited[i][j] = true;

      boolean tmp = applyDFS(word, i+1, j, r,c, cnt+1, deepCopy(isVisited), board) || applyDFS(word, i-1, j, r,c, cnt+1, deepCopy(isVisited), board)
        || applyDFS(word, i, j+1, r,c, cnt+1, deepCopy(isVisited), board) || applyDFS(word, i, j-1, r,c, cnt+1, deepCopy(isVisited), board);


    return tmp;
  }

  public static boolean[][] deepCopy(boolean[][] original) {
    if (original == null) {
      return null;
    }

    final boolean[][] result = new boolean[original.length][];
    for (int i = 0; i < original.length; i++) {
      result[i] = new boolean[original[i].length];
      for(int j = 0;j<original[i].length;j++){
        result[i][j] = original[i][j];
      }
      // For Java versions prior to Java 6 use the next:
      // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
    }
    return result;
  }
}
