package com.algorithms;

/**
 * Created by ajaspal on 10/18/16.
 */
public class RotateArray {

    public int[] rotate (int []input, int k){
        int sz = input.length;
        int []result = new int [sz];
        for(int i = 0;i < sz;i++){
            result[ (k + i) % sz] = input[i];
        }
        return result;
    }
}
