package com.algorithms;

public class MaximumSqurae {

  public int maximalSquare(char[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

    int DP[][] = new int[matrix.length][matrix[0].length];

    int answer = 0;
    for(int i = 0; i<matrix.length;i++){


      DP[i][0] = matrix[i][0] == '1' ? 1: 0;
      answer = Math.max(answer, DP[i][0]);
    }

    for(int i = 0; i<matrix[0].length;i++){


      DP[0][i] = matrix[0][i] == '1' ? 1: 0;
      answer = Math.max(answer, DP[0][i]);
    }

    for(int i = 1;i<matrix.length;i++){
      for(int j = 1;j<matrix[0].length;j++){
        if(matrix[i][j] == '1') {
          DP[i][j] = Math.min(DP[i][j - 1], Math.min(DP[i - 1][j - 1], DP[i - 1][j])) + 1;
          answer = Math.max(answer, DP[i][j]);
        }
      }
    }
    return answer*answer;
  }
}
