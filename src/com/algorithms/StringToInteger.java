package com.algorithms;

/**
 * Created by ajaspal on 1/6/17.
 */
public class StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        boolean isNegative = false;
        boolean isSignPresent = false;
        if(str.charAt(0) == '-'){
            isNegative = true;
            isSignPresent = true;
        }
        if(str.charAt(0) == '+'){
            isSignPresent = true;
        }
        int start = isSignPresent ? 1 : 0;
        if(isSignPresent && str.length() == 1) return 0;
        int answer = 0;
        for(int i = start;i<str.length();i++){

            if(str.charAt(i) >= '0' && str.charAt(i)<= '9'){
                int offset = (int) (str.charAt(i)) - 48;
                if(!isNegative) {
                    if (answer <= ((Integer.MAX_VALUE - offset) / 10)) {
                        answer = 10 * answer + ((int) (str.charAt(i)) - 48);
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }else {
                    if ((answer >= ((Integer.MIN_VALUE + offset) / 10))) {
                        answer = 10 * answer - ((int) (str.charAt(i)) - 48);
                    } else {

                        return Integer.MIN_VALUE;
                    }
                }
            }else{
                return answer;
            }
        }

        return answer;
    }
}
