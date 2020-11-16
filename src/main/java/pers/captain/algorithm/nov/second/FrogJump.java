package pers.captain.algorithm.nov.second;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 */
public class FrogJump {

    /**
     * 1. 初始化 dp[0] = 1 dp[1] = 1
     * 2. 状态转移  dp[i] = dp[i-1]+dp[i-2]
     * <p>
     * 1 ,1, 2, 3, 5
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n < 0) return -1;
        if (n == 1 || n == 0) return 1;
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }

}
