package com.algorithms;

/**
 * Created by ajaspal on 1/3/17.
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int reverse = 0;
        int cpy = x;
        while(cpy != 0){
            int rem = cpy % 10;
            reverse = reverse * 10 + rem;
            cpy = cpy / 10;

        }
        if(x == reverse) return true;
        return false;
    }
}
