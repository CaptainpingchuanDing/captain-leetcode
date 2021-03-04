package pers.captain.algorithm.offer.five;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 示例1
 * 输入
 * <p>
 * "aaa","a*a"
 * 返回值
 * <p>
 * true
 */
public class NO52StringMatcher {
    /**
     * // 动态规划，
     * // dp[i][j] = dp[i-1][j-1] if(str[i-1]==pattern[j-1]||pattern[j-1]=='*'
     * // || pattern[j-1]=='.')
     * // pattern[j-1]=='*' dp[i][j] = dp[i][j-1]|dp[i-1][j-1]
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int n = str.length, m = pattern.length;
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        // 初始化 第一行
        for (int i = 2; i <= m; i += 2) {
            if (pattern[i - 1] == '*') dp[0][i] = true;
        }
        // 初始化 第一列  都是false
        // 遍历所有的行列1-n,1-m
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (j > 1 && pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]) {
                        dp[i][j] = dp[i - 1][j - 2];
                    }
                    dp[i][j] |= dp[i][j - 2];
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void match() {
        char[] str = "aaa".toCharArray();
        char[] patter = "a.a".toCharArray();
        boolean res = match(str, patter);
        Assert.assertTrue(res);
    }

}
