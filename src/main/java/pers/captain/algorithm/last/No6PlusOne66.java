package pers.captain.algorithm.last;

import com.alibaba.fastjson.JSON;
import com.oracle.javafx.jmx.json.JSONDocument;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class No6PlusOne66 {

    /**
     * 1. 丛低危到高位开始加1，并且把进位向前加。
     * 2. 注意长度会大于原来的数组长度。
     */
    public static int[] plusOne1(int[] digits) {

        if (digits == null || digits.length == 0) {
            return new int[]{};
        }
        // 判断是否全是9
        boolean flag = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }

        int[] result;
        if (flag) {
            result = new int[digits.length + 1];
            result[0] = 1;
        } else {
            result = new int[digits.length];
            int carry = 0;
            for (int k = digits.length - 1; k >= 0 || carry > 0; k--) {

                int sum = digits[k] + carry;
                if (k == digits.length - 1) {// 加一操作
                    sum += 1;
                }
                result[k] = sum % 10;
                carry = sum / 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] digits1 = new int[]{4, 3, 2, 1};
        int[] digits2 = new int[]{9, 9, 9, 9};
        System.out.println(JSON.toJSONString(plusOne1(digits1)));
        System.out.println(JSON.toJSONString(plusOne1(digits2)));
    }
}
