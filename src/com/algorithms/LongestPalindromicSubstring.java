package com.algorithms;

/**
 * Created by ajaspal on 10/8/16.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {


        if(s == null || s.length() <= 1) return s;

        if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return s;

        int beginIndex = 0, endIndex = 0, length = 1;
        int sz = s.length();
        for(int center = 0;center < sz;center++){
            int candidate = 1, j = 1;

            while(center-j >= 0 && center + j < sz && s.charAt(center-j) == s.charAt(center + j)){
                j++;
                candidate += 2;
            }

            if(candidate > length){
                length = candidate;
                beginIndex = center - j + 1;
                endIndex = center + j - 1;
            }

            if(center + 1 < s.length() && s.charAt(center) == s.charAt(center + 1)){
                j = 1;
                candidate = 2;
                while(center - j >=0 && center + 1 + j < sz && s.charAt(center - j) == s.charAt(center + 1 + j)){
                    j++;
                    candidate += 2;
                }
            }

            if(candidate > length){
                length = candidate;
                beginIndex = center - j + 1;
                endIndex = center + 1 + j -1 ;
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }




}
