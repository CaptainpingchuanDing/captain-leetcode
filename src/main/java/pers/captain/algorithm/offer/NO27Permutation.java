package pers.captain.algorithm.offer;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * <p>
 * "ab"
 * 返回值
 * <p>
 * ["ab","ba"]
 */
public class NO27Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null || str.length() == 0) return result;
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);// 解决重复字符准备
        boolean[] used = new boolean[charArray.length];
        StringBuilder sb = new StringBuilder();
        helper(charArray, used, result, sb);
        return result;
    }


    private void helper(char[] charArray, boolean[] used, ArrayList<String> result, StringBuilder sb) {
        // 结束条件
        if (sb.length() == charArray.length) {
            result.add(sb.toString());
        } else {
            for (int i = 0; i < charArray.length; i++) {
                if (!used[i]) {
                    if (i > 0 && charArray[i - 1] == charArray[i] && !used[i - 1]) {
                        // 前一个位置在之前的排列中已经用过，当前的排列中没有用过
                        continue;
                    }// 去除重复部分
                    sb.append(charArray[i]);// 标记使用过
                    used[i] = true;// 标记使用过
                    helper(charArray, used, result, sb);// 递归到下一层，寻找排列的下一个位置字符
                    sb.deleteCharAt(sb.length() - 1); // 回溯，还原
                    used[i] = false; // 回溯，还原
                }
            }
        }
    }
}
