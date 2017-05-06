package com.algorithms;

public class TrieTree {

  Node head;

  TrieTree(){
    head = new Node();
  }
  class Node{
    Node []pointers;
    boolean isLeaf;
    Node(){
       pointers = new Node[26];
       for(int i = 0;i<26;i++){
         pointers[i] = null;
       }
       isLeaf = false;
    }
  }


  public void insert(String s){
    if(s == null || s.length() == 0) return;
    head.pointers[(int)s.charAt(0) - 97] = insertHelper(head.pointers[(int)s.charAt(0) - 97], s, 0);
  }

  private Node insertHelper(Node n, String s, int index){
    Node newNode;
    if(n == null){
      newNode = new Node();
      if(index == s.length() - 1){
        newNode.isLeaf = true;
        return newNode;
      }else{
        newNode.pointers[(int)s.charAt(index+1) - 97] = insertHelper(newNode.pointers[(int)s.charAt(index+1) - 97], s, index + 1);
        return newNode;
      }
    }else{
      if(index == s.length() - 1){
        n.isLeaf = true;
        return n;
      }else {
        n.pointers[(int) s.charAt(index + 1) - 97] = insertHelper(n.pointers[(int) s.charAt(index + 1) - 97], s, index + 1);
        return n;
      }
    }

  }

  public boolean search(String s){
    if(s == null || s.length() == 0) return false;
    return searchHelper(head.pointers[(int)s.charAt(0) - 97], s, 0);
  }

  private boolean searchHelper(Node n, String s, int index){
    if(n == null ) return false;
    else if(n.isLeaf && index == s.length() - 1){
      return true;
    }
    else if(index == s.length() - 1) return false;
    else{
      return searchHelper(n.pointers[(int)s.charAt(index+1) - 97], s, index+1);
    }

  }

  public boolean startsWith(String s){
    if(s == null || s.length() == 0) return false;
    return startsWithHelper(head.pointers[(int)s.charAt(0) - 97], s, 0);
  }

  private boolean startsWithHelper(Node n, String s, int index){
    //System.out.println(index);
    if(n == null ) {
      //System.out.println("null found");
      return false;
    }
    else if(index >= s.length() - 1){
      return true;
    }

    else{
      return startsWithHelper(n.pointers[(int)s.charAt(index+1) - 97], s, index+1);
    }

  }
}
