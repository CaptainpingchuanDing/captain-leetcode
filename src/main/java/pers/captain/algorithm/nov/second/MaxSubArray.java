package pers.captain.algorithm.nov.second;

import org.junit.Test;
import pers.captain.algorithm.CapL;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    /**
     * 以 nums的 第 i 位结束的连续子数组的最大和为 f（i）
     * <p>
     * 转移方程
     * f(n)= max(f(n-1)+ nums[n], nums[n])
     * <p>
     * 初始化
     * f(1) = nums[0];
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];
        int maxSum = nums[0];
        int max = maxSum;
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            max = Math.max(maxSum, max);
        }
        return max;
    }

    @Test
    public void maxSunArray() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        CapL.print(max);
    }
}
