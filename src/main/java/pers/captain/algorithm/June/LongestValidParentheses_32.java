package pers.captain.algorithm.June;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 例子1：
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 例子2：
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses_32 {
    /**
     * 用栈实现
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            boolean flag = true;
            for (int j = i; j < s.length(); j++) {
                if (flag && (s.charAt(j) == ')')) {
                    continue;
                }
                flag = false;
                if (s.charAt(j) == '(') {
                    stack.push('(');
                } else {
                    if (stack.size() > 0) {
                        stack.pop();
                        temp++;
                    } else {
                        break;
                    }
                }
            }
            if (temp > maxLength) {
                maxLength = temp;
            }
            stack.clear();
        }

        return maxLength * 2;
    }

    /**
     * 两个指针
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            int left = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    left++;
                } else {
                    left--;
                }
                if (left < 0) {
                    temp = j - i;
                    break;
                }
                if (left == 0) {
                    temp = j - i + 1;
                }
            }
            if (temp > maxLength) {
                maxLength = temp;
            }
            if (maxLength > s.length() - i) {
                break;
            }
        }
        return maxLength;
    }

    /**
     * 动态规划
     * boolean[][]
     * ()()())
     *
     * 1. 初始化
     *
     * 1-1
     *
     *
     * 2. 转移方程
     *
     */
    public int longestValidParentheses_dongtai(String s) {
        if (s == null) {
            return 0;
        }
        int maxLength = 0;

        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 main = new LongestValidParentheses_32();
//        int length = main.longestValidParentheses(")()())");
        int length = main.longestValidParentheses1("))()(()()");
//        int length = main.longestValidParentheses1("(()");
        System.out.println(length);
    }
}
