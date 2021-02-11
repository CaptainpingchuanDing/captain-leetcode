package pers.captain.algorithm.nov.third;

import org.junit.Assert;
import org.junit.Test;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LongestIncreasingSubsequence_300 {
    /**
     * 方法一： 暴力方法
     * 一次以 nums[i]为上升子序列为开头的一个元素，向后找出上升元素的个数
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = nums[i];
            int tempLen = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (tempMax < nums[j]) {
                    tempMax = nums[j];
                    tempLen++;
                }
            }
            if (tempLen > maxLen) maxLen = tempLen;
        }
        return maxLen;
    }
    @Test
    public void lengthOfLIS(){
        int[] nums = new int[]{0,1,0,3,2,3};
        int result = lengthOfLIS(nums);
        Assert.assertEquals(4,result);
    }
}
