package pers.captain.algorithm.last;

import java.util.HashMap;
import java.util.Map;

public class No21RomantoInteger_13 {

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int tempHigh = map.get(s.charAt(i));
            int temp = 0;
            if (i < s.length()-1) {
                temp = map.get(s.charAt(i + 1));
            }

            if (temp > tempHigh) {
                result += temp;
                result -= tempHigh;
                i++;
            } else {
                result += tempHigh;
            }
        }
        return result;

    }

    public int romanToInt1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int tempHigh = getValue(s.charAt(i));
            int temp = 0;
            if (i < s.length() - 1) {
                temp = getValue(s.charAt(i + 1));
            }

            if (temp > tempHigh) {
                result += temp;
                result -= tempHigh;
                i++;
            } else {
                result += tempHigh;
            }
        }
        return result;

    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        No21RomantoInteger_13 no21RomantoInteger_13 = new No21RomantoInteger_13();
        int result = no21RomantoInteger_13.romanToInt("IV");
        System.out.println("IV".charAt(1));
        System.out.println(result);
    }
}
