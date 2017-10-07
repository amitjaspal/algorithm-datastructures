package com.algorithms;

public class Calendar {

  int year;
  int month;
  int date;

  int []daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  public Calendar(int year, int month, int date){
    this.year = year;
    this.month = month;
    this.date = date;
  }
  public void addDays(int N){

    int daysToAdd = N;

    while(daysToAdd > 0){
      int oldMonth = month;
      for(int i = oldMonth - 1;i<12 && daysToAdd > 0;i++){
        int daysInMonthI = i == 1 && isLeapYear(year) ? 29 : daysInMonth[i];
        if(date + daysToAdd > daysInMonthI){
          daysToAdd = daysToAdd - (daysInMonthI - date);
          date = 0;
          if(month == 12) {
            month = 1;
          }else{
            month = month + 1;
          }

        }else{
          date = date + daysToAdd;
          daysToAdd = 0;
        }
      }
      System.out.println(daysToAdd);
      if(daysToAdd == 0){
        System.out.println(String.format("%s-%s-%s",year,month,date));
      }
      year = year + 1;
      month = 1;
    }

  }

  boolean isLeapYear(int year){

    return (year%4==0 && year%100!=0) || year%400==0;
  }
}
