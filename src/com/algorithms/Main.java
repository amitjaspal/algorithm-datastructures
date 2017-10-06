package com.algorithms;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
      int []input = {1,2,6};
      CircularLinkedList obj = new CircularLinkedList();
      obj.init(input);
      obj.insert(4);
      obj.printLL();
    }
}
