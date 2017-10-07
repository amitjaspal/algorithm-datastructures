package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeInterval {

  public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if(intervals == null && newInterval == null) return new ArrayList<>();
    if(intervals == null || intervals.size() == 0) return Arrays.asList(newInterval);
    if(newInterval == null) return intervals;

    List<Interval> answer = new ArrayList<>();
    boolean isIntersecting = false;
    boolean intervalInserted = false;
    for(Interval i : intervals){
      if(i.start <= newInterval.end && i.end >= newInterval.end){
        newInterval = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
        isIntersecting = true;
      }
      else if(i.start <= newInterval.start && i.end >= newInterval.start){
        newInterval = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
        isIntersecting = true;
      }else{
        if(isIntersecting){
          answer.add(newInterval);
          answer.add(i);
          intervalInserted = true;
        }else{
          answer.add(i);
        }
      }

    }

    if(isIntersecting == false && newInterval.start > intervals.get(intervals.size()-1).end) answer.add(newInterval);
    else if(isIntersecting == false && newInterval.end < intervals.get(0).start) answer.add(0,newInterval);


    if(isIntersecting && intervalInserted == false){
      answer.add(newInterval);
    }
    return answer;

  }
}
