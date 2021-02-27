package pers.captain.algorithm.offer.four;

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * <p>
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * <p>
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class NO30FindGreatestSumOfSubArray {

    /**
     * 动态规划的思想，dp[i] 表示以第i个字符结尾的最大连续子数组的值
     * dp[i] = max(dp[i]+array[i],dp[i-1])
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        // dp[] 连续最大和  dp[i] = max(dp[i-1]+ array[i],array[i])
        if (array == null || array.length == 0) return 0;
        int max = array[0];
        int dp = array[0];
        for (int i = 1; i < array.length; i++) {
            dp = Math.max(dp + array[i], array[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
