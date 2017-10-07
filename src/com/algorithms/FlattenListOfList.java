package com.algorithms;

import java.util.ArrayList;
import java.util.List;


public class FlattenListOfList {

  public List<Integer> flattenListOfList(List<Object> input){
    if(input == null || input.size() == 0) return null;
    List<Integer> answer = new ArrayList<>();
    for(int i = 0;i<input.size();i++){
      if( input.get(i) instanceof Integer){
        answer.add((int)input.get(i));
      }else{
        answer.addAll(flattenListOfList((List<Object>)input.get(i)));
      }
    }
    return answer;
  }
}
