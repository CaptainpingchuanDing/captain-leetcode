package pers.captain.algorithm.last;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 例如1：
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */
public class No5MultiplyStrings {

    /**
     * 1. 判断两个数是否为零，是则返回"0"
     * 2. 一个数不动，另一个数每个位置相乘。每一次相乘得到最低位的字符。进位特殊考虑。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply1(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        long mutiply = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                double num2Bit = map.get(num2.charAt(num2.length() - 1 - j)) * Math.pow(10, j);
                double num1Bit = map.get(num1.charAt(num1.length() - 1 - i)) * Math.pow(10, i);
                mutiply += num2Bit * num1Bit;
            }
        }

        return mutiply + "";
    }

    /*
    没有做出的原因：1. 110位的大数不应该用Math.pow进行计算  2. 字符串'0'-'9' 对应的 unicode 是相邻的

     */

    public static String multiply2(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "0";

        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();

            for (int k = 0; k < num1.length() - 1 - i; k++) {
                stringBuilder.append(0);
            }
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; carry > 0 || j >= 0; j--) {
                int num2Bit = j < 0 ? 0 : num2.charAt(j) - '0';
                stringBuilder.append((n1 * num2Bit + carry) % 10);
                carry = (n1 * num2Bit + carry) / 10;
            }
            result = addStrings(result, stringBuilder.reverse().toString());
        }
        return result;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    /*
    优化数坚式   num1的i位 与num2的j位 相乘 会把结果放在 result的 i+j位和 i+j+1 位（i+j+1 是两个数成绩十位）
    另外两个数相乘 一个M位  一个N位  结果最大长度为 M+N 位
     */
    public static String multiply3(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = result[i + j + 1] + n1 * n2;
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
//        boolean flag = false;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int k = 0; k < result.length; k++) {
//            if (result[k] > 0 && !flag) {
//                flag = true;
//            }
//            if (flag) {
//                stringBuilder.append(result[k]);
//            }
//        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            if (k == 0 && result[k] == 0) {
                continue;
            }
            stringBuilder.append(result[k]);
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply1("123456789", "987654321"));
        System.out.println(multiply2("123456789", "987654321"));
        System.out.println(multiply3("123456789", "987654321"));
    }
}
