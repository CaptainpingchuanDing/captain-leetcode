package pers.captain.algorithm.last;

import java.util.Arrays;
import java.util.List;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class No20IntegertoRoman_12 {


    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();

        int qian = num / 1000;
        num = num % 1000;
        qian(stringBuilder, qian);

        int bai = num / 100;
        bai(stringBuilder, bai);
        num = num % 100;

        int shi = num / 10;
        shi(stringBuilder, shi);
        num = num % 10;

        gewei(stringBuilder, num);
        return stringBuilder.toString();
    }

    private StringBuilder gewei(StringBuilder stringBuilder, int num) {
        if (num == 0) {
            return stringBuilder;
        } else if (num == 1) {
            stringBuilder.append("I");
        } else if (num == 2) {
            stringBuilder.append("II");
        } else if (num == 3) {
            stringBuilder.append("III");
        } else if (num == 4) {
            stringBuilder.append("IV");
        } else if (num == 5) {
            stringBuilder.append("V");
        } else if (num == 6) {
            stringBuilder.append("VI");
        } else if (num == 7) {
            stringBuilder.append("VII");
        } else if (num == 8) {
            stringBuilder.append("VIII");
        } else if (num == 9) {
            stringBuilder.append("IX");
        }
        return stringBuilder;
    }

    private StringBuilder qian(StringBuilder stringBuilder, int num) {
        if (num == 0) {
            return stringBuilder;
        } else if (num == 1) {
            stringBuilder.append('M');
        } else if (num == 2) {
            stringBuilder.append("MM");
        } else if (num == 3) {
            stringBuilder.append("MMM");
        }
        return stringBuilder;
    }

    private StringBuilder bai(StringBuilder stringBuilder, int num) {
        if (num == 0) {
            return stringBuilder;
        } else if (num == 1) {
            stringBuilder.append('C');
        } else if (num == 2) {
            stringBuilder.append("CC");
        } else if (num == 3) {
            stringBuilder.append("CCC");
        } else if (num == 4) {
            stringBuilder.append("CD");
        } else if (num == 5) {
            stringBuilder.append("D");
        } else if (num == 6) {
            stringBuilder.append("DC");
        } else if (num == 7) {
            stringBuilder.append("DCC");
        } else if (num == 8) {
            stringBuilder.append("DCCC");
        } else if (num == 9) {
            stringBuilder.append("CM");
        }
        return stringBuilder;
    }

    private StringBuilder shi(StringBuilder stringBuilder, int num) {
        if (num == 0) {
            return stringBuilder;
        } else if (num == 1) {
            stringBuilder.append('X');
        } else if (num == 2) {
            stringBuilder.append("XX");
        } else if (num == 3) {
            stringBuilder.append("XXX");
        } else if (num == 4) {
            stringBuilder.append("XL");
        } else if (num == 5) {
            stringBuilder.append("L");
        } else if (num == 6) {
            stringBuilder.append("LX");
        } else if (num == 7) {
            stringBuilder.append("LXX");
        } else if (num == 8) {
            stringBuilder.append("LXXX");
        } else if (num == 9) {
            stringBuilder.append("XC");
        }
        return stringBuilder;
    }


    public String int2Roman(int num) {
        List<String> tmpVec1 = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
        List<String> tmpVec2 = Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
        List<String> tmpVec3 = Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
        List<String> tmpVec4 = Arrays.asList("", "M", "MM", "MMM");
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(tmpVec4.get(num / 1000));
        stringBuilder.append(tmpVec3.get((num % 1000) / 100));
        stringBuilder.append(tmpVec2.get((num % 100) / 10));
        stringBuilder.append(tmpVec1.get(num % 10));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        No20IntegertoRoman_12 no20IntegertoRoman_12 = new No20IntegertoRoman_12();

        String temp = no20IntegertoRoman_12.intToRoman(113);

        String temp2 = no20IntegertoRoman_12.int2Roman(113);
        System.out.println(temp);
        System.out.println(temp2);
    }
}
