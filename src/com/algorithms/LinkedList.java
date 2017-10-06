package com.algorithms;

/**
 * Created by ajaspal on 3/17/17.
 */
public class LinkedList {

    class Node
    {
        int x;
        Node next;

        Node(int val){
            this.x = val;
            this.next = null;
        }
    }

    Node head = null;
    Node current = head;
    LinkedList(int []inputs){
        for(int input : inputs){
            if(head == null){
                head = new Node(input);
                current = head;
            }else{
                current.next = new Node(input);
                current = current.next;
            }
        }
    }


    public void printLinkedList(){
        Node tmp = head;
        while(tmp.next != null){
            System.out.print(tmp.x + " --> ");
            tmp = tmp.next;
        }
        System.out.println(tmp.x);
    }

    public void reverse(){
        Node current = head;
        Node prev = null;
        while(current != null){
            Node tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        head = prev;
    }

    public void reverseRecursive(){
        reverseRecursiveHelper(head, null);

    }

    private void reverseRecursiveHelper(Node current, Node previous){

        if(current == null){
            head = previous;
            return;
        }else{
            reverseRecursiveHelper(current.next, current);
            current.next = previous;
        }
    }

    Node first;
    boolean keepSwapping = true;
    public void reorder(){
        first = head;
        reorderHelper(head);
    }
    private void reorderHelper(Node current){
        if(current.next == null){
            Node tmp = first.next;
            first.next = current;
            current.next = tmp;
            first = tmp;
            return;
        }
        reorderHelper(current.next);
        if(first.next == current){
            current.next = null;
            keepSwapping = false;
            return;
        }
        if(keepSwapping){
            Node tmp = first.next;
            first.next = current;
            current.next = tmp;
            first = tmp;
            return;
        }

    }

    public void reverseBetween(int m, int n) {
        Node current = head, prev = null;
        int cnt  = 1;
        boolean doReverse = false;
        while(current != null){
            if(cnt == m-1){
                first = current;

                doReverse = true;
            }else if( cnt >= m+1 && cnt < n){
                Node tmp = current.next;
                current.next = prev;

            }else if(cnt == n){

            }

            prev = current;
            current = current.next;
        }
    }

    public void KReverse( int k ){
        Node current = head;
        Node lastTail = null;
        while(current != null){
            Node currentTail = current, prev = null;
            for(int i = 0;i<k;i++){
                Node tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }
            if(lastTail != null){
                lastTail.next = prev;
            }else{
                head = prev;
            }
            lastTail = currentTail;
        }
    }


    private boolean isPalindrome = true;
    public boolean isPalindrome(){
        first = head;
        isPalindromeHelper(head);
        return isPalindrome;
    }

    private void isPalindromeHelper(Node head){
        if(head.next == null){
           if(first.x != head.x) isPalindrome = false;
           first = first.next;
           return;
        }else{
            isPalindromeHelper(head.next);
            if(first.x != head.x) isPalindrome = false;
            first = first.next;
            return;
        }
    }

}
