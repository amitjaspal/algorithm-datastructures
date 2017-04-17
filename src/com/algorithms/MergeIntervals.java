package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajaspal on 10/19/16.
 */
public class MergeIntervals {

    class Interval {
        int start; int end;
        Interval(int x, int y){
            start = x;
            end = y;
        }
    }
    public List<Interval> insertInterval(List<Interval> input, Interval in){
        List<Interval> result = new ArrayList<Interval>();
        boolean hasMerged = false;
        for(int i = 0;i<input.size();i++){
            if(in.start > input.get(i).end || in.end < input.get(i).start){
                if(in.start < input.get(i).start){
                    result.add(in);
                    result.add(input.get(i));
                }else{

                    result.add(input.get(i));

                }

            }
        }
        return result;
    }
}
