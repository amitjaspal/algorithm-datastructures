package com.algorithms;

public class OneEditDistance {

  public boolean isOneEditDistance(String s, String t) {
    if(s == null && t == null) return false;
    if(s.equals(t)) return false;
    int l1 = s == null ? 0 : s.length();
    int l2 = t == null ? 0 : t.length();

    if(l1 != l2){
      if(Math.abs(l1-l2) == 1){
        if(s.contains(t) || t.contains(s)) return true;
        String bigger = s.length() > t.length() ? s : t;
        String smaller = s.length() > t.length() ? t : s;
        int j = 0;
        for(int i = 0;i<bigger.length();i++){
          if(bigger.charAt(i) == smaller.charAt(j)){
            j++;
          }
        }
        if(j == smaller.length()) return true;
        return false;
      }else{
        return false;
      }
    }else{
      int differentCount = 0;
      for(int i = 0;i<s.length();i++){
        if(s.charAt(i) != t.charAt(i)){
          differentCount++;
        }
      }
      if(differentCount <= 1) return true;
      return false;
    }
  }
}
