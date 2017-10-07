package com.algorithms;

public class MoveZeros {

  public void moveZeros(int []input){

    if(input == null || input.length == 0) return ;

    int i = 0, j = 0;
    while(j < input.length){
      if(input[j] == 0){
        j++;
      }else{
        int tmp = input[j];
        input[j] = input[i];
        input[i] = tmp;
        i++;
        j++;
      }
    }

  }
}
