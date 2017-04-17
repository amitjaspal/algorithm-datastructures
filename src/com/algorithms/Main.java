package com.algorithms;

import java.security.acl.Group;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int []inputs = {1};
        System.out.println(Arrays.toString(p.productExceptSelf(inputs)));
    }
}
