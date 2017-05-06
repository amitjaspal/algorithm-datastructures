package com.algorithms;

public class MyPower {

  public double myPow(double x, int n) {
    if(n == 0) return 1.0;
    if(n == 1) return x;
    if(n % 2 == 0){
      double a = myPow(x, n/2);
      return a*a;
    }else{
      double a = myPow(x, n/2);
      return a*a*x;
    }
  }
}
