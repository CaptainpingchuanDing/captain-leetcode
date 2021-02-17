package pers.captain.algorithm.tto.feb;

import org.junit.Assert;
import org.junit.Test;
import pers.captain.algorithm.CapL;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CuttingRope {

    /**
     * 暴力方法
     *
     * @param n
     * @return
     */
    public int cutttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        int result = -1;
        for (int i = 1; i < n; i++) {
            int t1 = i * (n - i);
            int t2 = i * cutttingRope1(n - i);
            result = Math.max(result, Math.max(t1, t2));
        }
        return result;
    }

    @Test
    public void cutttingRope1() {
        int result = cutttingRope1(10);
        CapL.print(result);
    }

    /**
     * 暴力方法，加上辅助记忆
     *
     * @param n
     * @return
     */
    public int cutttingRope2(int n) {
        int[] f = new int[n + 1];
        cal(n, f);
        return f[n];
    }

    private int cal(int n, int[] f) {
        if (n == 2) {
            return 1;
        }
        int result = -1;
        for (int i = 1; i < n; i++) {
            int t1 = i * (n - i);
            int t2;
            if (f[n - i] != 0) {
                t2 = f[n - i];
            } else {
                t2 = i * cutttingRope2(n - i);
            }
            result = Math.max(result, Math.max(t1, t2));
        }
        f[n] = result;
        return result;
    }

    @Test
    public void cutttingRope2() {
        int result = cutttingRope2(10);
        CapL.print(result);
    }

    /**
     * 动态规划题目 自底向上的方式
     * dp[0] = dp[1] = dp[2] = 1
     * dp[i] = max((j * (i-j)), j * dp[i-j])
     *
     * @param n
     * @return
     */
    public int cutttingRope3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    @Test
    public void cutttingRope3() {
        int result = cutttingRope3(10);
        CapL.print(result);
    }

    /**
     * 暴力方式
     * <p>
     * F(n)
     * /    \
     * 1*F(n-1) (n-1) F(1)
     * / \
     * 1* F(n-2)
     *
     * @return
     */
    public int cutingRope_1_E(int n) {
        if (n < 3) {
            return 1;
        }
        int res = -1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int q = j * (i - j);
                int m = j * cutingRope_1_E(i - j);
                res = Math.max(Math.max(q, m), res);
            }
        }
        return res;
    }

    /**
     * 自顶向下
     *
     * @param n
     * @return
     */
    public int cutingRope_2_E(int n) {
        if (n < 3) {
            return 1;
        }
        int[] res = new int[n + 1];
        return cal2(n, res);
    }

    private int cal2(int n, int[] res) {
        int temp = -1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int q = j * (i - j);
                int m = j * cal2(i - j, res);
                temp = Math.max(Math.max(q, m), temp);
            }
        }
        res[n] = temp;
        return temp;
    }

    /**
     * 自底向上
     *
     * @param n
     * @return
     */
    public int cutingRope_3_E(int n) {
        if (n < 3) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int m = j * (i - j);
                int k = j * res[i - j];
                res[i] = Math.max(Math.max(m, k), res[i]);
            }
        }
        return res[n];
    }

    @Test
    public void cutingRope_3_E() {
        int result = cutingRope_3_E(10);
        Assert.assertEquals(result, 36);
    }

    public int cutingRope_4_E(int n) {
        // 自底向上、dp[i] 便是 i长度的最大乘积
        int[] dp = new int[n + 1];// dp[i] = max[j*(i-j),j*dp[i-j]]
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]),dp[i]);
            }
        }
        return dp[n];
    }
    @Test
    public void cutingRope_4_E() {
        int result = cutingRope_4_E(10);
        Assert.assertEquals(result, 36);
    }

}
