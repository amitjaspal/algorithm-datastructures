package com.algorithms;

/**
 * Created by ajaspal on 1/3/17.
 */
public class ReverseBits {

    public int reverseBits(int n) {
        printBinary(n);
        int answer = 0;
        for(int i = 0;i<=31;i++){
            int bit = (1<<i & n) > 0 ? 1 : 0;

            answer = answer | bit;
            if(i != 31)
            answer = answer << 1;

        }
        printBinary(answer);
        return answer;
    }

    private void printBinary(long x){
        System.out.println(Long.toBinaryString(x));
    }
}
