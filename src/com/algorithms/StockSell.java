package com.algorithms;

import java.util.Arrays;


public class StockSell {

  public int maxProfit(int[] prices) {
    if(prices == null || prices.length < 2) return 0;

    int min = prices[0];
    int result = 0;
    for(int i = 1;i<prices.length;i++){
      if(prices[i] > min){
        result = Math.max(result, prices[i] - min);
      }
      min = Math.min(min, prices[i]);
    }
    return result;
  }

  public int maxProfitWithUnlimitedTransactions(int[] prices) {
    if(prices == null || prices.length < 2) return 0;

    int min = prices[0];
    int result = 0;
    for(int i = 1;i<prices.length;i++){
      //System.out.println("Hello");
      if(prices[i] > min){
        result = result + (prices[i] - min);
      }
      min = prices[i];
      //System.out.println(result);
    }
    return result;
  }

  public int maxProfitWith2Transactions(int []prices){
    if(prices == null || prices.length < 2) return 0;

    int []pl = new int[prices.length];
    int []pr = new int[prices.length];

    pl[0] = 0;
    int min = prices[0];
    for(int i = 1;i<prices.length;i++){
      if(prices[i] < min){
        pl[i] = pl[i-1];
        min = prices[i];
      }else{
        pl[i] = Math.max(pl[i-1], prices[i] - min);
      }
    }
    int l = prices.length - 1;
    pr[l] = 0;
    int max = prices[l];
    for(int i = l-1;i >= 0;i--){
      if(prices[i] < max){
        pr[i] = Math.max(pr[i+1], max - prices[i]);

      }else{
        pr[i] = pr[i+1];
        max = prices[i];
      }
    }

    int result = Math.max(pl[l], pr[0]);
    System.out.println(Arrays.toString(pl));
    System.out.println(Arrays.toString(pr));
    for(int i = 1;i<l;i++){
      result = Math.max(result, pl[i] + pr[i+1]);
    }
    return result;
  }
}
