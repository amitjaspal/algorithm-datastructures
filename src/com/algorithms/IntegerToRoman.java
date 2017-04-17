package com.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajaspal on 1/4/17.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        char []romanChars = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Integer, Character> intToRomanMapping = new HashMap<Integer, Character>();
        intToRomanMapping.put(1, 'I');
        intToRomanMapping.put(5, 'V');
        intToRomanMapping.put(10, 'X');
        intToRomanMapping.put(50, 'L');
        intToRomanMapping.put(100, 'C');
        intToRomanMapping.put(500, 'D');
        intToRomanMapping.put(1000, 'M');
        return null;
    }
}
