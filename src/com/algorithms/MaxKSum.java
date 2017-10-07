package com.algorithms;

public class MaxKSum {

  public int findMaxSumWithKElements(int []input, int k){
    if(input == null || input.length == 0) return 0;

    int i = 0;
    int j = i + k - 1;
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for(int t = 0;t <= j;t++){
      currentSum = currentSum + input[t];
    }
    maxSum = Math.max(maxSum, currentSum);
    j++;
    while(j < input.length){

      currentSum = currentSum + input[j];
      if(currentSum > 0){
        maxSum = Math.max(maxSum, currentSum);
      }else{
        int bestI = i;
        int bestMax = maxSum;
        int currentSumStore = currentSum;
        while((j - i + 1) >= k ) {
          currentSum = currentSum - input[i];
          i++;
          if(currentSum > maxSum){
            maxSum = currentSum;
            break;
          }

        }
        if(maxSum == bestMax){
          i = bestI;
          currentSum = currentSumStore;
        }
      }
      j++;
    }
    return maxSum;
  }
}
