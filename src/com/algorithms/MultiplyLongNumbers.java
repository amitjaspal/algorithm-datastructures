package com.algorithms;

import com.sun.deploy.util.StringUtils;
import java.util.Arrays;


public class MultiplyLongNumbers {

  public String multiply(String a, String b){
    if(a == null || a.length() == 0) return "0";
    if(b == null || b.length() == 0) return "0";

    String bigger = a.length() > b.length() ? a : b;
    String smaller = bigger.equals(a) ? b : a;

    int size = bigger.length() + smaller.length();
    int [] result = new int[size+1];

    //System.out.println(result.length());
    int carry = 0,i =0,j =0;
    for(i = smaller.length()-1;i >= 0;i--){
      int num1 = smaller.charAt(i) - '0';
      carry = 0;
      for(j = bigger.length() - 1;j>=0;j--){
        int num2 = bigger.charAt(j) - '0';
        int oldValue = result[i + j];
        int sum = num1 * num2 + oldValue + carry;
        carry = sum / 10;

        result[i + j + 2] = sum % 10;
      }
    }
    if(carry > 0){
      result[0] = carry;
    }
    System.out.println(Arrays.toString(result));
    return Arrays.toString(result);
  }
}
