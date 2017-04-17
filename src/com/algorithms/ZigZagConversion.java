package com.algorithms;

/**
 * Created by ajaspal on 1/3/17.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        char [][]grid = new char[numRows][s.length()];
        if(numRows ==1) return s;
        boolean dir = true;
        int r = 0; int c = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(dir){
                grid[r][c] = ch;
                r++;

            }else{
                grid[r][c] = ch;
                r--;
                c++;
            }
            if(r == numRows || r == -1) {
                if(r == numRows) {r = r-2; c = c +1;}
                else {r = 1;}
                dir = !dir;
            }
        }
        StringBuffer answer = new StringBuffer();
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<s.length();j++){
                if(grid[i][j] != '\u0000'){
                    answer.append(grid[i][j]);
                }
            }
        }

        return answer.toString();

    }
}
