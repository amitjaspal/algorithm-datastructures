package com.algorithms;

import java.util.TreeSet;


public class TryTreeSet {

  public static void main(String[] args) {
    TreeSet t = new TreeSet();
    t.add(10);
    t.add(5);
    t.add(5);
    t.remove(5);
    System.out.println(t.first());
  }
}
