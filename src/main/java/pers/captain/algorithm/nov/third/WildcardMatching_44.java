package pers.captain.algorithm.nov.third;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WildcardMatching_44 {

    /**
     * dp[m][n] 表示 前m个s的字符 与 前n个的p字符匹配
     * s[i-1] 表示s的第i个字符
     * p[j-1] 表示p的第j个字符
     * <p>
     * dp[0][0] s 和 p 为空，则是可以匹配成功
     * dp[0][j] s为空，p如果全是'*'则 dp[0][j]=true  j=[0,p.length()]
     * dp[i][0] p为空，不能匹配任何字符，则 dp[i][0] = false i=[1,s.length()]
     * <p>
     * 状态转移
     * 1. dp[i][j]= dp[i-1][j-1]
     * p[j-1] = '?'|| s[i-1] == p[j-1]
     * <p>
     * 2. p[j-1] ='*' 表示为空的时候，dp[i][j] = dp[i][j-1]
     * 表示任意字符串时，dp[i][j] = dp[i-1][j]  可以吧 i以前的一些字符可以匹配上
     * （p[j-1]匹配当前的s[i-1],同时匹配i-1 前面的字符串）
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0 && p.length() == 0) return true;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void isMatch() {
        String s = "adceb";
        String p = "*a*b";
        boolean result = isMatch(s, p);
        Assert.assertFalse(result);

    }

    @Test
    public void isMatch_true() {
        String s = "adceb";
        String p = "*a*b";
        boolean result = isMatch(s, p);
        Assert.assertTrue(result);
    }

    /**
     * 1.dp[i][j]  represent the ith of string s, and the jth pattern p
     * 2. init
     * dp[0][0] = true;
     * dp[i][0] = false;
     * dp[0][j] = true when p is like '****' all '* ' consist of it.
     * 3. transfer function
     * s[i]==p[j], p[j]=='?' dp[i][j] = dp[i-1][j-1];
     * p[j]=='*' represent nothing, dp[i][j-1]
     * represent any string , dp[i-1][j]
     * <p>
     * dp [1][1]--[m][n]
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_E(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0 && s.length() != 0) return false;
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        // 1.init
        dp[0][0] = true;
        for (int j = 1; j <= p.length() && dp[0][j - 1]; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
        //2. transfer
        //[1][1]--[m][n] for dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
