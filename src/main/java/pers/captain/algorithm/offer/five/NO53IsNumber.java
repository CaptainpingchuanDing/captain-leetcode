package pers.captain.algorithm.offer.five;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入
 * <p>
 * "123.45e+6"
 * 返回值
 * <p>
 * true
 * 示例2
 * 输入
 * <p>
 * "1.2.3"
 * 返回值
 * <p>
 * false
 */
public class NO53IsNumber {

    public boolean isNumeric(String s) {
        if (s == null || s.length() == 0) return false; // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        boolean isNum = false, isDot = false, ise_or_E = false; // 标记是否遇到数位、小数点、‘e’或'E'
        char[] str = s.trim().toCharArray();  // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') isNum = true; // 判断当前字符是否为 0~9 的数位
            else if (str[i] == '.') { // 遇到小数点
                if (isDot || ise_or_E) return false; // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                isDot = true; // 标记已经遇到小数点
            } else if (str[i] == 'e' || str[i] == 'E') { // 遇到‘e’或'E'
                if (!isNum || ise_or_E) return false; // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                ise_or_E = true; // 标记已经遇到‘e’或'E'
                isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false; // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
            } else return false; // 其它情况均为不合法字符
        }
        return isNum;
    }

    public boolean isNumeric1(String str) {
        // todo 不能独立完成
        // write code here
        if (str == null || str.length() == 0) return false;
        boolean flag = true;// 开头第一个字符
        boolean isE = false;
        boolean isInteger = true;
        boolean isHasNum = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            } else if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                if (flag) {
                    return false;
                } else {
                    flag = false;
                    if (str.length() <= i + 1) {
                        return false;
                    } else {
                        i++;
                        if ((str.charAt(i) >= '0' & str.charAt(i) <= '9')) {
                            isE = true;
                        } else if (str.charAt(i) == '-') {
                            if (str.length() <= i + 1) {
                                return false;
                            }
                            i++;
                            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }

                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                isHasNum = true;
            } else if (str.charAt(i) == '.') {
                if (!isHasNum) {
                    return false;
                }
                if (isE) {
                    return false;
                }
                isInteger = false;
            } else if (str.charAt(i) == '-') {
                isInteger = false;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isNumeric2(String str) {
        // write code here
        if (str == null || str.length() == 0) return false;
        String p = "^[+-]?\\d*(\\.\\d*)?([eE][+-]?\\d+)?$";
        return Pattern.matches(p, str);
    }

    public boolean isNumeric_E(String s) {
        if (s == null || s.length() == 0) return false;
        boolean isNum = false, isDot = false, isE = false;
        char[] array = s.trim().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                isNum = true;
            } else if (array[i] == 'e' || array[i] == 'E') {
                if (!isNum || isE) return false;
                isE = true;
                isNum = false;
            } else if (array[i] == '-' || array[i] == '+') {
                if (i != 0 && array[i - 1] != 'e' && array[i - 1] != 'E') return false;
            } else if (array[i] == '.') {
                if (isDot || isE) return false;
                isDot = true;
            } else {
                return false;
            }
        }
        return isNum;
    }

    @Test
    public void isNumeric_E() {
        isNumeric_E("-1E-16");
    }
}
