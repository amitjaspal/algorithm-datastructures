package com.algorithms;

/**
 * Ensure that there are a minimum of n dashes between any two of the same characters of a string.

 * Example: n = 2, string = "--abbcdecca" -> "ab--bcdec—ca"
 */

public class StringWithMinimumNDashes {

  public String constructStingWithMinimumNDashes(String input, int n){
    if(input == null || input.length() < 2) return input;
    StringBuffer output = new StringBuffer();
    Character lastChar = null;
    int lastIndex = -1;
    for(int i = 0;i<input.length();i++){
      if(input.charAt(i) == '-'){
        output.append('-');
      }
      else{
        if(lastChar != null && lastChar == input.charAt(i) && ((i - lastIndex -1) < n)){
          int toAppend = n - (i - lastIndex - 1);
          while(toAppend > 0){
            output.append('-');
            toAppend--;
          }

        }
        output.append(input.charAt(i));
        lastChar = input.charAt(i);
        lastIndex = i;
      }
    }
    return output.toString();
  }
}
