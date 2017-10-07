package com.algorithms;

public class ConvertExpression {

  class Node{
    Character ch;
    Node left;
    Node right;
  }

  Node root;

  int index = 0;
  public void convertExpressionToTree(String input){
    if(input == null || input.length() == 0) return;
    root = convertExpressionToTreeHelper(input);
    Node tmp = root;
    printTree(tmp);
  }

  private void printTree(Node tmp){
    if(tmp != null){
      System.out.println(tmp.ch);
      printTree(tmp.left);
      printTree(tmp.right);
    }
  }

  private Node convertExpressionToTreeHelper(String input){
    if(index >= input.length()) return null;

    char ch = input.charAt(index);
    Node n = new Node();
    n.ch = ch;
    index++;

    if(index == input.length() || input.charAt(index) == ':'){
      n.left = null;
      n.right = null;
      if(index != input.length()) index++;
      return n;
    }else{
      index++;
      n.left = convertExpressionToTreeHelper(input);
      n.right = convertExpressionToTreeHelper(input);
      return n;
    }
  }
}
