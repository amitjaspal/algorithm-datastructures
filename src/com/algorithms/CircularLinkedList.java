package com.algorithms;

public class CircularLinkedList {

  class Node{
    int val;
    Node next;
  }

  Node head = null;
  public void init(int []input){
    Node tmp = null;
    for(int i = 0;i<input.length;i++){
      if(head == null){
        head = new Node();
        head.val = input[i];
        tmp = head;
        tmp.next = null;
      }else{
        tmp.next = new Node();
        tmp = tmp.next;
        tmp.val = input[i];
        tmp.next = null;
      }
    }
    tmp.next = head;
  }

  public void printLL(){
    Node tmp = head;
    do{
      System.out.print(tmp.val + "-->");
      tmp = tmp.next;
    }while(tmp != head);
    System.out.println(tmp.val);
  }

  public void insert(int N){
    if(head == null) return;

    Node tmp = head;
    Node prev = null;

    if(head.val >= N){
      Node tail;
      do{
        tmp = tmp.next;
      }while(tmp.next != head);
      tail = tmp;
      Node newHead = new Node();
      newHead.val = N;
      newHead.next = head;
      tail.next = newHead;
      head = newHead;
    }else{

      boolean isInserted = false;
      do{
        if(tmp.val >= N){
          Node newNode = new Node();
          newNode.val = N;
          newNode.next = tmp;
          prev.next = newNode;
          isInserted = true;
        }
        prev = tmp;
        tmp = tmp.next;
      }while(tmp != head);

      if(!isInserted){

        Node newNode = new Node();
        newNode.val = N;
        newNode.next = head;
        prev.next = newNode;
      }

    }
  }
}
