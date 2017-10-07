package com.algorithms;

import java.util.ArrayList;
import java.util.List;


public class PrettyPrintJSON {

  public void formatJSON(String input){
    if(input == null || input.length() == 0){
      return;
    }

    input = input.replace(" ", "");
    StringBuffer current = new StringBuffer();
    StringBuffer indent = new StringBuffer();
    int idx = 0;
    List<String> result = new ArrayList<>();
    while(idx < input.length()){

      if(input.charAt(idx) == ','){
        current.append(input.charAt(idx));
        result.add(current.toString());
        current = new StringBuffer(indent);
        idx++;
      }
      else if(input.charAt(idx) == '{' || input.charAt(idx) == '['){

        if(idx > 0 && input.charAt(idx - 1) != ',') {
          System.out.println("Hello");
          System.out.println(current.toString());
          result.add(current.toString());
        }
        current = new StringBuffer(indent);
        current.append(input.charAt(idx));
        result.add(current.toString());
        indent.append('\t');
        current = new StringBuffer(indent);
        idx++;
      }
      else if(input.charAt(idx) == '}' || input.charAt(idx) == ']'){
        if(current.length() > 0) {
          result.add(current.toString());
        }
        indent.deleteCharAt(indent.length()-1);
        current = new StringBuffer(indent);
        current.append(input.charAt(idx));

        idx++;
        if(idx == input.length() || input.charAt(idx) != ','){
          result.add(current.toString());
          current = new StringBuffer();
        }
      }else{
        current.append(input.charAt(idx));
        idx++;
      }


    }
    for(String x : result){
      System.out.println(x);
    }
  }
}
