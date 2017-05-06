package com.algorithms;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
      MaximumSqurae obj = new MaximumSqurae();
      char [][]input = {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};
      System.out.println(obj.maximalSquare(input));
    }
}
