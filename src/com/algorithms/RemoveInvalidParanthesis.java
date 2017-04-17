package com.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ajaspal on 11/28/16.
 */
public class RemoveInvalidParanthesis {

    Set<String> solutions;
    int maxSize = 0;
    public Set<String> removeParanthesis(String input){
        solutions = new HashSet<String>();
        findSolutions(input, 0, new StringBuffer());
        return solutions;
    }

    private void findSolutions(String input, int index, StringBuffer solution){

        if(index == input.length() && isValid(solution.toString())){
            //System.out.println(solution);
            //System.out.println(maxSize);
            if(solutions.size() > 0){
                if(maxSize > solution.length() ){
                    return;
                }
                else if(maxSize == solution.length() ){
                    solutions.add(solution.toString());
                }
                else{
                    solutions = new HashSet<String>();
                    solutions.add(solution.toString());
                    maxSize = solution.length();
                }
            }else{
                solutions.add(solution.toString());
                maxSize = solution.length();
            }
            return;
        }
        if(index == input.length()) return;

        findSolutions(input, index + 1, solution);
        solution.append(input.charAt(index));
        findSolutions(input, index + 1, solution);
        solution.deleteCharAt(solution.length() - 1);

    }

    private boolean isValid(String solution){
        int count = 0;
        for(Character c : solution.toCharArray()){
            if(c == '(') {
                count ++;
            }
            else{
                if(count == 0) return false;
                count --;
            }
        }
        if(count == 0) return true;
        return false;
    }
}
