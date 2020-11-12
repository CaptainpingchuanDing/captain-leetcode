package pers.captain.algorithm.nov;

import org.junit.Test;
import pers.captain.algorithm.CapL;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 */
public class CoinChange {

    /**
     * 回溯的思路不对！ 回溯的思路不对
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_error(int[] coins, int amount) {
        if (amount == 0 || coins == null) return -1;
        Arrays.sort(coins);
        return helper(coins, amount, coins.length - 1, 1);
    }

    private int helper(int[] coins, int amount, int curIndex, int depth) {
        int count = -1;
        for (int i = curIndex; i >= 0; i--) {
            if (amount == coins[i])
                return depth;
            if (amount > coins[i]) {
                count = helper(coins, amount - coins[i], i, depth + 1);
                if (count != -1) break;
            }
        }
        return count;
    }

    /**
     * 贪心算法
     * 1. 优先使用大货币，计算需要的数量  amount/ 币  想下取整
     * 2. 剩余的数如果为零 结果，若果剩余的数，小于最小的货币，结束，返回-1 。不为零用另一个小的货币执行步骤1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null) return -1;
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int n = amount / coins[i];
            count += n;
            amount = amount % coins[i];
            // 剩余的数量为零结束，找到最少货币组合
            if (amount == 0) break;
        }
        return amount==0? count: -1;
    }


    @Test
    public void coinChange() {
        int[] coins = new int[]{186, 419, 83, 408};
        int count = coinChange(coins, 6249);
        CapL.print(count);
    }

}
