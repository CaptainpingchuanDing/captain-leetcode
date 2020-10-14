package pers.captain.algorithm.last;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class No27GenerateParentheses_22 {

    private int k;
    List<String> result = new ArrayList<>();

    /**
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n * 2; j++) {

                for (int k = 0; k < n * 2; k++) {

                }
            }
        }

        return result;
    }

    /**
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {

        this.k = n * 2;
        generate("");
        return result;
    }

    private void generate(String str) {
        if (str.length() == k) {
            if (isValid(str)) {
                result.add(str);
            }
        } else {
            generate(str + "(");
            generate(str + ")");
        }
    }

    private boolean isValid(String input) {
        if (input == null) {
            return false;
        }
        int indexSum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indexSum++;
            } else {
                indexSum--;
            }
            if (indexSum < 0) {
                return false;
            }
        }
        if (indexSum == 0) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 暴力方法解决
     *
     * @param
     * @return
     */
    public List<String> generateParenthesis2(int n) {

        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    public static void main(String[] args) {
        No27GenerateParentheses_22 parentheses_22 = new No27GenerateParentheses_22();
        List<String> result = parentheses_22.generateParenthesis1(3);
        List<String> result2 = parentheses_22.generateParenthesis2(3);
        System.out.println(result);
        System.out.println(result2);

    }
}
