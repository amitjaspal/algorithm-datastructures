package com.algorithms;

import java.util.*;
import java.util.LinkedList;


public class WordLadder {

  class Node{
    String word;
    int level;
    Node(String word, Integer level){
      this.word = word;
      this.level = level;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList)
  {
    if(beginWord ==  null || endWord == null || wordList == null || wordList.size() == 0) return 0;
    if(beginWord.length() != endWord.length()) return 0;
    Set<String> dict = new HashSet<>();
    for(String x : wordList){
      dict.add(x);
    }
    Node n = new Node(beginWord, 1);
    Queue<Node> q = new LinkedList<Node>();
    q.add(n);
    while(q.size() != 0){
      Node tmp = q.poll();
      //System.out.println(tmp.word);
      int li = tmp.level;

      for(int i = 0;i<tmp.word.length();i++){

        for(int j = 0;j<26;j++){
          StringBuffer candidate = new StringBuffer(tmp.word);
          candidate.setCharAt(i, (char)(97+j));
          if(dict.contains(candidate.toString())){
            if(candidate.toString().equals(endWord)) return li + 1;
            dict.remove(candidate.toString());
            q.add(new Node(candidate.toString(), li + 1));
          }
        }
      }
    }
    return 0;
  }
}
