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

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null) return -1;
        int[] count = new int[1];
        Arrays.sort(coins);
        helper(coins, amount, 0, count);
        return count[0] == 0 ? -1 : count[0];

    }

    private void helper(int[] coins, int amount, int curIndex, int[] count) {
        for (int i = curIndex; i < coins.length; i++) {
            if (amount > coins[i]) {
                helper(coins, amount - coins[i], i, count);
            } else if (amount == coins[i]) {
                count[0]++;
            }
        }
    }

    @Test
    public void coinChange() {
        int[] coins = new int[]{1, 2, 5};
        int count = coinChange(coins, 11);
        CapL.print(count);
    }

}
