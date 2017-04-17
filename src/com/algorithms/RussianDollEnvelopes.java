package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ajaspal on 3/20/17.
 */
public class RussianDollEnvelopes {

    class Envelope implements Comparable<Envelope>{
        int w;
        int h;

        public int compareTo(Envelope e){
            if(this.w <= e.w)return -1;
            return 1;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        List<Envelope> inputs = new ArrayList<Envelope>();
        for(int i = 0;i< envelopes.length;i++) {
            Envelope e = new Envelope();
            e.w = envelopes[i][0];
            e.h = envelopes[i][1];
            inputs.add(e);
        }
        Collections.sort(inputs);
        //for(int i = 0;i<inputs.size();i++){
        //    System.out.println("w = " + inputs.get(i).w + " h = " + inputs.get(i).h);
        //}

        int DP[] = new int[inputs.size()];
        Arrays.fill(DP, 1);
        int answer = 1;
        for(int i = 1;i<inputs.size();i++){
            for(int j = 0; j< i;j++){
                if(inputs.get(i).w > inputs.get(j).w && inputs.get(i).h > inputs.get(j).h){
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
                answer = Math.max(answer, DP[i]);
            }
        }
        return answer;
    }
}
