package com.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RandomizedSet {

  Map<Integer, Integer> valToIndex;
  Map<Integer, Integer> indexToVal;
  int sz;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    valToIndex = new HashMap<>();
    indexToVal = new HashMap<>();
    sz = 0;
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(valToIndex.containsKey(val)) return false;
    sz++;
    valToIndex.put(val, sz);
    indexToVal.put(sz, val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!valToIndex.containsKey(val)) return false;
    int index = valToIndex.get(val);
    valToIndex.remove(val);
    int key = indexToVal.get(sz);
    indexToVal.remove(sz);

    valToIndex.put(key, index);
    indexToVal.put(index, key);

    sz--;
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random r = new Random();
    int Low = 1;
    int High = sz+1;
    int Result = r.nextInt(High-Low) + Low;
    return indexToVal.get(Result);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */