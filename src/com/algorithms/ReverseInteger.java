package com.algorithms;

/**
 * Created by ajaspal on 10/8/16.
 */
public class ReverseInteger {

    public int reverse(int x) {

        boolean preceedingZero = true;
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x = x * -1;
        }
        int answer = 0;
        while(x != 0){
            int rem = x % 10;
            if(rem == 0 && preceedingZero) {
                x = x / 10;
                continue;
            }
            else preceedingZero = false;

            if( answer != 0 &&  ((Integer.MAX_VALUE - rem) / answer < 10)) return 0;
            answer = 10* answer + rem;
            x = x / 10;
        }

        return isNegative ? -answer : answer;
    }
}
