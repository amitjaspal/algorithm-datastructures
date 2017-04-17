package com.algorithms;

/**
 * Created by ajaspal on 1/4/17.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int answer = 0;
        int i = 0, j = height.length - 1;
        while(i<j){
            if(height[i]<=height[j]){
                answer = Math.max(answer, (j-i)*height[i]);
                i++;
            }else{
                answer = Math.max(answer, (j-i)*height[j]);
                j--;
            }
        }
        return answer;
    }
}
