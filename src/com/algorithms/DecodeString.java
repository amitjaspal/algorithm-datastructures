//package com.algorithms;
//
//public class DecodeString {
//
//  public String decodeString(String input){
//
//  }
//
//  private String decodeString(String input, int start, int end){
//    if(start > end) return "";
//    StringBuffer result = new StringBuffer();
//    for(int i = start;i<=end;){
//      if(Character.isDigit(input.charAt(i))){
//        int l = findLastBrace(input, start + 1,end);
//        String partialResult = decodeString(input, start+2, l);
//
//      }
//    }
//  }
//}
