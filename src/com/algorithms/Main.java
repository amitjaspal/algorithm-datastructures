package com.algorithms;

import java.security.acl.Group;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int []input = {2,1};
        SearchInRotatedArray s = new SearchInRotatedArray();
        System.out.println(s.search(input, 2));
    }
}
