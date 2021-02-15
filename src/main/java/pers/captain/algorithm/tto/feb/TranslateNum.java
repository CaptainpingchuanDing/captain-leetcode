package pers.captain.algorithm.tto.feb;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {

    public int translateNum(int num) {
        if (num < 0) return 0;
        String numStr = num + "";
        int n = numStr.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (numStr.charAt(i - 2) == '1') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (numStr.charAt(i - 2) == '2') {
                if (numStr.charAt(i - 1) < '6') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public int translateNum_Better(int num) {
        if (num < 0) return 0;
        String numStr = num + "";
        int res = 1, pre = 1, pPre = 1;
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.substring(i - 1, i + 1).compareTo("25") <= 0 &&
                    numStr.substring(i - 1, i + 1).compareTo("10") >= 0) {
                res = pre + pPre;
                pPre = pre;
                pre = res;
            }
        }
        return res;
    }


    public int translateNum_Better2(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    @Test
    public void translateNum() {
//        int res = translateNum(12258);
//        Assert.assertEquals(5,res);

        int res = translateNum(26);
        Assert.assertEquals(1, res);
    }

    @Test
    public void translateNum_Better() {
        int result = translateNum_Better2(18822);
        Assert.assertEquals(result, 4);
    }

    public int translateNum_better_2_E(int n) {
        String s = String.valueOf(n);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.substring(i - 2, i).compareTo("25") <= 0
                    && s.substring(i - 2, i).compareTo("10") >= 0) {
                b = a;
                a = a + b;
            }
        }
        return a;
    }
}
