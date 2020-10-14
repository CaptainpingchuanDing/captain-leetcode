package pers.captain.algorithm.August;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimetoBuyandSellStock_121 {

    /**
     *  总结： 多个角度 去看问题，会有不同的解法，然后挑选出最优的。
     */


    /**
     * 方法一：暴力解法   时间O(n^2)
     * 分别以 i 天作为买入点，计算i天买入最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    @Test
    public void maxProfit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = 5;
        Assert.assertEquals(maxProfit(prices), maxProfit);

        prices = new int[]{7, 6, 4, 3, 1};
        Assert.assertEquals(maxProfit(prices), 0);

    }


    /**
     * 方法二   时间 O(N)
     * 以 i day为卖股票的日子，用一个常亮记录过去历史的最低值。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    @Test
    public void maxProfit1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = 5;
        Assert.assertEquals(maxProfit1(prices), maxProfit);

        prices = new int[]{7, 6, 4, 3, 1};
        Assert.assertEquals(maxProfit1(prices), 0);

    }

}
